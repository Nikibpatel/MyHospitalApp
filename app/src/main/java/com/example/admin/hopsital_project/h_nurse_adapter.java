package com.example.admin.hopsital_project;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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


        myclass.tv_n_name.setText(gl.getTv_n_name());
        myclass.tv_n_email.setText(gl.getTv_n_email());
        myclass.tv_n_number.setText(gl.getTv_n_number());
        myclass.tv_n_spec.setText(gl.getTv_n_spec());
        myclass.tv_n_hospital.setText(gl.getTv_n_hospital());
    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    class Myclass extends RecyclerView.ViewHolder{

        Button btn_sms,btn_email,btn_call;
        TextView tv_n_name,tv_n_email,tv_n_number,tv_n_spec,tv_n_hospital;

        public Myclass(View itemView){
            super(itemView);

            tv_n_name=itemView.findViewById(R.id.tv_nh_name);
            tv_n_email=itemView.findViewById(R.id.tv_nh_emailid);
            tv_n_number=itemView.findViewById(R.id.tv_nh_contact);
            tv_n_spec=itemView.findViewById(R.id.tv_nh_spec);
            tv_n_hospital=itemView.findViewById(R.id.tv_nh_hospital);
            btn_sms=itemView.findViewById(R.id.btn_sms);
            btn_email=itemView.findViewById(R.id.btn_email);
            btn_call=itemView.findViewById(R.id.btn_call);
        }
    }
}
