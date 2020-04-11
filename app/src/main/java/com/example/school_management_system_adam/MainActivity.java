package com.example.school_management_system_adam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button login;
    private Button cancel;
    private Button signup;
    private TextView error;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.login_username);
        password = (EditText) findViewById(R.id.login_password);
        login = (Button) findViewById(R.id.login_button);
        cancel = (Button) findViewById(R.id.cancel_button);
        signup = (Button) findViewById(R.id.signup_button);
        error = (TextView) findViewById(R.id.error_dialogue);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = username.getText().toString();
                String passWord = password.getText().toString();
                validate(userName,passWord);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Reset the fields
                username.setText("");
                password.setText("");
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create a link to sign-up page
                Intent intent_link_signup = new Intent(MainActivity.this,Signup_Activity_1.class);
                startActivity(intent_link_signup);
            }
        });

    }

    private void validate(String username, String password)
    {
        if(true)
        {
            //Create a link to next page in case the sign-in validates
            Intent intent_link_home = new Intent(MainActivity.this, Home_Activity_0.class);
            startActivity(intent_link_home);
        }
        else
        {
            //Show a error on same page
            error.setText("Try Again...");
        }
    }


}
