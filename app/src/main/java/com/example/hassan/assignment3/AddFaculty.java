package com.example.hassan.assignment3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddFaculty extends AppCompatActivity {

EditText t1,t2,t3;
DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_faculty);

        t1=findViewById(R.id.editTextFName);
        t2=findViewById(R.id.editTextFdep);
        t3=findViewById(R.id.editTextFsalary);

        db=new DatabaseHelper(this);
    }

    public  void add(View view)
    {


        try {
            String name = t1.getText().toString();

            String  dep = t2.getText().toString();

            String salary = t3.getText().toString();

            int sal=Integer.parseInt(salary);

            boolean r=  db.AddFaculty(name,dep,sal);

            if (r == true) {
                Toast.makeText(this, "Data Inserted", Toast.LENGTH_LONG).show();
                t1.setText("");
                t2.setText("");
                t3.setText("");
            } else {
                Toast.makeText(this, "Error!! Data Not Inserted", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            Log.i("Error",e.getMessage());
        }

    }


}
