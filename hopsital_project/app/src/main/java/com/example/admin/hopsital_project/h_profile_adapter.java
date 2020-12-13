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

public class h_profile_adapter extends RecyclerView.Adapter<h_profile_adapter.Myclass> {

    Context h_pr_context;
    ArrayList<h_profile_GetterSetter> al;
    public h_profile_adapter(Context context, ArrayList<h_profile_GetterSetter> al){

        this.h_pr_context=context;
        this.al=al;
    }

    @NonNull
    @Override
    public h_profile_adapter.Myclass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.h_profile_rowfile,viewGroup,false);
        return new Myclass(v);
    }

    @Override
    public void onBindViewHolder(@NonNull h_profile_adapter.Myclass myclass, int i) {

        final  h_profile_GetterSetter gl=al.get(i);
    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    class Myclass extends RecyclerView.ViewHolder{

        ImageView h_pr_img;
        TextView tv_pr_newpassword,tv_pr_updatepassword;

        public Myclass(View itemView){
            super(itemView);
            h_pr_img=itemView.findViewById(R.id.h_pr_img);
            tv_pr_newpassword=itemView.findViewById(R.id.tv_pr_newpassword);
            tv_pr_updatepassword=itemView.findViewById(R.id.tv_pr_updatepassword);
        }
    }
}
