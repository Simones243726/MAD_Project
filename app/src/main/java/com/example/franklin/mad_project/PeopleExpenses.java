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

        ArrayList group2_nembers = new ArrayList();
        group2_nembers.add("Member 4");
        group2_nembers.add("Member 5");
        group2_nembers.add("Member 6");
        group2_nembers.add("Member 7");

        Bundle b = getIntent().getExtras();
        ArrayList exp_names;
        ArrayList exp_amount;

        if (b.getLong("index") == 0) {

            exp_names = group1_members;
            exp_amount = b.getStringArrayList("group1");
        } else {
            exp_names = group2_nembers;
            exp_amount = b.getStringArrayList("group2");
        }
        peopleView = (ListView) findViewById(R.id.people_expenses);
        CustomAdapter expAdapter = new CustomAdapter (exp_names, this);
        peopleView.setAdapter(expAdapter);

        peopleView = (ListView) findViewById(R.id.people_expenses);
        CustomAdapter amAdapter = new CustomAdapter (exp_amount, this);
        peopleView.setAdapter(amAdapter);


        //MemberList[] Lista1 = new MemberList[]{
        //        new MemberList("Item 1", "Member 1"),
        //        new MemberList("Item 1", "You"),
        //        new MemberList("Item 2", "Member 3"),
        //};

        //MemberList[] Lista1 = new MemberList[]{
        //        new MemberList("Member 1", "3"),
       //         new MemberList("Member 2", "4"),
       //         new MemberList("Member 3", "5"),
        //};


        //peopleView = (ListView) findViewById(R.id.people_expenses);
        //CustomAdapterMembers amAdapter = new CustomAdapterMembers(this.getBaseContext(), Lista1);
        //peopleView.setAdapter(amAdapter);


    }
}

