package com.example.admin.hopsital_project.medicine;

public class Medicine_gettersetter
{
    String img;

    String m_name,m_desc,m_power,m_disease;

    public Medicine_gettersetter(String img, String m_name, String m_desc, String m_power, String m_disease) {
        this.img = img;
        this.m_name = m_name;
        this.m_desc = m_desc;
        this.m_power = m_power;
        this.m_disease = m_disease;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public String getM_desc() {
        return m_desc;
    }

    public void setM_desc(String m_desc) {
        this.m_desc = m_desc;
    }

    public String getM_power() {
        return m_power;
    }

    public void setM_power(String m_power) {
        this.m_power = m_power;
    }

    public String getM_disease() {
        return m_disease;
    }

    public void setM_disease(String m_disease) {
        this.m_disease = m_disease;
    }
}
