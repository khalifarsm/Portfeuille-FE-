package com.example.mahmoud.portefeuille.Screen;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.mahmoud.portefeuille.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoriqueActivity extends AppCompatActivity {

    @BindView(R.id.DrawerLayout)
    DrawerLayout mLinearLayout;

    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historique);

        ButterKnife.bind(this);

        mToggle = new ActionBarDrawerToggle(this,mLinearLayout,R.string.open,R.string.close);
        mLinearLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

     if(mToggle.onOptionsItemSelected(item)){
         return  true;
     }
         return super.onOptionsItemSelected(item);
    }
}
