package com.example.franklin.mad_project;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;


/**
 * Created by franklin on 02/04/17.
 */



public class Tab_2_Groups extends Fragment {
    ListView listGroup;
    public Tab_2_Groups(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_2_groups, container, false);

        listGroup = (ListView) rootView.findViewById(R.id.listViewGroups);
        //ArrayList stringList = new ArrayList();
        //    stringList.add("Group 1");
        //    stringList.add("Group 2");

        //CustomAdapter adapter = new CustomAdapter (stringList, getActivity());
        //listGroup.setAdapter(adapter);

        ///

        //listGroup = (ListView)findViewById(R.id.listViewGroups);
        GroupList [] datos = new GroupList[]{
                new GroupList("London trip", "7", "+10€"),
                new GroupList("House", "3", "-7€"),
                new GroupList("Degree gift", "10", "-20€")
        };
        CustomAdapterGroup adapter = new CustomAdapterGroup(this.getContext(), datos);
        listGroup.setAdapter(adapter);
        //

        listGroup.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle b = new Bundle();
                Intent newIntent = new Intent(Tab_2_Groups.this.getActivity(), GroupExpenses.class);
                b.putLong("index", id);
                newIntent.putExtras(b);
                getActivity().startActivity(newIntent);
            }
        });
        return rootView;
    }

}
