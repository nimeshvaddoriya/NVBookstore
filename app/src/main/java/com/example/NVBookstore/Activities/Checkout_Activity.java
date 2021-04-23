package com.example.NVBookstore.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.NVBookstore.POJO.Cartlist;
import com.example.NVBookstore.R;
import java.util.ArrayList;
import java.util.List;

public class Checkout_Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    Button checkout_btn_confirmorder;
    ConstraintLayout checkout_cl_paymentmethod;
    TextView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        recyclerView=(RecyclerView)findViewById(R.id.checkout_recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        back=(TextView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        checkout_cl_paymentmethod=(ConstraintLayout)findViewById(R.id.checkout_cl_paymentmethod);
        checkout_cl_paymentmethod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Checkout_Activity.this,Payment_Method_Activity.class);
                startActivity(i);
            }
        });
        checkout_btn_confirmorder=(Button)findViewById(R.id.checkout_btn_confirmorder);
        checkout_btn_confirmorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Checkout_Activity.this,Confirmorder_Activity.class);
                startActivity(i);
            }
        });
        recyclerView.setLayoutManager(layoutManager);
        //dummy list
        List<Cartlist> dataList = new ArrayList<>();
        dataList.add(new Cartlist());

        Adapter adapter=new Adapter(dataList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
        private List<Cartlist> dataList;

        public Adapter(List<Cartlist> dataList) {
            this.dataList=dataList;
        }


        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.checkout_itemview,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.checkout_item_addaddress.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(Checkout_Activity.this,Add_Address_Activity.class);
                    startActivity(i);
                }
            });

        }

        @Override
        public int getItemCount() {
            return dataList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder
        {
            TextView checkout_item_addaddress;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                checkout_item_addaddress=itemView.findViewById(R.id.checkout_item_addaddress);

            }

        }


    }

}
