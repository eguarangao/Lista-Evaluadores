package com.example.listadeevaluadores.Modelo;

import java.util.List;
import java.util.Objects;

public class EvaluadoFull {
    List<Evaluado> listaaevaluar;

    public EvaluadoFull(List<Evaluado> listaaevaluar) {
        this.listaaevaluar = listaaevaluar;
    }

    public List<Evaluado> getListaaevaluar() {
        return listaaevaluar;
    }

    public void setListaaevaluar(List<Evaluado> listaaevaluar) {
        this.listaaevaluar = listaaevaluar;
    }
}
