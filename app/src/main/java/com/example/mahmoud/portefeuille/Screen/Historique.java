package com.example.mahmoud.portefeuille.Screen;

import java.util.Date;

/**
 * Created by Mahmoud on 25/04/2018.
 */

public class Historique {
    String type;
    int valeur;
    String date;

    public Historique(String type, int valeur, String date) {
        this.type = type;
        this.valeur = valeur;
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
