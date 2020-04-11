package com.example.school_management_system_adam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Home_Activity_0 extends AppCompatActivity {

    ImageView img_class, img_subject, img_staffDetails, img_viewStaff, img_examDetails, img_viewExam, img_student, img_logout;
    TextView  text_class, text_subject, text_staffDetails, text_viewStaff, text_examDetails, text_viewExam, text_student, text_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__0);

        img_class = (ImageView)findViewById(R.id.img_class);
        img_subject = (ImageView)findViewById(R.id.img_subject);
        img_staffDetails = (ImageView)findViewById(R.id.img_staffDetails);
        img_viewStaff = (ImageView)findViewById(R.id.img_viewStaff);
        img_examDetails = (ImageView)findViewById(R.id.img_examDetails);
        img_viewExam = (ImageView)findViewById(R.id.img_viewExam);
        img_student = (ImageView)findViewById(R.id.img_student);
        img_logout = (ImageView)findViewById(R.id.img_logout);

        text_class = (TextView)findViewById(R.id.text_class);
        text_subject = (TextView)findViewById(R.id.text_subject);
        text_staffDetails = (TextView)findViewById(R.id.text_staffDetails);
        text_viewStaff = (TextView)findViewById(R.id.text_viewStaff);
        text_examDetails = (TextView)findViewById(R.id.text_examDetails);
        text_viewExam = (TextView)findViewById(R.id.text_viewExam);
        text_student = (TextView)findViewById(R.id.text_student);
        text_logout = (TextView)findViewById(R.id.text_logout);


        img_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Home_Activity_0.this,"Class",Toast.LENGTH_SHORT).show();
//                Intent homepage = new Intent(HomePage.this, MainActivity.class);
//                startActivity(homepage);
            }
        });

        img_subject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Home_Activity_0.this,"Subject",Toast.LENGTH_SHORT).show();
            }
        });

        img_staffDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Home_Activity_0.this,"Staff Details",Toast.LENGTH_SHORT).show();
            }
        });

        img_viewStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Home_Activity_0.this,"View Staff",Toast.LENGTH_SHORT).show();
            }
        });

        img_examDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Home_Activity_0.this,"Exam Details",Toast.LENGTH_SHORT).show();
            }
        });

        img_viewExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Home_Activity_0.this,"View Exam",Toast.LENGTH_SHORT).show();
            }
        });

        img_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Home_Activity_0.this,"Student",Toast.LENGTH_SHORT).show();
            }
        });

        img_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Home_Activity_0.this,"Logout",Toast.LENGTH_SHORT).show();
                Intent homepage = new Intent(Home_Activity_0.this, MainActivity.class);
                startActivity(homepage);
            }
        });

        text_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Home_Activity_0.this,"Class",Toast.LENGTH_SHORT).show();
//                Intent homepage = new Intent(Home_Activity_0.this, MainActivity.class);
//                startActivity(homepage);
            }
        });

        text_subject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Home_Activity_0.this,"Class",Toast.LENGTH_SHORT).show();
//                Intent homepage = new Intent(Home_Activity_0.this, MainActivity.class);
//                startActivity(homepage);
            }
        });

        text_staffDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Home_Activity_0.this,"Class",Toast.LENGTH_SHORT).show();
//                Intent homepage = new Intent(Home_Activity_0.this, MainActivity.class);
//                startActivity(homepage);
            }
        });

        text_viewStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Home_Activity_0.this,"Class",Toast.LENGTH_SHORT).show();
//                Intent homepage = new Intent(Home_Activity_0.this, MainActivity.class);
//                startActivity(homepage);
            }
        });

        text_examDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Home_Activity_0.this,"Class",Toast.LENGTH_SHORT).show();
//                Intent homepage = new Intent(Home_Activity_0.this, MainActivity.class);
//                startActivity(homepage);
            }
        });

        text_viewExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Home_Activity_0.this,"Class",Toast.LENGTH_SHORT).show();
//                Intent homepage = new Intent(Home_Activity_0.this, MainActivity.class);
//                startActivity(homepage);
            }
        });

        text_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Home_Activity_0.this,"Class",Toast.LENGTH_SHORT).show();
//                Intent homepage = new Intent(Home_Activity_0.this, MainActivity.class);
//                startActivity(homepage);
            }
        });

        text_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Home_Activity_0.this,"Class",Toast.LENGTH_SHORT).show();
                Intent homepage = new Intent(Home_Activity_0.this, MainActivity.class);
                startActivity(homepage);
            }
        });
    }
}
