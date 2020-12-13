package com.example.admin.hopsital_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class h_chemist_dashboard extends AppCompatActivity {

    RecyclerView h_c_rev;
    String title[]={"Chemist"};
    int img[]={R.mipmap.chemist};
    TextView tv_c_name,tv_c_email,tv_c_number;
    ImageView h_c_img;
    ArrayList<h_chemist_GetterSetter > al=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h_chemist_dashboard);

        tv_c_name=findViewById(R.id.tv_c_name);
        tv_c_email=findViewById(R.id.tv_c_email);
        tv_c_number=findViewById(R.id.tv_c_number);
        h_c_img=findViewById(R.id.h_c_img);

        h_c_rev=findViewById(R.id.h_c_rev);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(h_chemist_dashboard.this);

        h_c_rev.setLayoutManager(layoutManager);
        for (int i=0;i<title.length;i++)
        {
            h_chemist_GetterSetter gl=new h_chemist_GetterSetter(title[i],img[i]);
            al.add(gl);
        }

        h_chemist_adapter my=new h_chemist_adapter(h_chemist_dashboard.this,al);
        h_c_rev.setAdapter(my);
    }
}
