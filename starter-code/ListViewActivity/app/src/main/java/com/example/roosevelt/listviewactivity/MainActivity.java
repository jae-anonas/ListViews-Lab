package com.example.roosevelt.listviewactivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayAdapter<String> mStateAdapter;
    BaseAdapter mBaseAdapter;
    ArrayList<String> mStateList;
    ListView mListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mListView = (ListView) findViewById(R.id.listview);

        mStateList = new ArrayList<>();
        mStateList.add("Arizona");
        mStateList.add("New York");
        mStateList.add("California");
        mStateList.add("Hawaii");

        mStateAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mStateList);

        mBaseAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return mStateList.size();
            }

            @Override
            public Object getItem(int i) {
                return mStateList.get(i);
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View convertView, ViewGroup viewGroup) {
                View view = convertView;
                if(view == null){
                    LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    view = inflater.inflate(android.R.layout.simple_list_item_1, null);
                }
                TextView textView = (TextView) view.findViewById(android.R.id.text1);
                textView.setText(mStateList.get(i));
                return view;
            }
        };

//        mListView.setAdapter(mStateAdapter);
        mListView.setAdapter(mBaseAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "You clicked list item " + i, Toast.LENGTH_SHORT).show();
                TextView tv = (TextView) view;
                tv.setText("I changed the text!");
                tv.setTextColor(Color.parseColor("#FF0000"));
            }
        });

        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                mStateList.remove(i);
                mBaseAdapter.notifyDataSetChanged();
                return true;
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStateList.add("Florida");
                mBaseAdapter.notifyDataSetChanged();
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
