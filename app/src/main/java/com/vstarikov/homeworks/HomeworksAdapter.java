package com.vstarikov.homeworks;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by vladstarikov on 14.10.15.
 */
public class HomeworksAdapter<T> extends ArrayAdapter<T> {
    public HomeworksAdapter(Context context, int resource) {
        super(context, resource);
    }

    public HomeworksAdapter(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public HomeworksAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
    }

    public HomeworksAdapter(Context context, int resource, int textViewResourceId, List objects) {
        super(context, resource, textViewResourceId, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = (TextView) super.getView(position, convertView, parent);
        textView.setText("Homework " + (position + 1));
        return textView;
    }
}
