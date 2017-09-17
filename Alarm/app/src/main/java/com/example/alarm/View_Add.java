package com.example.alarm;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class View_Add extends AppCompatActivity {

    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__add);

        dbHelper=new MyDatabaseHelper(this,"AlarmStore.db",null,1);

        Button addData=(Button)findViewById(R.id.btn_Add);
        final EditText Event=(EditText)findViewById(R.id.edit_event);
        final EditText Time=(EditText)findViewById(R.id.edit_time);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                ContentValues values=new ContentValues();
                values.put("event",Event.getText().toString());
                values.put("total_time",Integer.valueOf(Time.getText().toString()));
                db.insert("Alarm",null,values);
                values.clear();
                Toast.makeText(getApplicationContext(), "添加成功",
                        Toast.LENGTH_SHORT).show();
                finish();
                Intent intent=new Intent();
                intent.setClass(View_Add.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
