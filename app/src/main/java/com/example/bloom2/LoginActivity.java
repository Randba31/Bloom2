package com.example.bloom2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class LoginActivity extends AppCompatActivity {
    private FirebaseServicesClass fbs;
    private UtilitiesClass utls;
    private EditText etusername,etpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        etusername=findViewById(R.id.etusernameSignup);
        etpassword=findViewById(R.id.etPasswordSignup);
        utls= UtilitiesClass.getInstance();
        fbs=FirebaseServicesClass.getInstance();
    }

    public void login(View view) {
        String username=etusername.getText().toString();
        String password=etpassword.getText().toString();
        //validation if empty
        if(username.trim().isEmpty()||password.trim().isEmpty())
        {
            Toast.makeText(this, "Username or Password is empty!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!(utls.validatePassword(this,password)|| utls.validateEmail(this,username)))
            return;

        fbs.getAuth().createUserWithEmailAndPassword(username, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
                        {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful())
                                {
                                    Intent i=new Intent(LoginActivity.this, MainPageActivity.class);
                                    startActivity(i);
                                }
                                else
                                {

                                    Toast.makeText(LoginActivity.this, "Username or password is empty!", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            }
                        }
                );
    }




    }





