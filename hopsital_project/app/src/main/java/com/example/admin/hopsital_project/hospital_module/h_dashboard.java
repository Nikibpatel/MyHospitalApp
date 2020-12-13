package com.example.admin.hopsital_project.hospital_module;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.hopsital_project.GetterSetter;
import com.example.admin.hopsital_project.R;

import java.util.ArrayList;

public class h_dashboard extends AppCompatActivity {
    RecyclerView rv;
    String title[]={"Profile","Patient","Doctor","Nurse","BloodDonor","Chemist","Medicine"};
    int img[]={R.mipmap.profile,R.mipmap.patient2,R.mipmap.doctor,R.mipmap.nurse,R.mipmap.donor,R.mipmap.chemist,R.mipmap.chemist};
    ArrayList<GetterSetter> al=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h_dashboard);
        rv=findViewById(R.id.rev);


        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(h_dashboard.this,2);
        rv.setLayoutManager(layoutManager);


        for(int i=0;i<title.length;i++)
        {
            GetterSetter gl = new GetterSetter(img[i],title[i]);
            al.add(gl);
        }

        h_dashboard_adapter my=new h_dashboard_adapter(h_dashboard.this,al);
        rv.setAdapter(my);
    }
}
