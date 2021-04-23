package com.example.NVBookstore.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.NVBookstore.R;

public class ForgotPassword_Activity extends AppCompatActivity {
    EditText forgotpassword_et_email;
    Button forgotpassword_btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password_);
        forgotpassword_et_email=(EditText)findViewById(R.id.forgotpassword_et_email);
        forgotpassword_btn_send=(Button)findViewById(R.id.forgotpassword_btn_send);
        forgotpassword_btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            finish();
            }
        });
    }
}
