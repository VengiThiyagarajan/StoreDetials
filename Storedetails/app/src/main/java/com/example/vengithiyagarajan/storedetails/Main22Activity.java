package com.example.vengithiyagarajan.storedetails;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main22Activity extends AppCompatActivity {

    DatabaseHelper myDb;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);
        final ListView listView =(ListView)findViewById(R.id.listView);


        myDb = new DatabaseHelper(this);
        ArrayList<String> list = new ArrayList<>();
        Cursor data = myDb.getALLData();

        if(data.getCount()==0)
        {
            Toast.makeText(Main22Activity.this, "Data not Inserted", Toast.LENGTH_SHORT).show();
        }else
        {
            while (data.moveToNext())
            {
                list.add(data.getString(0));
                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
                listView.setAdapter(listAdapter);
            }
        }




    }





}
