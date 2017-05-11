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

        GroupList [] datos = new GroupList[]{
                new GroupList("London trip", "7", "+10€"),
                new GroupList("House", "3", "-7€"),
                new GroupList("Degree gift", "10", "-20€")
        };
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myDb = database.getReference();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final List<GroupList> groups = new ArrayList<GroupList>();

        myDb.child("users").child(user.getUid()).child("groups").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    GroupList glTemp = new GroupList(snapshot.child("name").getValue().toString(), snapshot.child("category").getValue().toString(), "0");
                    Log.d("debug", snapshot.child("name").toString());
                    groups.add(glTemp);
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
