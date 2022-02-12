package com.example.bloom2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.ResourceBundle;

public class AllTasksActivity extends AppCompatActivity {
    private RecyclerView taskAllRest;
    Adapter adapter;
    FirebaseServicesClass fbs;
    ArrayList<TaskClass> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_tasks);
        fbs = FirebaseServicesClass.getInstance();
        tasks = new ArrayList<TaskClass>();
        readData();

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvAllTask);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this, tasks);
        recyclerView.setAdapter(adapter);
    }

    private void readData() {
        try {

            fbs.getFire().collection("restaurants")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    tasks.add(document.toObject(TaskClass.class));
                                }
                            } else {
                                Log.e("AllRestActivity: readData()", "Error getting documents.", task.getException());
                            }
                        }
                    });
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "error reading!" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
