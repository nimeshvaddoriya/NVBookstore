package com.example.NVBookstore.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.NVBookstore.Activities.Checkout_Activity;
import com.example.NVBookstore.POJO.Cartlist;
import com.example.NVBookstore.R;

import java.util.ArrayList;
import java.util.List;


public class CartFragment extends Fragment {
    RecyclerView recyclerView;
    Button cart_btn_checkout;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_cart, container, false);

        cart_btn_checkout=(Button)root.findViewById(R.id.cart_btn_checkout);

        cart_btn_checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(), Checkout_Activity.class);
                startActivity(i);
            }
        });
        recyclerView=(RecyclerView)root.findViewById(R.id.cart_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        List<Cartlist> dataList = new ArrayList<>();
        dataList.add(new Cartlist());

        CartFragment.Adapter adapter = new CartFragment.Adapter(dataList);

        recyclerView.setAdapter(adapter);
        return root;
}
    public class Adapter extends RecyclerView.Adapter<CartFragment.Adapter.ViewHolder> {
        private List<Cartlist> dataList;

        public Adapter(List<Cartlist> dataList) {
            this.dataList=dataList;
        }

        @NonNull
        @Override
        public CartFragment.Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_itemview,parent,false);
            return new CartFragment.Adapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CartFragment.Adapter.ViewHolder holder, int position) {
        }

        @Override
        public int getItemCount() {
            return dataList.size();
        }
        class ViewHolder extends RecyclerView.ViewHolder
        {
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
            }
        }
    }}
