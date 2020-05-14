package com.zu_libraries_automation.fayed.zag_uni_lib_automation;


import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class Home extends AppCompatActivity implements HomeCustomAdapter.ClickListener{


    HomeCustomAdapter homeCustomAdapter ;
    GridView homeGridView ;

    String [] faculties_names ;
    int []img_resource = new int[]{
            R.drawable.agriculture,R.drawable.art,R.drawable.commerce,R.drawable.education,
            R.drawable.engineer,R.drawable.fci,R.drawable.fsopem,R.drawable.fsopef,R.drawable.law,
            R.drawable.medicin,R.drawable.nursing,R.drawable.pharmacy,R.drawable.science,
            R.drawable.special_education,R.drawable.technology_development,R.drawable.vet
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_home);

        faculties_names = getResources().getStringArray(R.array.faculty_names);

        homeGridView = (GridView)findViewById(R.id.home_grid_view);
        homeCustomAdapter = new HomeCustomAdapter(this,getData());
        homeCustomAdapter.setClickListener(this);
        homeGridView.setAdapter(homeCustomAdapter);

    }

    private ArrayList<Faculties> getData() {
        ArrayList<Faculties> facultiesArrayList = new ArrayList<>();

        for (int i=0;i<faculties_names.length;i++){
            Faculties faculties = new Faculties();
            faculties.setFacultyName(faculties_names[i]);
            faculties.setFacultyIcon(img_resource[i]);
            facultiesArrayList.add(faculties);
        }
        return facultiesArrayList;
    }

    @Override
    public void itemClicked(View view, int position) {
        if(position !=-1) {
            Intent intent = new Intent(Home.this, FacultyName.class);
            intent.putExtra("INDEX",faculties_names[position]);
            startActivity(intent);
        }
    }
}
