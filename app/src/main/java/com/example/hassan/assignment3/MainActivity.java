package com.example.hassan.assignment3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText t1, t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);
        t1 = findViewById(R.id.editText);
        t2 = findViewById(R.id.editText2);
    }

    public void login(View view) {
        String name = "admin", password = "admin";

        String n = t1.getText().toString();
        String p = t2.getText().toString();

        if (n.equals(name) && p.equals(password)) {
            startActivity(new Intent(this, MainMenu.class));
            t1.setText("");
            t2.setText("");

        } else {
            Toast.makeText(this, "ERROR..!!! Invalid User", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onBackPressed() {

        moveTaskToBack(true);
    }
}
