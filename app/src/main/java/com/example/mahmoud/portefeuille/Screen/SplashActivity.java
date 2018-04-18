package com.example.mahmoud.portefeuille.Screen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mahmoud.portefeuille.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        loginExist();
    }

    void loginExist()
    {
        SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(this);
        String login=prefs.getString("login","default");
        String pass=prefs.getString("pass","default");
        if(false)//login.equals("khalifa") && pass.equals("123456"))
        {
            Intent intent=new Intent(this,AcceuilActivity.class);
            startActivity(intent);
        }
        else
        {
            Intent intent=new Intent(this,LoginActivity.class);
            startActivity(intent);
        }
    }
}
