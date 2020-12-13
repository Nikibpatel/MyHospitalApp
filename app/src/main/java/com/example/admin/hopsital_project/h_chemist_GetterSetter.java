package com.example.admin.hopsital_project;

public class h_chemist_GetterSetter {


    String tv_c_name,tv_c_email,tv_c_number;
    String h_c_img;

    public h_chemist_GetterSetter(String tv_c_name, String tv_c_email, String tv_c_number, String h_c_img) {
        this.tv_c_name = tv_c_name;
        this.tv_c_email = tv_c_email;
        this.tv_c_number = tv_c_number;
        this.h_c_img = h_c_img;
    }

    public String getTv_c_name() {
        return tv_c_name;
    }

    public void setTv_c_name(String tv_c_name) {
        this.tv_c_name = tv_c_name;
    }

    public String getTv_c_email() {
        return tv_c_email;
    }

    public void setTv_c_email(String tv_c_email) {
        this.tv_c_email = tv_c_email;
    }

    public String getTv_c_number() {
        return tv_c_number;
    }

    public void setTv_c_number(String tv_c_number) {
        this.tv_c_number = tv_c_number;
    }

    public String getH_c_img() {
        return h_c_img;
    }

    public void setH_c_img(String h_c_img) {
        this.h_c_img = h_c_img;
    }
}
