package com.example.admin.hopsital_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.hopsital_project.connection.Myconnection;

import java.util.ArrayList;

import retrofit.RestAdapter;

public class h_donor_dashboard extends AppCompatActivity
{
    RecyclerView h_dn_rev;

    String tv_dn_name,tv_dn_bloodgroup,tv_dn_hname;

    ArrayList<h_donor_GetterSetter> al=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h_donor_dashboard);


        h_dn_rev=findViewById(R.id.h_dn_rev);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(h_donor_dashboard.this);

        h_dn_rev.setLayoutManager(layoutManager);


        RestAdapter restAdapter=new RestAdapter.Builder().setEndpoint("https://infohappy2help.000webhostapp.com").build();
        Myconnection my=restAdapter.create(Myconnection.class);



       // for (int i=0;i<title.length;i++){
         //   h_donor_GetterSetter gl=new h_donor_GetterSetter(title[i],img[i]);
           // al.add(gl);
        }
        h_donor_adapter my=new h_donor_adapter(h_donor_dashboard.this,al);
        //h_dn_rev.setAdapter(my);
    }
//}
