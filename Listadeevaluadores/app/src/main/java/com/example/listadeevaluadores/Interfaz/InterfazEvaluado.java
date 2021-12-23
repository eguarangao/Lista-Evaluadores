package com.example.listadeevaluadores.Interfaz;

import com.example.listadeevaluadores.Modelo.EvaluadoFull;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface InterfazEvaluado {

    @GET("listadoaevaluar.php")
    Call<EvaluadoFull> find(@Query("e")String id);

}
