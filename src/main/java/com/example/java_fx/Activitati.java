package com.example.java_fx;

import java.util.Date;

public class Activitati {
    int terenul,autovehiculul,utilajul,angajat;
    Date data_activitatii;

    public Activitati(Date data,int teren,int auto,int utilaj,int angajat)
    {
        this.data_activitatii = data;
        this.terenul = teren;
        this.angajat = angajat;
        this.utilajul = utilaj;
        this.autovehiculul = auto;
    }

    public int getTerenul() {
        return terenul;
    }

    public void setTerenul(int terenul) {
        this.terenul = terenul;
    }

    public int getAutovehiculul() {
        return autovehiculul;
    }

    public void setAutovehiculul(int autovehiculul) {
        this.autovehiculul = autovehiculul;
    }

    public int getUtilajul() {
        return utilajul;
    }

    public void setUtilajul(int utilajul) {
        this.utilajul = utilajul;
    }

    public int getAngajat() {
        return angajat;
    }

    public void setAngajat(int angajat) {
        this.angajat = angajat;
    }

    public Date getData_activitatii() {
        return data_activitatii;
    }

    public void setData_activitatii(Date data_activitatii) {
        this.data_activitatii = data_activitatii;
    }
}
