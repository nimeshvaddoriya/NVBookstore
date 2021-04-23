package com.example.NVBookstore.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.NVBookstore.R;

public class Login_Activity extends AppCompatActivity {
    Button login_btn_signin;
    TextView login_tv_register,login_tv_guest,login_tv_forgotpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login_btn_signin=(Button)findViewById(R.id.login_btn_signin);
        login_tv_guest=(TextView)findViewById(R.id.login_tv_guest);
        login_tv_register=(TextView)findViewById(R.id.login_tv_register);
        login_tv_forgotpassword=(TextView)findViewById(R.id.login_tv_forgotpassword);
        login_tv_forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Login_Activity.this,ForgotPassword_Activity.class);
                startActivity(i);
            }
        });
        login_btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Login_Activity.this,MainActivity.class);
                startActivity(i);
            }
        });
        login_tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Login_Activity.this,Registration_Activity.class);
                startActivity(i);
            }
        });
        login_tv_guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Login_Activity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
