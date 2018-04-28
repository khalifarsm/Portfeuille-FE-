package com.example.mahmoud.portefeuille.Screen;

import android.annotation.TargetApi;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

    @BindView(R.id.etCommentaire)
    EditText etCom;

    @BindView(R.id.etDate)
    EditText etDate;


    private String  mCommentaire;
    private Date mDate;
    private int mValeur;
    private boolean isRevenu;

    AjoutHistoriquePresenter ajoutPresenter;

    @android.support.annotation.RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_historique);

        ButterKnife.bind(this);

        mValeur = Integer.parseInt(etValeur.getText().toString());
        mCommentaire = etCom.getText().toString();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            mDate = (Date)format.parse(etDate.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }


        ajoutPresenter = new AjoutHistoriquePresenter();

         ajoutPresenter.ajoutHistorique(mValeur, mCommentaire, mDate, isRevenu);

    }

    public void onRadioButtonClicked(View m){
        Boolean checked = ((RadioButton) m).isChecked();
        switch (m.getId()){
            case R.id.rbDepense:
                if(checked) isRevenu = true;
                break;
            case R.id.rbRevenu:
                if(checked) isRevenu = true;
                break;
        }

    }
}
