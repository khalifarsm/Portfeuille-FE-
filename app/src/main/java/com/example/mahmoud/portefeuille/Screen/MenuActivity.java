package com.example.mahmoud.portefeuille.Screen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.mahmoud.portefeuille.Presenters.LoginPresenter;
import com.example.mahmoud.portefeuille.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuActivity extends AppCompatActivity {
    MenuClass m;

    public void setMenu(AppCompatActivity appCompatActivity, int d, int n){
        m = new MenuClass(appCompatActivity,d,n);
        m.monMenu();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        m.toggle(item);
        return super.onOptionsItemSelected(item);
    }
}
