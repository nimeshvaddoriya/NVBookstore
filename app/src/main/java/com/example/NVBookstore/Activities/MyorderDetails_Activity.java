package com.example.NVBookstore.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

public class MyorderDetails_Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myorder_details);
        recyclerView=(RecyclerView)findViewById(R.id.orderdetails_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        back=(TextView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        recyclerView.setLayoutManager(layoutManager);
        //dummy list
        List<Cartlist> dataList = new ArrayList<>();
        dataList.add(new Cartlist());

        

        MyorderDetails_Activity.Adapter adapter=new MyorderDetails_Activity.Adapter(dataList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    public class Adapter extends RecyclerView.Adapter<MyorderDetails_Activity.Adapter.ViewHolder> {
        private List<Cartlist> dataList;

        public Adapter(List<Cartlist> dataList) {
            this.dataList=dataList;
        }
        @NonNull
        @Override
        public MyorderDetails_Activity.Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.myorderdetails_itemview,parent,false);
            return new MyorderDetails_Activity.Adapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyorderDetails_Activity.Adapter.ViewHolder holder, int position) {
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
              }
        }
    }

}
