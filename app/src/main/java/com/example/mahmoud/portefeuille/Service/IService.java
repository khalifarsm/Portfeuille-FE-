package com.example.mahmoud.portefeuille.Service;

import com.example.mahmoud.portefeuille.Models.Historique;
import com.example.mahmoud.portefeuille.Models.Personne;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by khalifa on 17/04/2018.
 */

public interface IService {
    @GET("personnes/{email}/{pass}")
    public Call<Personne> getUser(@Path("email") String email,@Path("pass") String pass);

    @GET("historiques/{email}/{pass}")
    public Call<List<Historique>> getHistorique(@Path("email") String email, @Path("pass") String pass);
}
