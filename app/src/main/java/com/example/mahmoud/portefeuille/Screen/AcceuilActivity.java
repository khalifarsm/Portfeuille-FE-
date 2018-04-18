package com.example.mahmoud.portefeuille.Screen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mahmoud.portefeuille.Models.Historique;
import com.example.mahmoud.portefeuille.Presenters.HistoriquePresenter;
import com.example.mahmoud.portefeuille.Presenters.LoginPresenter;
import com.example.mahmoud.portefeuille.R;

import java.util.List;

public class AcceuilActivity extends AppCompatActivity {
    HistoriquePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);
        presenter=new HistoriquePresenter(this){
            @Override
            public void onHistoriqueLoaded(List<Historique> historiques) {
                String chaine="";
                for (Historique h: historiques
                     ) {
                    chaine+=h.toString()+"\n";
                }
                Toast.makeText(getApplicationContext(), chaine, Toast.LENGTH_LONG).show();
            }
        };
        presenter.getHistoriques(LoginPresenter.user.getEmail(),LoginPresenter.user.getPass());
    }
}
