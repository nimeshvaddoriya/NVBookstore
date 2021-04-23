package com.example.NVBookstore.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.NVBookstore.R;

public class Bookdetails_Activity extends AppCompatActivity {
    Button bookdetails_btn_addtocart;
    TextView bookdetails_tv_wishlist,bookdetails_tv_share, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookdetails);
        bookdetails_btn_addtocart=(Button)findViewById(R.id.bookdetails_btn_addtocart);
        bookdetails_tv_wishlist=(TextView)findViewById(R.id.bookdetails_tv_wishlist);
        bookdetails_tv_share=(TextView)findViewById(R.id.bookdetails_tv_share);
        back=(TextView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        bookdetails_tv_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Here is the share content body";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });
        bookdetails_tv_wishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Bookdetails_Activity.this,"Added to Wishlist",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        bookdetails_btn_addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Bookdetails_Activity.this,"Added to Cart",Toast.LENGTH_SHORT).show();
            finish();
            }
        });
    }
}
