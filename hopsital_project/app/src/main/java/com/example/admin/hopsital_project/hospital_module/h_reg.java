package com.example.admin.hopsital_project.hospital_module;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.hopsital_project.R;
import com.example.admin.hopsital_project.connection.Myconnection;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class h_reg extends AppCompatActivity {

    EditText ed_h_name,ed_h_email,ed_h_password,ed_h_contact,ed_h_address,ed_h_city,ed_h_area;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h_reg);

        ed_h_name=findViewById(R.id.ed_h_name);
        ed_h_email=findViewById(R.id.ed_h_email);
        ed_h_password=findViewById(R.id.ed_h_password);
        ed_h_contact=findViewById(R.id.ed_h_contact);
        ed_h_address=findViewById(R.id.ed_h_address);
        ed_h_city=findViewById(R.id.ed_h_city);
        ed_h_area=findViewById(R.id.ed_h_area);

        btn=findViewById(R.id.btn_registration);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("https://infohappy2help.000webhostapp.com").build();
                Myconnection my=restAdapter.create(Myconnection.class);

                my.h_reg(ed_h_name.getText().toString(),ed_h_email.getText().toString(), ed_h_password.getText().toString(),
                        ed_h_contact.getText().toString(),ed_h_city.getText().toString(),ed_h_area.getText().toString(),
                        new Callback<Response>() {

                            @Override
                            public void success(Response response, Response response2) {

                                Toast.makeText(h_reg.this, "Successfully Registared", Toast.LENGTH_SHORT).show();

                                Intent i=new Intent(h_reg.this,h_login.class);
                                startActivity(i);


                            }

                            @Override
                            public void failure(RetrofitError error) {

                                Toast.makeText(h_reg.this, ""+error, Toast.LENGTH_SHORT).show();
                            }
                        }
                );

            }
        });

            }
        }
//}
