package com.example.mahmoud.portefeuille.Screen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mahmoud.portefeuille.Models.Personne;
import com.example.mahmoud.portefeuille.Presenters.LoginPresenter;
import com.example.mahmoud.portefeuille.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.mahmoud.portefeuille.Presenters.InscriptionPresenter.ajoutpersonne;
import static com.example.mahmoud.portefeuille.Presenters.InscriptionPresenter.connection;
import static com.example.mahmoud.portefeuille.Presenters.InscriptionPresenter.isValidEmail;
import static com.example.mahmoud.portefeuille.Presenters.InscriptionPresenter.verificationChampsNull;
import static com.example.mahmoud.portefeuille.Presenters.InscriptionPresenter.verificationPass;
import static com.example.mahmoud.portefeuille.Presenters.ProfilPresenter.miseajourpersonne;

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
    @BindView(R.id.pass)
    TextView pass;
    @BindView(R.id.imageButton)
    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        ButterKnife.bind(this);
        p= LoginPresenter.user;
        nom.setText(p.getNom());
        prenom.setText(p.getPrenom());
        adresse.setText(p.getAdresse());
        email.setText(p.getEmail());
        pass.setText(p.getPass());
        if(p.getImage()!=null) {
            imageButton.setImageBitmap(p.getImage());
        }
    }
    @OnClick(R.id.btnmodif)
    public void modif() {

        boolean connection = connection(getApplicationContext());
        boolean champs = verificationChampsNull(nom, prenom, adresse, email, pass, pass);
        CharSequence eemail = email.getText();
        boolean format = isValidEmail(eemail);
        //verifier l'existance d'une connection internet
        if (!connection) {
            Toast.makeText(getApplicationContext(), "Pas de connection disponible", Toast.LENGTH_LONG);
        }
        //verifier si les champs sont vides
        if (!champs) {
            Toast.makeText(getApplicationContext(), "Remplir tous les champs", Toast.LENGTH_LONG);
        }
        //verifier si le format email est valide
        if (!format) {
            Toast.makeText(getApplicationContext(), "Revoir votre Email", Toast.LENGTH_LONG);
        }
        //envoie de la personne au serveur
        if (connection && champs && format) {

            p = new Personne(p.getPersonneID(), nom.getText().toString(), prenom.getText().toString(), adresse.getText().toString(), email.getText().toString(), pass.getText().toString(), imageButton.getDrawingCache());
            miseajourpersonne(p,this);
        }
    }
}
