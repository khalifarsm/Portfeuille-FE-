package com.example.mahmoud.portefeuille.Presenters;

import android.content.Context;
import android.widget.Toast;

import com.example.mahmoud.portefeuille.Models.Personne;
import com.example.mahmoud.portefeuille.R;
import com.example.mahmoud.portefeuille.Service.ConnexionServeur;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mahmoud on 02/04/2018.
 */

public class ProfilPresenter {
    public static void miseajourpersonne(Personne personne, final Context context) {
        ConnexionServeur connexionServeur = new ConnexionServeur();
        Call<Integer> call = connexionServeur.updatePersonne(personne.getPersonneID(),personne);
        call.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                Toast.makeText(context.getApplicationContext(), "Envoyé", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                Toast.makeText(context.getApplicationContext(), context.getResources().getString(R.string.connexion_failed), Toast.LENGTH_LONG).show();
            }
        });
    }
}
