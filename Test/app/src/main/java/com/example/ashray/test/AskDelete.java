package com.example.ashray.test;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.AlertDialog;
import android.database.Cursor;
import android.widget.Toast;

/**
 * Created by Ashray on 11-02-2017.
 */

public class AskDelete extends Activity {


    DBHandler db;
    ContactActivity ca;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        db = new DBHandler(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.askdelete);
        final EditText Ad1=(EditText)findViewById(R.id.Ad1);
        final  Button Ad2=(Button)findViewById(R.id.Ad2);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);


        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .8), (int) (height * .8));
        Ad2.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                Integer deletedRows = db.deleteData(Ad1.getText().toString());
                //startActivity(new Intent(getApplicationContext(),DBHandler.class));

                if(deletedRows > 0) {


                    Toast.makeText(AskDelete.this, "Data Deleted", Toast.LENGTH_LONG).show();
                    ca.count= ca.count-1;


                }

                else

                  Toast.makeText(AskDelete.this,"Data not Deleted",Toast.LENGTH_LONG).show();


            }
        }


        );




    }
}
