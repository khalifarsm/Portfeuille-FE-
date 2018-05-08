package com.example.mahmoud.portefeuille.Service;

import com.example.mahmoud.portefeuille.Models.Historique;
import com.example.mahmoud.portefeuille.Models.Periodique;
import com.example.mahmoud.portefeuille.Models.Personne;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by khalifa on 17/04/2018.
 */

public interface IService {
    @GET("personnes/{email}/{pass}")
    public Call<Personne> getUser(@Path("email") String email,@Path("pass") String pass);

    @GET("personnes/{email}/{pass}/{newpass}")
    public Call<Personne> setUserPassword(@Path("email") String email,@Path("pass") String pass,@Path("newpass") String newpass);

    @GET("historiques/{email}/{pass}")
    public Call<List<Historique>> getHistorique(@Path("email") String email, @Path("pass") String pass);

    @GET("periodiques/{email}/{pass}")
    public Call<List<Periodique>> getPeriodique(@Path("email") String email, @Path("pass") String pass);

    @GET("historiques/{email}")
    public Call<Boolean> emailExist(@Path("email") String email);

    @POST("periodiques")
    public Call<Integer> addPeriodique(@Body Periodique periodique);

    @POST("historiques")
    public Call<Integer> addHistorique(@Body Historique historique);

    @POST("personnes")
    public Call<Integer> addPersonne(@Body Personne personne);

    @DELETE("periodiques/{id}")
    public Call<Integer> removePeriodique(@Path("id") int id);

    @DELETE("historiques/{id}")
    public Call<Historique> removeHistorique(@Path("id") int id);

    @PUT("periodiques/{id}")
    public Call<Integer> updatePeriodique(@Path("id") int id,@Body Periodique periodique);

    @PUT("historiques/{id}")
    public Call<Integer> updateHistorique(@Path("id") int id,@Body Historique historique);

    @PUT("personnes/{id}")
    public Call<Integer> updatePersonne(@Path("id") int id,@Body Personne personne);
}
