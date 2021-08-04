package com.example.moboassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddProductActivity extends AppCompatActivity {

    Button save, cancel;
    EditText name, price;
    Spinner spinner;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        List<String> types = Arrays.asList("Drinks", "Food","Snacks");

        save = (Button)findViewById(R.id.buttonsave);
        cancel = (Button)findViewById(R.id.buttoncancel);
        name = (EditText) findViewById(R.id.editTextName);
        price = (EditText) findViewById(R.id.editTextPrice);
        spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, types);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = name.getText().toString();
                String Price = price.getText().toString();
                String Category = spinner.getSelectedItem().toString();

                Intent intent = new Intent(AddProductActivity.this, ViewProductActivity.class);
                intent.putExtra("KeyName", Name);
                intent.putExtra("KeyCategory", Category);
                intent.putExtra("KeyPrice", Price);
                startActivity(intent);

            }
        });






    }



}