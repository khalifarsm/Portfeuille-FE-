package com.example.mahmoud.portefeuille.Models;

import java.util.List;

/**
 * Created by Mahmoud on 02/04/2018.
 */

public class Personne {
    int PersonneID;
    String nom;
    String prenom;
    String adresse;
    String email;
    String pass;
    String image;
    public String toString()
    {
        return nom+" "+prenom;
    }
}
