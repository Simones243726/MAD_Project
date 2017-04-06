package com.example.franklin.mad_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

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
        group1_members.add("Member 1");
        group1_members.add("Member 2");
        group1_members.add("Member 3");
        group1_members.add("Member 4");

        ArrayList group2_nembers = new ArrayList();
        group2_nembers.add("Member 5");
        group2_nembers.add("Member 6");
        group2_nembers.add("Member 7");
        group2_nembers.add("Member 8");

        Bundle b = getIntent().getExtras();
        ArrayList exp_names;

        if(b.getLong("index") == 0) {
            exp_names = group1_members;
        } else {
            exp_names = group2_nembers;
        }
        peopleView = (ListView) findViewById(R.id.people_expenses);
        CustomAdapter expAdapter = new CustomAdapter (exp_names, this);
        peopleView.setAdapter(expAdapter);



    }
}

