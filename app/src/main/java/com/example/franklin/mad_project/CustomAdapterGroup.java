package com.example.franklin.mad_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by franklin on 17/04/17.
 */

public class CustomAdapterGroup extends ArrayAdapter<GroupList> {
        private List<GroupList> dat;
        public CustomAdapterGroup (Context context, List<GroupList> datos){
            super(context, R.layout.tab_2_groups_text, datos);
                this.dat = datos;
        }
        public View getView(int position, View convertView, ViewGroup parent){
                LayoutInflater inflater = LayoutInflater.from(getContext());
                View item = inflater.inflate(R.layout.tab_2_groups_text, null);

                TextView textTitle = (TextView) item.findViewById(R.id.GroupTextTittle);
                textTitle.setText(dat.get(position).getTitle());

                TextView textDesc = (TextView) item.findViewById(R.id.GroupMembersNumber);
                textDesc.setText(dat.get(position).getDescription());

                TextView textAmo = (TextView) item.findViewById(R.id.GroupTextAmount);
                textAmo.setText(dat.get(position).getAmount());
                return (item);
        }
    }

