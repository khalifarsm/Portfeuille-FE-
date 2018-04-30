package com.example.mahmoud.portefeuille.Presenters;

import android.content.Context;
import android.widget.Toast;

import com.example.mahmoud.portefeuille.Models.Historique;
import com.example.mahmoud.portefeuille.R;
import com.example.mahmoud.portefeuille.Service.ConnexionServeur;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mahmoud on 02/04/2018.
 */

public class ModifierHistoriquePresenter {
    ConnexionServeur connexionServeur = new ConnexionServeur();
    Context context;
    public ModifierHistoriquePresenter(Context context)
    {
        this.context=context;
    }

    public void updateHistorique(int id, int valeur, String commentaire, boolean isRevenu, String date) {
        Historique historique = new Historique();
        historique.setValeur(valeur);
        historique.setCommentaire(commentaire);
        historique.setRevenu(isRevenu);
        historique.setDate(date);
        historique.setPersonne(LoginPresenter.user);

        Call<Integer> call = connexionServeur.updateHistorique(id, historique);
        call.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                Toast.makeText(context.getApplicationContext(), "Modifié", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                Toast.makeText(context.getApplicationContext(), context.getResources().getString(R.string.connexion_failed), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void deleteHistorique(int id){
        Call<Historique> call =connexionServeur.removeHistorique(id);
        call.enqueue(new Callback<Historique>(){
            @Override
            public void onResponse(Call<Historique> call, Response<Historique> response) {
                Toast.makeText(context.getApplicationContext(), "Supprimé", Toast.LENGTH_LONG).show();
            }
            @Override
            public void onFailure(Call<Historique> call, Throwable t) {
                Toast.makeText(context.getApplicationContext(), context.getResources().getString(R.string.connexion_failed), Toast.LENGTH_LONG).show();
            }
        });
    }


}
