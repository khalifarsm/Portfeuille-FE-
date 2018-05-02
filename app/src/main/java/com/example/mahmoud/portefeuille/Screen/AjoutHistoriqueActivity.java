package com.example.mahmoud.portefeuille.Screen;

import android.annotation.TargetApi;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.mahmoud.portefeuille.Presenters.AjoutHistoriquePresenter;
import com.example.mahmoud.portefeuille.R;

import java.sql.Date;
import java.text.ParseException;


import butterknife.BindView;
import butterknife.ButterKnife;

public class AjoutHistoriqueActivity extends MenuActivity  {

    @BindView(R.id.etValeur)
    EditText etValeur;

    @BindView(R.id.ajouter)
    Button ajouter;


    @BindView(R.id.etDate)
    EditText etDate;

    private EditText etCommentaire;
    private String  mCommentaire, mDate;
    private int mValeur;
    private boolean isRevenu;

    AjoutHistoriquePresenter ajoutPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_historique);
        ButterKnife.bind(this);




        ajoutPresenter = new AjoutHistoriquePresenter(this);

        ajouter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                etCommentaire = (EditText) findViewById(R.id.etComment);
                String valeur = etValeur.getText().toString();

                try {
                    mValeur = Integer.parseInt(valeur);
                } catch (NumberFormatException e) {
                    valeur = "";
                }
                mCommentaire = etCommentaire.getText().toString();
                mDate = etDate.getText().toString();
                ajoutPresenter.ajoutHistorique(mValeur, mCommentaire, mDate, isRevenu);
                startActivity(new Intent(getApplicationContext(),HistoriqueActivity.class));
            }
        });

    }

    public void onRadioButtonClicked(View m){
        Boolean checked = ((RadioButton) m).isChecked();
        switch (m.getId()){
            case R.id.rbDepense:
                if(checked) isRevenu = false;
                break;
            case R.id.rbRevenu:
                if(checked) isRevenu = true;
                break;
        }

    }
}
