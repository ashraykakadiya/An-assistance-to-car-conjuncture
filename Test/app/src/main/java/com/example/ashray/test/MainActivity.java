package com.example.ashray.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // ToggleButton Sbutton = (ToggleButton) findViewById(R.id.Sbutton);
       /* Sbutton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    //bluetooth background activity
                    Intent BackBlueIntent = new Intent(this, BackActivity.class);
                    MainActivity.this.startActivity(BackBlueIntent);
                }
                else
                {
                    //background activity will be stopped
                }
            }
        });
        */
        Button CButton = (Button) findViewById(R.id.Cbutton);
        CButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ci = new Intent(getApplicationContext(),ContactActivity.class);
                startActivity(ci);
            }
        });

        Button SSButton = (Button) findViewById(R.id.ssbutton);
        SSButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent si = new Intent(getApplicationContext(),ssservice.class);
                startActivity(si);
            }
        });

        Button SMSButton = (Button) findViewById(R.id.smsbutton);
        SMSButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent smi = new Intent(getApplicationContext(),SMSmodule.class);
                startActivity(smi);
            }
        });


    }
}

