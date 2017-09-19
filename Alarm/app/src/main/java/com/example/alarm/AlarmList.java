package com.example.alarm;

/**
 * Created by 彬 on 2017/9/16.
 */

public class AlarmList {
    private int id;
    private String event;
    private int time;
    public AlarmList(int id,String event,int time){
        this.id=id;
        this.event=event;
        this.time=time;
    }

    public int getId(){
        return id;
    }

    public String getEvent() {
        return event;
    }

    public int getTime() {
        return time;
    }
}
