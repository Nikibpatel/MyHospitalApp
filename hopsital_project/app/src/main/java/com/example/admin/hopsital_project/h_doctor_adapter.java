package com.example.admin.hopsital_project;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

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
        TextView tv_d_name,tv_d_email,tv_d_number;
        Button btn_bookapp,btn_call;

        public Myclass(@NonNull View itemView) {
            super(itemView);
            tv_d_name=itemView.findViewById(R.id.tv_d_name);
            tv_d_email=itemView.findViewById(R.id.tv_d_email);
            tv_d_number=itemView.findViewById(R.id.tv_d_number);
            btn_bookapp=itemView.findViewById(R.id.btn_bookapp);
            btn_call=itemView.findViewById(R.id.btn_call);


        }
    }
}
