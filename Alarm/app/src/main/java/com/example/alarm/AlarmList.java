package com.example.alarm;

/**
 * Created by 彬 on 2017/9/16.
 */

public class AlarmList {
    private String event;
    private int time;
    public AlarmList(String event,int time){
        this.event=event;
        this.time=time;
    }

    public String getEvent() {
        return event;
    }

    public int getTime() {
        return time;
    }
}
