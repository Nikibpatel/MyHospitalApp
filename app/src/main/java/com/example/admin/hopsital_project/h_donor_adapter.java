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

public class h_donor_adapter extends RecyclerView.Adapter<h_donor_adapter.Myclass>

{
    Context h_dn_context;
    ArrayList<h_donor_GetterSetter> al;

    public h_donor_adapter(Context h_dn_context, ArrayList<h_donor_GetterSetter> al) {
        this.h_dn_context = h_dn_context;
        this.al = al;
    }

    public h_donor_adapter(ArrayList<h_donor_GetterSetter> al) {

    }

    @NonNull
    @Override
    public h_donor_adapter.Myclass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_h_donor_rowfile,viewGroup,false);
        return new Myclass(v);
    }

    @Override
    public void onBindViewHolder(@NonNull h_donor_adapter.Myclass myclass, int i)
    {
    final h_donor_GetterSetter gl=al.get(i);
    }

    @Override
    public int getItemCount() {
        return al.size();
    }
    class Myclass extends RecyclerView.ViewHolder{
        ImageView h_dn_img;
        TextView tv_dn_name,tv_dn_bloodgroup,tv_dn_hname;
        public Myclass(View itemView)
        {
            super(itemView);
            h_dn_img=itemView.findViewById(R.id.h_dn_img);
            tv_dn_name=itemView.findViewById(R.id.tv_dn_name);
            tv_dn_bloodgroup=itemView.findViewById(R.id.tv_dn_bloodgroup);
            tv_dn_hname=itemView.findViewById(R.id.tv_dn_hname);
        }
    }
}
