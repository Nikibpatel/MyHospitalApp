package com.example.admin.hopsital_project;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class h_chemist_adapter extends RecyclerView.Adapter<h_chemist_adapter.Myclass> {

    Context h_c_context;
    ArrayList<h_chemist_GetterSetter> al;

    public h_chemist_adapter(Context context, ArrayList<h_chemist_GetterSetter> al) {
        this.h_c_context =context;
        this.al=al;
    }

    @NonNull
    @Override
    public h_chemist_adapter.Myclass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.h_chemist_rowfile,viewGroup,false);
        return new Myclass(v);
    }

    @Override
    public void onBindViewHolder(@NonNull h_chemist_adapter.Myclass myclass, int i) {

        final h_chemist_GetterSetter gl=al.get(i);

    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    class Myclass extends  RecyclerView.ViewHolder
    {
        ImageView h_c_img;
        TextView tv_c_name,tv_c_email,tv_c_number;

        public  Myclass (View itemView)
        {
            super(itemView);
            h_c_img=itemView.findViewById(R.id.h_c_img);
            tv_c_name=itemView.findViewById(R.id.tv_c_name);
            tv_c_email=itemView.findViewById(R.id.tv_c_email);
            tv_c_number=itemView.findViewById(R.id.tv_c_number);


        }
    }
}
