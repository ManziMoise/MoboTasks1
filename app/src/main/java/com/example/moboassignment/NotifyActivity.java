package com.example.moboassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.InvocationTargetException;

public class NotifyActivity extends AppCompatActivity {

    Button notify, dialog, toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);

        notify= (Button)findViewById(R.id.buttonnotify);
        dialog= (Button)findViewById(R.id.buttondialog);
        toast= (Button)findViewById(R.id.buttontoast);


        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message= "this is a notification";
                NotificationCompat.Builder builder = new NotificationCompat.Builder(
                        NotifyActivity.this
                )
                        .setSmallIcon(R.drawable.ic_message)
                        .setContentTitle("New Notification")
                        .setContentText(message)
                        .setAutoCancel(true);

                Intent intent = new Intent(NotifyActivity.this, NotificationActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("message", message);

                PendingIntent pendingIntent = PendingIntent.getActivity(NotifyActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);

                NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(0,builder.build());

            }
        });

        dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            openDialog();
            }
        });

        toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NotifyActivity.this, "this is a Toast!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void openDialog(){
     Notifier notifier = new Notifier();
     notifier.show(getSupportFragmentManager(), "example dialog");
    }
}