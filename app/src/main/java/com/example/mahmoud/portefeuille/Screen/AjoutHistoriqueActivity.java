package com.example.mahmoud.portefeuille.Screen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.mahmoud.portefeuille.R;

public class AjoutHistoriqueActivity extends MenuActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_historique);
        setMenu(this,R.id.DrawerLayoutajou,R.id.navigationajou);
    }
}
