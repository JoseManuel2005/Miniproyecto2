/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
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
     private boolean cuadrosIguales;
     private boolean huboError;
     private Cuadrado cuadros[];
     

    public Juego(Cuadrado cuadro1, Cuadrado cuadro2, Cuadrado cuadro3, Cuadrado cuadro4, Cuadrado cuadro5, Cuadrado cuadro6, Cuadrado cuadro7, Cuadrado cuadro8) {
        puntuacion = 0;
        aciertos = 0;
        errores = 0;
        vidas = 3;
        numeroCuadros = 3;
        Cuadrado cuadros[] = {cuadro1,cuadro2, cuadro3,cuadro4,cuadro5,cuadro6,cuadro7,cuadro8};
        cuadrosIguales = false;
        huboError = false;
    }

    public void setPuntuacion() {
        puntuacion++;
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

    public boolean isCuadrosIguales() {
        return cuadrosIguales;
    }

    public void setAciertos() {
        aciertos++;
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
    
    
    
    
    
    public void sonIguales(){
         
        
    }
}
