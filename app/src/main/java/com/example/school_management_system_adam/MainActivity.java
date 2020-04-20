package com.example.school_management_system_adam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button login;
    private Button cancel;
    private Button signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //If user is has already logged in earlier
        if(SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, Home_Activity_0.class));
            return;
        }

        username = (EditText) findViewById(R.id.login_username);
        password = (EditText) findViewById(R.id.login_password);
        login = (Button) findViewById(R.id.login_button);
        cancel = (Button) findViewById(R.id.cancel_button);
        signup = (Button) findViewById(R.id.signup_button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String userName = username.getText().toString();
                final String passWord = password.getText().toString();

                if(userName != null && passWord != null) {
                    validate(userName, passWord);
                }
                else {
                    Toast.makeText(MainActivity.this, "Please enter the required fields.", Toast.LENGTH_SHORT).show();
                }
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

    private void validate(final String username, final String password)
    {
        StringRequest stringRequest = new StringRequest(
            Request.Method.POST,
            Connection_constants.LOGIN_URL,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    //Handle the response from the server
                    try {
                        JSONObject obj = new JSONObject(response);
                        if(!obj.getBoolean("error")) {
                            //store the user-data from server
                            SharedPrefManager.getInstance(getApplicationContext())
                                    .userLogin(
                                            obj.getInt("id"),
                                            obj.getString("username"),
                                            obj.getString("email")
                                    );

                            Toast.makeText(MainActivity.this, "User login successful", Toast.LENGTH_SHORT).show();

                            //Create a link to Home page in case the sign-in validates
                            Intent intent_link_home = new Intent(MainActivity.this, Home_Activity_0.class);

                            startActivity(intent_link_home);
                            finish();
                        }
                        else {
                            //Make toast for the response-error message
                            Toast.makeText(MainActivity.this, obj.getString("message"), Toast.LENGTH_LONG).show();
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username",username);
                params.put("password",password);
                return params;
            }
        };

        //Add this request to our request handler class
        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);

    }
}
