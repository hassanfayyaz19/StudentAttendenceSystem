package com.example.hassan.assignment3;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewFaculty extends AppCompatActivity {

    TextView textView;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_faculty);
        textView=findViewById(R.id.textView6);
        db=new DatabaseHelper(this);
        ViewDataF();
    }

    public void ViewDataF() {
        Cursor cursor = db.ViewFaculty();
        if (cursor.getCount() != 0) {
            StringBuffer buffer = new StringBuffer();
            while (cursor.moveToNext()) {

                buffer.append("Name : " + cursor.getString(1) + "\n");
                buffer.append("Department : " + cursor.getString(2) + "\n");
                buffer.append("Roll No : " + cursor.getString(3) + "\n");
                buffer.append("------------------------------------------"+"\n")
                ;
            }
            textView.setText(buffer.toString());
        }
    }

}
