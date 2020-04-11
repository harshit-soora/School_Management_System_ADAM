package com.example.school_management_system_adam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signup_Activity_1 extends AppCompatActivity {

    //DatabaseHelper db;
    EditText mTextUsername;
    EditText mTextPassword;
    EditText mTextCnfPassword;
    Button mButtonRegister;
    TextView mTextViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup__1);

       // db = new DatabaseHelper(this);

        mTextUsername = (EditText)findViewById(R.id.edittext_username);
        mTextPassword = (EditText)findViewById(R.id.edittext_password);
        mTextCnfPassword = (EditText)findViewById(R.id.edittext_cnf_password);
        mButtonRegister = (Button)findViewById(R.id.button_register);
        mTextViewLogin = (TextView)findViewById(R.id.textview_login);

        mTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LoginIntent = new Intent(Signup_Activity_1.this, MainActivity.class);
                startActivity(LoginIntent);
            }
        });

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                String cnf_pwd = mTextCnfPassword.getText().toString().trim();

                if(pwd.equals(cnf_pwd)){
                    //long val = db.addUser(user, pwd);
                    long val = 1;
                    if(val > 0)
                    {
                        Toast.makeText(Signup_Activity_1.this, "You Have Registered", Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent(Signup_Activity_1.this, MainActivity.class);
                        startActivity(moveToLogin);

                    }
                    else
                    {
                        Toast.makeText(Signup_Activity_1.this, "Registration Error",Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(Signup_Activity_1.this,"Password is not matching",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

