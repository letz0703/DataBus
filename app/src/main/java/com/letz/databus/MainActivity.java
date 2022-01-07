package com.letz.databus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;

public class MainActivity extends AppCompatActivity
{

    EditText message;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message = findViewById(R.id.etMessage);
        send = findViewById(R.id.btnSend);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        fragment fr = new fragment();
        ft.add(R.id.frame_layout, fr);
        ft.commit();

        send.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String userMessage = message.getText().toString();

                EventBus.getDefault().post(new Messages(userMessage));
            }
        });
    }
}