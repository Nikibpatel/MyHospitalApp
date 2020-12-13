package com.example.admin.hopsital_project.medicine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import com.example.admin.hopsital_project.R;
import com.example.admin.hopsital_project.connection.Myconnection;
import com.example.admin.hopsital_project.hospital_module.h_dashboard;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import retrofit.ResponseCallback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class Medicine extends AppCompatActivity {

    String img;
    String m_name,m_desc,m_power,m_disease;

    RecyclerView rev;

    ArrayList<Medicine_gettersetter> al=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_dashboard);


        rev=findViewById(R.id.rev);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(Medicine.this);

        rev.setLayoutManager(layoutManager);
        //------Connection Start-----------------------------


        RestAdapter restAdapter=new RestAdapter.Builder().setEndpoint("https://infohappy2help.000webhostapp.com").build();
        Myconnection my=restAdapter.create(Myconnection.class);

        my.getMedicine(new ResponseCallback() {
            @Override
            public void success(Response response) {

                try {
                    BufferedReader bf=new BufferedReader(new InputStreamReader(response.getBody().in()));

                    String data=bf.readLine();

                    JSONArray jarr=new JSONArray(data);

                    for(int i=0;i<jarr.length();i++)
                    {

                  //      Toast.makeText(Medicine.this, "inside the success", Toast.LENGTH_SHORT).show();
                        JSONObject jobj=jarr.getJSONObject(i);

                        img=jobj.getString("path");
                        m_name=jobj.getString("m_name");
                        m_desc=jobj.getString("m_discrip");
                        m_power=jobj.getString("m_power");
                        m_disease=jobj.getString("m_diseasename");

                      //  Toast.makeText(Medicine.this, ""+m_name, Toast.LENGTH_SHORT).show();

                        Medicine_gettersetter me=new Medicine_gettersetter(img,m_name,m_desc,m_power,m_disease);
                        al.add(me);

                    }

                    Medicine_Adapter my=new Medicine_Adapter(Medicine.this,al);
                    rev.setAdapter(my);


                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failure(RetrofitError error) {

                Toast.makeText(Medicine.this, ""+error, Toast.LENGTH_SHORT).show();
            }
        }); //complete



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(Medicine.this,h_dashboard.class);
        finish();
        startActivity(i);
    }
}
