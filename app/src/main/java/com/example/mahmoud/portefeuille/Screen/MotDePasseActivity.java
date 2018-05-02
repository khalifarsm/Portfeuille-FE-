package com.example.mahmoud.portefeuille.Screen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mahmoud.portefeuille.Presenters.MotDePassePresenter;
import com.example.mahmoud.portefeuille.Presenters.PasswordGenerator;
import com.example.mahmoud.portefeuille.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.mahmoud.portefeuille.Presenters.InscriptionPresenter.isValidEmail;

public class MotDePasseActivity extends AppCompatActivity {
    MotDePassePresenter p;
    @BindView(R.id.email)
    TextView email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mot_de_passe);
        ButterKnife.bind(this);
        p=new MotDePassePresenter(this){
            @Override
            public void onEmailExistLoaded(Boolean exist) {
                if (exist) {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("message/rfc822");
                    PasswordGenerator passwordGenerator = new PasswordGenerator.PasswordGeneratorBuilder()
                            .useDigits(true)
                            .useLower(true)
                            .useUpper(true)
                            .build();
                    String password = passwordGenerator.generate(10);
                    i.putExtra(Intent.EXTRA_EMAIL, email.getText());
                    i.putExtra(Intent.EXTRA_SUBJECT, "Changement de code");
                    i.putExtra(Intent.EXTRA_TEXT, "Votre nouveau code est:\n"+password);
                    try {
                        startActivity(Intent.createChooser(i, "Send mail..."));
                        Toast.makeText(getApplicationContext(), "Email envoyé....", Toast.LENGTH_LONG);
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(getApplicationContext(), "Erreur....", Toast.LENGTH_LONG);
                        Toast.makeText(getApplicationContext(), "There are no email clients installed.", Toast.LENGTH_LONG).show();
                    }
                }
                else {

                    Toast.makeText(getApplicationContext(), "Email innexistant....", Toast.LENGTH_LONG);
                }
            }
        };


    }
    @OnClick(R.id.btnmodif)
    public void btn(){

        CharSequence eemail=email.getText();
        boolean format=isValidEmail(eemail);
        //verifier si le format email est valide
        if (!format){
            Toast.makeText(getApplicationContext(),"Revoir votre Email",Toast.LENGTH_LONG);
        }
        else {
            p.emailExist("email");
            // verifier l'existance de l email dans la base de donnés

        }
    }
}
