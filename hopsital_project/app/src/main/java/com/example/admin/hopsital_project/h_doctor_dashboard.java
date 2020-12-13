package com.example.admin.hopsital_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class h_doctor_dashboard extends AppCompatActivity
{
    RecyclerView h_d_rev;
    String title[]={"Doctor"};
    TextView tv_d_name,tv_d_email,tv_d_number;
    Button btn_bookapp,btn_call;
    ArrayList<doctor_GetterSetter> al=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h_doctor_dashboard);

        tv_d_name=findViewById(R.id.tv_d_name);
        tv_d_email=findViewById(R.id.tv_d_email);
        tv_d_number=findViewById(R.id.tv_d_number);
        btn_bookapp=findViewById(R.id.btn_bookapp);
        btn_call=findViewById(R.id.btn_call);
        h_d_rev=findViewById(R.id.h_d_rev);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(h_doctor_dashboard.this);
        h_d_rev.setLayoutManager(layoutManager);
        for (int i=0;i<title.length;i++){
            doctor_GetterSetter gl=new doctor_GetterSetter(title[i]);
            al.add(gl);
        }
      h_doctor_adapter my=new h_doctor_adapter(h_doctor_dashboard.this,al);
        h_d_rev.setAdapter(my);
    }
}
