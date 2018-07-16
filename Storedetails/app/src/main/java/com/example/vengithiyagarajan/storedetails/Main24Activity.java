package com.example.vengithiyagarajan.storedetails;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main24Activity extends AppCompatActivity {

    EditText Name;
    EditText Password;
    Button Login;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main24);
        Name = (EditText)findViewById(R.id.editText_name);
        Name.setTextColor(Color.WHITE);
        Password = (EditText)findViewById(R.id.editText_pass);
        Password.setTextColor(Color.WHITE);
        Login = (Button)findViewById(R.id.button_login);



        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = Name.getText().toString();
                String pass = Password.getText().toString();

                if (uname.equals("psg") && pass.equals("12345")) {
                    Intent intent = new Intent(Main24Activity.this, Main2Activity.class);
                    intent.putExtra("username", Name.getText().toString());
                    startActivity(intent);
                } else {
                    Toast.makeText(Main24Activity.this, "Invalid Usename password pair.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
