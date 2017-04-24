package com.example.franklin.mad_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by franklin on 24/04/17.
 */

public class CustomAdapterMembers extends ArrayAdapter<MemberList> {
    private MemberList[] dat;
    public CustomAdapterMembers (Context context, MemberList[] datos){
        super(context, R.layout.people_expenses_text, datos);
        this.dat = datos;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.people_expenses_text, null);

        TextView textMember = (TextView) item.findViewById(R.id.textName);
        textMember.setText(dat[position].getMember());

        TextView textAmount = (TextView) item.findViewById(R.id.textAmount);
        textAmount.setText(dat[position].getAmount());
        return (item);
    }
}
