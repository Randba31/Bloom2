package com.example.bloom2;

public class TaskClass {


    private  String Time;
    private  String Task ;


    public TaskClass(String time, String task) {
        Time = time;
        Task = task;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getTask() {
        return Task;
    }

    public void setTask(String task) {
        Task = task;
    }


}
