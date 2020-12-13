package com.example.admin.hopsital_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class h_profile_dashboard extends AppCompatActivity {

    RecyclerView h_pr_rev;
    String title[] = {"Profile"};
    int img[] = {R.mipmap.profile};
    TextView tv_pr_newpassword, tv_pr_updatepassword;
    ImageView h_pr_img;
    ArrayList<h_profile_GetterSetter> al = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h_profile_dashboard);

        tv_pr_newpassword = findViewById(R.id.tv_pr_newpassword);
        tv_pr_updatepassword = findViewById(R.id.tv_pr_updatepassword);


        h_pr_img = findViewById(R.id.h_pr_img);
        h_pr_rev = findViewById(R.id.h_pr_rev);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(h_profile_dashboard.this);

        h_pr_rev.setLayoutManager(layoutManager);
        for (int i = 0; i < title.length; i++) {
            h_profile_GetterSetter gl = new h_profile_GetterSetter(title[i],img[i]);
            al.add(gl);
        }
        h_profile_adapter my = new h_profile_adapter(h_profile_dashboard.this, al);
        h_pr_rev.setAdapter(my);
    }
}
