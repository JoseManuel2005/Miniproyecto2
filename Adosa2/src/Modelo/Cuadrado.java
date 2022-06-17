/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Random;

/**
 *
 * @author Usuario
 */
public class Cuadrado {
    private int imagen;
    private boolean aparece;
    

    public Cuadrado( boolean aparece) {
        Random r = new Random();
        imagen = (int)(r.nextDouble()*7);
       
        this.aparece = aparece;
    }

    public void setImagen() {
        //Random r = new Random();
        //imagen = (int)(r.nextDouble()*7);
    }

    public void setAparece(boolean aparece) {
        this.aparece = aparece;
    }

    public int getImagen() {
        return imagen;
    }

    public boolean isAparece() {
        return aparece;
    }
    
    
}
