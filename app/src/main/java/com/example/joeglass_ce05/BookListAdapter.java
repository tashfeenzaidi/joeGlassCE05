package com.example.joeglass_ce05;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class BookListAdapter extends BaseAdapter {

    private Context context;
    private List<BookModel> list;
    LayoutInflater inflater ;
    public BookListAdapter(Context context, List<BookModel> book) {
        this.context = context;
        this.list = book;
        inflater = LayoutInflater.from(context);
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

        return view;
    }
}
