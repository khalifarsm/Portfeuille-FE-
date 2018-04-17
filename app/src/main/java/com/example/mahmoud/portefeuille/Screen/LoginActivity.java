package com.example.mahmoud.portefeuille.Screen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.example.mahmoud.portefeuille.Models.Personne;
import com.example.mahmoud.portefeuille.Presenters.LoginPresenter;
import com.example.mahmoud.portefeuille.R;
import com.example.mahmoud.portefeuille.Service.ConnexionServeur;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.editTextLogin)
    EditText loginET;

    @BindView(R.id.editTextPass)
    EditText passET;

    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        presenter=new LoginPresenter(){
            @Override
            public void onUserLoaded(Personne user) {
                if(user!=null)
                {
                    SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    prefs.edit().putString("login",loginET.getText().toString()).commit();
                    prefs.edit().putString("pass",passET.getText().toString()).commit();
                    Intent intent=new Intent(getApplicationContext(),AcceuilActivity.class);
                    startActivity(intent);
                }
                else
                    loginET.setError("login ou mot de passe incorrect");
            }
        };
    }

    @OnClick(R.id.buttonLogin)
    void buttonLoginClic()
    {
        presenter.getUser(loginET.getText().toString(),passET.getText().toString());
    }
}
