package com.example.mahmoud.portefeuille.Screen;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.mahmoud.portefeuille.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuClass{
    MenuClass(AppCompatActivity activity,int drawer,int nav){
        context=activity;
        navigation=nav;
        drawerLayout=drawer;
    }
    AppCompatActivity context;

    DrawerLayout mLinearLayout ;
    int drawerLayout;
    int navigation;

    private ActionBarDrawerToggle mToggle;
    public void toggle(MenuItem item){
        mToggle.onOptionsItemSelected(item);
    }
    public  void monMenu(){
        //ButterKnife.bind(context);
        mLinearLayout = (DrawerLayout) context.findViewById(drawerLayout);
        mToggle = new ActionBarDrawerToggle(context,mLinearLayout,R.string.open,R.string.close);

        mLinearLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        context.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = context.findViewById(navigation);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        item.setChecked(true);
                        mLinearLayout.closeDrawers();
                        switch (item.toString()) {
                            case "Acceuil":
                                Intent intent = new Intent(context.getApplicationContext(), AcceuilActivity.class);
                                context.startActivity(intent);
                                break;
                            case "Statistique":
                                Intent intentstatistique = new Intent(context.getApplicationContext(), StatistiqueActivity.class);
                                context.startActivity(intentstatistique);
                                break;
                            case "Historique":
                                Intent intenthist = new Intent(context.getApplicationContext(), StatistiqueActivity.class);
                                context.startActivity(intenthist);
                                break;
                            case "Profil":
                                Intent intentprofil = new Intent(context.getApplicationContext(), ProfilActivity.class);
                                context.startActivity(intentprofil);
                                break;
                            case "Deconnexion":
                                Intent intentdeco = new Intent(context.getApplicationContext(),LoginActivity.class);
                                context.startActivity(intentdeco);
                                break;
                        }
                        return true;
                    }
                }
        );
    }
}
