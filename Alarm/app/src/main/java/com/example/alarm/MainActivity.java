package com.example.alarm;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper=new MyDatabaseHelper(this,"AlarmStore.db",null,1);

        Select_Data();
        //点击事件--创建数据库
        Button createDatabase=(Button)findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.getWritableDatabase();
            }
        });
        //点击事件--打开添加页面
        Button Open_AddView=(Button)findViewById(R.id.Open_AddView);
        Open_AddView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,View_Add.class);
                startActivity(intent);
            }
        });
        //查询数据



    }
    public void Select_Data(){
        List<AlarmList> alarmList=new ArrayList<>();
        alarmList.clear();
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        Cursor cursor=db.query("Alarm",null,null,null,null,null,null);
        AlarmListAdapter adapter=new AlarmListAdapter(MainActivity.this,R.layout.activity_list_view,alarmList);
        ListView listView=(ListView)findViewById(R.id.list_view);


        listView.setAdapter(adapter);
        if (cursor.moveToFirst()){
            do {
               String event=cursor.getString(cursor.getColumnIndex("event"));
               int time=cursor.getInt(cursor.getColumnIndex("total_time"));
                int id=cursor.getInt(cursor.getColumnIndex("id"));
                AlarmList list=new AlarmList(id,event,time);
                alarmList.add(list);
            }while (cursor.moveToNext());
        }
    }
}
