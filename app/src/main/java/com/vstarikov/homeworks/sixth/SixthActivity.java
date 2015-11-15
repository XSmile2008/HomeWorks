package com.vstarikov.homeworks.sixth;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.vstarikov.homeworks.R;

/**
 * Created by vladstarikov on 14.11.15.
 */
public class SixthActivity extends AppCompatActivity implements Selector {

    FragmentA fragmentA;
    FragmentB fragmentB;

    int key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        //if (savedInstanceState != null) key = savedInstanceState.getInt("key") ;//TODO

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentA = new FragmentA();
        fragmentManager.beginTransaction().add(R.id.containerA, fragmentA).commit();
        if (findViewById(R.id.containerB) != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("key", key);
            fragmentB = new FragmentB();
            fragmentB.setArguments(bundle);
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
    public void select(int key) {
        if (findViewById(R.id.containerB) != null) {
            ((FragmentB)getSupportFragmentManager().getFragments().get(1)).update(key);
            Log.i("nyan", "nyan");
        } else {
            Bundle bundle = new Bundle();
            bundle.putInt("key", key);
            fragmentB = new FragmentB();
            fragmentB.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.containerA, fragmentB).addToBackStack("nyan").commit();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt("key", key);//TODO
    }
}
