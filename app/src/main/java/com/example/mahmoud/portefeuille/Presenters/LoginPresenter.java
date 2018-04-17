package com.example.mahmoud.portefeuille.Presenters;

import android.util.Log;
import android.widget.Toast;

import com.example.mahmoud.portefeuille.Models.Personne;
import com.example.mahmoud.portefeuille.Service.ConnexionServeur;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mahmoud on 02/04/2018.
 */

public class LoginPresenter {
    ConnexionServeur cs=new ConnexionServeur();

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
                Personne user=response.body();
                onUserLoaded(user);
            }

            @Override
            public void onFailure(Call<Personne> call, Throwable t) {
                call.cancel();
            }
        });
    }

    public void test(Personne p) {
        Log.v("khalifa", p.toString());
    }
}
