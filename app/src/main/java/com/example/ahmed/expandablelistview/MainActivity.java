package com.example.ahmed.expandablelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // declare the variable needed in activity
    MyExpandableAdapter expandableadapter;
    ExpandableListView expandableListView;
    List<String> headers;
    HashMap<String,List<String>> headeritems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get expandable listview
        expandableListView=(ExpandableListView)findViewById(R.id.expandlist);

        //get data to be set to list
        prepareDummyData();

        // get expandable list adapter
        expandableadapter=new MyExpandableAdapter(this,headers,headeritems);
        //set list adapter to list
        expandableListView.setAdapter(expandableadapter);
        //handling the header items click
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(MainActivity.this,headers.get(groupPosition)+"--"+headeritems.get(headers.get(groupPosition)).get(childPosition),Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        //get the expand of headers
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(MainActivity.this,headers.get(groupPosition),Toast.LENGTH_SHORT).show();
            }
        });
        //get the collapse of headers
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(MainActivity.this,headers.get(groupPosition),Toast.LENGTH_SHORT).show();
            }
        });
    }
    // get dummy data to be set to adapter
    public void prepareDummyData()
    {
        headers=new ArrayList<String>();
        headeritems=new HashMap<String,List<String>>();
        //adding headers
        headers.add("Primary");
        headers.add("Senior Secondary");
        headers.add("College");
        //preparing header items data
        List<String> primary=new ArrayList<String>();
        primary.add("first class");
        primary.add("second class");
        primary.add("third class");
        List<String> secondary=new ArrayList<String>();
        secondary.add("eighth class");
        secondary.add("ninth class");
        secondary.add("tenth class");
        List<String> college=new ArrayList<String>();
        college.add("CSE");
        college.add("ECE");
        college.add("IT");
        //contain header and header items
        headeritems.put(headers.get(0), primary);
        headeritems.put(headers.get(1), secondary);
        headeritems.put(headers.get(2),college);
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