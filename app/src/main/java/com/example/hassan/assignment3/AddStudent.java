package com.example.hassan.assignment3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudent extends AppCompatActivity {

    EditText t1, t2, t3;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        t1 = findViewById(R.id.editTextName);
        t2 = findViewById(R.id.editTextDep);
        t3 = findViewById(R.id.editTextRollno);

        db = new DatabaseHelper(this);
    }

    public void save(View view) {
        String name = null;
        String dep = null;
        String roll = null;
        name = t1.getText().toString();

        dep = t2.getText().toString();

        roll = t3.getText().toString();


        try {
            boolean r = db.insertStudent(name, dep, roll);

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
        }


    }
}
