package com.example.hassan.assignment3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class StudentAttendence extends AppCompatActivity {

    RadioButton p,a;
String status;
DatabaseHelper db;
EditText t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_attendence);
        db=new DatabaseHelper(this);
        t1=findViewById(R.id.editTextAttendence);

    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton3:
                if (checked)
                  status="Present";
                    break;
            case R.id.radioButton4:
                if (checked)
                   status="Absent";
                    break;
        }
    }

    public void saveAttendence(View view)
    {
        try {
            String roll=t1.getText().toString();
            boolean r=db.attendence(roll,status);
            if (r == true) {
                Toast.makeText(this, "Data Inserted", Toast.LENGTH_LONG).show();
                t1.setText("");

            } else {
                Toast.makeText(this, "Error!! Data Not Inserted", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();

        }
    }
}
