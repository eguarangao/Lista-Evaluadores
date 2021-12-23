package com.example.listadeevaluadores.Interfaz;

import com.example.listadeevaluadores.Modelo.EvaluadoFull;
import com.example.listadeevaluadores.Modelo.Evaluador;
import com.example.listadeevaluadores.Modelo.EvaluadorFull;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface InterfazEvaluador {
    @GET("/ws/listadoevaluadores.php")
    Call<EvaluadorFull> getEvaluador();

}
