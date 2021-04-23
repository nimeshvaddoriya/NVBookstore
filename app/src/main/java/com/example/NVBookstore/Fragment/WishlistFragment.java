package com.example.NVBookstore.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.NVBookstore.Activities.Bookdetails_Activity;
import com.example.NVBookstore.Activities.Filter_Activity;
import com.example.NVBookstore.POJO.Bookdata;
import com.example.NVBookstore.R;

import java.util.ArrayList;
import java.util.List;

public class WishlistFragment extends Fragment {
    TextView wishlist_filter;
    RecyclerView recyclerView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_wishlist, container, false);
        recyclerView = (RecyclerView) root.findViewById(R.id.wishlist_recyclerview);
        wishlist_filter = (TextView) root.findViewById(R.id.viewall_filter);
        wishlist_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Filter_Activity.class);
                startActivity(i);
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        List<Bookdata> dataList = new ArrayList<>();
        dataList.add(new Bookdata(R.drawable.one,"sds","sbsb","sbs"));
        dataList.add(new Bookdata(R.drawable.two,"sds","sbsb","sbs"));
        dataList.add(new Bookdata(R.drawable.three,"sds","sbsb","sbs"));
        dataList.add(new Bookdata(R.drawable.four,"sds","sbsb","sbs"));
        dataList.add(new Bookdata(R.drawable.five,"sds","sbsb","sbs"));
        dataList.add(new Bookdata(R.drawable.six,"sds","sbsb","sbs"));


        WishlistFragment.Adapter adapter = new WishlistFragment.Adapter(dataList);

        recyclerView.setAdapter(adapter);
        return root;
    }

    public class Adapter extends RecyclerView.Adapter<WishlistFragment.Adapter.ViewHolder> {
        private List<Bookdata> dataList;

        public Adapter(List<Bookdata> dataList) {
            this.dataList = dataList;
        }


        @NonNull
        @Override
        public WishlistFragment.Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bookitem_view, parent, false);
            return new WishlistFragment.Adapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull WishlistFragment.Adapter.ViewHolder holder, int position) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int width = (int) ((displayMetrics.widthPixels) -100) / 2;

            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(width, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(16, 16, 0, 16);
            holder.parent.setLayoutParams(layoutParams);
            holder.parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(getActivity(), Bookdetails_Activity.class);
                    startActivity(i);
                }
            });
        }

        @Override
        public int getItemCount() {

            return 2;
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            ConstraintLayout parent;
            ImageView imageView;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                parent=itemView.findViewById(R.id.bookview_parent);
                imageView=itemView.findViewById(R.id.bookitem_iv);

            }
        }
    }
}