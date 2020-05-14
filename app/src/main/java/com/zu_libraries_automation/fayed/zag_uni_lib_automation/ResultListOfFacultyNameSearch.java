package com.zu_libraries_automation.fayed.zag_uni_lib_automation;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResultListOfFacultyNameSearch extends AppCompatActivity {

    ArrayAdapter<String> adapter;
    ListView resultList;
    ArrayList<FacultyNameListHelp> listHelpBookTitle;
    ArrayList<FacultyNameListHelp> listHelpAllBook;
    String input;
    String inputBookTitle;
    FacultyNameListHelp f;
    ArrayList<GetDataToDetails> detailsList;
    GetDataToDetails sendData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_list_of_faculty_name_search);

        sendData = new GetDataToDetails();

        resultList = (ListView) findViewById(R.id.faculty_name_result_listview);

        Intent intent = getIntent();
        f = (FacultyNameListHelp) intent.getSerializableExtra("data");

        if (f.getTypeOfList().equals("facultyname")) {
            listHelpBookTitle = new ArrayList<>();
            listHelpBookTitle = f.getTitleBookList();

            String[] bookTitles = new String[listHelpBookTitle.size()];

            for (int i = 0; i < listHelpBookTitle.size(); i++) {
                input = listHelpBookTitle.get(i).getBookTitle();
                bookTitles[i] = input.trim();
            }

            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, bookTitles);
            resultList.setAdapter(adapter);
        }

        resultList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                detailsList = new ArrayList<>();
                detailsList.add(new GetDataToDetails(listHelpBookTitle.get(position).getBookTitle(), listHelpBookTitle.get(position).getGeneralNo(),
                        listHelpBookTitle.get(position).getAuthor(), listHelpBookTitle.get(position).getSubjectHeadings(),
                        listHelpBookTitle.get(position).getAbstract(), listHelpBookTitle.get(position).getShelfLocation(),
                        listHelpBookTitle.get(position).getISBN(), listHelpBookTitle.get(position).getISSN(), listHelpBookTitle.get(position).getPublishYear(),
                        listHelpBookTitle.get(position).getBibid()));

                sendData.setAllDataOfBook(detailsList);

                Intent detailsIntent = new Intent(ResultListOfFacultyNameSearch.this, Details.class);
                detailsIntent.putExtra("detailsListData", sendData);
                startActivity(detailsIntent);
            }
        });
        //}

        Log.e("ResultType", f.getTypeOfList());
        if (f.getTypeOfList().equals("faculty_allBook")) {
            listHelpAllBook = new ArrayList<>();
            listHelpAllBook = f.getAllBooksList();

            String[] bookAllTitles = new String[listHelpAllBook.size()];

            for (int i = 0; i < listHelpAllBook.size(); i++) {
                inputBookTitle = listHelpAllBook.get(i).getBookTitle();
                bookAllTitles[i] = inputBookTitle.trim();
                Log.e("ResultData", bookAllTitles[1] + "Hello world");
            }

            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, bookAllTitles);
            resultList.setAdapter(adapter);

//            resultList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    f.setTitleBookList(listHelpAllBook);
//                    Intent detailsIntent = new Intent(ResultListOfFacultyNameSearch.this, Details.class);
//                    startActivity(detailsIntent);
//                }
//            });
        }

    }

}
