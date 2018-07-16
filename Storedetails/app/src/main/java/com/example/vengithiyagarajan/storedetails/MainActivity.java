package com.example.vengithiyagarajan.storedetails;

import android.app.ActivityManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView,imageView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=(ImageView)findViewById(R.id.iv);
        imageView1=(ImageView)findViewById(R.id.imageView2);


        Animation animation= AnimationUtils.loadAnimation(this,R.anim.myanimation);
        imageView1.startAnimation(animation);
        imageView.startAnimation(animation);
        final Intent i = new Intent(this,Main24Activity.class);
        Thread timer =new Thread()
        {
            public void run(){

                try{
                    sleep(5000);

                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();
    }

}
