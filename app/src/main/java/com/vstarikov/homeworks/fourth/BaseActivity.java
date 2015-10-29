package com.vstarikov.homeworks.fourth;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.vstarikov.homeworks.R;

/**
 * Created by Starikov on 26.10.15.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //if (savedInstanceState == null) {
            if (isAddFragment()) {
                setContentView(R.layout.activity_base);
                if (savedInstanceState == null) addFragment();
            } else setContentView(R.layout.activity_fourth);
        //}
    }

    abstract boolean isAddFragment();

    abstract void addFragment();
}
