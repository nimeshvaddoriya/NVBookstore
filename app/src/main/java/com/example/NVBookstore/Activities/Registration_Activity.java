package com.example.NVBookstore.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.NVBookstore.R;

public class Registration_Activity extends AppCompatActivity {
    EditText Register_et_name,Register_et_address,Register_et_landmark,Register_et_pin,Register_et_email,
            Register_et_confirmemail,Register_et_password,Register_et_confirmpassword,
            Register_et_mobile;
    Button Register_btn_register;
    TextView Register_tv_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Register_tv_login=(TextView)findViewById(R.id.Register_tv_login);
        Register_btn_register=(Button)findViewById(R.id.Register_btn_register);
        Register_btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(Registration_Activity.this,Login_Activity.class);
                startActivity(i);
            }
        });
        Register_tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Registration_Activity.this,Login_Activity.class);
                startActivity(i);
            }
        });
    }
}
