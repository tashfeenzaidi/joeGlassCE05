// Joe Glass

// JAV2 - C20201201

// MainActivity
package com.fullsail.ce05.student;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.fullsail.ce05.R;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    private ListView listView;
    static final String PROVIDER_NAME = "com.fullsail.ce05.provider";
    static final String URL = "content://" + PROVIDER_NAME +"/books";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list);
        TextView label = findViewById(R.id.label);
        BookModel.list = new ArrayList<>();

        // fill the data into  article table
        fillArticlesInDb();

        //load the data from companion app to list view
        loadBookData();

        if (!BookModel.getList().isEmpty()){
            setBookList();
            label.setVisibility(View.INVISIBLE);
        }else {
            label.setVisibility(View.VISIBLE);
        }

    }

    public void setBookList(){
        BookListAdapter listAdapter = new BookListAdapter(getApplicationContext(),BookModel.getList(),this);
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

    public void fillArticlesInDb(){
        ArticleModel articleModel = new ArticleModel(this);
        articleModel.storeArticlesDb();
    }

    @Override
    public void onClick(int id) {
        showDialog(BookModel.list.get(id));
    }

    public void showDialog(BookModel book){
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle(book.getTitle());
        if (book.getDescription().equals("")){
            alertDialog.setMessage("No available description");
        }else {
            alertDialog.setMessage(book.getDescription());
        }
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                (dialog, which) -> dialog.dismiss());
        alertDialog.show();
    }
}