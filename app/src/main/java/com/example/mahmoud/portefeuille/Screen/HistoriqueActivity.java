package com.example.mahmoud.portefeuille.Screen;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mahmoud.portefeuille.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.support.v4.widget.DrawerLayout.*;

public class HistoriqueActivity extends AppCompatActivity {
    MenuClass menu;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historique);
        menu  = new MenuClass(this,R.id.DrawerLayout,R.id.navigation);
        menu.monMenu();

        mListView = (ListView) findViewById(R.id.listeHistorique);

        Historique historique0 = new Historique("+",500,"15-02-2018");
        Historique historique1 = new Historique("-",320,"13-01-2017");
        Historique historique2 = new Historique("+",220,"12-12-2013");

        ArrayList<Historique> arrayHistorique = new ArrayList<>();
        arrayHistorique.add(historique0);
        arrayHistorique.add(historique1);
        arrayHistorique.add(historique2);

        HistoriqueAdapter adapter = new HistoriqueAdapter(this, R.layout.adapter_view_layout,arrayHistorique);
        mListView.setAdapter(adapter);
    }
}
