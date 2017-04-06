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
        ArrayList exp_amount;

        if(b.getLong("index") == 0) {
            exp_names = group1_members;
            //exp_amount=group1_members_amount;
            exp_amount = b.getStringArrayList("group1");
        } else {
            //exp_amount=group2_members_amount;
            exp_names = group2_nembers;
            exp_amount = b.getStringArrayList("group2");
        }
        peopleView = (ListView) findViewById(R.id.people_expenses);
        CustomAdapter expAdapter = new CustomAdapter (exp_names, this);
        peopleView.setAdapter(expAdapter);

        peopleView = (ListView) findViewById(R.id.people_expenses);
        CustomAdapter amAdapter = new CustomAdapter (exp_amount, this);
        peopleView.setAdapter(amAdapter);



    }
}

