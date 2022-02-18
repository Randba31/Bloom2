package com.example.bloom2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class MainPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);


    }

    public void GoToAddbtn(View view) {
        Intent i=new Intent(MainPageActivity.this, AddTaskActivity.class);
        startActivity(i);
    }
}
