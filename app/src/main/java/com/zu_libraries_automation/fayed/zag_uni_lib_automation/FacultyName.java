
package com.zu_libraries_automation.fayed.zag_uni_lib_automation;


import android.content.Intent;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class FacultyName extends AppCompatActivity implements BackgroundWorker.GetDataListenerFacultyName{

    Spinner spinner;
    ArrayAdapter<String> adapter;
    Button searchbtn;
    EditText editsearch;
    int spinner_position;
    String index ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_name);

        Intent intent = getIntent();
        index = intent.getStringExtra("INDEX");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);

        getSupportActionBar().setTitle(index);

        spinner = (Spinner) findViewById(R.id.home_spinner);
        searchbtn = (Button) findViewById(R.id.home_search_btn);
        editsearch = (EditText) findViewById(R.id.home_searchtxt);
        String[] arr = getResources().getStringArray(R.array.home_spinner_array);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                spinner_position = position;
                if (position == 0) {
                    editsearch.setHint("please Select something");
                    editsearch.setEnabled(false);
                    searchbtn.setEnabled(false);
                } else if (position == 1) {
                    editsearch.setHint("Enter Book Name");
                    searchbtn.setEnabled(true);
                    editsearch.setEnabled(true);
                } else if (position == 2) {
                    editsearch.setHint("Enter Book Author");
                    searchbtn.setEnabled(true);
                    editsearch.setEnabled(true);
                } else {
                    editsearch.setHint("Enter Book BiBID");
                    searchbtn.setEnabled(true);
                    editsearch.setEnabled(true);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void searchResult(View view) {

        String id,title, author;
        index = index.toLowerCase();

        if (spinner_position == 1) {
            id = "";
            title = editsearch.getText().toString();
            author = "";
            BackgroundWorker worker = new BackgroundWorker(this);
            worker.getDataFromFacultyName = this;
            worker.execute("facultyName",id, title, author, index);
        } else if (spinner_position == 2) {
            id = "";
            title = "";
            author = editsearch.getText().toString();
            BackgroundWorker worker = new BackgroundWorker(this);
            worker.getDataFromFacultyName = this;
            worker.execute("facultyName",id, title, author, index);
        } else {
            id = editsearch.getText().toString();
            title = "";
            author = "";
            BackgroundWorker worker = new BackgroundWorker(this);
            worker.getDataFromFacultyName = this;
            worker.execute("facultyName",id, title, author, index);

        }
    }

    @Override
    public void ongetData(FacultyNameListHelp f) {
        Intent intent = new Intent(this,ResultListOfFacultyNameSearch.class);
        intent.putExtra("data",f);
        Log.d("faculty_naaaaam",f.getTypeOfList());
        startActivity(intent);
    }

    @Override
    public void onListenerGetAllBook(FacultyNameListHelp f) {
        Intent intent = new Intent(this,ResultListOfFacultyNameSearch.class);
        intent.putExtra("data",f);
        Log.e("onListenerAllBook",f.getTypeOfList());
        startActivity(intent);
    }

    public void seeBooks(View view) {
        index = index.toLowerCase();
        String type = "facultyAllBook";
        BackgroundWorker worker = new BackgroundWorker(this);
        worker.getDataFromFacultyName = this;
        worker.execute(type,index);
    }
}