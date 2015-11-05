package com.vstarikov.homeworks;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.vstarikov.homeworks.fifth.FifthActivity;
import com.vstarikov.homeworks.first.FirstActivity;
import com.vstarikov.homeworks.fourth.FourthActivity;
import com.vstarikov.homeworks.second.SecondActivity;
import com.vstarikov.homeworks.third.ThirdActivity;

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

        final HomeworksAdapter<Class> adapter = new HomeworksAdapter<Class>(this, android.R.layout.simple_list_item_1);
        adapter.add(FirstActivity.class);
        adapter.add(SecondActivity.class);
        adapter.add(ThirdActivity.class);
        adapter.add(FourthActivity.class);
        adapter.add(FifthActivity.class);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getApplicationContext(), (Class<?>) adapter.getItem(position)));
            }
        });
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
