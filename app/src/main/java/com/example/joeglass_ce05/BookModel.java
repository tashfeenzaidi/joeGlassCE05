package com.example.joeglass_ce05;

import java.util.ArrayList;
import java.util.List;

public class BookModel {

    private String title;
    private String description;
    private String imagePath;
    private static List<BookModel> list;

    public BookModel(String title,String description, String imagePath) {
        this.title = title;
        this.description = description;
        this.imagePath = imagePath;
        if (list == null){
            list = new ArrayList<>();
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static List<BookModel> getList() {
        return list;
    }

    public static void setList(List<BookModel> list) {
        BookModel.list = list;
    }
}
