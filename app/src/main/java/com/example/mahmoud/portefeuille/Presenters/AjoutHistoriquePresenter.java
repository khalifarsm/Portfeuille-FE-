package com.example.mahmoud.portefeuille.Presenters;

import android.content.Context;
import android.widget.Toast;

import com.example.mahmoud.portefeuille.Models.Historique;
import com.example.mahmoud.portefeuille.R;
import com.example.mahmoud.portefeuille.Service.ConnexionServeur;

import java.sql.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mahmoud on 02/04/2018.
 */


public class AjoutHistoriquePresenter {

    Context context;

    public AjoutHistoriquePresenter(Context context) {
        this.context=context;
    }

    ConnexionServeur connexionServeur = new ConnexionServeur();
    Historique historique = new Historique();

    public void ajoutHistorique(int valeur, String commentaire, String date , boolean isRevenu){
        historique.setValeur(valeur);
        historique.setCommentaire(commentaire);
        historique.setDate(date);
        historique.setRevenu(isRevenu);
        historique.setPersonne(LoginPresenter.user);
        Call<Integer> call=connexionServeur.addHistorique(historique);
        call.enqueue(new Callback<Integer>(){
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                Toast.makeText(context.getApplicationContext(), "Ajouté", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                Toast.makeText(context.getApplicationContext(), context.getResources().getString(R.string.connexion_failed), Toast.LENGTH_LONG).show();
            }
        });
    }


}
