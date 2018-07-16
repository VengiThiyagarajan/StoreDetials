package com.example.vengithiyagarajan.storedetails;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Vengi Thiyagarajan on 23-11-2017.
 */
public class Viewlistcontents extends AppCompatActivity {

    DatabaseHelper myDb;
    Button bt;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);
        ListView listView =(ListView)findViewById(R.id.listView);
        myDb = new DatabaseHelper(this);
        final ArrayList<String> list = new ArrayList<>();
        final Cursor data = myDb.getALLData();
        if(data.getCount()==0)
        {
            Toast.makeText(Viewlistcontents.this, "Data not Inserted", Toast.LENGTH_SHORT).show();
        }else
        {
            while (data.moveToNext())
            {

                list.add("NAME : "+data.getString(1));
                list.add("AADHAR CARD : "+data.getString(2));
                list.add("RATION CARD : "+data.getString(3));
                list.add("PAN CARD : " + data.getString(4));
                list.add("BANK ACCOUNT NO : " + data.getString(5));



                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);


                listView.setAdapter(listAdapter);
            }
        }




    }

}
