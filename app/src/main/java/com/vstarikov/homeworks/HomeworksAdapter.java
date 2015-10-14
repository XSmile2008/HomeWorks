package com.vstarikov.homeworks;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import java.util.List;

/**
 * Created by vladstarikov on 14.10.15.
 */
public class HomeworksAdapter extends BaseAdapter {
    private final static String LOG_TAG = "HomeworksAdapter";

    private Context context;
    private List<Button> list;

    public HomeworksAdapter(Context context, List<Button> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return list.get(position);
    }
}
