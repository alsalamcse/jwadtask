package com.raslan.jwadtaskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;

public class Sittings extends AppCompatActivity {
    private CheckBox checkBox;
    private SeekBar sebasi;
    private Button sabt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sittings);
        checkBox=(CheckBox)findViewById(R.id.checkBox);
        sebasi=(SeekBar)findViewById(R.id.sebasi);
        sabt=(Button)findViewById(R.id.sabt);
    }
}
