package com.example.java_fx;

public class Utilaj {
    Integer id;
    String denumireutilaj, lucrari;
    Integer mentenantautilaj, putereminima;
    Double viteza;
    String AnFabricatie, AnAchizitie;
    public Utilaj(Integer id, String denumireutilaj, Integer putere,Integer mentenantautilaj, String lucrari, Double viteza, String anulfabricatiei, String anulachizitie) {
        this.id = id;
        this.denumireutilaj = denumireutilaj;
        this.lucrari = lucrari;
        this.mentenantautilaj = mentenantautilaj;
        this.putereminima = putere;
        this.viteza = viteza;
        this.AnFabricatie = anulfabricatiei;
        this.AnAchizitie = anulachizitie;
    }
    //Setters and getters

    public String getDenumireutilaj() {
        return denumireutilaj;
    }

    public void setDenumireutilaj(String denumireutilaj) {
        this.denumireutilaj = denumireutilaj;
    }

    public String getLucrari() {
        return lucrari;
    }

    public void setLucrari(String lucrari) {
        this.lucrari = lucrari;
    }

    public Integer getMentenantautilaj() {
        return mentenantautilaj;
    }

    public void setMentenantautilaj(Integer mentenantautilaj) {
        this.mentenantautilaj = mentenantautilaj;
    }

    public Double getViteza() {
        return viteza;
    }

    public void setViteza(Double viteza) {
        this.viteza = viteza;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getPutereminima() {
        return putereminima;
    }

    public void setPutereminima(Integer putereminima) {
        this.putereminima = putereminima;
    }

    public String getAnFabricatie() {
        return AnFabricatie;
    }

    public void setAnFabricatie(String anFabricatie) {
        this.AnFabricatie = anFabricatie;
    }

    public String getAnAchizitie() {
        return AnAchizitie;
    }

    public void setAnAchizitie(String anAchizitie) {
        this.AnAchizitie = anAchizitie;
    }
}

