package com.example.mahmoud.portefeuille.Screen;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.mahmoud.portefeuille.Models.Historique;
import com.example.mahmoud.portefeuille.Presenters.AcceuilPresenter;
import com.example.mahmoud.portefeuille.Presenters.HistoriquePresenter;
import com.example.mahmoud.portefeuille.Presenters.LoginPresenter;
import com.example.mahmoud.portefeuille.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AcceuilActivity extends MenuActivity {
    HistoriquePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);
        setMenu(this,R.id.DrawerLayoutacc,R.id.navigationacc);
        AcceuilPresenter ap=new AcceuilPresenter(this);
        ap.graphe();
    }

}
