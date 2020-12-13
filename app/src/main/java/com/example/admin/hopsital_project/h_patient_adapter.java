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

public class h_patient_adapter extends RecyclerView.Adapter<h_patient_adapter.Myclass>
{
    Context h_p_context;
    ArrayList<h_patient_GetterSetter> al;

    public h_patient_adapter(Context context, ArrayList<h_patient_GetterSetter> al){
        this.h_p_context=context;
        this.al=al;

    }


    @NonNull
    @Override
    public h_patient_adapter.Myclass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.h_patient_rowfile,viewGroup,false);
        return new Myclass(v);
    }

    @Override
    public void onBindViewHolder(@NonNull h_patient_adapter.Myclass myclass, int i) {

        final h_patient_GetterSetter gl=al.get(i);

    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    class Myclass extends  RecyclerView.ViewHolder{
        TextView tv_p_name,tv_p_description,tv_p_number;

        public Myclass(View itemView){

            super(itemView);

            tv_p_name=itemView.findViewById(R.id.tv_p_name);
            tv_p_description=itemView.findViewById(R.id.tv_p_description);
            tv_p_number=itemView.findViewById(R.id.tv_p_number);
        }
    }
}
