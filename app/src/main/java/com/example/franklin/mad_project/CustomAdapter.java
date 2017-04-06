package com.example.franklin.mad_project;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by franklin on 03/04/17.
 */

public class CustomAdapter extends ArrayAdapter {
    private ArrayList dataSet;
    Context mContext;

    private static class ViewHolder{
        TextView txtName;
    }

    public CustomAdapter(ArrayList data, Context context){
        super(context, R.layout.tab_2_groups_text, data);
        this.dataSet= data;
        this.mContext = context;
    }

    @Nullable
    @Override
    public String getItem(int position){
        return (String) dataSet.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder viewHolder;
        if (convertView==null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.tab_2_groups_text, parent, false);
            viewHolder.txtName = (TextView)convertView.findViewById(R.id.GroupTextTittle);
        }
        else{
            viewHolder=(ViewHolder) convertView.getTag();
        }
        viewHolder.txtName.setText(getItem(position));
        return convertView;
    }

}
