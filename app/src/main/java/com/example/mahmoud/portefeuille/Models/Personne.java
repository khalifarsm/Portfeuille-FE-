package com.example.mahmoud.portefeuille.Models;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import com.example.mahmoud.portefeuille.R;
import com.google.gson.annotations.SerializedName;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Mahmoud on 02/04/2018.
 */

public class Personne implements Serializable{
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

    public Personne(int personneID, String nom, String prenom, String adresse, String email, String pass, Bitmap image1) {
        PersonneID = personneID;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.pass = pass;
        setImage(image1);
    }

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

    public Bitmap getImage() {
        try {
            byte[] byteArray = Base64.decode(image, Base64.DEFAULT);
            return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        }
        catch (Exception ex){
            return null;
        }
    }

    public void setImage(Bitmap bitmap) {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream .toByteArray();
        image= Base64.encodeToString(byteArray, Base64.DEFAULT);
    }



    @SerializedName("image")
    String image;


    public String toString()
    {
        return nom+" "+prenom;
    }


}
