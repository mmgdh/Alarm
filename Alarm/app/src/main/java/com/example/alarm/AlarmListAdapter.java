package com.example.alarm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by 彬 on 2017/9/16.
 */

public class AlarmListAdapter extends ArrayAdapter<AlarmList> {

    private int reId;
    public AlarmListAdapter(Context context, int textViewResourceId, List<AlarmList> objects){
        super(context,textViewResourceId,objects);
        reId=textViewResourceId;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        AlarmList Alarm=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(reId,parent,false);
        TextView event=view.findViewById(R.id.txt_list_event);
        TextView percent=view.findViewById(R.id.txt_list_percent);
        event.setText(Alarm.getEvent());
        percent.setText(String.valueOf(Alarm.getTime()));
        return view;
    }
}
