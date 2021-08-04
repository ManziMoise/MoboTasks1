package com.example.moboassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OpenActivity extends AppCompatActivity {

    EditText ed;
    Button open, cancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);

        ed = (EditText)findViewById(R.id.editTextInfo);
        open = (Button)findViewById(R.id.buttonopen);
        cancel = (Button)findViewById(R.id.buttoncancel2);

        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String info = ed.getText().toString();
                if(PhoneNoOrWeb(info)){
                    Intent intent = new Intent(OpenActivity.this, CallActivity.class);
                    intent.putExtra("KeyPhoneInfo", info);
                    startActivity(intent);

                }else{
                    Intent intent = new Intent(OpenActivity.this, WebViewActivity.class);
                    intent.putExtra("KeyLinkInfo", info);
                    startActivity(intent);
                }

            }
        });


    }

    public boolean PhoneNoOrWeb(String input){

        try {
            Integer.parseInt(input);
        }catch (NumberFormatException ex){
            return false;
        }
        return true;
    }
}