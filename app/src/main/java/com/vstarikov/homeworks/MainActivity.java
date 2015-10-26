package com.vstarikov.homeworks;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.vstarikov.homeworks.first.FirstActivity;
import com.vstarikov.homeworks.fourth.FourthActivity;
import com.vstarikov.homeworks.second.SecondActivity;
import com.vstarikov.homeworks.third.ThirdActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "GeekHub!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        List<Class> activities = new ArrayList<>();
        activities.add(FirstActivity.class);
        activities.add(SecondActivity.class);
        activities.add(ThirdActivity.class);
        activities.add(FourthActivity.class);
        HomeworksAdapter homeworksAdapter = new HomeworksAdapter(this, activities);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(homeworksAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_exit) {
            System.exit(1);//TODO: make correct exit
        }

        return super.onOptionsItemSelected(item);
    }
}
