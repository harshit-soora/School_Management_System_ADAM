package com.example.school_management_system_adam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class addClass_Activity_3  extends AppCompatActivity {

    private TableLayout table_layout;
    private EditText classname, section;
    private Button addClass, deleteRow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class__3);

        //If user is not logged
        if(!SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, MainActivity.class));
            return;
        }

        displayClass();

        classname = (EditText)findViewById(R.id.id_classname);
        section = (EditText)findViewById(R.id.id_section_class);
        addClass = (Button)findViewById(R.id.btn_addClass);
        deleteRow = (Button)findViewById(R.id.btn_delete);
        table_layout = (TableLayout)findViewById(R.id.tableLayout1);

        addClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                table_layout.removeAllViews();

                String nameClass = classname.getText().toString();
                String nameSection = section.getText().toString();

                if(nameClass == null && nameSection == null) {
                    Toast.makeText(addClass_Activity_3.this,"Please fill the required fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    addClassQuery(nameClass,nameSection);
                }

                displayClass();
            }
        });


        deleteRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                table_layout.removeAllViews();

                String nameClass = classname.getText().toString();
                String nameSection = section.getText().toString();

                if(nameClass == null && nameSection == null) {
                    Toast.makeText(addClass_Activity_3.this,"Please fill the class-section to delete", Toast.LENGTH_SHORT).show();
                }
                else{
                    removeClassQuery(nameClass,nameSection);
                }

                displayClass();
            }
        });
    }


    private void addClassQuery (final String classname, final String section)
    {
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                Connection_constants.addCLASS_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Handle the response from the server
                        try {
                            JSONObject obj = new JSONObject(response);
                            if(!obj.getBoolean("error")) {
                                Toast.makeText(addClass_Activity_3.this,  obj.getString("message"), Toast.LENGTH_SHORT).show();
                            }
                            else {
                                //Make toast for the response-error message
                                Toast.makeText(addClass_Activity_3.this, obj.getString("message"), Toast.LENGTH_LONG).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(addClass_Activity_3.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("classname",classname);
                params.put("section",section);
                return params;
            }
        };

        //Add this request to our request handler class
        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }


    private void displayClass()
    {
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                Connection_constants.addCLASS_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Handle the response from the server
                        try {
                            JSONObject obj = new JSONObject(response);
                            if(!obj.getBoolean("error")) {
                                 JSONObject database_output = obj.getJSONObject("data");
                                BuildTable(database_output);
                            }
                            else {
                                //Make toast for the response-error message
                                Toast.makeText(addClass_Activity_3.this, obj.getString("message"), Toast.LENGTH_LONG).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(addClass_Activity_3.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("displayClass","true");
                return params;
            }
        };

        //Add this request to our request handler class
        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }


    private void removeClassQuery (final String classname, final String section)
    {
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                Connection_constants.addCLASS_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Handle the response from the server
                        try {
                            JSONObject obj = new JSONObject(response);
                            if(!obj.getBoolean("error")) {
                                Toast.makeText(addClass_Activity_3.this,  obj.getString("message"), Toast.LENGTH_SHORT).show();
                            }
                            else {
                                //Make toast for the response-error message
                                Toast.makeText(addClass_Activity_3.this, obj.getString("message"), Toast.LENGTH_LONG).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(addClass_Activity_3.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("classname",classname);
                params.put("section",section);
                params.put("delete","true");
                return params;
            }
        };

        //Add this request to our request handler class
        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }


    private void BuildTable(JSONObject data) throws JSONException {
        int len =  Integer.parseInt(data.getString("length"));
        String classroom;
        String section;

        for(int i=1;i<=len;i++)
        {
            JSONObject row = data.getJSONObject(String.valueOf(i));
            classroom = row.getString("Class");
            section = row.getString("Section");

            TableRow Row = new TableRow(this);
            Row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));

            int columns = 2;
            for(int j = 0 ; j < columns; j++)
            {
                TextView tv = new TextView(this);
                tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT));

                tv.setBackgroundResource(R.drawable.cell_shape);
                tv.setGravity(Gravity.CENTER);
                tv.setTextSize(18);
                tv.setPadding(0, 5, 0, 5);

                if(j==0)
                    tv.setText(classroom);
                else
                    tv.setText(section);

                Row.addView(tv);
            }
            table_layout.addView(Row);
        }
    }

}
