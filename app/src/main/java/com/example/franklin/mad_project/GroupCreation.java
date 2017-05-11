package com.example.franklin.mad_project;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.widget.SimpleCursorAdapter;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.net.Uri;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import  static com.example.franklin.mad_project.R.id.lst_contacts;




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
        Spinner spinner = (Spinner) findViewById(R.id.SpinnerGroupCategory);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.categories_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button nextBtn = (Button) findViewById(R.id.ButtonCreateGroupNext);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nameText = (EditText)findViewById(R.id.TextNameGroup);
                Spinner spinner = (Spinner) findViewById(R.id.SpinnerGroupCategory);
                String name = nameText.getText().toString();
                Bundle b = new Bundle();
                b.putString("group_name", name);
                b.putString("group_category", spinner.getSelectedItem().toString());

                Intent intent = new Intent(GroupCreation.this, GroupCreation2.class);
                intent.putExtras(b);
                startActivity(intent);

                //setContentView(R.layout.group_creation_1);

//                mMatrixCursor=new MatrixCursor(new String[]{"_id", "name", "photo", "details"});
//                mAdapter = new SimpleCursorAdapter(getBaseContext(), R.layout.group_creation_3_text, null, new String[]{"name", "photo", "details"}, new int[]{R.id.txtName, R.id.ImgContact,R.id.txtTel},0);
//                final ListView lstContacts = (ListView) findViewById(lst_contacts);
//
//                lstContacts.setAdapter(mAdapter);
//
//                lstContacts.setOnItemClickListener(new AdapterView.OnItemClickListener()
//                {
//
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view,
//                                            int position, long id) {
//                        String phoneNumber = ((TextView) view.findViewById(R.id.txtTel)).getText().toString();
//                        Toast.makeText(GroupCreation.this, phoneNumber, Toast.LENGTH_SHORT).show();
//                        //startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("sms:HOla que tal"+ phoneNumber)));
//                        //Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("sms:"+ phoneNumber));
//                        //intent.putExtra("sms_body", "Hello, Download this App");
//
//                        //startActivity(intent);
//                        SmsManager sms = SmsManager.getDefault();
//                        sms.sendTextMessage(phoneNumber, null, "Download this App", null, null);
//
//
//                    }
//                });
//
//                GroupCreation.ListViewContactsLoader listViewContactsLoader = new GroupCreation.ListViewContactsLoader();
//                listViewContactsLoader.execute();
            }
        });
    }

//    private class ListViewContactsLoader extends AsyncTask<Void, Void, Cursor> {
//
//        @Override
//        protected Cursor doInBackground(Void... params) {
//            Uri contactsUri = ContactsContract.Contacts.CONTENT_URI;
//
//            // Querying the table ContactsContract.Contacts to retrieve all the contacts
//            Cursor contactsCursor = getContentResolver().query(contactsUri, null, null, null,
//                    ContactsContract.Contacts.DISPLAY_NAME + " ASC ");
//
//            if(contactsCursor.moveToFirst()){
//                do{
//                    long contactId = contactsCursor.getLong(contactsCursor.getColumnIndex("_ID"));
//
//                    Uri dataUri = ContactsContract.Data.CONTENT_URI;
//
//                    // Querying the table ContactsContract.Data to retrieve individual items like
//                    // home phone, mobile phone, work email etc corresponding to each contact
//                    Cursor dataCursor = getContentResolver().query(dataUri, null,
//                            ContactsContract.Data.CONTACT_ID + "=" + contactId,
//                            null, null);
//
//                    String displayName="";
//                    String nickName="";
//                    String homePhone="";
//                    String mobilePhone="";
//                    String workPhone="";
//                    String photoPath="" + R.drawable.blank;
//                    byte[] photoByte=null;
//                    String homeEmail="";
//                    String workEmail="";
//                    String companyName="";
//                    String title="";
//
//                    if(dataCursor.moveToFirst()){
//                        // Getting Display Name
//                        displayName = dataCursor.getString(dataCursor.getColumnIndex(ContactsContract.Data.DISPLAY_NAME ));
//                        do{
//
//                            // Getting NickName
//                            if(dataCursor.getString(dataCursor.getColumnIndex("mimetype")).equals(ContactsContract.CommonDataKinds.Nickname.CONTENT_ITEM_TYPE))
//                                nickName = dataCursor.getString(dataCursor.getColumnIndex("data1"));
//
//                            // Getting Phone numbers
//                            if(dataCursor.getString(dataCursor.getColumnIndex("mimetype")).equals(ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)){
//                                switch(dataCursor.getInt(dataCursor.getColumnIndex("data2"))){
//                                    case ContactsContract.CommonDataKinds.Phone.TYPE_HOME :
//                                        homePhone = dataCursor.getString(dataCursor.getColumnIndex("data1"));
//                                        break;
//                                    case ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE :
//                                        mobilePhone = dataCursor.getString(dataCursor.getColumnIndex("data1"));
//                                        break;
//                                    case ContactsContract.CommonDataKinds.Phone.TYPE_WORK :
//                                        workPhone = dataCursor.getString(dataCursor.getColumnIndex("data1"));
//                                        break;
//                                }
//                            }
//
//                            // Getting EMails
//                            if(dataCursor.getString(dataCursor.getColumnIndex("mimetype")).equals(ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE ) ) {
//                                switch(dataCursor.getInt(dataCursor.getColumnIndex("data2"))){
//                                    case ContactsContract.CommonDataKinds.Email.TYPE_HOME :
//                                        homeEmail = dataCursor.getString(dataCursor.getColumnIndex("data1"));
//                                        break;
//                                    case ContactsContract.CommonDataKinds.Email.TYPE_WORK :
//                                        workEmail = dataCursor.getString(dataCursor.getColumnIndex("data1"));
//                                        break;
//                                }
//                            }
//
//                            // Getting Organization details
//                            if(dataCursor.getString(dataCursor.getColumnIndex("mimetype")).equals(ContactsContract.CommonDataKinds.Organization.CONTENT_ITEM_TYPE)){
//                                companyName = dataCursor.getString(dataCursor.getColumnIndex("data1"));
//                                title = dataCursor.getString(dataCursor.getColumnIndex("data4"));
//                            }
//
//                            // Getting Photo
//                            if(dataCursor.getString(dataCursor.getColumnIndex("mimetype")).equals(ContactsContract.CommonDataKinds.Photo.CONTENT_ITEM_TYPE)){
//                                photoByte = dataCursor.getBlob(dataCursor.getColumnIndex("data15"));
//
//                                if(photoByte != null) {
//                                    Bitmap bitmap = BitmapFactory.decodeByteArray(photoByte, 0, photoByte.length);
//
//                                    // Getting Caching directory
//                                    File cacheDirectory = getBaseContext().getCacheDir();
//
//                                    // Temporary file to store the contact image
//                                    File tmpFile = new File(cacheDirectory.getPath() + "/wpta_"+contactId+".png");
//
//                                    // The FileOutputStream to the temporary file
//                                    try {
//                                        FileOutputStream fOutStream = new FileOutputStream(tmpFile);
//
//                                        // Writing the bitmap to the temporary file as png file
//                                        bitmap.compress(Bitmap.CompressFormat.PNG,100, fOutStream);
//
//                                        // Flush the FileOutputStream
//                                        fOutStream.flush();
//
//                                        //Close the FileOutputStream
//                                        fOutStream.close();
//
//                                    } catch (Exception e) {
//                                        e.printStackTrace();
//                                    }
//                                    photoPath = tmpFile.getPath();
//                                }
//                            }
//                        }while(dataCursor.moveToNext());
//                        String details = "";
//
//                        // Concatenating various information to single string
//                        if(homePhone != null && !homePhone.equals("") )
//                            details = "HomePhone : " + homePhone + "\n";
//                        if(mobilePhone != null && !mobilePhone.equals("") )
//                            details += "MobilePhone : " + mobilePhone + "\n";
//                        if(workPhone != null && !workPhone.equals("") )
//                            details += "WorkPhone : " + workPhone + "\n";
//                        if(nickName != null && !nickName.equals("") )
//                            details += "NickName : " + nickName + "\n";
//                        if(homeEmail != null && !homeEmail.equals("") )
//                            details += "HomeEmail : " + homeEmail + "\n";
//                        if(workEmail != null && !workEmail.equals("") )
//                            details += "WorkEmail : " + workEmail + "\n";
//                        if(companyName != null && !companyName.equals("") )
//                            details += "CompanyName : " + companyName + "\n";
//                        if(title != null && !title.equals("") )
//                            details += "Title : " + title + "\n";
//
//                        // Adding id, display name, path to photo and other details to cursor
//                        mMatrixCursor.addRow(new Object[]{ Long.toString(contactId),displayName,photoPath,details});
//                    }
//                }while(contactsCursor.moveToNext());
//            }
//            return mMatrixCursor;
//        }
//
//        @Override
//        protected void onPostExecute(Cursor result) {
//            // Setting the cursor containing contacts to listview
//            mAdapter.swapCursor(result);
//        }
//    }

}
