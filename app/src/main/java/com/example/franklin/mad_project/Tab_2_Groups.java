package com.example.franklin.mad_project;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myDb = database.getReference();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        myDb.child("users").child(user.getUid()).child("groups").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final List<Group> groups = new ArrayList<Group>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    List<Integer> users = new ArrayList<Integer>();
                    try {
                        //Group gTemp = new Group(snapshot.child("name").getValue().toString(), snapshot.child("category").getValue().toString(), users);
                        //groups.add(gTemp);
                        Group gTemp = new Group(snapshot.child("name").getValue().toString(), snapshot.child("category").getValue().toString(), users);
                        groups.add(gTemp);
                    }
                    catch (Exception e){

                        Toast.makeText(getContext(),getResources().getString(R.string.values),Toast.LENGTH_LONG).show();
                    }
                }

                CustomAdapterGroup adapter = new CustomAdapterGroup(getContext(), groups);
                listGroup.setAdapter(adapter);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

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
