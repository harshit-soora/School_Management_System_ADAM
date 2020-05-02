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

public class addSubject_Activity_4 extends AppCompatActivity {

    TableLayout table_layout;
    EditText subjectname, subjectteacher;
    Button btn_addSubject, delete_row;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subject__4);

        //If user is not logged
        if(!SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, MainActivity.class));
            return;
        }

        displaySubject();

        subjectname = (EditText)findViewById(R.id.id_subjectname);
        subjectteacher = (EditText)findViewById(R.id.id_subjectTeacher);
        btn_addSubject = (Button)findViewById(R.id.btn_addSubject);
        table_layout = (TableLayout)findViewById(R.id.tableLayout1);
        delete_row = (Button)findViewById(R.id.btn_delete);


        btn_addSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                table_layout.removeAllViews();

                String subject = subjectname.getText().toString();
                String ID = subjectteacher.getText().toString();

                subjectname.setText("");
                subjectteacher.setText("");

                if(subject == null && ID == null) {
                    Toast.makeText(addSubject_Activity_4.this,"Please fill the required fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    addSubject(subject,ID);
                }

                displaySubject();
            }
        });


        delete_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                table_layout.removeAllViews();

                String subject = subjectname.getText().toString();
                String ID = subjectteacher.getText().toString();

                if(subject == null && ID == null) {
                    Toast.makeText(addSubject_Activity_4.this,"Please fill subject-teacher name to delete", Toast.LENGTH_SHORT).show();
                }
                else{
                    removeSubject(subject, ID);
                }

                displaySubject();
            }
        });
    }

     private void addSubject(final String subject, final String teacher)
     {
         StringRequest stringRequest = new StringRequest(
                 Request.Method.POST,
                 Connection_constants.addSUBJECT_URL,
                 new Response.Listener<String>() {
                     @Override
                     public void onResponse(String response) {
                         //Handle the response from the server
                         try {
                             JSONObject obj = new JSONObject(response);
                             if(!obj.getBoolean("error")) {
                                 Toast.makeText(addSubject_Activity_4.this,  obj.getString("message"), Toast.LENGTH_SHORT).show();
                             }
                             else {
                                 //Make toast for the response-error message
                                 Toast.makeText(addSubject_Activity_4.this, obj.getString("message"), Toast.LENGTH_LONG).show();
                             }

                         } catch (JSONException e) {
                             e.printStackTrace();
                         }
                     }
                 },
                 new Response.ErrorListener() {
                     @Override
                     public void onErrorResponse(VolleyError error) {
                         Toast.makeText(addSubject_Activity_4.this, error.getMessage(), Toast.LENGTH_LONG).show();
                     }
                 }
         ){
             @Override
             protected Map<String, String> getParams() throws AuthFailureError {
                 Map<String, String> params = new HashMap<>();
                 params.put("subjectName",subject);
                 params.put("subjectTeacher",teacher);
                 return params;
             }
         };

         //Add this request to our request handler class
         RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
     }


    private void displaySubject()
    {
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                Connection_constants.addSUBJECT_URL,
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
                                Toast.makeText(addSubject_Activity_4.this, obj.getString("message"), Toast.LENGTH_LONG).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(addSubject_Activity_4.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("displaySubject","true");
                return params;
            }
        };

        //Add this request to our request handler class
        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }


    private void removeSubject(final String subject, final String teacher)
    {
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                Connection_constants.addSUBJECT_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Handle the response from the server
                        try {
                            JSONObject obj = new JSONObject(response);
                            if(!obj.getBoolean("error")) {
                                Toast.makeText(addSubject_Activity_4.this,  obj.getString("message"), Toast.LENGTH_SHORT).show();
                            }
                            else {
                                //Make toast for the response-error message
                                Toast.makeText(addSubject_Activity_4.this, obj.getString("message"), Toast.LENGTH_LONG).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(addSubject_Activity_4.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("subjectName",subject);
                params.put("subjectTeacher",teacher);
                params.put("delete","true");
                return params;
            }
        };

        //Add this request to our request handler class
        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }


    private void BuildTable(JSONObject data) throws JSONException
    {
        int len =  Integer.parseInt(data.getString("length"));
        String subject;
        String teacher;

        for(int i=1;i<=len;i++)
        {
            JSONObject row = data.getJSONObject(String.valueOf(i));
            subject = row.getString("Subject");
            teacher = row.getString("Teacher");

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
                    tv.setText(subject);
                else
                    tv.setText(teacher);

                Row.addView(tv);
            }
            table_layout.addView(Row);
        }
    }

}
