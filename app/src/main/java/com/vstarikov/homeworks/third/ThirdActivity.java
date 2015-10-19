package com.vstarikov.homeworks.third;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.vstarikov.homeworks.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Starikov on 19.10.15.
 */
public class ThirdActivity extends Activity {
    private String[] values = new String[] { "Android", "iPhone", "WindowsMobile", "Blackberry", "Ubuntu", "Windows7", "Mac OS X", "Linux", "Ubuntu", "Windows7", "Mac OS X", "Linux", "Ubuntu", "Windows7", "Android", "iPhone", "WindowsMobile" };

    TextView textView1;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);

        /*String s = "";//TODO: traditional way
        for (String value : values) s += value + ", ";
        textView1.setText(s.substring(0, s.length() - 2));*/

        textView1.setText(TextUtils.join(", ", Arrays.asList(values)));//TODO: new way

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> reversed = new ArrayList<>(Arrays.asList(values));
                Collections.reverse(reversed);
                textView2.setText(TextUtils.join(", ", reversed));
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> list = new ArrayList<>();
                for (int i = 0; i < values.length; i++)
                    if ((i + 1) % 3 != 0) list.add(values[i]);
                textView2.setText(TextUtils.join(", ", list));
            }
        });

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setText(TextUtils.join(", ", new HashSet<>(Arrays.asList(values))));
            }
        });

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> list = new ArrayList<>(Arrays.asList(values));
                Collections.sort(list);
                textView2.setText(TextUtils.join(", ", list));
            }
        });
    }
}
