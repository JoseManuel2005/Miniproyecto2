/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import Modelo.Cuadrado;
/**
 *
 * @author Usuario
 */
public class Juego {
     private int puntuacion;
     private int aciertos;
     private int errores;
     private int vidas;
     private int numeroCuadros;
     private Cuadrado cuadros[];

    public Juego(Cuadrado cuadro1, Cuadrado cuadro2, Cuadrado cuadro3, Cuadrado cuadro4, Cuadrado cuadro5, Cuadrado cuadro6, Cuadrado cuadro7, Cuadrado cuadro8) {
        puntuacion = 0;
        aciertos = 0;
        errores = 0;
        vidas = 3;
        numeroCuadros = 3;
        Cuadrado cuadros[] = {cuadro1,cuadro2, cuadro3,cuadro4,cuadro5,cuadro6,cuadro7,cuadro8};
       
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }

    public void setErrores(int errores) {
        this.errores = errores;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }
  
    public void setNumeroCuadros(int numeroCuadros) {
        this.numeroCuadros = numeroCuadros;
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

    public int getNumeroCuadros() {
        return numeroCuadros;
    }
    
    public void sonIguales(){
        
        
        
    }
}
