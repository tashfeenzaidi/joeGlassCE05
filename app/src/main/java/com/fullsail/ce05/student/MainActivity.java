package com.fullsail.ce05.student;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.fullsail.ce05.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>{

    private ListView listView;
    static final String PROVIDER_NAME = "com.fullsail.ce05.provider";
    static final String URL = "content://" + PROVIDER_NAME +"/books";
    String[] projection = {
            "_id","title","thumbnail","description","book_id"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list);
        TextView label = findViewById(R.id.label);
        BookModel.list = new ArrayList<>();

        loadBookData();

        if (!BookModel.getList().isEmpty()){
            setBookList();
            label.setVisibility(View.INVISIBLE);
        }else {
            label.setVisibility(View.VISIBLE);
        }

    }

    public void setBookList(){
        BookListAdapter listAdapter = new BookListAdapter(getApplicationContext(),BookModel.getList());
        listView.setAdapter(listAdapter);
    }

    public void loadBookData(){
        Cursor cursor = getContentResolver().query(Uri.parse(URL),null,null,null, null );
        if (cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                BookModel bookModel = new BookModel(
                        cursor.getString(cursor.getColumnIndex("title"))
                        ,cursor.getString(cursor.getColumnIndex("description"))
                        ,cursor.getString(cursor.getColumnIndex("thumbnail"))
                        ,cursor.getInt(cursor.getColumnIndex("_id"))
                        ,cursor.getInt(cursor.getColumnIndex("book_id")));
                BookModel.list.add(bookModel);
                cursor.moveToNext();
            }
        }
        cursor.close();
    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {

        CursorLoader cursorLoader = new CursorLoader(this,Uri.parse(URL),null,null,null,null);
        return cursorLoader;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {

        if (data.moveToFirst()){
            while (!data.isAfterLast()){
                BookModel bookModel = new BookModel(
                        data.getString(data.getColumnIndex("title"))
                        ,data.getString(data.getColumnIndex("description"))
                        ,data.getString(data.getColumnIndex("thumbnail"))
                        ,data.getInt(data.getColumnIndex("_id"))
                        ,data.getInt(data.getColumnIndex("book_id")));
                BookModel.list.add(bookModel);
                data.moveToNext();
            }
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {

    }
}