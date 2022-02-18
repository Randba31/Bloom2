package com.example.bloom2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TaskDetailsActivity extends AppCompatActivity {
    private TextView tvTaskDetails, tvTimeDetails, tvPlaceDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);

        connectComponents();
        Intent i = this.getIntent();
        TaskClass tasks = (TaskClass) i.getSerializableExtra("tasks");

        tvTaskDetails.setText(tasks.getTask());
        tvTimeDetails.setText(tasks.getTime());
        tvPlaceDetails.setText(tasks.getPlace());


    }

    private void connectComponents() {
        tvTaskDetails=findViewById(R.id.tvTaskdetails);
        tvTimeDetails=findViewById(R.id.tvTimeDetails);
        tvPlaceDetails=findViewById(R.id.tvPlaceDetails);
    }
}
