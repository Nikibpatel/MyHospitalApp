package com.example.admin.hopsital_project.medicine;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.admin.hopsital_project.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Medicine_Adapter extends RecyclerView.Adapter<Medicine_Adapter.MYCLASS>
{

    Context context;
    ArrayList<Medicine_gettersetter> al;

    public Medicine_Adapter(Context context, ArrayList<Medicine_gettersetter> al) {
        this.context = context;
        this.al = al;
    }

    @NonNull
    @Override
    public MYCLASS onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.medicine_row, parent, false);
        return new MYCLASS(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MYCLASS holder, int position)
    {
        final Medicine_gettersetter gl=al.get(position);

        Picasso.with(context).load(gl.getImg()).into(holder.im);

        holder.m_name.setText(gl.getM_name());
        holder.m_desc.setText(gl.getM_desc());
        holder.m_disease.setText(gl.getM_disease());
        holder.m_power.setText(gl.getM_power());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

       }

    @Override
    public int getItemCount() {
        return al.size();
    }


    class MYCLASS extends RecyclerView.ViewHolder {
        ImageView im;

        TextView m_name,m_desc,m_power,m_disease;

        public MYCLASS(View itemView) {
            super(itemView);

            im=itemView.findViewById(R.id.m_img);
            m_name=itemView.findViewById(R.id.tv_m_name);
            m_desc=itemView.findViewById(R.id.tv_m_desc);
            m_power=itemView.findViewById(R.id.tv_m_power);
            m_disease=itemView.findViewById(R.id.tv_m_disease);

        }
    }
}
