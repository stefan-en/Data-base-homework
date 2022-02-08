package com.example.java_fx;

import javafx.scene.control.TableView;

import java.sql.Date;

public class Autovehicul {
    int id_autovehicul,id_sofer;
    String denumireautovehicul;
    Date anulFabricatiei,anulAchizitiei;
    int mentenanta, rezervor, putere_nominal, putere_maxim;

    public Autovehicul(int id, String denumireautovehicul, int mentenanta, int rezervor, int putere_nominal, int putere_maxim, Date anulFabricatiei, Date anulAchizitiei, int idul) {
        this.id_autovehicul = id;
        this.denumireautovehicul = denumireautovehicul;
        this.mentenanta = mentenanta;
        this.rezervor = rezervor;
        this.putere_nominal = putere_nominal;
        this.putere_maxim = putere_maxim;
        this.anulFabricatiei = anulFabricatiei;
        this.anulAchizitiei = anulAchizitiei;
        this.id_sofer = idul;
    }

    //getters and setters

    public String getDenumireautovehicul() {
        return denumireautovehicul;
    }

    public void setDenumireautovehicul(String denumireautovehicul) {
        this.denumireautovehicul = denumireautovehicul;
    }

    public int getMentenanta() {
        return mentenanta;
    }

    public void setMentenanta(int mentenanta) {
        this.mentenanta = mentenanta;
    }

    public int getRezervor() {
        return rezervor;
    }

    public void setRezervor(int rezervor) {
        this.rezervor = rezervor;
    }

    public int getPutere_nominal() {
        return putere_nominal;
    }

    public void setPutere_nominal(int putere_nominal) {
        this.putere_nominal = putere_nominal;
    }

    public int getPutere_maxim() {
        return putere_maxim;
    }

    public void setPutere_maxim(int putere_maxim) {
        this.putere_maxim = putere_maxim;
    }

    public Date getAnulFabricatiei() {
        return anulFabricatiei;
    }

    public void setAnulFabricatiei(Date anulFabricatiei) {
        this.anulFabricatiei = anulFabricatiei;
    }

    public Date getAnulAchizitiei() {
        return anulAchizitiei;
    }

    public void setAnulAchizitiei(Date anulAchizitiei) {
        this.anulAchizitiei = anulAchizitiei;
    }

    public int getId_autovehicul() {
        return id_autovehicul;
    }

    public void setId_autovehicul(int id_autovehicul) {
        this.id_autovehicul = id_autovehicul;
    }

    public int getId_sofer() {
        return id_sofer;
    }

    public void setId_sofer(int id_sofer) {
        this.id_sofer = id_sofer;
    }

}