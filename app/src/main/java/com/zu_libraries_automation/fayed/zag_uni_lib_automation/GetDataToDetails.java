package com.zu_libraries_automation.fayed.zag_uni_lib_automation;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Gemy on 3/25/2017.
 */

public class GetDataToDetails implements Serializable {

    String bookTitle, GeneralNo, Author, SubjectHeadings, Abstract, ShelfLocation, ISBN, ISSN;
    String PublishYear, bibid;
    String typeOfList;

    int listPoistion;


    public GetDataToDetails() {
    }

    public int getListPoistion() {
        return listPoistion;
    }

    ArrayList<GetDataToDetails> allDataList;

    public ArrayList<GetDataToDetails> getAllDataOfBook() {
        return allDataList;
    }

    public void setAllDataOfBook(ArrayList<GetDataToDetails> titleBookList) {
        this.allDataList = titleBookList;
    }


    public GetDataToDetails(String bookTitle, String generalNo, String author, String subjectHeadings,
                            String anAbstract, String shelfLocation, String ISBN, String ISSN, String publishYear, String bibid) {
        this.bookTitle = bookTitle;
        this.GeneralNo = generalNo;
        this.Author = author;
        this.SubjectHeadings = subjectHeadings;
        this.Abstract = anAbstract;
        this.ShelfLocation = shelfLocation;
        this.ISBN = ISBN;
        this.ISSN = ISSN;
        this.PublishYear = publishYear;
        this.bibid = bibid;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getGeneralNo() {
        return GeneralNo;
    }

    public String getAuthor() {
        return Author;
    }

    public String getSubjectHeadings() {
        return SubjectHeadings;
    }

    public String getAbstract() {
        return Abstract;
    }

    public String getShelfLocation() {
        return ShelfLocation;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getISSN() {
        return ISSN;
    }

    public String getPublishYear() {
        return PublishYear;
    }

    public String getBibid() {
        return bibid;
    }

}

