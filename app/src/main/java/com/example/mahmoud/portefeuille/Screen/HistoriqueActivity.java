package com.example.mahmoud.portefeuille.Screen;

import android.content.Intent;
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

public class HistoriqueActivity extends AppCompatActivity implements ListView.OnItemClickListener {

    @BindView(R.id.DrawerLayout)
    DrawerLayout mLinearLayout;
    View v;

    private ListView drawerListView;
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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navigation_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

     mToggle.onOptionsItemSelected(item);
     switch (item.getItemId()) {
         case R.id.macceuil:
             Toast toast = Toast.makeText(getApplicationContext(),"acceuil",Toast.LENGTH_LONG);
             toast.show();
             Intent intent = new Intent(getApplicationContext(), AcceuilActivity.class);
             startActivity(intent);
             return true;
         case R.id.mprofil:
             Toast toastprofil = Toast.makeText(getApplicationContext(),"acceuil",Toast.LENGTH_LONG);
             toastprofil.show();
             Intent intentprofil = new Intent(getApplicationContext(), ProfilActivity.class);
             startActivity(intentprofil);
             return true;
         case R.id.mstatisque:
             Toast toaststat = Toast.makeText(getApplicationContext(),"statistique",Toast.LENGTH_LONG);
             toaststat.show();
             Intent intentstatistique = new Intent(getApplicationContext(), AjoutHistoriqueActivity.class);
             startActivity(intentstatistique);
             return true;
         case R.id.mdeconnexion:
             Toast toastdeco = Toast.makeText(getApplicationContext(),"deconnexion",Toast.LENGTH_LONG);
             toastdeco.show();
             Intent intentdeco = new Intent(getApplicationContext(),LoginActivity.class);
             startActivity(intentdeco);
             return true;
         default:
             return super.onOptionsItemSelected(item);
     }
    }


    @Override
    public void onItemClick(AdapterView<?> parent , View view, int position, long id) {
        String clickedItem = (String) parent.getAdapter().getItem(position);
        //myTextView.setText(clickedItem);
        if(position == 0){
            Intent intentdeco = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intentdeco);
        }
        mLinearLayout.closeDrawer(drawerListView);
    }
}
