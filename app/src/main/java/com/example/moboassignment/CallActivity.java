package com.example.moboassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CallActivity extends AppCompatActivity {

    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        tv = (TextView)findViewById(R.id.textCallNo);


        String Info = getIntent().getStringExtra("KeyPhoneInfo");
        tv.setText("Calling: "+Info);


    }
}