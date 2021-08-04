package com.example.moboassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    TextView resulttv;
    boolean isNewOp = true;
    String op = "+";
    String oldNumber="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        resulttv = (TextView) findViewById(R.id.resulttextView);

    }
    public void numberEvent(View view){

        if(isNewOp)
            resulttv.setText("");
        isNewOp= false;

        String number = resulttv.getText().toString();

        switch (view.getId()){
            case R.id.button1:
                number += "1";
                break;
            case R.id.button2:
                number += "2";
                break;
            case R.id.button3:
                number += "3";
                break;
            case R.id.button4:
                number += "4";
                break;
            case R.id.button5:
                number += "5";
                break;
            case R.id.button6:
                number += "6";
                break;
            case R.id.button7:
                number += "7";
                break;
            case R.id.button8:
                number += "8";
                break;
            case R.id.button9:
                number += "9";
                break;
            case R.id.button0:
                number += "0";
                break;
            case R.id.dotButton:
                number += ".";
                break;
            case R.id.PlusMinusButton:
                number ="-"+number;
                break;
        }
        resulttv.setText(number);
    }

    public void operatorEvent(View view){

        isNewOp = true;
        oldNumber = resulttv.getText().toString();
        switch (view.getId()){
            case R.id.divideButton:
                op = "/";
                break;
            case R.id.multiButton:
                op = "*";
                break;
            case R.id.subButton:
                op = "-";
                break;
            case R.id.addButton:
                op = "+";
                break;
        }

    }

    public void equalEvent(View view) {
        String newNumber = resulttv.getText().toString();
        double result = 0.0;
        switch (op){
            case "+":
                result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                break;
            case "- ":
                result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                break;
            case "*":
                result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                break;
            case "/":
                result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                break;
        }
        resulttv.setText(result+"");

    }

    public void clearEvent(View view) {

        resulttv.setText("0");
        isNewOp = true;
    }

    public void modEvent(View view) {

        double no = Double.parseDouble(resulttv.getText().toString())/100;
        resulttv.setText(no+"");
        isNewOp = true;
    }
}