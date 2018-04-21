package com.example.mahmoud.portefeuille.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mahmoud on 02/04/2018.
 */

public class Periodique {
    @SerializedName("historiqueID")
    String historiqueID;

    @SerializedName("valeur")
    int valeur;

    @SerializedName("isRevenu")
    boolean isRevenu;

    @SerializedName("commentaire")
    String commentaire;

    @SerializedName("periode")
    int periode;

    public String getHistoriqueID() {
        return historiqueID;
    }

    public void setHistoriqueID(String historiqueID) {
        this.historiqueID = historiqueID;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public boolean isRevenu() {
        return isRevenu;
    }

    public void setRevenu(boolean revenu) {
        isRevenu = revenu;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public int getPeriode() {
        return periode;
    }

    public void setPeriode(int periode) {
        this.periode = periode;
    }
}
