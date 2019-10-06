package com.raslan.jwadtaskmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
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

    private void createMyTask(final Mytask t)
    {
        FirebaseDatabase database=FirebaseDatabase.getInstance();

        DatabaseReference reference = database.getReference();

        String key = reference.child("tasks").push().getKey();
        reference.child("tasks").child(key).setValue(t).addOnCompleteListener(Addtasks.this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(Addtasks.this, "Add Successful", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else{
                    Toast.makeText(Addtasks.this, "Add Failed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        }


    }


}
