package com.example.franklin.mad_project;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.util.RangeValueIterator;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import android.support.design.widget.FloatingActionButton;


/**
 * Created by franklin on 04/04/17.
 */

public class GroupExpenses extends Activity{
    ListView expensesView;

    PeopleList[] group1_names = new PeopleList[]{
            new PeopleList("Item 1", "Member 1", "You owe: $21", "17/05/2017", "Group 1"),
            new PeopleList("Item 1", "You", "You lent: $15", "17/05/2017", "Group 1"),
            new PeopleList("Item 2", "Member 3", "You owe: $2", "17/05/2017", "Group 1"),
    };

    PeopleList[] group2_names = new PeopleList[]{
            new PeopleList("Item 5", "Member 3", "You owe: $56", "17/05/2017", "Group 2"),
            new PeopleList("Item 4", "Member 5", "You owe: $21", "17/05/2017", "Group 2"),
            new PeopleList("Item 2", "You", "You lent: $31", "17/05/2017", "Group 2"),
            new PeopleList("Item 3", "Member 2", "You owe: 3", "17/05/2017", "Group 2"),
            new PeopleList("Item 2", "Member 5", "You owe: $23", "17/05/2017", "Group 2"),
            new PeopleList("Item 1", "You", "You lent: $12", "17/05/2017", "Group 2"),
            new PeopleList("Item 3", "Member 2", "You owe: $14", "17/05/2017", "Group 2")
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_expenses);

        //ArrayList group1_names = new ArrayList();
        //group1_names.add("1_exp1");
        //group1_names.add("1_exp2");
        //group1_names.add("1_exp3");
        //group1_names.add("1_exp4");

        //ArrayList group2_names = new ArrayList();
        //group2_names.add("2_exp1");
        //group2_names.add("2_exp2");
        //group2_names.add("2_exp3");
        //group2_names.add("2_exp4");

        final ArrayList group1_members_amount = new ArrayList();
        group1_members_amount.add("5");
        group1_members_amount.add("10");
        group1_members_amount.add("-2");

        final ArrayList group2_members_amount = new ArrayList();
        group2_members_amount.add("1");
        group2_members_amount.add("2");
        group2_members_amount.add("-3");
        group2_members_amount.add("-4");
        group2_members_amount.add("6");
        group2_members_amount.add("-7");
        group2_members_amount.add("-8");

        Bundle b = getIntent().getExtras();
        //ArrayList exp_names;
        PeopleList[] exp_names;

        if(b.getLong("index") == 0) {

            //exp_names = group1_names;
            //exp_names = group1_names;
            expensesView = (ListView) findViewById(R.id.group_expenses);
            CustomAdapterPeopleExpenses expAdapter = new CustomAdapterPeopleExpenses(this.getBaseContext(),group1_names);
            expensesView.setAdapter(expAdapter);


        } else {

            expensesView = (ListView) findViewById(R.id.group_expenses);
            CustomAdapterPeopleExpenses expAdapter = new CustomAdapterPeopleExpenses(this.getBaseContext(),group2_names);
            expensesView.setAdapter(expAdapter);


            //exp_names = group2_names;
        }





        //expensesView = (ListView) findViewById(R.id.group_expenses);
        //CustomAdapter expAdapter = new CustomAdapter (exp_names, this);
        //expensesView.setAdapter(expAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.addExp);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(GroupExpenses.this);
                LayoutInflater inflater = getLayoutInflater();
                // Inflate and set the layout for the dialog
                alertDialogBuilder.setView(inflater.inflate(R.layout.dialog_add_expense, null));

                final EditText expenseName = (EditText) findViewById(R.id.expenseAmount);
                // set title
                alertDialogBuilder.setTitle("Add expense");
                View promptView = inflater.inflate(R.layout.dialog_add_expense, null);
                final EditText editText = (EditText) promptView.findViewById(R.id.expenseAmount);
                alertDialogBuilder.setView(promptView);

                // setup a dialog window
                alertDialogBuilder.setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int id) {
                                int amount;
                                amount = Integer.parseInt(editText.getText().toString());

                                for(int i = 0; i<group1_members_amount.size(); i++){
                                    group1_members_amount.set(i, String.valueOf(amount+Integer.parseInt(group1_members_amount.get(i).toString())));


                                }

                                for(int i = 0; i<group2_members_amount.size(); i++){
                                    group2_members_amount.set(i, String.valueOf(amount+Integer.parseInt(group2_members_amount.get(i).toString())));


                                }
                                // resultText.setText("Hello, " + editText.getText());
                            }
                        })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });


                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();

            }
        });

        Button balance = (Button) findViewById(R.id.btnBalance);
        balance.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Bundle b = getIntent().getExtras();
                Bundle b1 = new Bundle();
                Intent newIntent = new Intent(GroupExpenses.this, PeopleExpenses.class);
                b1.putLong("index", b.getLong("index"));
                b1.putStringArrayList("group1",group1_members_amount);
                b1.putStringArrayList("group2",group2_members_amount);
                newIntent.putExtras(b1);
                startActivity(newIntent);
            }
        });

    }
}
