package com.example.mahmoud.portefeuille.Presenters;

import android.content.Context;
import android.widget.Toast;

import com.example.mahmoud.portefeuille.R;
import com.example.mahmoud.portefeuille.Service.ConnexionServeur;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mahmoud on 02/04/2018.
 */

public class MotDePassePresenter {
    ConnexionServeur cs=new ConnexionServeur();
    Context context;
    public MotDePassePresenter(Context context)
    {
        this.context=context;
    }
    public void onEmailExistLoaded(Boolean exist)
    {
        //cette methode doit etre redefinie dans l'activity
    }

    public void emailExist(String email)
    {
        Call<Boolean> call=cs.emailExistCall(email);
        call.enqueue(new Callback<Boolean>(){
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                Boolean exist=response.body();
                onEmailExistLoaded(exist);
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Toast.makeText(context.getApplicationContext(), context.getResources().getString(R.string.connexion_failed), Toast.LENGTH_LONG).show();
                call.cancel();
            }
        });
    }
}
