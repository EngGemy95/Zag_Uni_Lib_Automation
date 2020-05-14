package com.zu_libraries_automation.fayed.zag_uni_lib_automation;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Details extends AppCompatActivity {

    private TextView BiBid_TV,GeneralNum_TV,Title_TV
    ,Author_TV,SubjectHead_TV,
    PublishingYear_TV,ISBN_TV,ISSN_TV,Abstract_TV,ShelfLoc_TV;

    private CheckBox CheckBoxFav;
    private CheckBox CheckBoxRem;
    private Button btn_ShowMap;

    int position ;

    GetDataToDetails f ;

    ArrayList<GetDataToDetails> listData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        Intent intent = getIntent();
        f = (GetDataToDetails) intent.getSerializableExtra("detailsListData");

        BiBid_TV = (TextView) findViewById(R.id.details_BIB_TV);
        BiBid_TV.setMovementMethod(new ScrollingMovementMethod());
        GeneralNum_TV = (TextView) findViewById(R.id.details_General__TV);
        GeneralNum_TV.setMovementMethod(new ScrollingMovementMethod());
        Title_TV = (TextView) findViewById(R.id.details_Title_TV);
        Title_TV.setMovementMethod(new ScrollingMovementMethod());
        Author_TV = (TextView) findViewById(R.id.details_author_TV);
        Author_TV.setMovementMethod(new ScrollingMovementMethod());
        SubjectHead_TV = (TextView) findViewById(R.id.details_subject_headings_TV);
        SubjectHead_TV.setMovementMethod(new ScrollingMovementMethod());
        ShelfLoc_TV = (TextView) findViewById(R.id.details_shelf_TV);
        ShelfLoc_TV.setMovementMethod(new ScrollingMovementMethod());
        PublishingYear_TV = (TextView) findViewById(R.id.details_publishing_TV);
        PublishingYear_TV.setMovementMethod(new ScrollingMovementMethod());
        ISBN_TV = (TextView) findViewById(R.id.details_isbn_TV);
        ISBN_TV.setMovementMethod(new ScrollingMovementMethod());
        ISSN_TV = (TextView) findViewById(R.id.details_issn_TV);
        ISSN_TV.setMovementMethod(new ScrollingMovementMethod());
        Abstract_TV = (TextView) findViewById(R.id.details_abstract_TV);
        Abstract_TV.setMovementMethod(new ScrollingMovementMethod());

        CheckBoxFav = (CheckBox) findViewById(R.id.checkBox_Fav);
        CheckBoxRem = (CheckBox) findViewById(R.id.checkBox_Rem);

        position = f.getListPoistion();

        listData = new ArrayList<>();
        listData = f.getAllDataOfBook();

        Log.d("pooooosiiiition",position+"");

        BiBid_TV.setText(listData.get(position).getBibid());
        GeneralNum_TV.setText(listData.get(position).getGeneralNo());
        Title_TV.setText(listData.get(position).getBookTitle());
        Author_TV.setText(listData.get(position).getAuthor());
        SubjectHead_TV.setText(listData.get(position).getSubjectHeadings());
        Abstract_TV.setText(listData.get(position).getAbstract());
        ShelfLoc_TV.setText(listData.get(position).getShelfLocation());
        PublishingYear_TV.setText(listData.get(position).getPublishYear());
        ISBN_TV.setText(listData.get(position).getISBN());
        ISSN_TV.setText(listData.get(position).getISSN());

    }

}
