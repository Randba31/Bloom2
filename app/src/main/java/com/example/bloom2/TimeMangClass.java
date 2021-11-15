package com.example.bloom2;

import java.util.ArrayList;

public class TimeMangClass {     

    private  double wakingUpTime;
    private  String SceduleHours;
    private  ArrayList<String> ToDo ;
    private  double sleepingtime;

    public String getSceduleHours() {
        return SceduleHours;
    }

    public void setSceduleHours(String sceduleHours) {
        SceduleHours = sceduleHours;
    }

    public double getWakingUpTime() {
        return wakingUpTime;
    }

    public void setWakingUpTime(double wakingUpTime) {
        this.wakingUpTime = wakingUpTime;
    }

    public ArrayList<String> getToDo() {
        return ToDo;
    }

    public void setToDo(ArrayList<String> toDo) {
        ToDo = toDo;
    }

    public double getSleepingtime() {
        return sleepingtime;
    }

    public void setSleepingtime(double sleepingtime) {
        this.sleepingtime = sleepingtime;
    }



    public TimeMangClass(String sceduleHours, double wakingUpTime, ArrayList<String> toDo, double sleepingtime) {
        SceduleHours = sceduleHours;
        this.wakingUpTime = wakingUpTime;
        ToDo = toDo;
        this.sleepingtime = sleepingtime;
    }



    @Override
    public String toString() {
        return "TimeMang{" +
                "SceduleHours='" + SceduleHours + '\'' +
                ", wakingUpTime=" + wakingUpTime +
                ", ToDo=" + ToDo +
                ", sleepingtime=" + sleepingtime +
                '}';
    }





}
