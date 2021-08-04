package com.example.moboassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;

import android.view.KeyEvent;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.PopupMenu;
import android.widget.Toast;

public class MenusActivity extends AppCompatActivity {

    ConstraintLayout layout;
    EditText myEditText;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);

        layout = findViewById(R.id.Layout);
        myEditText = (EditText)findViewById(R.id.editText);
        btn = (Button)findViewById(R.id.buttonback);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenusActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //context menu
        registerForContextMenu(layout);

        //Popup menu

        myEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                PopupMenu popupMenu = new PopupMenu(MenusActivity.this, myEditText);
                popupMenu.inflate(R.menu.pop_up_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()){
                            case R.id.ViewMenu:
                                Toast.makeText(MenusActivity.this, "View Products Details", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.EditMenu:
                                Toast.makeText(MenusActivity.this, "Edit Product", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.DeleteMenu:
                                Toast.makeText(MenusActivity.this, "Delete Menu", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return true;
                    }
                });
                return true;
            }
        });
    }

    //start-- Options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ViewMenu:
                Toast.makeText(MenusActivity.this, "View Products Details", Toast.LENGTH_SHORT).show();
                break;
            case R.id.EditMenu:
                Toast.makeText(MenusActivity.this, "Edit Product", Toast.LENGTH_SHORT).show();
                break;
            case R.id.DeleteMenu:
                Toast.makeText(MenusActivity.this, "Delete Menu", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }


    //End-- Options menu

    //Start-- Context Menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ViewMenu:
                Toast.makeText(MenusActivity.this, "View Products Details", Toast.LENGTH_SHORT).show();
                break;
            case R.id.EditMenu:
                Toast.makeText(MenusActivity.this, "Edit Product", Toast.LENGTH_SHORT).show();
                break;
            case R.id.DeleteMenu:
                Toast.makeText(MenusActivity.this, "Delete Menu", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
    //End-- Context Menu

}