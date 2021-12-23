package com.example.listadeevaluadores.Modelo;

import java.util.List;

public class Evaluador extends EvaluadorFull {

        String idevaluador;
        String nombres;
        String area;
        String imgJPG;
        String imgjpg;

    public Evaluador(String idevaluador, String nombres, String area, String imgJPG) {
        this.idevaluador = idevaluador;
        this.nombres = nombres;
        this.area = area;
        this.imgJPG = imgJPG;
    }

    public String getIdevaluador() {
            return idevaluador;
        }

        public void setIdevaluador(String idevaluador) {
            this.idevaluador = idevaluador;
        }

        public String getNombres() {
            return nombres;
        }

        public void setNombres(String nombres) {
            this.nombres = nombres;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
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

