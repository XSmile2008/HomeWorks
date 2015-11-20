package com.vstarikov.homeworks.sixth;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.vstarikov.homeworks.R;

/**
 * Created by vladstarikov on 14.11.15.
 */
public class SixthActivity extends AppCompatActivity implements Selector {

    int key;
    boolean fragmentBCreated = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        if (savedInstanceState == null) {
            FragmentA fragmentA = new FragmentA();
            fragmentManager.beginTransaction().add(R.id.containerA, fragmentA).commit();
        } else {
            this.key = savedInstanceState.getInt("key");
            this.fragmentBCreated = savedInstanceState.getBoolean("fragmentB");
        }

        if (findViewById(R.id.containerB) != null) {
            if (fragmentManager.getBackStackEntryCount() > 0) fragmentManager.popBackStack();
            if (!fragmentBCreated) {//if we rotate from phone mode or start Activity for first time
                Bundle bundle = new Bundle();
                bundle.putInt("key", key);
                FragmentB fragmentB = new FragmentB();
                fragmentB.setArguments(bundle);
                fragmentManager.beginTransaction().add(R.id.containerB, fragmentB).commit();
                fragmentBCreated = true;
            }
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
    public void select(int key) {
        this.key = key;
        if (findViewById(R.id.containerB) != null) {
            ((FragmentB) getSupportFragmentManager().getFragments().get(1)).update(key);
        } else {
            Bundle bundle = new Bundle();
            bundle.putInt("key", key);
            FragmentB fragmentB = new FragmentB();
            fragmentB.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.containerA, fragmentB).addToBackStack("nyan").commit();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        onSaveInstanceState(new Bundle());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("key", key);
        outState.putBoolean("fragmentB", fragmentBCreated);
        super.onSaveInstanceState(outState);
    }

}
