package com.example.bloom2;

import java.util.SplittableRandom;

public class TaskClass {


    private  String Time;
    private  String Task ;
    private String Place;


    public TaskClass(String time, String task,String place) {
        Time = time;
        Task = task;
        Place=place;
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

    public String getPlace() {
        return Place;
    }

    public void setPlace(String place) {
        Place=place;
    }

}
