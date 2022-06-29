package Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Laboratorio N.2: segundo miniproyecto. Archivo: Juego.java, Autores (Grupo 01 POE): 
 * Brayan Andrés Sánchez Lozano <brayan.andres.sanchez@correounivalle.edu.co>
 * Jose Manuel Palma Oquendo <jose.palma@correounivalle.edu.co>
 * Fecha creación: 10-06-2022, Fecha última modificación: 18-06-2022 
 * Docente: Luis Romo <luis.romo@correounivalle.edu.co>
 */

public class Juego {
    private int puntuacion;
    private int aciertos;
    private int errores;
    private int vidas;
    private int nivel;
    private int tiempo;
    private final boolean cuadrosIguales;
    private boolean huboError;
    private List<Integer> numerosC = new ArrayList<Integer>();  
     
    public Juego(Cuadrado cuadro1, Cuadrado cuadro2, Cuadrado cuadro3, Cuadrado cuadro4, Cuadrado cuadro5, Cuadrado cuadro6, Cuadrado cuadro7, Cuadrado cuadro8) {
        puntuacion = 0;
        aciertos = 0;
        errores = 0;
        vidas = 3;
        nivel = 1;
        tiempo = 1500;
        cuadrosIguales = false;
        huboError = false;
    }

    public void setPuntuacion() {
        puntuacion+=5;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public int getAciertos() {
        return aciertos;
    }

    public int getErrores() {
        return errores;
    }

    public int getVidas() {
        return vidas;
    }

    public int getNivel() {
        return nivel;
    }

    public int getTiempo() {
        return tiempo;
    }

    public List getNumeroCuadros(List<Cuadrado> cuadros) {
        numerosC.removeAll(numerosC);
        for(int i = 0; i < cuadros.size(); i++){
            numerosC.add((cuadros.get(i)).getImagen());
        }
        return numerosC;
    }

    public boolean isCuadrosIguales() {
        return cuadrosIguales;
    }

    public void setAciertos() {
        aciertos++;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public void errores() {
        errores++;
        huboError = true;
    }

    public void disminuirVidas() {
        vidas--;
    }

    public boolean isHuboError() {
        return huboError;
    }
}
