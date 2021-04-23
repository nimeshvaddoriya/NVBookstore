package com.example.NVBookstore.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.NVBookstore.R;

public class Filter_Activity extends AppCompatActivity {
    Button filter_btn_apply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        filter_btn_apply=(Button)findViewById(R.id.filter_btn_apply);
        filter_btn_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
