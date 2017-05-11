package com.example.franklin.mad_project;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by franklin on 17/04/17.
 */

public class CustomAdapterGroup extends ArrayAdapter<Group> {
        private List<Group> dat;
        public CustomAdapterGroup (Context context, List<Group> datos){
            super(context, R.layout.tab_2_groups_text, datos);
                this.dat = datos;
        }
        public View getView(int position, View convertView, ViewGroup parent){
                LayoutInflater inflater = LayoutInflater.from(getContext());
                View item = inflater.inflate(R.layout.tab_2_groups_text, null);

                TextView textTitle = (TextView) item.findViewById(R.id.GroupTextTittle);
                textTitle.setText(dat.get(position).getName());

                TextView textDesc = (TextView) item.findViewById(R.id.GroupMembersNumber);
                textDesc.setText("2");
                //dat.get(position).getUsers().size()

                TextView textAmo = (TextView) item.findViewById(R.id.GroupTextAmount);
                textAmo.setText("0");

                ImageView groupIcon = (ImageView) item.findViewById(R.id.groupIcon);
                String icon = dat.get(position).getCategory();
                int res = this.getContext().getResources().getIdentifier(icon.toLowerCase(), "drawable", "com.example.franklin.mad_project");
                groupIcon.setImageResource(res);
                return (item);
        }
    }

