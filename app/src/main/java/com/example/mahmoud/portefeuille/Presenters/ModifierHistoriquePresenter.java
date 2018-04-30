package com.example.mahmoud.portefeuille.Presenters;

import com.example.mahmoud.portefeuille.Models.Historique;
import com.example.mahmoud.portefeuille.Service.ConnexionServeur;

/**
 * Created by Mahmoud on 02/04/2018.
 */

public class ModifierHistoriquePresenter {
    ConnexionServeur connexionServeur = new ConnexionServeur();

    public void updateHistorique(int id, int valeur, String commentaire, boolean isRevenu, String date){
        Historique historique = new Historique();
        historique.setValeur(valeur);
        historique.setCommentaire(commentaire);
        historique.setRevenu(isRevenu);
        historique.setDate(date);

        connexionServeur.updateHistorique(id, historique);
    }

}
