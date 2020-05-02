package com.example.school_management_system_adam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class homeClass_Activity_2 extends AppCompatActivity {

    ImageView back_Button, admin;
    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_class__2);

        //If user is not logged
        if(!SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, MainActivity.class));
            return;
        }

        back_Button = (ImageView)findViewById(R.id.backButton);
        admin = (ImageView)findViewById(R.id.admin);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);

        back_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homepage = new Intent(homeClass_Activity_2.this, Home_Activity_0.class);
                startActivity(homepage);
            }
        });

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homepage = new Intent(homeClass_Activity_2.this, Home_Activity_0.class);
                startActivity(homepage);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addclass = new Intent(homeClass_Activity_2.this, addClass_Activity_3.class);
                startActivity(addclass);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addclass = new Intent(homeClass_Activity_2.this, addClass_Activity_3.class);
                startActivity(addclass);
            }
        });
    }
}
