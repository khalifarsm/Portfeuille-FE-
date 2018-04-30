package com.example.mahmoud.portefeuille.Screen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mahmoud.portefeuille.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.mahmoud.portefeuille.Presenters.InscriptionPresenter.connection;
import static com.example.mahmoud.portefeuille.Presenters.InscriptionPresenter.isValidEmail;
import static com.example.mahmoud.portefeuille.Presenters.InscriptionPresenter.verificationChampsNull;
import static com.example.mahmoud.portefeuille.Presenters.InscriptionPresenter.verificationPass;

public class InscriptionActivity extends AppCompatActivity {
    @BindView(R.id.nom)
    TextView nom;
    @BindView(R.id.prenom)
    TextView prenom;
    @BindView(R.id.adresse)
    TextView adresse;
    @BindView(R.id.email)
    TextView email;
    @BindView(R.id.pass1)
    TextView pass1;
    @BindView(R.id.pass2)
    TextView pass2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        ButterKnife.bind(this);

    }


    @OnClick(R.id.btnSingIn)
    public void inscription(){

        boolean connection=connection(getApplicationContext());
        boolean champs=verificationChampsNull(nom,prenom,adresse,email,pass1,pass2);
        boolean pass=verificationPass(pass1,pass2);
        CharSequence eemail=email.getText();
        boolean format=isValidEmail(eemail);
        //verifier l'existance d'une connection internet
        if (!connection){
            Toast.makeText(getApplicationContext(),"Pas de connection disponible",Toast.LENGTH_LONG);
        }
        //verifier si les champs sont vides
        if (!champs){
            Toast.makeText(getApplicationContext(),"Remplir tous les champs",Toast.LENGTH_LONG);
        }
        //verifier si pass1==pass2
        if (!pass){
            Toast.makeText(getApplicationContext(),"le premier mot de passe diffère du deuxième",Toast.LENGTH_LONG);
        }
        //verifier si le format email est valide
        if (!format){
            Toast.makeText(getApplicationContext(),"Revoir votre Email",Toast.LENGTH_LONG);
        }
    }

}
