package com.example.admin.hopsital_project.hospital_module;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.admin.hopsital_project.R;
import com.example.admin.hopsital_project.connection.Myconnection;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class H_Profile extends AppCompatActivity {

    EditText ed_emailid, ed_n_new_password;
    Button btn_update;
    ImageView p_n_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_dashboard);
        ed_emailid = findViewById(R.id.ed_h_email_id);
       // ed_n_old_password = findViewById(R.id.ed_n_Old_password);
        ed_n_new_password = findViewById(R.id.ed_n_new_password);
        p_n_img = findViewById(R.id.p_n_img);
        btn_update = findViewById(R.id.btn_n_profile_Update);
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RestAdapter restAdapter=new RestAdapter.Builder().setEndpoint("https://infohappy2help.000webhostapp.com").build();

                Myconnection my=restAdapter.create(Myconnection.class);


              //  Toast.makeText(H_Profile.this, ""+ed_emailid.getText().toString(), Toast.LENGTH_SHORT).show();
                my.h_profile_update(ed_emailid.getText().toString(), ed_n_new_password.getText().toString(), new Callback<Response>() {
                    @Override
                    public void success(Response response, Response response2) {

                        Toast.makeText(H_Profile.this, "profile updated", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(H_Profile.this,h_dashboard.class);
                        startActivity(i);
                    }

                    @Override
                    public void failure(RetrofitError error)
                    {
                        Toast.makeText(H_Profile.this, "Error : "+error, Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

