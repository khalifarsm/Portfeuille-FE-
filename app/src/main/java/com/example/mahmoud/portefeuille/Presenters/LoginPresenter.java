package com.example.mahmoud.portefeuille.Presenters;

import android.util.Log;
import android.widget.Toast;

import com.example.mahmoud.portefeuille.Models.Personne;
import com.example.mahmoud.portefeuille.Service.ConnexionServeur;

/**
 * Created by Mahmoud on 02/04/2018.
 */

public class LoginPresenter {
    ConnexionServeur cs=new ConnexionServeur();
    public Personne getUser(final String email, final String pass)
    {
         /*Personne personne=new Personne();
        new Thread(new Runnable() {
            public void run() {
                Personne p = cs.getUser(email,pass);
                test(p);
            }
        }).start();
        //return cs.getUser(email,pass);*/
        return cs.getUser(email,pass);
    }

    public void test(Personne p) {
        Log.v("khalifa", p.toString());
    }
}
