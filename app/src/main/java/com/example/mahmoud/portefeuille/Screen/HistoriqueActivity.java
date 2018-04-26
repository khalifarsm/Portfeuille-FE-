package com.example.mahmoud.portefeuille.Screen;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mahmoud.portefeuille.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.support.v4.widget.DrawerLayout.*;

public class HistoriqueActivity extends MenuActivity {
    MenuClass menu;
    ListView mListView;
    ImageButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historique);
        //menu  = new MenuClass(this,R.id.DrawerLayout,R.id.navigation);
        //menu.monMenu();
        setMenu(this,R.id.DrawerLayout,R.id.navigation);

        button = (ImageButton) findViewById(R.id.imageButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),AjoutHistoriqueActivity.class));
            }
        });
        mListView = (ListView) findViewById(R.id.listeHistorique);

        Historique historique0 = new Historique("+",500,"15-02-2018");
        Historique historique1 = new Historique("-",320,"13-01-2017");
        Historique historique2 = new Historique("+",220,"12-12-2013");

        ArrayList<Historique> arrayHistorique = new ArrayList<>();
        arrayHistorique.add(historique0);
        arrayHistorique.add(historique1);
        arrayHistorique.add(historique2);

        HistoriqueAdapter adapter = new HistoriqueAdapter(this, R.layout.adapter_view_layout,arrayHistorique);

        LayoutInflater inflater = getLayoutInflater();
        ViewGroup header = (ViewGroup) inflater.inflate(R.layout.header_list_layout,mListView,false);
        mListView.addHeaderView(header);

        mListView.setAdapter(adapter);
    }

}


