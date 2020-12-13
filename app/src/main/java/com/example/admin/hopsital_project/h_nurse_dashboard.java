package com.example.admin.hopsital_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.hopsital_project.connection.Myconnection;
import com.example.admin.hopsital_project.hospital_module.h_dashboard;
import com.example.admin.hopsital_project.medicine.Medicine;

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

public class h_nurse_dashboard extends AppCompatActivity {

    RecyclerView h_n_rev;

        Button  btn_sms,btn_email,btn_call;
    String tv_n_name, tv_n_email, tv_n_number,tv_n_spec,tv_n_hospital;
    ArrayList<h_nurse_GetterSetter> al = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h_nurse_dashboard);

      //  tv_n_name = findViewById(R.id.tv_n_name);
        //tv_n_address = findViewById(R.id.tv_n_address);
        //_n_number = findViewById(R.id.tv_n_number);
        //img = findViewById(R.id.h_n_img);

        h_n_rev = findViewById(R.id.h_n_rev);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(h_nurse_dashboard.this);

        h_n_rev.setLayoutManager(layoutManager);


        RestAdapter restAdapter=new RestAdapter.Builder().setEndpoint("https://infohappy2help.000webhostapp.com").build();
        Myconnection my=restAdapter.create(Myconnection.class);

        my.getNurse(new ResponseCallback() {
            @Override
            public void success(Response response) {

                try {
                    BufferedReader bf=new BufferedReader(new InputStreamReader(response.getBody().in()));

                    String data=bf.readLine();

                    Toast.makeText(h_nurse_dashboard.this, ""+data, Toast.LENGTH_SHORT).show();
                    JSONArray jarr=new JSONArray(data);

                    for (int i = 0; i < jarr.length(); i++) {

                        JSONObject jobj=jarr.getJSONObject(i);


                        tv_n_name=jobj.getString("n_name");
                        tv_n_email=jobj.getString("n_email");
                        tv_n_number=jobj.getString("n_contact");
                        tv_n_spec=jobj.getString("n_spec");
                        tv_n_hospital=jobj.getString("n_hospital");


                        Toast.makeText(h_nurse_dashboard.this, ""+tv_n_hospital, Toast.LENGTH_SHORT).show();


                        h_nurse_GetterSetter gl = new h_nurse_GetterSetter(tv_n_name,tv_n_email,tv_n_number,tv_n_spec,tv_n_hospital);
                        al.add(gl);

                    }

                    h_nurse_adapter my = new h_nurse_adapter(h_nurse_dashboard.this, al);
                    h_n_rev.setAdapter(my);
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void failure(RetrofitError error) {

                Toast.makeText(h_nurse_dashboard.this, ""+error, Toast.LENGTH_SHORT).show();
            }

            });
        }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent i=new Intent(h_nurse_dashboard.this,h_dashboard.class);
        finish();
        startActivity(i);
    }
}
