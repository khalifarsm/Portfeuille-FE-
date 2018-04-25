package com.example.mahmoud.portefeuille.Screen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

import com.example.mahmoud.portefeuille.Models.Personne;
import com.example.mahmoud.portefeuille.Presenters.LoginPresenter;
import com.example.mahmoud.portefeuille.R;

public class SplashActivity extends AppCompatActivity {

    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        presenter=new LoginPresenter(this){
            @Override
            public void onUserLoaded(Personne user)
            {
                if(user==null)
                {
                    Intent intent=new Intent(context,LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Intent intent=new Intent(context,AcceuilActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(this);
        String login=prefs.getString("login","default");
        String pass=prefs.getString("pass","default");
        presenter.getUser(login,pass);
    }
}
