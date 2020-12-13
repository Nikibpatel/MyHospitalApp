package com.example.admin.hopsital_project;

public class h_patient_GetterSetter {

    String title;
    int img;

    public h_patient_GetterSetter(String title, int img) {
        this.title = title;
        this.img = img;
    }

    public  String getTitle() {return title;}

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}

