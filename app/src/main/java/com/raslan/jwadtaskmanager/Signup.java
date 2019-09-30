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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

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
        pastx=(EditText)findViewById(R.id.pastx);
        repastx=(EditText)findViewById(R.id.repastx);
        siupbt=(Button) findViewById(R.id.siupbt);

        siupbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datahandler();

            }
        });




    }
    private void datahandler(){
        boolean isok=true;
        String fina=finatx.getText().toString();
        String lana=lanatx.getText().toString();
        String phnu=phtx.getText().toString();
        String em=emtx.getText().toString();
        String pas=pastx.getText().toString();
        String repas=repastx.getText().toString();
        if (em.length()<4||
         em.indexOf('@')<=0||
        em.indexOf('.')<0)
        {
        emtx.setError("Wrong error");
        isok=false;
        }
        if (pas.length()<8|| pas.equals(repas)==false)
        {
         repastx.setError("have to be at least 8 letters");
         pastx.setError("have to be at least 8 char and the same password");
         isok=false;
        }
        if (fina.length()==0)
        {
            finatx.setError("enter name");
            isok=false;
        }
        if (isok)
        {
            createAcount(em,pas,fina,lana,phnu);
        }
    }

    private void createAcount(String em, String pas, String fina, String lana, String phnu)
    {
        FirebaseAuth auth=FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(em,pas).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(Signup.this, "signup Successful", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else
                {
                    emtx.setError("sign up failed");
                }
            }
             });
    }

}
