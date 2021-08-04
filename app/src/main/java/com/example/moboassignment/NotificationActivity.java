package com.example.moboassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class NotificationActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        tv = (TextView)findViewById(R.id.textViewNotification);

        String message = getIntent().getStringExtra("message");
        tv.setText(message);
    }
}