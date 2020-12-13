package com.example.admin.hopsital_project;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class h_patient_dashboard extends AppCompatActivity {

    RecyclerView h_p_rev;
    String title[]={"Patient"};
    int img[]={R.mipmap.patient2};
    TextView tv_p_name,tv_p_description,tv_p_number;
    ImageView h_p_img;
    ArrayList<h_patient_GetterSetter> al=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h_patient_dashboard);

        tv_p_name=findViewById(R.id.tv_p_name);
        tv_p_description=findViewById(R.id.tv_p_description);
        tv_p_number=findViewById(R.id.tv_p_number);

        h_p_img=findViewById(R.id.h_p_img);
        h_p_rev=findViewById(R.id.h_p_rev);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(h_patient_dashboard.this);

        h_p_rev.setLayoutManager(layoutManager);
        for (int i=0;i<title.length;i++){
            h_patient_GetterSetter gl=new h_patient_GetterSetter(title[i],img[i]);
            al.add(gl);
        }
        h_patient_adapter my=new h_patient_adapter(h_patient_dashboard.this,al);
        h_p_rev.setAdapter(my);


    }
}
