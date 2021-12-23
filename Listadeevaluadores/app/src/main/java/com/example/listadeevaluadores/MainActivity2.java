package com.example.listadeevaluadores;

import android.app.VoiceInteractor;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.android.volley.toolbox.JsonObjectRequest;
import com.example.listadeevaluadores.Adaptador.AdapterEvaluado;
import com.example.listadeevaluadores.Interfaz.InterfazEvaluado;
import com.example.listadeevaluadores.Modelo.Evaluado;
import com.example.listadeevaluadores.Modelo.EvaluadoFull;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity2 extends AppCompatActivity {

    public List<Evaluado> itemsEvaluado;
    public RecyclerView recyclerView;
    AdapterEvaluado adapterEvaluado;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main2);

        Bundle bundle1 = getIntent().getExtras();
        System.out.println(bundle1.toString() + "EVERT");
        getRetrofit(bundle1.getString("var").toString());
        System.out.println(bundle1.getString("var") + "EVERT");
        // getVolley("1200984258");

    }

    public void getRetrofit(String valor) {

        System.out.println(valor + "EVERTf");
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://uealecpeterson.net/ws/").
                addConverterFactory(GsonConverterFactory.create()).build();
        System.out.println(valor + "EVERTs");
        InterfazEvaluado interfazEvaluado = retrofit.create(InterfazEvaluado.class);
        System.out.println(valor + "EVERTa");
        Call<EvaluadoFull> call = interfazEvaluado.find(valor);
        System.out.println(valor + "EVERTA");
        call.enqueue(new Callback<EvaluadoFull>() {

            @Override
            public void onResponse(Call<EvaluadoFull> call, retrofit2.Response<EvaluadoFull> response) {
                System.out.println(valor + "EVERFFFTA");
                try {
                    if (response.isSuccessful())
                        System.out.println("Yes");

                    EvaluadoFull evaluado = response.body();
                    //  for(int i = 0;i<itemsEvaluado.size();i++)
                    //  itemsEvaluado.add(evaluado.getListaaevaluado().get(i));
                    loadListEvaluado(evaluado.getListaaevaluar());
                    PutData(itemsEvaluado);

                } catch (Exception ex) {
                    System.out.println(ex.toString());
                }
            }

            @Override
            public void onFailure(Call<EvaluadoFull> call, Throwable t) {

                System.out.println("EBERT.. " + t.toString());
            }
        });
    }

    public void loadListEvaluado(List<Evaluado> evaluados) {
        RecyclerView recyclerView = findViewById(R.id.recyclerView2);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        RecyclerView.Adapter evaluadoAdapter = new AdapterEvaluado(this, evaluados, R.layout.items2);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(evaluadoAdapter);
    }

    private void PutData(List<Evaluado> evaluadorList) {
        adapterEvaluado = new AdapterEvaluado(MainActivity2.this,
                evaluadorList, R.layout.items2);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity2.this));
        recyclerView.setAdapter(adapterEvaluado);


    }


}
