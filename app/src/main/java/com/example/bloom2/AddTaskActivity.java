package com.example.bloom2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;

public class AddTaskActivity extends AppCompatActivity {

    public EditText etTime , etTask;
    private FirebaseServicesClass fbs;
    private static final String TAG = "AddRestActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        etTime=findViewById(R.id.etTime);
        etTask=findViewById(R.id.etTask);
    }



    public void AddTask(View view) {
        String Time,Task;
        Time= etTime.getText().toString();
        Task=etTask.getText().toString();
        //checking if empty
        if (Time.trim().isEmpty()|| Task.trim().isEmpty())
        {
            Toast.makeText(this,R.string.err_fields_empty, Toast.LENGTH_SHORT).show();
        }
        TaskClass task=new TaskClass(Task,Time);

        //adding to firebase
        fbs.getFire().collection("Tasks")
                .add(task)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                        Intent i=new Intent(AddTaskActivity.this, AddTaskActivity.class);
                        startActivity(i);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });

    }


    public void Finish(View view) {
        String Time,Task;
        Time= etTime.getText().toString();
        Task=etTask.getText().toString();
        //checking if empty
        if (Time.trim().isEmpty()|| Task.trim().isEmpty())
        {
            Toast.makeText(this, "Empty ", Toast.LENGTH_SHORT).show();
        }
        TaskClass task=new TaskClass(Task,Time);

        //adding to firebase
        fbs.getFire().collection("Tasks")
                .add(task)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                        Intent i=new Intent(AddTaskActivity.this,AddTaskActivity.class);
                        startActivity(i);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });


    }
}
