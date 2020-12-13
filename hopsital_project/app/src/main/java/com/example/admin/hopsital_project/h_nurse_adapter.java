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

public class h_nurse_adapter extends RecyclerView.Adapter<h_nurse_adapter.Myclass>
{
    Context h_n_context;
    ArrayList<h_nurse_GetterSetter> al;


    public h_nurse_adapter(Context context, ArrayList<h_nurse_GetterSetter> al){

        this.h_n_context=context;
        this.al=al;
        }

    @NonNull
    @Override
    public h_nurse_adapter.Myclass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.h_nurse_rowfile,viewGroup,false);
        return new Myclass(v);
    }

    @Override
    public void onBindViewHolder(@NonNull h_nurse_adapter.Myclass myclass, int i) {

        final h_nurse_GetterSetter gl=al.get(i);
    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    class Myclass extends RecyclerView.ViewHolder{

        ImageView h_n_img;
        TextView tv_n_name,tv_n_address,tv_n_number;

        public Myclass(View itemView){
            super(itemView);
            h_n_img=itemView.findViewById(R.id.h_n_img);
            tv_n_name=itemView.findViewById(R.id.tv_n_name);
            tv_n_address=itemView.findViewById(R.id.tv_n_address);
            tv_n_number=itemView.findViewById(R.id.tv_n_number);
        }
    }
}
