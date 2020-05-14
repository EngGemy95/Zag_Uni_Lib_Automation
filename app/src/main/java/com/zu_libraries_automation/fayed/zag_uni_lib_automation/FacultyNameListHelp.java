package com.zu_libraries_automation.fayed.zag_uni_lib_automation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gemy on 3/5/2017.
 */

public class FacultyNameListHelp implements Serializable {
    String bookTitle, GeneralNo, Author, SubjectHeadings, Abstract, ShelfLocation, ISBN, ISSN;
    String PublishYear, bibid;
    String typeOfList;

    int ListPoistion, faculty_id;

    public int getListPoistion() {
        return ListPoistion;
    }

    public void setListPoistion(int listPoistion) {
        ListPoistion = listPoistion;
    }

    ArrayList<FacultyNameListHelp> allBooksList;
    ArrayList<FacultyNameListHelp> titleBookList;

    public FacultyNameListHelp() {
    }

    public ArrayList<FacultyNameListHelp> getTitleBookList() {
        return titleBookList;
    }

    public void setTitleBookList(ArrayList<FacultyNameListHelp> titleBookList) {
        this.titleBookList = titleBookList;
    }

    public ArrayList<FacultyNameListHelp> getAllBooksList() {
        return allBooksList;
    }

    public void setAllBooksList(ArrayList<FacultyNameListHelp> allBooksList) {
        this.allBooksList = allBooksList;
    }

    public String getTypeOfList() {
        return typeOfList;
    }

    public void setTypeOfList(String typeOfList) {
        this.typeOfList = typeOfList;
    }

    public FacultyNameListHelp(String bookTitle, String generalNo, String author, String subjectHeadings, String anAbstract, String shelfLocation, String ISBN, String ISSN, String publishYear, String bibid) {
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

    public int getFaculty_id() {
        return faculty_id;
    }

    public void setFaculty_id(int faculty_id) {
        this.faculty_id = faculty_id;
    }

    public FacultyNameListHelp(String bookTitle, String generalNo, String author, String subjectHeadings,
                               String anAbstract, String shelfLocation,
                               String ISBN, String ISSN, String publishYear, String bibid, int faculty_id) {
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
        this.faculty_id = faculty_id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getGeneralNo() {
        return GeneralNo;
    }

    public void setGeneralNo(String generalNo) {
        GeneralNo = generalNo;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getSubjectHeadings() {
        return SubjectHeadings;
    }

    public void setSubjectHeadings(String subjectHeadings) {
        SubjectHeadings = subjectHeadings;
    }

    public String getAbstract() {
        return Abstract;
    }

    public void setAbstract(String anAbstract) {
        Abstract = anAbstract;
    }

    public String getShelfLocation() {
        return ShelfLocation;
    }

    public void setShelfLocation(String shelfLocation) {
        ShelfLocation = shelfLocation;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getISSN() {
        return ISSN;
    }

    public void setISSN(String ISSN) {
        this.ISSN = ISSN;
    }

    public String getPublishYear() {
        return PublishYear;
    }

    public void setPublishYear(String publishYear) {
        PublishYear = publishYear;
    }

    public String getBibid() {
        return bibid;
    }

    public void setBibid(String bibid) {
        this.bibid = bibid;
    }
}
