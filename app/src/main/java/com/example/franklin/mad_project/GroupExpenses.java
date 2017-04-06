package com.example.franklin.mad_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;


/**
 * Created by franklin on 04/04/17.
 */

public class GroupExpenses extends Activity{
    ListView expensesView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_expenses);

        ArrayList group1_names = new ArrayList();
        group1_names.add("1_exp1");
        group1_names.add("1_exp2");
        group1_names.add("1_exp3");
        group1_names.add("1_exp4");

        ArrayList group2_names = new ArrayList();
        group2_names.add("2_exp1");
        group2_names.add("2_exp2");
        group2_names.add("2_exp3");
        group2_names.add("2_exp4");

        Bundle b = getIntent().getExtras();
        ArrayList exp_names;
        if(b.getLong("index") == 0) {
            exp_names = group1_names;
        } else {
            exp_names = group2_names;
        }





        expensesView = (ListView) findViewById(R.id.group_expenses);
        CustomAdapter expAdapter = new CustomAdapter (exp_names, this);
        expensesView.setAdapter(expAdapter);

        Button balance = (Button) findViewById(R.id.btnBalance);
        balance.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Bundle b = getIntent().getExtras();

                Bundle b1 = new Bundle();
                Intent newIntent = new Intent(GroupExpenses.this, PeopleExpenses.class);
                b1.putLong("index", b.getLong("index"));
                newIntent.putExtras(b1);
                startActivity(newIntent);


                //Intent intent = new Intent(view.getContext(),PeopleExpenses.class);
                //startActivityForResult(intent,0);
                //finish();
            }
        });

    }
}
