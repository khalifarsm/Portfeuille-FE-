package com.example.mahmoud.portefeuille.Screen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mahmoud.portefeuille.Models.Personne;
import com.example.mahmoud.portefeuille.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfilActivity extends AppCompatActivity {
    Personne p;
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
    @BindView(R.id.imageButton)
    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        ButterKnife.bind(this);
    }
}
