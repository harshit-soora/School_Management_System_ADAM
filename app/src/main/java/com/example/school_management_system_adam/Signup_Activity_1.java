package com.example.school_management_system_adam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Signup_Activity_1 extends AppCompatActivity {


    private EditText mTextUsername;
    private EditText mTextPassword;
    private EditText mTextCnfPassword;
    private EditText mTextEmail;
    private Button mButtonRegister;
    private TextView mTextViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup__1);

        //If user is already logged-in
        if(SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, Home_Activity_0.class));
            return;
        }

        mTextUsername = (EditText)findViewById(R.id.edittext_username);
        mTextPassword = (EditText)findViewById(R.id.edittext_password);
        mTextEmail = (EditText)findViewById(R.id.editText_email);
        mTextCnfPassword = (EditText)findViewById(R.id.edittext_cnf_password);
        mButtonRegister = (Button)findViewById(R.id.button_register);
        mTextViewLogin = (TextView)findViewById(R.id.textview_login);

        //Redirect in case of Login
        mTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LoginIntent = new Intent(Signup_Activity_1.this, MainActivity.class);
                finish();
                startActivity(LoginIntent);
            }
        });


        //Lets us make a entry in database
        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                String cnf_pwd = mTextCnfPassword.getText().toString().trim();
                String email = mTextEmail.getText().toString().trim();

                if(pwd.equals(cnf_pwd)){
                    registerUser(user,pwd,email);
                }
                else
                {
                    Toast.makeText(Signup_Activity_1.this,"Password is not matching",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    //Better to make the function private for the sake of Encapsulation
    private void registerUser(final String user, final String pwd, final String email) {

        //Let us first call the volley implementation for connection to Server
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
            Connection_constants.REGISTER_URL,
            new Response.Listener<String>() {
                /* Will catch the response from php script*/
                @Override
                public void onResponse(String response) {
                    //Since our server will send a JSON Object..so we will parse it
                    try {
                        JSONObject jsonObject = new JSONObject(response);

                        //There are two params error & message..send by server
                        Toast.makeText(getApplicationContext(), jsonObject.getString("message"), Toast.LENGTH_LONG).show();

                        String flag = jsonObject.getString("error");

                        if("false".equals(flag))
                        {
                            //There is no error..move to login page
                            Intent moveToLogin = new Intent(Signup_Activity_1.this, MainActivity.class);
                            finish();
                            startActivity(moveToLogin);
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            },
            new Response.ErrorListener() {
                /* Will catch the error response from php script*/
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        )
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                /* Here we put all the parameter to be send */
                Map<String,String> params = new HashMap<>();
                params.put("username",user);
                params.put("email",email);
                params.put("password",pwd);

                return params;
            }
        };

        //Now we have to add this request to a request queue
        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);

    }
}

