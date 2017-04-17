package com.example.franklin.mad_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by franklin on 17/04/17.
 */

public class CustomAdapterPeopleExpenses extends ArrayAdapter<PeopleList> {
    private PeopleList[] dat;
    public CustomAdapterPeopleExpenses (Context context, PeopleList[] datos){
        super(context, R.layout.group_expenses_text, datos);
        this.dat = datos;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.group_expenses_text, null);

        TextView textItem = (TextView) item.findViewById(R.id.GroupExpenseItem);
        textItem.setText(dat[position].getItem());

        TextView textExp = (TextView) item.findViewById(R.id.GroupExpenseMember);
        textExp.setText(dat[position].getMember());

        TextView textAmo = (TextView) item.findViewById(R.id.GroupExpenseAmount);
        textAmo.setText(dat[position].getAmount());

        TextView textDate = (TextView) item.findViewById(R.id.GroupExpenseDate);
        textDate.setText(dat[position].getDate());

        TextView textGroup = (TextView) item.findViewById(R.id.GroupExpenseGroup);
        textGroup.setText(dat[position].getGroup());

        return (item);
    }
}
