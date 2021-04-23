package com.example.NVBookstore.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.NVBookstore.R;

public class Splash_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(

                new Runnable() {
                    @Override
                    public void run() {
                        Intent i=new Intent(Splash_Activity.this,Login_Activity.class);
                        startActivity(i);
                        finish();
                    }
                },3000
        );
    }
}
