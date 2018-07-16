package com.example.vengithiyagarajan.storedetails;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private static Button button_submit;


    DatabaseHelper myDb;
    EditText editNAME,editAADHAR_NO,editRATIONCARD_NO,editTextId;
    EditText editpan;
    EditText editbank;
    Button btnADD;
    Button btnVIEW;
    Button btnUpdate;
    Button btnDelete;
    Button btnview;
    Button btnexit;
    Button btnsplash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        myDb = new DatabaseHelper(this);
        editTextId = (EditText) findViewById(R.id.editText_id);
        editTextId.setTextColor(Color.WHITE);
        editNAME = (EditText) findViewById(R.id.editText_name);
        editNAME.setTextColor(Color.WHITE);
        editNAME.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        editAADHAR_NO = (EditText) findViewById(R.id.editText_aadhar);
        editAADHAR_NO.setTextColor(Color.WHITE);
        editRATIONCARD_NO = (EditText) findViewById(R.id.editText_rationcard);
        editRATIONCARD_NO.setTextColor(Color.WHITE);
        editpan = (EditText) findViewById(R.id.editText_pancard);
        editpan.setTextColor(Color.WHITE);
        editbank = (EditText) findViewById(R.id.editText_bankno);
        editbank.setTextColor(Color.WHITE);
        btnADD = (Button) findViewById(R.id.button_add);
        btnVIEW = (Button) findViewById(R.id.button_view);
        btnUpdate = (Button) findViewById(R.id.button_update);
        btnDelete = (Button) findViewById(R.id.button_delete);
        btnview = (Button) findViewById(R.id.btn_view);
        btnexit = (Button)findViewById(R.id.btn_exit);


        Add();
        Update();
        Delete();
        VIEW();







        btnview.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, Viewlistcontents.class);
                startActivity(intent);
            }
        });
    }

    public void clickExit(View view)
    {
        finish();
    }
    @Override
    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
       builder.setTitle(R.string.app_name);
        builder.setIcon(R.drawable.logostore);
        builder.setCancelable(true);
        builder.setMessage("Do you want to exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        finish();

                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }


    public void Delete() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb.deleteData(editTextId.getText().toString());
                        if (deletedRows > 0)
                            Toast.makeText(Main2Activity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(Main2Activity.this, "Data not Deleted", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    public void Update() {
        btnUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updatedata(editTextId.getText().toString(), editNAME.getText().toString(), editAADHAR_NO.getText().toString(),
                                editRATIONCARD_NO.getText().toString(), editpan.getText().toString(), editbank.getText().toString());
                        if (isUpdate == true)
                            Toast.makeText(Main2Activity.this, "Data Updated", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(Main2Activity.this, "Data not Updated", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
    public void Add()
    {
        btnADD.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editNAME.getText().toString(),
                                editAADHAR_NO.getText().toString(),
                                editRATIONCARD_NO.getText().toString(),editpan.getText().toString(),editbank.getText().toString());
                        if (isInserted == true)
                            Toast.makeText(Main2Activity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(Main2Activity.this, "Data not Inserted", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    public void VIEW() {
        btnVIEW.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getALLData();
                        if (res.getCount() == 0) {
                            // show msg
                            showMessage("Error", "Nothing Found");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("ID :" + res.getString(0) + "\n\n");
                            buffer.append("NAME:" + res.getString(1) + "\n\n");
                            buffer.append("AADHAR NO :" + res.getString(2) + "\n\n");
                            buffer.append("RATIONCARD NO :" + res.getString(3) + "\n\n");
                            buffer.append("PANCARD NO :" + res.getString(4) + "\n\n");
                            buffer.append("BANKACCOUNT NO :" + res.getString(5) + "\n\n");

                        }
                        //show all data
                        showMessage("Data",buffer.toString());
                    }
                }
        );
    }



    public void showMessage(String title,String Message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
    }

