package com.example.admin.hopsital_project;

public class h_nurse_GetterSetter

{
   String tv_n_name,tv_n_email,tv_n_number,tv_n_spec,tv_n_hospital;

    public h_nurse_GetterSetter(String tv_n_name, String tv_n_email, String tv_n_number, String tv_n_spec, String tv_n_hospital) {
        this.tv_n_name = tv_n_name;
        this.tv_n_email = tv_n_email;
        this.tv_n_number = tv_n_number;
        this.tv_n_spec = tv_n_spec;
        this.tv_n_hospital = tv_n_hospital;
    }

    public String getTv_n_name() {
        return tv_n_name;
    }

    public void setTv_n_name(String tv_n_name) {
        this.tv_n_name = tv_n_name;
    }

    public String getTv_n_email() {
        return tv_n_email;
    }

    public void setTv_n_email(String tv_n_email) {
        this.tv_n_email = tv_n_email;
    }

    public String getTv_n_number() {
        return tv_n_number;
    }

    public void setTv_n_number(String tv_n_number) {
        this.tv_n_number = tv_n_number;
    }

    public String getTv_n_spec() {
        return tv_n_spec;
    }

    public void setTv_n_spec(String tv_n_spec) {
        this.tv_n_spec = tv_n_spec;
    }

    public String getTv_n_hospital() {
        return tv_n_hospital;
    }

    public void setTv_n_hospital(String tv_n_hospital) {
        this.tv_n_hospital = tv_n_hospital;
    }
}
