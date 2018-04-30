package com.example.mahmoud.portefeuille.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Mahmoud on 02/04/2018.
 */

public class Historique implements Serializable{
    @SerializedName("historiqueID")
    int historiqueID;

    @SerializedName("valeur")
    int valeur;

    @SerializedName("isRevenu")
    boolean isRevenu;

    @SerializedName("commentaire")
    String commentaire;

    public int getHistoriqueID() {
        return historiqueID;
    }

    public void setHistoriqueID(int historiqueID) {
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

    public int getDate() {
        String dateString=this.date.substring(0,10);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date=format.parse(dateString);
            return date.getDate()+30*date.getMonth();
        } catch (ParseException e) {
            return 0;
        }
    }

    public String getDateString()
    {
        return this.date.substring(5,10);
    }

    public String getDateStringAll()
    {
        return this.date.substring(0,10);
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String toString(){
        return historiqueID+" "+valeur+" "+isRevenu+" "+date.toString();
    }

    @SerializedName("date")
    String date;

    @SerializedName("personneID")
    int personneID;

    public void setPersonne(Personne personne) {
        this.personneID = personne.getPersonneID();
    }

    public int getPersonneID() {
        return personneID;
    }
}
