package com.example.mahmoud.portefeuille.Presenters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.mahmoud.portefeuille.Models.Personne;
import com.example.mahmoud.portefeuille.R;
import com.example.mahmoud.portefeuille.Screen.StatistiqueActivity;
import com.example.mahmoud.portefeuille.Service.ConnexionServeur;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mahmoud on 02/04/2018.
 */

public class LoginPresenter {
    ConnexionServeur cs=new ConnexionServeur();
    public Context context;
    public static Personne user;
    public LoginPresenter(Context context)
    {
        this.context=context;
    }
    public void onUserLoaded(Personne user)
    {
        //cette methode doit etre redefinie dans l'activity
    }

    public void getUser(final String email, final String pass)
    {
        Call<Personne> call=cs.getUserCall(email,pass);
        call.enqueue(new Callback<Personne>(){
            @Override
            public void onResponse(Call<Personne> call, Response<Personne> response) {
                user=response.body();
                onUserLoaded(user);
            }

            @Override
            public void onFailure(Call<Personne> call, Throwable t) {
                Log.d("ok", "onFailure: connexion ");
                Toast.makeText(context.getApplicationContext(), context.getResources().getString(R.string.connexion_failed), Toast.LENGTH_LONG).show();
                call.cancel();
            }
        });
    }
}
