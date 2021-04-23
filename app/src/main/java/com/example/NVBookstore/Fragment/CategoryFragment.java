package com.example.NVBookstore.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.NVBookstore.POJO.Categorylist;
import com.example.NVBookstore.R;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment {
    RecyclerView recyclerView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_category, container, false);
        recyclerView = (RecyclerView) root.findViewById(R.id.category_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        List<Categorylist> dataList = new ArrayList<>();

        dataList.add(new Categorylist(""));

        CategoryFragment.Adapter adapter = new CategoryFragment.Adapter(dataList);

        recyclerView.setAdapter(adapter);

        return root;
    }

    public class Adapter extends RecyclerView.Adapter<CategoryFragment.Adapter.ViewHolder> {
        private List<Categorylist> dataList;

        public Adapter(List<Categorylist> dataList) {
            this.dataList = dataList;
        }


        @NonNull
        @Override
        public CategoryFragment.Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_itemview, parent, false);
            return new CategoryFragment.Adapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CategoryFragment.Adapter.ViewHolder holder, int position) {
        }

        @Override
        public int getItemCount() {

            return dataList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            public ViewHolder(@NonNull View itemView)
            {
                super(itemView);
            }
        }
    }
}