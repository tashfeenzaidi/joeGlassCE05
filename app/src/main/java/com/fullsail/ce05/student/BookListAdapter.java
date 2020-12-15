// Joe Glass

// JAV2 - C20201201

// BookListAdapter
package com.fullsail.ce05.student;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fullsail.ce05.R;

import java.util.List;


public class BookListAdapter extends BaseAdapter {

    private final Context context;


    final OnItemClickListener onItemClickListener;

    private final List<BookModel> list;
    final LayoutInflater inflater ;
    public BookListAdapter(Context context, List<BookModel> book, OnItemClickListener listener) {
        this.context = context;
        this.list = book;
        inflater = LayoutInflater.from(context);
        this.onItemClickListener = listener;
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

        view.setOnClickListener(view1 -> onItemClickListener.onClick(i));

        return view;
    }


}
