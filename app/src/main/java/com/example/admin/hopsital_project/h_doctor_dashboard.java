package com.example.admin.hopsital_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import com.example.admin.hopsital_project.connection.Myconnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import retrofit.Callback;
import retrofit.ResponseCallback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class h_doctor_dashboard extends AppCompatActivity
{
    RecyclerView h_d_rev;
    Button btn_sms,btn_email,btn_call;
    String tv_d_name,tv_d_email,tv_d_number,tv_d_hn,tv_d_speciality,tv_d_pincode,tv_d_area,tv_d_address;

    ArrayList<doctor_GetterSetter> al=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h_doctor_dashboard);

        //tv_d_name=findViewById(R.id.tv_d_name);
        //tv_d_email=findViewById(R.id.tv_d_email);
        //tv_d_number=findViewById(R.id.tv_d_number);
        btn_sms=findViewById(R.id.btn_sms);
        btn_email=findViewById(R.id.btn_email);
        btn_call=findViewById(R.id.btn_call);
        h_d_rev=findViewById(R.id.h_d_rev);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(h_doctor_dashboard.this);
        h_d_rev.setLayoutManager(layoutManager);


        RestAdapter restAdapter=new RestAdapter.Builder().setEndpoint("https://infohappy2help.000webhostapp.com").build();
        Myconnection my=restAdapter.create(Myconnection.class);
        my.getDoctor(new Callback<Response>() {
            @Override
            public void success(Response response, Response response2) {
                try{
                    BufferedReader bf=new BufferedReader(new InputStreamReader(response.getBody().in()));
                    String data=bf.readLine();
                    JSONArray jarr=new JSONArray(data);



                    for (int i=0;i<jarr.length();i++){

                        JSONObject jobj=jarr.getJSONObject(i);
                        tv_d_name=jobj.getString("d_name");
                        tv_d_email=jobj.getString("d_email");
                        tv_d_number=jobj.getString("d_contact");
                        tv_d_hn=jobj.getString("d_hosp_name");
                        tv_d_speciality=jobj.getString("d_spec");
                        tv_d_pincode=jobj.getString("d_pincode");
                        tv_d_area=jobj.getString("d_area");
                        tv_d_address=jobj.getString("d_address");


                        doctor_GetterSetter gl=new doctor_GetterSetter(tv_d_name,tv_d_email,tv_d_number,tv_d_hn,tv_d_speciality,tv_d_pincode,tv_d_area,tv_d_address);
                        al.add(gl);
                    }
                    h_doctor_adapter my=new h_doctor_adapter(h_doctor_dashboard.this,al);
                    h_d_rev.setAdapter(my);



                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });

    }
}
