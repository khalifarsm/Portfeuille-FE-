package com.example.mahmoud.portefeuille.Service;

import android.util.Log;

import com.example.mahmoud.portefeuille.Models.Personne;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConnexionServeur {
	String url="http://192.168.43.63:45455/api/";
	static Personne user=null;

	public Personne getUser(String email, String pass)
	{
		if(user==null) {
			Log.d("ok", "getUser: usernull");
			String jsonString;
			try {
				jsonString = Connexion.sendGet(url + "personnes/" + email + "/" + pass);
				Log.d("ok", jsonString);
				GsonBuilder builder = new GsonBuilder();
				builder.setPrettyPrinting();

				Gson gson = builder.create();
				user = gson.fromJson(jsonString, Personne.class);
				return user;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				Log.d("ok", e.toString());
				//e.printStackTrace();

			}
		}
		return user;
	}
}
