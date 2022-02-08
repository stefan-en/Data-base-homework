package com.example.java_fx;

import java.util.Date;

public class Angajat {
    int id_angajat;
    String nume,rol,categorii_permis,CNP;
    Date data_nasterii, data_angajarii;
    Integer ore,salariu;

    public Angajat(int id, String nume,Date nasterea,Date angajarea, String cnp ,String rol,Integer ore, Integer salariu,String categorii) {
        this.id_angajat = id;
        this.nume = nume;
        this.categorii_permis = categorii;
        this.data_nasterii = nasterea;
        this.data_angajarii = angajarea;
        this.rol = rol;
        this.ore = ore;
        this.salariu = salariu;
        this.CNP = cnp;
    }
    //setter and getters


    public int getId_angajat() {
        return id_angajat;
    }

    public void setId_angajat(int id_angajat) {
        this.id_angajat = id_angajat;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Date getData_nasterii() {
        return data_nasterii;
    }

    public void setData_nasterii(Date data_nasterii) {
        this.data_nasterii = data_nasterii;
    }

    public Date getData_angajarii() {
        return data_angajarii;
    }

    public void setData_angajarii(Date data_angajarii) {
        this.data_angajarii = data_angajarii;
    }

    public Integer getOre() {
        return ore;
    }

    public void setOre(Integer ore) {
        this.ore = ore;
    }

    public Integer getSalariu() {
        return salariu;
    }

    public void setSalariu(Integer salariu) {
        this.salariu = salariu;
    }

    public String getCategorii_permis() {
        return categorii_permis;
    }

    public void setCategorii_permis(String categorii_permis) {
        this.categorii_permis = categorii_permis;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }
}
