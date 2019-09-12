package com.raslan.jwadtaskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

public class Signup extends AppCompatActivity {
    private EditText finatx;
    private EditText lanatx;
    private EditText phtx;
    private EditText emtx;
    private EditText pastx;
    private EditText repastx;
    private Button siupbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        finatx=(EditText)findViewById(R.id.finatx);
        lanatx=(EditText)findViewById(R.id.lanatx);
        phtx=(EditText)findViewById(R.id.phtx);
        emtx=(EditText)findViewById(R.id.emtx);
        pastx=(EditText)findViewById(R.id.passtx);
        repastx=(EditText)findViewById(R.id.repastx);
        siupbt=(Button) findViewById(R.id.siupbt);

    }
}
