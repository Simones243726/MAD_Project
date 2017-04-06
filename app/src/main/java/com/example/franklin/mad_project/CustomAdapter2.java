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
 * Created by franklin on 06/04/17.
 */

public class CustomAdapter2 extends ArrayAdapter {
    private ArrayList dataSet, dataSet2;
    Context mContext;

    private static class ViewHolder2{
        TextView txtName;
    }

    public CustomAdapter2(ArrayList data, ArrayList data1, Context context){
        super(context, R.layout.tab_2_groups_text, data);
        this.dataSet= data;
        this.mContext = context;
        this.dataSet2 = data1;
    }

    @Nullable
    @Override
    public String getItem(int position){
        return (String) dataSet.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        CustomAdapter2.ViewHolder2 viewHolder;
        if (convertView==null) {
            viewHolder = new CustomAdapter2.ViewHolder2();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.tab_2_groups_text, parent, false);
            viewHolder.txtName = (TextView)convertView.findViewById(R.id.GroupTextTittle);
            viewHolder.txtName.setText(getItem(position));
        }
        else{
            viewHolder=(CustomAdapter2.ViewHolder2) convertView.getTag();
        }
        return convertView;
    }

}
