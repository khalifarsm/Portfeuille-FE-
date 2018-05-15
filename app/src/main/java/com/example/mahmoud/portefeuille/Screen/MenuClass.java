package com.example.mahmoud.portefeuille.Screen;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mahmoud.portefeuille.Presenters.LoginPresenter;
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
        //nom et prenom
        View headerLayout = navigationView.inflateHeaderView(R.layout.header);
        TextView tv=(TextView) headerLayout.findViewById(R.id.textViewUserName);
        ImageView imagev=(ImageView) headerLayout.findViewById(R.id.imageViewUserImage);
        imagev.setImageBitmap(LoginPresenter.user.getImage());
        tv.setText(LoginPresenter.user.toString());
        //
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
                                context.finish();
                                break;
                            case "Statistique":
                                Intent intentstatistique = new Intent(context.getApplicationContext(), StatistiqueActivity.class);
                                context.startActivity(intentstatistique);
                                context.finish();
                                break;
                            case "Historique":
                                Intent intenthist = new Intent(context.getApplicationContext(), HistoriqueActivity.class);
                                context.startActivity(intenthist);
                                context.finish();
                                break;
                            case "Profil":
                                Intent intentprofil = new Intent(context.getApplicationContext(), ProfilActivity.class);
                                context.startActivity(intentprofil);
                                context.finish();
                                break;
                            case "Deconnexion":
                                Intent intentdeco = new Intent(context.getApplicationContext(),LoginActivity.class);
                                context.startActivity(intentdeco);
                                SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
                                prefs.edit().clear().commit();
                                context.finish();
                                break;
                        }
                        return true;
                    }
                }
        );
    }
}
