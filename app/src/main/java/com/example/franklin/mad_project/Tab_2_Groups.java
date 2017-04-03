package com.example.franklin.mad_project;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


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
        ArrayList stringList = new ArrayList();
            stringList.add("Group 1");
            stringList.add("Group 2");
            stringList.add("Group 3");
            stringList.add("Group 4");


        CustomAdapter adapter = new CustomAdapter (stringList, getActivity());
        listGroup.setAdapter(adapter);





        return rootView;
    }
}
