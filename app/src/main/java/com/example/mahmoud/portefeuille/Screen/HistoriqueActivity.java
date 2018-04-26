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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.support.v4.widget.DrawerLayout.*;

public class HistoriqueActivity extends AppCompatActivity {
    MenuClass menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historique);
        menu  = new MenuClass(this,R.id.DrawerLayout,R.id.navigation);
        menu.monMenu();
    }
}
