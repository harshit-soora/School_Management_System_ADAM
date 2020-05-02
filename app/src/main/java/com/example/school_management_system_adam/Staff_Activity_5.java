package com.example.school_management_system_adam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;

public class Staff_Activity_5 extends AppCompatActivity {

    TableLayout table_layout;
    EditText firstname_et, lastname_et, row;
    Button addmem_btn, delete;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff__5);
        //sqlcon = new SQLController(this);

        firstname_et = (EditText)findViewById(R.id.id_subjectname);
        lastname_et = (EditText)findViewById(R.id.id_section_class);
        addmem_btn = (Button)findViewById(R.id.btn_addClass);
        table_layout = (TableLayout)findViewById(R.id.tableLayout1);
        delete = (Button)findViewById(R.id.btn_delete);
        row = (EditText)findViewById(R.id.row);

        BuildTable();
//        String rownum = row.getText().toString();
//        index = Integer.parseInt(rownum);
//        delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                DeleteRow();
//            }
//        });



        addmem_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                table_layout.removeAllViews();

                String firstname = firstname_et.getText().toString();
                String lastname = lastname_et.getText().toString();

                firstname_et.setText("");
                lastname_et.setText("");

                //sqlcon.open();
                //sqlcon.insertData(firstname, lastname);
                BuildTable();
            }
        });
    }

    // private void DeleteRow()
    // {
    //     table_layout.removeView(table_layout.getChildAt(index));
    // }




    private void BuildTable()
    {
        /*
        sqlcon.open();
        Cursor c = sqlcon.readEntry();

        int rows = c.getCount();
        int columns = c.getColumnCount();

        c.moveToFirst();

        for(int i = 0 ; i < rows;i++)
        {
            TableRow Row = new TableRow(this);
            Row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));

            for(int j = 0 ; j < columns; j++)
            {
                TextView tv = new TextView(this);
                tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT));

                tv.setBackgroundResource(R.drawable.cell_shape);
                tv.setGravity(Gravity.CENTER);
                tv.setTextSize(18);
                tv.setPadding(0, 5, 0, 5);

                tv.setText(c.getString(j));

                Row.addView(tv);
            }
            c.moveToNext();
            table_layout.addView(row);

        }
        sqlcon.close();
        */
    }

}
