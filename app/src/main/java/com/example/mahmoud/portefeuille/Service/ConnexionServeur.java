package com.example.mahmoud.portefeuille.Service;

import android.util.Log;

import com.example.mahmoud.portefeuille.Models.Personne;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ConnexionServeur {
	String url="http://192.168.43.63:45455/api/";
	IService service;
	//static Personne user=null;
	public ConnexionServeur()
	{
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://api.github.com/")
				.build();

		service = retrofit.create(IService.class);
	}

	public Personne getUser(String email, String pass)
	{
		try {
			Call<Personne> call= service.getUser(email,pass);
			call.enqueue(new Callback<Personne>(){
				@Override
				public void onResponse(Call<Personne> call, Response<Personne> response) {
					Personne user=response.body();
					Log.d("ok", user.toString());
				}

				@Override
				public void onFailure(Call<Personne> call, Throwable t) {

				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*if(user==null) {
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
		}*/
		return new Personne();
	}
}
