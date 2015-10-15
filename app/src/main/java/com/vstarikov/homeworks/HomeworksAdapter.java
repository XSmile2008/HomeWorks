package com.vstarikov.homeworks;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.vstarikov.homeworks.second.SecondActivity;

import java.util.List;

/**
 * Created by vladstarikov on 14.10.15.
 */
public class HomeworksAdapter extends BaseAdapter {
    private final static String LOG_TAG = "HomeworksAdapter";

    private Context context;
    private List<Class> list;

    public HomeworksAdapter(Context context, List<Class> list) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        Button button = new Button(context);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, list.get(position)));
            }
        });
        button.setText((position + 1) + " homework");
        button.setWidth(500);
        return button;
    }
}
