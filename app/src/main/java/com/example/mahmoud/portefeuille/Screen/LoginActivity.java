package com.example.mahmoud.portefeuille.Screen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

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
        presenter=new LoginPresenter(this){
            @Override
            public void onUserLoaded(Personne user) {
                if(user!=null)
                {
                    SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    prefs.edit().putString("login",loginET.getText().toString()).commit();
                    prefs.edit().putString("pass",passET.getText().toString()).commit();
                    Intent intent=new Intent(getApplicationContext(),AcceuilActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                    loginET.setError("login ou mot de passe incorrect");
            }
        };
    }

    @OnClick(R.id.buttonLogin)
    void buttonLoginClic()
    {
        if(loginET.getText().toString().length()==0)
        {
            loginET.setError(getResources().getString(R.string.error_field_required));
        }
        else
        {
            if(passET.getText().toString().length()==0)
            {
                passET.setError(getResources().getString(R.string.error_field_required));
            }
            else
            {
                if(passET.getText().toString().length()<6)
                {
                    passET.setError(getResources().getString(R.string.error_incorrect_password));
                }
                else
                {
                    presenter.getUser(loginET.getText().toString(),passET.getText().toString());
                }
            }
        }
    }

    @OnClick(R.id.textViewAbout)
    void aboutClic()
    {
        Toast.makeText(getApplicationContext(), "Réalisé par:\nNabil RAHALI\nKhalifa RHARBAOUI RASSAME\nMahmoud CHAHTAN", Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.textViewLostPass)
    void lostPassClic()
    {
        Intent intent=new Intent(getApplicationContext(),MotDePasseActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.textViewInscription)
    void inscriptionClic()
    {
        Intent intent=new Intent(getApplicationContext(),InscriptionActivity.class);
        startActivity(intent);
    }
}
