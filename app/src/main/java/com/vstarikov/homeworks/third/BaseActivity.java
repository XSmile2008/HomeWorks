package com.vstarikov.homeworks.third;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Starikov on 26.10.15.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    abstract boolean isAddFragment();
}
