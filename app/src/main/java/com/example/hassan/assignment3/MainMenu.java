package com.example.hassan.assignment3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
    }

    public void adds(View view)
    {
        Intent intent=new Intent(this,AddStudent.class);
        startActivity(intent);
    }
    public void vs(View view)
    {
        Intent intent=new Intent(this,ViewStudent.class);
        startActivity(intent);
    }
    public void addF(View view)
    {
        Intent intent=new Intent(this,AddFaculty.class);
        startActivity(intent);
    }
    public void vF(View view)
    {
        Intent intent=new Intent(this,ViewFaculty.class);
        startActivity(intent);
    }
    public void atten(View view)
    {
        Intent intent=new Intent(this,StudentAttendence.class);
        startActivity(intent);
    }
    public void logout(View view)
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
