package com.example.alarm;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by 彬 on 2017/9/16.
 */

public class AlarmListAdapter extends ArrayAdapter<AlarmList> {

    private MyDatabaseHelper dbHelper;
    private int reId;
    public AlarmListAdapter(Context context, int textViewResourceId, List<AlarmList> objects){
        super(context,textViewResourceId,objects);
        reId=textViewResourceId;
    }
    public View getView(final int position, View convertView, final ViewGroup parent){
        final AlarmList Alarm=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(reId,parent,false);
        TextView event=view.findViewById(R.id.txt_list_event);
        TextView percent=view.findViewById(R.id.txt_list_percent);
     /*   Button button=view.findViewById(R.id.btn_list_Delete);
       dbHelper=new MyDatabaseHelper(getContext(),"AlarmStore.db",null,1);
          button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
         //       Toast.makeText(getContext(),"mmgdh"+String.valueOf(Alarm.getId()),Toast.LENGTH_SHORT).show();
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                db.delete("Alarm","id=?",new String[] {String.valueOf(Alarm.getId())});
                Intent intent=new Intent(getContext(),MainActivity.class);
                getContext().startActivity(intent);
            }
        });*/
        event.setText(Alarm.getEvent());
        percent.setText(String.valueOf(Alarm.getTime()));
        return view;
    }
}
