package com.example.franklin.mad_project;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by franklin on 06/04/17.
 */

public class PeopleExpenses extends Activity {
    ListView peopleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.people_expenses);

        ArrayList group1_members = new ArrayList();
        group1_members.add("Name 1");
        group1_members.add("Name 2");
        group1_members.add("Name 3");
        group1_members.add("Name 4");

        ArrayList group2_members = new ArrayList();
        group2_members.add("Name 1");
        group2_members.add("Name 2");
        group2_members.add("Name 3");
        group2_members.add("Name 4");

        Bundle b = getIntent().getExtras();
        ArrayList exp_names;
        if(b.getLong("index") == 0) {
            exp_names = group1_members;
        } else {
            exp_names = group2_members;
        }
        peopleView = (ListView) findViewById(R.id.people_expenses);
        CustomAdapter expAdapter = new CustomAdapter (exp_names, this);
        peopleView.setAdapter(expAdapter);

    }
}

