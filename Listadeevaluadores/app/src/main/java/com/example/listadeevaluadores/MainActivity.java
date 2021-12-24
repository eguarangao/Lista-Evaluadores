package com.example.listadeevaluadores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.listadeevaluadores.Adaptador.AdapterEvaluador;
import com.example.listadeevaluadores.Interfaz.InterfazEvaluador;
import com.example.listadeevaluadores.Modelo.Evaluador;
import com.example.listadeevaluadores.Modelo.EvaluadorFull;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    AdapterEvaluador adapterEvaluador;
    public RecyclerView recyclerView;
    public List<Evaluador> itemsEvaluador;
    int x = 0;
    String y = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        itemsEvaluador = new ArrayList<>();

        getRetrofit();
    }

    public void getRetrofit() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                "https://www.uealecpeterson.net/").addConverterFactory(GsonConverterFactory.create()).build();

        InterfazEvaluador interfazEvaluador = retrofit.create(InterfazEvaluador.class);
        Call<EvaluadorFull> call = interfazEvaluador.getEvaluador();
        call.enqueue(new Callback<EvaluadorFull>() {
            @Override
            public void onResponse(Call<EvaluadorFull> call, Response<EvaluadorFull> response) {
                EvaluadorFull listaEvaluador = response.body();
                for (EvaluadorFull evaluador : listaEvaluador.getListaaevaluador()) {
                    itemsEvaluador.add((Evaluador) evaluador);
                }

                ///add datos
                PutData(itemsEvaluador);
            }

            @Override
            public void onFailure(Call<EvaluadorFull> call, Throwable t) {
                System.out.println(t.toString() + " ERRROR  EBERT ERROR");
            }
        });
    }

    private void PutData(List<Evaluador> evaluadorList) {
        adapterEvaluador = new AdapterEvaluador(MainActivity.this, (ArrayList<Evaluador>) evaluadorList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapterEvaluador);


    }


    public void BtnClic(View view) {

        int i= view.getId();
       System.out.println(i + "Ebert BUTTON");
                      Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("var", itemsEvaluador.get(2).getIdevaluador());
                startActivity(intent);

    }
/*
    @Override
    public void onInfo(int position) {
        Intent intent = new Intent(this,MainActivity2.class);
       intent.putExtra("var",itemsEvaluador.get(position).getIdevaluador());
        startActivity(intent);
            System.out.println(itemsEvaluador.get(position).getIdevaluador());

    }*/
}