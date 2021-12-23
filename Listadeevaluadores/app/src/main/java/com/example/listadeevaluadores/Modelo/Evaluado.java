package com.example.listadeevaluadores.Modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Evaluado {
    private String id;
    private String idevaluado;
    private String Nombres;
    private String genero;
    private String situacion;
    private String cargo;
    private String fechaInicio;
    private String fechaFin;
    private String imgJPG;
    private String imgjpg;

    public Evaluado() {
    }
    public Evaluado(String nombres, String situacion, String cargo, String fechaInicio, String fechaFin, String imgJPG) {

        Nombres = nombres;
        this.situacion = situacion;
        this.cargo = cargo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.imgJPG = imgJPG;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdevaluado() {
        return idevaluado;
    }

    public void setIdevaluado(String idevaluado) {
        this.idevaluado = idevaluado;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getImgJPG() {
        return imgJPG;
    }

    public void setImgJPG(String imgJPG) {
        this.imgJPG = imgJPG;
    }

    public String getImgjpg() {
        return imgjpg;
    }

    public void setImgjpg(String imgjpg) {
        this.imgjpg = imgjpg;
    }
}
