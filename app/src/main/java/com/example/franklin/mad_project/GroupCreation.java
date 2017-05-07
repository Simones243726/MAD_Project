package com.example.franklin.mad_project;

import android.app.Activity;
import android.content.Intent;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Frank on 4/21/2017.
 */

public class GroupCreation extends Activity {
    SimpleCursorAdapter mAdapter;
    MatrixCursor mMatrixCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_creation_1);

        Button nextBtn = (Button) findViewById(R.id.ButtonCreateGroupNext);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nameText = (EditText)findViewById(R.id.TextNameGroup);
                String name = nameText.getText().toString();
                Bundle b = new Bundle();
                b.putString("group_name", name);

                Intent intent = new Intent(GroupCreation.this, GroupCreation2.class);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }
}
