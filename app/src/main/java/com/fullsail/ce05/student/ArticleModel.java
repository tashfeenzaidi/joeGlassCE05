package com.fullsail.ce05.student;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

// Joe Glass

// JAV2 - C20201201

// ArticleModel

public class ArticleModel {

    int id;
    List<String> title;
    List<String> thumbnail;
    List<String> body;
    Context context;

    static final String PROVIDER_NAME = "com.fullsail.ce05.student.provider";
    static final String URL = "content://" + PROVIDER_NAME +"/articles";

    public ArticleModel(Context context) {
        this.context = context;
        title = new ArrayList<>();
        thumbnail = new ArrayList<>();
        body = new ArrayList<>();
    }

    public void storeArticlesDb(){

        if (isDataExist()){

            title.add("10 Deadly Mistakes to Avoid When Learning Java");
            title.add("10 Deadly Mistakes to Avoid When Learning Java");
            title.add("10 Deadly Mistakes to Avoid When Learning Java");
            thumbnail.add("https://images-na.ssl-images-amazon.com/images/I/51cUVaBWZzL._SX380_BO1,204,203,200_.jpg");
            thumbnail.add("https://miro.medium.com/max/276/1*HTSUqc3Xk66vgJj9PAiMjA.png");
            thumbnail.add("https://images-na.ssl-images-amazon.com/images/I/41yafGMO+rL._SX376_BO1,204,203,200_.jpg");
            body.add("Now, twenty years later, this new edition re-examines what it means to be a modern programmer. Topics range from personal responsibility and career development to architectural techniques for keeping your code flexible and easy to adapt and reuse. Read this book, and you’ll learn how to");
            body.add("We are proud to announce a new version of Helidon 1.3. The main feature of this release is MicroProfile 3.0 support, but it also includes additional features, bug fixes and performance improvements. Let’s take a closer look.");
            body.add("Even bad code can function. But if code isn’t clean, it can bring a development organization to its knees. Every year, countless hours and significant resources are lost because of poorly written code. But it doesn’t have to be that way.");



            for (int i = 0; i<title.size(); i++){
                ContentValues values = new ContentValues();
                values.put(ArticleContentProvider.title,title.get(i));
                values.put(ArticleContentProvider.thumbnail,thumbnail.get(i));
                values.put(ArticleContentProvider.body,body.get(i));
                context.getContentResolver().insert(ArticleContentProvider.CONTENT_URI,values);
            }

        }

    }

    public  boolean isDataExist(){
        Cursor cursor = context.getContentResolver().query(Uri.parse(URL),null,null,null, null );
        if (cursor.getCount() <= 0){
            return true;
        }
        cursor.close();
        return false;
    }
}
