package com.example.mahmoud.portefeuille.Presenters;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.widget.TextView;

/**
 * Created by Mahmoud on 02/04/2018.
 */

public class InscriptionPresenter {
    //verification de la connection
   static public boolean connection(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }
    //verification si les champs sont vides
    static public boolean verificationChampsNull(TextView nom,TextView prenom,TextView adresse,TextView email,TextView pass1,TextView pass2) {
        boolean verif=true;
        if (nom.equals(null)){
            verif=false;
        }
        if (prenom.equals(null)){
            verif=false;
        }
        if (adresse.equals(null)){
            verif=false;
        }
        if (email.equals(null)){
            verif=false;
        }
        if (pass1.equals(null)){
            verif=false;
        }
        if (pass2.equals(null)){
            verif=false;
        }
       return verif;
    }
    static public boolean verificationPass(TextView pass1,TextView pass2) {
        boolean verif=false;
        if (pass2.equals(pass1)){
            verif=true;
        }
        return verif;
    }
    //verifie la validité d'un email
    public static boolean isValidEmail(CharSequence email) {
        if (TextUtils.isEmpty(email)) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
    }
}
