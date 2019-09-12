package com.raslan.jwadtaskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Signin extends AppCompatActivity {
    private EditText emailtx;
    private EditText passtx;
    private Button signinbt;
    private Button signupbt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigin);

        emailtx=(EditText)findViewById(R.id.emailtx);
        passtx=(EditText)findViewById(R.id.passtx);
        signinbt=(Button)findViewById(R.id.signinbt);
        signupbt=(Button)findViewById(R.id.siupbt);
    }
}
