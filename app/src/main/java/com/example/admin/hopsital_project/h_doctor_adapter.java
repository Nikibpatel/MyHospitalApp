package com.example.admin.hopsital_project;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class h_doctor_adapter extends RecyclerView.Adapter<h_doctor_adapter.Myclass> {

    Context d_doctor_context;
    ArrayList<doctor_GetterSetter> al;


    public h_doctor_adapter(@NonNull Context context, ArrayList<doctor_GetterSetter> al) {
        this.d_doctor_context = d_doctor_context;
        this.al = al;
    }

    @NonNull
    @Override
    public Myclass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.doctor_rowfile,viewGroup,false);
        return new Myclass(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Myclass myclass, int i) {
    final doctor_GetterSetter gl=al.get(i);

    myclass.tv_d_name.setText(gl.getTv_d_name());
    myclass.tv_d_email.setText(gl.getTv_d_email());
    myclass.tv_d_number.setText(gl.getTv_d_number());
    myclass.tv_d_hn.setText(gl.getTv_d_hn());
    myclass.tv_d_speciality.setText(gl.getTv_d_speciality());
    myclass.tv_d_pincode.setText(gl.getTv_d_pincode());
    myclass.tv_d_area.setText(gl.getTv_d_area());
    myclass.tv_d_address.setText(gl.getTv_d_address());

    myclass.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    });
    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    class Myclass extends RecyclerView.ViewHolder
    {
        TextView tv_d_name,tv_d_email,tv_d_number,tv_d_hn,tv_d_speciality,tv_d_pincode,tv_d_area,tv_d_address;


        public Myclass(@NonNull View itemView) {
            super(itemView);
            tv_d_name=itemView.findViewById(R.id.tv_d_name);
            tv_d_email=itemView.findViewById(R.id.tv_d_email);
            tv_d_number=itemView.findViewById(R.id.tv_d_number);
            tv_d_hn=itemView.findViewById(R.id.tv_d_hn);
            tv_d_speciality=itemView.findViewById(R.id.tv_d_spec);
            tv_d_pincode=itemView.findViewById(R.id.tv_d_pincode);
            tv_d_area=itemView.findViewById(R.id.tv_d_area);
            tv_d_address=itemView.findViewById(R.id.tv_d_address);

        }
    }
}
