// Joe Glass

// JAV2 - C20201201

// BookModel
package com.fullsail.ce05.student;

import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("ALL")
public class BookModel {

    private int _id;
    private int book_id;
    private String title;
    private String description;
    private String thumbnail;
    public static List<BookModel> list;


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



    public String getDescription() {
        return description;
    }


    public String getThumbnail() {
        return thumbnail;
    }


    public String getTitle() {
        return title;
    }


    public static List<BookModel> getList() {
        if (list == null){
            list = new ArrayList<>();
        }
        return list;
    }
}
