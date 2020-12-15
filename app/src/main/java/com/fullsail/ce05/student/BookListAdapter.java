package com.fullsail.ce05.student;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fullsail.ce05.R;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.Executors;

public class BookListAdapter extends BaseAdapter {

    private Context context;
    Bitmap bmp = null;
    URL url = null;

    OnItemClickListner onItemClickListner;


    private List<BookModel> list;
    LayoutInflater inflater ;
    public BookListAdapter(Context context, List<BookModel> book,OnItemClickListner listner) {
        this.context = context;
        this.list = book;
        inflater = LayoutInflater.from(context);
        this.onItemClickListner = listner;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = inflater.inflate(R.layout.book_item, viewGroup, false);
        }

        ImageView thumbnail = view.findViewById(R.id.thumbnail);
        TextView title = view.findViewById(R.id.title);

        Glide.with(context).load(list.get(i).getThumbnail()).into(thumbnail);
        title.setText(list.get(i).getTitle());

        view.setOnClickListener(view1 -> onItemClickListner.onClick(i));

        return view;
    }


}
