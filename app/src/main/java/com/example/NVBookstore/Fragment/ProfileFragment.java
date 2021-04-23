package com.example.NVBookstore.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.NVBookstore.Activities.Confirmorder_Activity;
import com.example.NVBookstore.Activities.Editprofile_Activity;
import com.example.NVBookstore.Activities.Login_Activity;
import com.example.NVBookstore.Activities.Myorders_Activity;
import com.example.NVBookstore.Activities.Notification_Activity;
import com.example.NVBookstore.Activities.Shipping_Address_Activity;
import com.example.NVBookstore.R;


public class ProfileFragment extends Fragment {
    Button profile_btn_myorders,profile_btn_customersupport,profile_btn_notification,
            profile_btn_shippingaddress,profile_btn_logout,profile_btn_editprofile;
    TextView profile_tv_username,profile_tv_email;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        profile_btn_myorders=(Button)root.findViewById(R.id.profile_btn_myorders);
        profile_btn_customersupport=(Button)root.findViewById(R.id.profile_btn_customersupport);
        profile_btn_notification=(Button)root.findViewById(R.id.profile_btn_notification);
        profile_btn_shippingaddress=(Button)root.findViewById(R.id.profile_btn_shippingaddress);
        profile_btn_logout=(Button)root.findViewById(R.id.profile_btn_logout);
        profile_btn_editprofile=(Button)root.findViewById(R.id.profile_btn_editprofile);

        profile_btn_myorders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(), Myorders_Activity.class);
                startActivity(i);
            }
        });
        profile_btn_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(), Notification_Activity.class);
                startActivity(i);
            }
        });
        profile_btn_shippingaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(), Shipping_Address_Activity.class);
                startActivity(i);
            }
        });
        profile_btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(), Login_Activity.class);
                startActivity(i);
            }
        });
        profile_btn_editprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(), Editprofile_Activity.class);
                startActivity(i);
            }
        });
        profile_btn_customersupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Contact:807-123-5216",Toast.LENGTH_LONG).show();

            }
        });

        return root;
    }
}