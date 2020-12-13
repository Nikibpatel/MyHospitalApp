package com.example.admin.hopsital_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.hopsital_project.connection.Myconnection;
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

public class h_chemist_dashboard extends AppCompatActivity {

    RecyclerView h_c_rev;

    String tv_c_name,tv_c_email,tv_c_number;
    String h_c_img;
    ArrayList<h_chemist_GetterSetter > al=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h_chemist_dashboard);

       // tv_c_name=findViewById(R.id.tv_c_name);
        //tv_c_email=findViewById(R.id.tv_c_email);
        //tv_c_number=findViewById(R.id.tv_c_number);
        //h_c_img=findViewById(R.id.h_c_img);

        h_c_rev=findViewById(R.id.h_c_rev);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(h_chemist_dashboard.this);
        h_c_rev.setLayoutManager(layoutManager);

        //------Connnection Start--------------

        RestAdapter restAdapter=new RestAdapter.Builder().setEndpoint("https://infohappy2help.000webhostapp.com").build();
        Myconnection my=restAdapter.create(Myconnection.class);

        my.getChemist(new Callback<Response>() {
            @Override
            public void success(Response response, Response response2)
            {
                try{
                    BufferedReader bf=new BufferedReader(new InputStreamReader(response.getBody().in()));
                    String data=bf.readLine();
                    JSONArray jarr=new JSONArray(data);



                for (int i=0;i<jarr.length();i++)
                {
                    JSONObject jobj=jarr.getJSONObject(i);
                    h_c_img=jobj.getString("c_imagepath");
                    tv_c_name=jobj.getString("c_name");
                    tv_c_email=jobj.getString("c_email");
                    tv_c_number=jobj.getString("c_contact");


                    h_chemist_GetterSetter gl=new h_chemist_GetterSetter(h_c_img,tv_c_name,tv_c_email,tv_c_number);
                    al.add(gl);
                }

                h_chemist_adapter my=new h_chemist_adapter(h_chemist_dashboard.this,al);
                h_c_rev.setAdapter(my);
            } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void failure(RetrofitError error) {

                Toast.makeText(h_chemist_dashboard.this, ""+error, Toast.LENGTH_SHORT).show();

            }
        });
    }




}
