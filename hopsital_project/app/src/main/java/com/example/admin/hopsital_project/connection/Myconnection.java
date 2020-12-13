package com.example.admin.hopsital_project.connection;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

public interface Myconnection
{
    @GET("/h_login.php")
    void hlogin(@Query("h_email") String h_email,
                       @Query("password") String h_password,
                       Callback<Response> responseCallback);

    @FormUrlEncoded
    @POST("/h_reg.php")
    void h_reg(@Field("h_name") String n_name,
                            @Field("h_email") String n_email,
                            @Field("password") String password,
                            @Field("h_contact") String h_contact,
                            @Field("h_city") String h_city,
                            @Field("h_area") String h_area,
                            Callback<Response> responseCallback);
    @FormUrlEncoded
    @POST("/h_profile_update.php")
    void h_profile_update(
            @Field("h_email") String h_email,
            @Field("password") String password,
            Callback<Response> responseCallback);



    @GET("/medicine_get.php")
    void getMedicine(Callback<Response> responseCallback);
}
