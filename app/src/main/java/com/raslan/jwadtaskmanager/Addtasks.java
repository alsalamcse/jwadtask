package com.raslan.jwadtaskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import data.Mytask;

public class Addtasks extends AppCompatActivity {
    private EditText titx;
    private EditText sutx;
    private SeekBar seba;
    private Button savebt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtasks);

        titx=(EditText)findViewById(R.id.titx);
        sutx=(EditText)findViewById(R.id.sutx);
        seba=(SeekBar)findViewById(R.id.seba);
        savebt=(Button)findViewById(R.id.savebt);

        savebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();

            }
        });




    }

    private void dataHandler() {
        String title=titx.getText().toString();
        String subject=sutx.getText().toString();
        int seek=seba.getProgress();
        boolean isok=true;
        if (title.length()==0){
            titx.setError("enter title");
            isok=false;

        }
            if (subject.length()==0){
                sutx.setError("enter subject");
                isok=false;
            }
            if (isok)
            {
                Mytask t=new Mytask();
                t.setSubject(subject);
                t.setTitle(title);
                createMyTask(t);


            }
    }

    private void createMyTask(Mytask t)
    {
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference();
        String key = reference.child("tasks").push().getKey();
        reference.child("tasks").child(key).setValue(t);
    }


}
