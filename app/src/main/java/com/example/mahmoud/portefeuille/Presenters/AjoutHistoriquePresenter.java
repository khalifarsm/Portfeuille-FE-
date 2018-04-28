package com.example.mahmoud.portefeuille.Presenters;

import com.example.mahmoud.portefeuille.Models.Historique;
import com.example.mahmoud.portefeuille.Service.ConnexionServeur;

import java.sql.Date;

/**
 * Created by Mahmoud on 02/04/2018.
 */


public class AjoutHistoriquePresenter {

    public AjoutHistoriquePresenter() {
    }

    ConnexionServeur connexionServeur = new ConnexionServeur();
    Historique historique = new Historique();

    public void ajoutHistorique(int valeur, String commentaire, Date date , boolean isRevenu){
        historique.setValeur(valeur);
        historique.setCommentaire(commentaire);
        historique.setDate(date);
        historique.setRevenu(isRevenu);
        connexionServeur.addHistorique(historique);
    }


}
