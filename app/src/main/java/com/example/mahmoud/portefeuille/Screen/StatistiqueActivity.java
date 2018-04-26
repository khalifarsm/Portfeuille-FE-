package com.example.mahmoud.portefeuille.Screen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mahmoud.portefeuille.Presenters.StatistiquePresenter;
import com.example.mahmoud.portefeuille.R;

public class StatistiqueActivity extends MenuActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistique);
        setMenu(this,R.id.DrawerLayoutStatistiques,R.id.navigationStatistiques);
        StatistiquePresenter presenter=new StatistiquePresenter(this);
        presenter.graphe();
    }
}
