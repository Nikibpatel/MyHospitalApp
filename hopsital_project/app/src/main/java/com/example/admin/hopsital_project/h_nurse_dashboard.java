package com.example.admin.hopsital_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class h_nurse_dashboard extends AppCompatActivity {

    RecyclerView h_n_rev;
    String title[] = {"Nurse"};
    int img[] = {R.mipmap.nurse};
    ImageView h_n_img;
    TextView tv_n_name, tv_n_address, tv_n_number;
    ArrayList<h_nurse_GetterSetter> al = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h_nurse_dashboard);

        tv_n_name = findViewById(R.id.tv_n_name);
        tv_n_address = findViewById(R.id.tv_n_address);
        tv_n_number = findViewById(R.id.tv_n_number);
        h_n_img = findViewById(R.id.h_n_img);

        h_n_rev = findViewById(R.id.h_n_rev);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(h_nurse_dashboard.this);

        h_n_rev.setLayoutManager(layoutManager);

        for (int i = 0; i < title.length; i++) {
            h_nurse_GetterSetter gl = new h_nurse_GetterSetter(title[i], img[i]);
            al.add(gl);

        }

        h_nurse_adapter my = new h_nurse_adapter(h_nurse_dashboard.this, al);
        h_n_rev.setAdapter(my);
    }
}
