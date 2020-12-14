package com.fullsail.ce05.student;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fullsail.ce05.R;

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

        ImageView thumbnail = view.findViewById(R.id.thumbnail);
        TextView title = view.findViewById(R.id.title);

        thumbnail.setImageResource(R.mipmap.ic_launcher_round);
        title.setText(list.get(i).getTitle());
        return view;
    }
}
