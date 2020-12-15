package com.fullsail.ce05.student;

import java.util.ArrayList;
import java.util.List;

public class BookModel {

    private int _id;
    private int book_id;
    private String title;
    private String description;
    private String thumbnail;
    public static List<BookModel> list;

    public BookModel() {

    }

    public BookModel(String title, String description, String imagePath, int _id, int book_id) {
        this.title = title;
        this.description = description;
        this.thumbnail = imagePath;
        this._id = _id;
        this.book_id = book_id;


    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static List<BookModel> getList() {
        if (list == null){
            list = new ArrayList<>();
        }
//        addDummyData();
        return list;
    }

    public static void setList(List<BookModel> list) {
        BookModel.list = list;
    }

    private static void addDummyData(){
        for (int i = 0 ; i<10 ; i++){
            BookModel bookModel = new BookModel("book "+i,"book description","",i,i);
            BookModel.list.add(bookModel);
        }
    }
}
