package com.example.mahmoud.portefeuille.Service;

import android.util.Log;

import com.example.mahmoud.portefeuille.Models.Historique;
import com.example.mahmoud.portefeuille.Models.Personne;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConnexionServeur {
	String url="http://192.168.43.63:45455/api/";
	IService service;

	public ConnexionServeur()
	{
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(url)
				.addConverterFactory(GsonConverterFactory.create())
				.build();

		service = retrofit.create(IService.class);
	}

	public Call<Personne> getUserCall(String email, String pass)
	{
		Call<Personne> call=null;
		try {
			call= service.getUser(email,pass);
			return call;
		} catch (Exception e) {
			e.printStackTrace();
			Log.d("ok", e.toString());
		}
		return call;
	}

	public Call<List<Historique>> getHistoriqueCall(String email, String pass)
	{
		Call<List<Historique>> call=null;
		try {
			call= service.getHistorique(email,pass);
			return call;
		} catch (Exception e) {
			e.printStackTrace();
			Log.d("ok", e.toString());
		}
		return call;
	}

	public Call<Boolean> emailExistCall(String email)
	{
		Call<Boolean> call=null;
		try {
			call= service.emailExist(email);
			return call;
		} catch (Exception e) {
			e.printStackTrace();
			Log.d("ok", e.toString());
		}
		return call;
	}
}
