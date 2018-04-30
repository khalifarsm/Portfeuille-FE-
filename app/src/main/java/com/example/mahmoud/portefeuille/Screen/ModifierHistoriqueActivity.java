package com.example.mahmoud.portefeuille.Screen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.mahmoud.portefeuille.Models.Historique;
import com.example.mahmoud.portefeuille.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ModifierHistoriqueActivity extends AppCompatActivity {

    @BindView(R.id.etValeur)
    EditText etValeur;

    @BindView(R.id.etComment)
    EditText etCommentaire;

    @BindView(R.id.etDate)
    EditText etDate;

    @BindView(R.id.rbRevenu)
    RadioButton rbRevenu;

    @BindView(R.id.rbDepense)
    RadioButton rbDepense;

    @BindView(R.id.modifier)
    Button modifier;

    @BindView(R.id.supprimer)
    Button supprimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_historique);

        ButterKnife.bind(this);

        //Intent intent = new Intent();

        Historique historique = (Historique) getIntent().getSerializableExtra("historique");
        Toast.makeText(this,"voila " + historique.getValeur(),Toast.LENGTH_LONG).show();

        etValeur.setText(String.valueOf(historique.getValeur()));
        etCommentaire.setText(String.valueOf(historique.getCommentaire()));
        etDate.setText(String.valueOf(historique.getDateStringAll()));
        if(!historique.isRevenu()) {
            rbDepense.setChecked(true);
        } else {
            rbRevenu.setChecked(true);
        }

    }
    public void onRadioButtonClicked(View m){
        Boolean checked = ((RadioButton) m).isChecked();
        switch (m.getId()){
            case R.id.rbDepense:
                checked = true;
                break;
            case R.id.rbRevenu:
                checked = true;
                break;
        }

    }
}
