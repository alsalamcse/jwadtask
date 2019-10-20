package com.raslan.jwadtaskmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signin extends AppCompatActivity {
    private EditText emailtx;
    private EditText passtx;
    private Button signinbt;
    private Button signupbt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigin);

        emailtx = (EditText) findViewById(R.id.emailtx);
        passtx = (EditText) findViewById(R.id.passtx);
        signinbt = (Button) findViewById(R.id.signinbt);
        signupbt = (Button) findViewById(R.id.siupbt);

        signupbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplication(),Signup.class);
                startActivity(intent);
            }
        });



        signinbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                dataHandler();

            }
        });

    }

    private void dataHandler() {
        String email = emailtx.getText().toString();
        String password = passtx.getText().toString();
        boolean isok=true;

        if (email.length()<4)
       {
           emailtx.setError("email length error");
           isok=false;
       }
       if(email.indexOf("@")<0 || email.indexOf(".")<0)
       {
            emailtx.setError("email wrong format");
            isok=false;
       }
        if (isValidEmailAddress(email)==false)
        {
            emailtx.setError("Invalid Email");
            isok = false;
        }

        if (password.length()<8)
        {
            passtx.setError("min length 8");
            isok=false;
        }
        if (isok)
        {signIn(email,password);

        }
    }
    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
    private void signIn(String email, String password)
    {
        FirebaseAuth auth=FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
             if (task.isSuccessful()){
                 // todo go to,main screen(all task activity)
                 Intent i=new Intent(getApplication(),MainTasksActivity.class);
                 startActivity(i);
                }
             else {
                 emailtx.setError("email or passord is wrong");
             }

            }
        });

    }

}