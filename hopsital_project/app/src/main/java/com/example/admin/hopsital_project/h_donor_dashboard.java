package com.example.admin.hopsital_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class h_donor_dashboard extends AppCompatActivity
{
    RecyclerView h_dn_rev;
    String title[]={"Donor"};
    int img[]={R.mipmap.donor};
    TextView tv_dn_name,tv_dn_bloodgroup,tv_dn_hname;
    ImageView h_dn_img;
    ArrayList<h_donor_GetterSetter> al=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h_donor_dashboard);
        tv_dn_name=findViewById(R.id.tv_dn_name);
        tv_dn_bloodgroup=findViewById(R.id.tv_dn_bloodgroup);
        tv_dn_hname=findViewById(R.id.tv_dn_hname);
        h_dn_img=findViewById(R.id.h_dn_img);

        h_dn_rev=findViewById(R.id.h_dn_rev);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(h_donor_dashboard.this);

        h_dn_rev.setLayoutManager(layoutManager);
        for (int i=0;i<title.length;i++){
            h_donor_GetterSetter gl=new h_donor_GetterSetter(title[i],img[i]);
            al.add(gl);
        }
        h_donor_adapter my=new h_donor_adapter(h_donor_dashboard.this,al);
        h_dn_rev.setAdapter(my);
    }
}
