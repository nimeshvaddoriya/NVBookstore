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
import com.example.NVBookstore.Activities.Notification_Activity;
import com.example.NVBookstore.Activities.Viewall_Activity;
import com.example.NVBookstore.POJO.Bookdata;
import com.example.NVBookstore.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView, recyclerView1, recyclerView2;



    TextView home_tv_notibell, home_tv_viewall1, home_tv_viewall2, home_tv_viewall3;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        home_tv_notibell = (TextView) root.findViewById(R.id.home_tv_notibell);
        home_tv_viewall1 = (TextView) root.findViewById(R.id.home_tv_viewall1);
        home_tv_viewall2 = (TextView) root.findViewById(R.id.home_tv_viewall2);
        home_tv_viewall3 = (TextView) root.findViewById(R.id.home_tv_viewall3);
        home_tv_viewall1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Viewall_Activity.class);
                startActivity(i);
            }
        });
        home_tv_viewall2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Viewall_Activity.class);
                startActivity(i);
            }
        });
        home_tv_viewall3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Viewall_Activity.class);
                startActivity(i);
            }
        });
        home_tv_notibell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Notification_Activity.class);
                startActivity(i);
            }
        });




        recyclerView = (RecyclerView) root.findViewById(R.id.home_rv_newrelease);
        recyclerView1 = (RecyclerView) root.findViewById(R.id.home_rv_specialoffer);
        recyclerView2 = (RecyclerView) root.findViewById(R.id.home_rv_top100);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext());
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getContext());

        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        layoutManager1.setOrientation(RecyclerView.HORIZONTAL);
        layoutManager2.setOrientation(RecyclerView.HORIZONTAL);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView2.setLayoutManager(layoutManager2);

        List<Bookdata> dataList = new ArrayList<>();
        dataList.add(new Bookdata(R.drawable.one,"sds","sbsb","54"));
        dataList.add(new Bookdata(R.drawable.two,"sttgs","srrbsb","4242"));




        Adapter adapter = new Adapter(dataList);

        recyclerView.setAdapter(adapter);
        recyclerView1.setAdapter(adapter);
        recyclerView2.setAdapter(adapter);

        return root;
    }

    public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
        private List<Bookdata> dataList;

        public Adapter(List<Bookdata> dataList) {
            this.dataList = dataList;
        }


        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bookitem_view, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int width = (int) ((displayMetrics.widthPixels) - 100) / 2;

            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(width, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(16, 16, 0, 16);
            holder.parent.setLayoutParams(layoutParams);


            holder.parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getActivity(), Bookdetails_Activity.class);
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
            TextView bookitem_tv_bookname,bookitem_tv_bookprice,bookitem_tv_authorname;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                parent = itemView.findViewById(R.id.bookview_parent);
                imageView = itemView.findViewById(R.id.bookitem_iv);
                bookitem_tv_bookname=itemView.findViewById(R.id.bookitem_tv_bookname);
                bookitem_tv_bookprice=itemView.findViewById(R.id.bookitem_tv_bookprice);
                bookitem_tv_authorname=itemView.findViewById(R.id.bookitem_tv_authorname);


            }

        }
    }
}