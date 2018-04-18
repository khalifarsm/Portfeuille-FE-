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

    public int getPersonneID() {
        return PersonneID;
    }

    public void setPersonneID(int personneID) {
        PersonneID = personneID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }



    @SerializedName("image")
    String image;


    public String toString()
    {
        return nom+" "+prenom;
    }


}
