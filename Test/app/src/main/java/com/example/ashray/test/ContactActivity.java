package com.example.ashray.test;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.AlertDialog;
import android.database.Cursor;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.R.id.edit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;




public class ContactActivity extends ActionBarActivity {


    DBHandler myDb;
    EditText editName,editMob,editTextId;
    Button btnAddData;
    Button btnviewAll;
    Button btnDelete;
    int count;
    AskDelete ad;
    Button btnviewUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        myDb = new DBHandler(this);
        editName = (EditText)findViewById(R.id.editText_name);
        editMob = (EditText)findViewById(R.id.editText_number);
        btnAddData = (Button)findViewById(R.id.button_add);
        btnviewAll = (Button)findViewById(R.id.button_viewAll);
        btnviewUpdate= (Button)findViewById(R.id.button_update);
        btnDelete= (Button)findViewById(R.id.button_delete);
        AddData();
        viewAll();
        UpdateData();
        DeleteData();
    }
    public void DeleteData() {

        btnDelete.setOnClickListener(new View.OnClickListener() {


                                         @Override
                                         public void onClick(View v) {
                                             startActivity(new Intent(getApplicationContext(),AskDelete.class));
                                         }
                                     }


        );

                        //Intent del = new Intent(getApplicationContext(),AskDelete.class);
                        //startActivity(del);
                        //Integer deletedRows = myDb.deleteData(editTextId.getText().toString());
                        //if(deletedRows > 0)
                        //    Toast.makeText(ContactActivity.this,"Data Deleted",Toast.LENGTH_LONG).show();
                        //else
                          //  Toast.makeText(ContactActivity.this,"Data not Deleted",Toast.LENGTH_LONG).show();


    }
    public void UpdateData() {
        btnviewUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updateData(editTextId.getText().toString(),
                                editName.getText().toString(),
                                editMob.getText().toString());
                        if(isUpdate == true)
                            Toast.makeText(ContactActivity.this,"Data Update",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(ContactActivity.this,"Data not Updated",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public  void AddData() {

        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (count<3){

                            boolean isInserted = myDb.insertData(editName.getText().toString(),
                                    editMob.getText().toString());


                            if (isInserted == true) {

                                Toast.makeText(ContactActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                                count = count + 1;
                            }
                            else
                                Toast.makeText(ContactActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            btnAddData.setEnabled(false);
                            Toast.makeText(ContactActivity.this, "You've entered max no. of recipients", Toast.LENGTH_LONG).show();
                        }
                    }

                }
        );
    }
    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id :"+ res.getString(0)+"\n");
                            buffer.append("Name :"+ res.getString(1)+"\n");
                            buffer.append("Mobile :"+ res.getString(2)+"\n\n");
                        }

                        // Show all data
                        showMessage("Data",buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }



}





