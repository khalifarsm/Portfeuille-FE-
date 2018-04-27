package com.example.mahmoud.portefeuille.Presenters;

import android.content.Context;
import android.widget.Toast;

import com.example.mahmoud.portefeuille.Models.Historique;
import com.example.mahmoud.portefeuille.Models.Personne;
import com.example.mahmoud.portefeuille.R;
import com.example.mahmoud.portefeuille.Service.ConnexionServeur;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mahmoud on 02/04/2018.
 */

public class HistoriquePresenter {
    ConnexionServeur cs=new ConnexionServeur();
    public Context context;
    public HistoriquePresenter(Context context)
    {
        this.context=context;
    }
    public void onHistoriqueLoaded(List<Historique> historiques)
    {
        //cette methode doit etre redefinie dans l'activity

    }

    public void getHistoriques(final String email, final String pass)
    {
        Call<List<Historique>> call=cs.getHistoriqueCall(email,pass);
        call.enqueue(new Callback<List<Historique>>(){
            @Override
            public void onResponse(Call<List<Historique>> call, Response<List<Historique>> response) {
                List<Historique> historiques = response.body();
                onHistoriqueLoaded(historiques);
            }

            @Override
            public void onFailure(Call<List<Historique>> call, Throwable t) {
                Toast.makeText(context.getApplicationContext(), context.getResources().getString(R.string.connexion_failed), Toast.LENGTH_LONG).show();
                call.cancel();
            }
        });
    }

}
