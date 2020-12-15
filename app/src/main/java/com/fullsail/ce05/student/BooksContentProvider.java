package com.fullsail.ce05.student;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;

public class BooksContentProvider implements LoaderManager.LoaderCallbacks<Cursor> {

    Context context;
    static final String PROVIDER_NAME = "com.fullsail.ce05.student.provider";
    static final String URL = "content://" + PROVIDER_NAME + "/books";
    String[] projection = {
            "_id","title","thumbnail","description","book_id"
    };

    public BooksContentProvider(Context context) {
        this.context = context;
    }

    public void getBooks(){
//        Cursor cursor = context.getContentResolver().query(Uri.parse(URL),projection,null,null, null );
//        if (cursor.moveToFirst()){
//            while (!cursor.isAfterLast()){
//                BookModel bookModel = new BookModel(
//                        cursor.getString(cursor.getColumnIndex("title"))
//                        ,cursor.getString(cursor.getColumnIndex("description"))
//                        ,cursor.getString(cursor.getColumnIndex("thumbnail"))
//                        ,cursor.getInt(cursor.getColumnIndex("_id"))
//                        ,cursor.getInt(cursor.getColumnIndex("book_id")));
//                BookModel.list.add(bookModel);
//                cursor.moveToNext();
//            }
//        }
//        cursor.close();



    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {

        CursorLoader cursorLoader = new CursorLoader(context,Uri.parse(URL),null,null,null,null);
        return cursorLoader;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {

    }
}
