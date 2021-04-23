package com.example.NVBookstore.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.NVBookstore.POJO.Cartlist;
import com.example.NVBookstore.R;

import java.util.ArrayList;
import java.util.List;

public class Shipping_Address_Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    Button shippingaddress_btn_addaddress;
    TextView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping__address);
        back=(TextView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        shippingaddress_btn_addaddress = (Button) findViewById(R.id.shippingaddress_btn_addaddress);
        shippingaddress_btn_addaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Shipping_Address_Activity.this, Add_Address_Activity.class);
                startActivity(i);
            }
        });
        recyclerView = (RecyclerView) findViewById(R.id.shippingaddress_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        //dummy list
        List<Cartlist> dataList = new ArrayList<>();
        dataList.add(new Cartlist());



        Shipping_Address_Activity.Adapter adapter = new Shipping_Address_Activity.Adapter(dataList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public class Adapter extends RecyclerView.Adapter<Shipping_Address_Activity.Adapter.ViewHolder> {
        private List<Cartlist> dataList;

        public Adapter(List<Cartlist> dataList) {
            this.dataList = dataList;
        }


        @NonNull
        @Override
        public Shipping_Address_Activity.Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shippingaddress_itemview, parent, false);
            return new Shipping_Address_Activity.Adapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull Shipping_Address_Activity.Adapter.ViewHolder holder, int position) {
            holder.shippingaddress_tv_edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Shipping_Address_Activity.this, Edit_Address_Activity.class);
                    startActivity(i);
                }
            });
        }

        @Override
        public int getItemCount() {
            return dataList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            TextView shippingaddress_tv_edit;


            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                shippingaddress_tv_edit = itemView.findViewById(R.id.shippingaddress_tv_edit);
            }

        }


    }
}
