package com.example.mahmoud.portefeuille.Screen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mahmoud.portefeuille.Presenters.MotDePassePresenter;
import com.example.mahmoud.portefeuille.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MotDePasseActivity extends AppCompatActivity {
    @BindView(R.id.email)
    TextView email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mot_de_passe);
        ButterKnife.bind(this);
        MotDePassePresenter p=new MotDePassePresenter(this){
            @Override
            public void onEmailExistLoaded(Boolean exist) {
                //tr
            }
        };
        p.emailExist("email");

    }
    @OnClick(R.id.btnmodif)
    public void btn(){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , email.getText());
        i.putExtra(Intent.EXTRA_SUBJECT, "Changement de code");
        i.putExtra(Intent.EXTRA_TEXT   , "body of email");
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getApplicationContext(), "There are no email clients installed.", Toast.LENGTH_LONG).show();
        }
    }
}
