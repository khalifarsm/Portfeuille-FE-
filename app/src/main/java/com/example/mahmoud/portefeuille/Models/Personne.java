package com.example.mahmoud.portefeuille.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Mahmoud on 02/04/2018.
 */

public class Personne {
    @SerializedName("personneID")
    int PersonneID;

    @SerializedName("nom")
    String nom;

    @SerializedName("prenom")
    String prenom;

    @SerializedName("adresse")
    String adresse;

    @SerializedName("email")
    String email;

    @SerializedName("pass")
    String pass;

    @SerializedName("image")
    String image;

    @SerializedName("historiques")
    List<Historique> historiques;

    @SerializedName("periodiques")
    List<Periodique> periodiques;

    public String toString()
    {
        return nom+" "+prenom;
    }
}
