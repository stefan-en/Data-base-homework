package com.example.java_fx;

public class Teren {
    int id_teren;
    String denumire, cultura,stadiu,fertilizare;
    Double suprafata,recolta;
    Double profit;

    public Teren(int id, String denumire,String cultura, String stadiu, String fertilizare, Double suprafata, Double profit, Double recolta) {
        this.id_teren = id;
        this.denumire = denumire;
        this.cultura = cultura;
        this.stadiu = stadiu;
        this.fertilizare = fertilizare;
        this.suprafata = suprafata;
        this.profit = profit;
        this.recolta = recolta;
    }
    //getters and setters

    public String getCultura() {
        return cultura;
    }

    public void setCultura(String cultura) {
        this.cultura = cultura;
    }

    public String getStadiu() {
        return stadiu;
    }

    public void setStadiu(String stadiu) {
        this.stadiu = stadiu;
    }

    public String getFertilizare() {
        return fertilizare;
    }

    public void setFertilizare(String fertilizare) {
        this.fertilizare = fertilizare;
    }

    public Double getSuprafata() {
        return suprafata;
    }

    public void setSuprafata(Double suprafata) {
        this.suprafata = suprafata;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Double getRecolta() {
        return recolta;
    }

    public void setRecolta(Double recolta) {
        this.recolta = recolta;
    }

    public int getId_teren() {
        return id_teren;
    }

    public void setId_teren(int id_teren) {
        this.id_teren = id_teren;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }
}

