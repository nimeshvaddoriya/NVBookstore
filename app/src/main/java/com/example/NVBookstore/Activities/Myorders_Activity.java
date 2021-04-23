package com.example.NVBookstore.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.NVBookstore.POJO.Cartlist;
import com.example.NVBookstore.R;

import java.util.ArrayList;
import java.util.List;

public class Myorders_Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myorders);

        recyclerView=(RecyclerView)findViewById(R.id.myorders_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        //dummy list
        List<Cartlist> dataList = new ArrayList<>();
        dataList.add(new Cartlist());


        Myorders_Activity.Adapter adapter=new Myorders_Activity.Adapter(dataList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    public class Adapter extends RecyclerView.Adapter<Myorders_Activity.Adapter.ViewHolder> {
        private List<Cartlist> dataList;

        public Adapter(List<Cartlist> dataList) {
            this.dataList=dataList;
        }
        @NonNull
        @Override
        public Myorders_Activity.Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.myorders_itemview,parent,false);
            return new Myorders_Activity.Adapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull Myorders_Activity.Adapter.ViewHolder holder, int position) {
            holder.myorder_itemview_btn_details.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(Myorders_Activity.this,MyorderDetails_Activity.class);
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
            Button myorder_itemview_btn_details;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                myorder_itemview_btn_details=itemView.findViewById(R.id.myorder_itemview_btn_details);
            }
        }
    }

}
