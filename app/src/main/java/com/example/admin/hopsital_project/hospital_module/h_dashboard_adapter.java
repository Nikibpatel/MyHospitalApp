package com.example.admin.hopsital_project.hospital_module;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.hopsital_project.GetterSetter;
import com.example.admin.hopsital_project.R;
import com.example.admin.hopsital_project.h_chemist_dashboard;
import com.example.admin.hopsital_project.h_doctor_dashboard;
import com.example.admin.hopsital_project.h_donor_dashboard;
import com.example.admin.hopsital_project.h_nurse_dashboard;
import com.example.admin.hopsital_project.h_patient_dashboard;
import com.example.admin.hopsital_project.h_profile_dashboard;
import com.example.admin.hopsital_project.medicine.Medicine;

import java.util.ArrayList;

public class h_dashboard_adapter extends RecyclerView.Adapter<h_dashboard_adapter.MYCLASS>
{

    Context context;
    ArrayList<GetterSetter> al;


    public h_dashboard_adapter(Context context, ArrayList<GetterSetter> al) {
        this.context = context;
        this.al = al;
    }

    @NonNull
    @Override
    public MYCLASS onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rowfile,viewGroup,false);
        return new MYCLASS(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MYCLASS myclass, int position) {
        final Object gl=al.get(position);
        myclass.im.setImageResource(((GetterSetter) gl).getImg());
        myclass.tv.setText(((GetterSetter) gl).getTitle());

        myclass.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             if ( ((GetterSetter) gl).getTitle().equals("Doctor"))
                {
                    Intent i=new Intent(context,h_doctor_dashboard.class);
                    ((Activity)context).finish();
                    context.startActivity(i);
                }
             if (((GetterSetter) gl).getTitle().equals("BloodDonor"))
             {
                Intent i=new Intent(context,h_donor_dashboard.class);
                ((Activity)context).finish();
                context.startActivity(i);
            }

            if (((GetterSetter) gl).getTitle().equals("Nurse")){
                 Intent i=new Intent(context,h_nurse_dashboard.class);
                ((Activity)context).finish();
                context.startActivity(i);
            }

               if (((GetterSetter) gl).getTitle().equals("Patient")){
                    Intent i=new Intent(context,h_patient_dashboard.class);
                    ((Activity)context).finish();
                    context.startActivity(i);
                }

                if (((GetterSetter) gl).getTitle().equals("Chemist")){
                    Intent i=new Intent(context,h_chemist_dashboard.class);
                    ((Activity)context).finish();
                    context.startActivity(i);
                }

                if (((GetterSetter) gl).getTitle().equals("Profile")){
                    Intent i=new Intent(context,H_Profile.class);
                    ((Activity)context).finish();
                    context.startActivity(i);
                }if (((GetterSetter) gl).getTitle().equals("Medicine")){
                    Intent i=new Intent(context,Medicine.class);
                    ((Activity)context).finish();
                    context.startActivity(i);
                }
            }

        });


    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    class MYCLASS extends RecyclerView.ViewHolder
    {
        ImageView im;
        TextView tv;

        public MYCLASS(View itemView)
        {
            super(itemView);
            im=itemView.findViewById(R.id.img);
            tv=itemView.findViewById(R.id.tv);

        }
    }

}
