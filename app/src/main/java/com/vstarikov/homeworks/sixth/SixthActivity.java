package com.vstarikov.homeworks.sixth;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.vstarikov.homeworks.R;

/**
 * Created by vladstarikov on 14.11.15.
 */
public class SixthActivity extends AppCompatActivity implements MyManager{

    FrameLayout containerA;
    FrameLayout containerB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        containerA = (FrameLayout) findViewById(R.id.containerA);
        containerB = (FrameLayout) findViewById(R.id.containerB);

        FragmentManager fragmentManager = getSupportFragmentManager();

        Fragment fragmentA = new FragmentA();
        fragmentManager.beginTransaction().add(R.id.containerA, fragmentA).commit();
        if (containerB != null) {
            Fragment fragmentB = new FragmentB();
            fragmentManager.beginTransaction().add(R.id.containerB, fragmentB).commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void update(int data) {

    }
}
