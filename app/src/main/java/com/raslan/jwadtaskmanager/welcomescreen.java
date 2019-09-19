package com.raslan.jwadtaskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class welcomescreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomescreen);
        Thread th=new Thread()
        {
            @Override
            public void run() {
                try {
                    sleep(3*1000);
                    Intent i=new Intent(getApplication(),Signin.class);
                    startActivity(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        th.start();
    }
}

