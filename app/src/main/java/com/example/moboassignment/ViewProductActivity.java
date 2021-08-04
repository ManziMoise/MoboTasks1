package com.example.moboassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ViewProductActivity extends AppCompatActivity {

    TextView names, categories, prices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_product);

        names = (TextView)findViewById(R.id.TextName);
        categories = (TextView)findViewById(R.id.TextCategory);
        prices = (TextView)findViewById(R.id.TextPrice);

        String namess= getIntent().getStringExtra("KeyName");
        String categoriess= getIntent().getStringExtra("KeyCategory");
        String pricess= getIntent().getStringExtra("KeyPrice");

        names.setText(namess);
        categories.setText(categoriess);
        prices.setText(pricess);
    }
}