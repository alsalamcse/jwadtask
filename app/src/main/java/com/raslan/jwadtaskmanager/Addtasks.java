package com.raslan.jwadtaskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;

public class Addtasks extends AppCompatActivity {
    private EditText titx;
    private EditText sutx;
    private SeekBar seba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtasks);

        titx=(EditText)findViewById(R.id.titx);
        sutx=(EditText)findViewById(R.id.sutx);
        seba=(SeekBar)findViewById(R.id.seba);

    }
}
