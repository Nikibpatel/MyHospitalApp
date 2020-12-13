package com.example.admin.hopsital_project.hospital_module;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.hopsital_project.R;
import com.example.admin.hopsital_project.connection.Myconnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class h_login extends AppCompatActivity {

    EditText h_email,h_password;
    Button btn_login;
    ImageView h_img;
    String email,password;

    TextView tvregisterlink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_login);
        h_email=findViewById(R.id.h_email);
        h_password=findViewById(R.id.h_password);
        btn_login=findViewById(R.id.btn_login);
        h_img=findViewById(R.id.h_img);


        tvregisterlink=findViewById(R.id.tvregister);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("https://infohappy2help.000webhostapp.com").build();
                Myconnection my = restAdapter.create(Myconnection.class);

                my.hlogin(h_email.getText().toString(),h_password.getText().toString(), new Callback<Response>() {
                    @Override
                    public void success(Response response, Response response2) {
                        try {
                            // Toast.makeText(h_login.this, "login", Toast.LENGTH_SHORT).show();
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getBody().in()));
                            String data = bufferedReader.readLine();
                            JSONArray jarr = new JSONArray(data);

                            for(int i=0;i<jarr.length();i++)
                            {
                                JSONObject jsonObject=jarr.getJSONObject(i);
                                // String h_id=jsonObject.getString("h_id");

                                Intent in=new Intent(h_login.this,h_dashboard.class);
                                finish();
                                startActivity(in);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(h_login.this, ""+error, Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        tvregisterlink.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i =new Intent(h_login.this,h_reg.class);
                startActivity(i);
            }
        });
    }
}
