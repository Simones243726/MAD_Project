package com.example.franklin.mad_project;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.MatrixCursor;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*Almost all this code was generated by Android when I chose the Layout to work, only some
    * some changes were made.
    * */

    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    SimpleCursorAdapter mAdapter;
    MatrixCursor mMatrixCursor;
    int valPer = 0;
    private static final int PERMISSION_REQUEST_CODE_CONTACTS = 100;
    private static final int PERMISSION_REQUEST_CODE_SMS = 101;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        verifyPermissionContact();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, GroupCreation.class));
            }
        });
    }



    private void verifyPermissionContact(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS, Manifest.permission.SEND_SMS}, PERMISSION_REQUEST_CODE_CONTACTS);
        }
        else{
            Toast.makeText(this, getResources().getString(R.string.permission), Toast.LENGTH_SHORT).show();
            //Toast.makeText(this, "Displaying Contacts", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
    switch (requestCode){
        case PERMISSION_REQUEST_CODE_CONTACTS:{
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                verifyPermissionContact();
                Toast.makeText(this, getResources().getString(R.string.permission), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, getResources().getString(R.string.permission_contact), Toast.LENGTH_SHORT).show();
            }
        }
        return;
        case PERMISSION_REQUEST_CODE_SMS: {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                verifyPermissionContact();
                Toast.makeText(this, getResources().getString(R.string.permission), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, getResources().getString(R.string.permission_sms), Toast.LENGTH_SHORT).show();
            }
        }
        return;

    }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    Tab_1_Home tab1 = new Tab_1_Home();
                    return tab1;
                case 1:
                    Tab_2_Groups tab2 = new Tab_2_Groups();
                    return tab2;
                case 2:
                    Tab_3_Expenses tab3 = new Tab_3_Expenses();
                    return tab3;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getResources().getString(R.string.tab_label_home);
                    //return "Home";
                case 1:
                    return getResources().getString(R.string.tab_label_groups);
                    //return "Groups";
                case 2:
                    return getResources().getString(R.string.tab_label_expenses);
                    //return "Expenses";
            }
            return null;
        }
    }


}



