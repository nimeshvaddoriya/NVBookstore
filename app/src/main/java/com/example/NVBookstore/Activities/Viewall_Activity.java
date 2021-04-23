package com.example.NVBookstore.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.NVBookstore.POJO.Cartlist;
import com.example.NVBookstore.R;

import java.util.ArrayList;
import java.util.List;

public class Viewall_Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView viewall_filter,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewall);
        recyclerView = (RecyclerView) findViewById(R.id.viewall_recyclerview);
        viewall_filter=(TextView)findViewById(R.id.viewall_filter);
        back=(TextView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        viewall_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Viewall_Activity.this,Filter_Activity.class);
                startActivity(i);
            }
        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        //dummy list
        List<Cartlist> dataList = new ArrayList<>();
        dataList.add(new Cartlist());
        dataList.add(new Cartlist());

        Viewall_Activity.Adapter adapter = new Viewall_Activity.Adapter(dataList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public class Adapter extends RecyclerView.Adapter<Viewall_Activity.Adapter.ViewHolder> {
        private List<Cartlist> dataList;

        public Adapter(List<Cartlist> dataList) {
            this.dataList = dataList;
        }


        @NonNull
        @Override
        public Viewall_Activity.Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bookitem_view, parent, false);
            return new Viewall_Activity.Adapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull Viewall_Activity.Adapter.ViewHolder holder, int position) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Viewall_Activity.this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int width = (int) ((displayMetrics.widthPixels) - 100) / 2;

            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(width, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(16, 16, 0, 16);
            holder.parent.setLayoutParams(layoutParams);
        }

        @Override
        public int getItemCount() {
            return dataList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {


            ConstraintLayout parent;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                parent = itemView.findViewById(R.id.bookview_parent);
            }

        }


    }
}
