package Modelo;
import java.util.Random;

/**
 * Laboratorio N.2: segundo miniproyecto. Archivo: Cuadrado.java, Autores (Grupo 01 POE): 
 * Brayan Andrés Sánchez Lozano <brayan.andres.sanchez@correounivalle.edu.co>
 * Jose Manuel Palma Oquendo <jose.palma@correounivalle.edu.co>
 * Fecha creación: 10-06-2022, Fecha última modificación: 18-06-2022 
 * Docente: Luis Romo <luis.romo@correounivalle.edu.co>
 */

public class Cuadrado {
    private int imagen;
    private boolean aparece;
    
    public Cuadrado(boolean aparece) {
        this.aparece = aparece;
    }

    public void setImagen() {
        Random r = new Random();
        imagen = (int)(r.nextDouble()*16);
    }

    /* Se llama a la funcion con el numero de imagen que desea que NO se repita. Crea un arreglo sin ese valor,
*   y selecciona un número aleatorio de este con ayuda de un Random */
    public void setImagenEx(int nEx) {
        int numeros[] = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int numerosEx[] = remueveElemento(numeros, nEx);
        Random r = new Random();
        imagen = numerosEx[(int)(r.nextDouble()*16)];
    }

    // Coloca como imagen el entero que recibe como parametro
    public void setImagenF(int F){
        imagen = F;
    }

    /* Se llama a la función con un arreglo y un entero, este último siendo el valor que desea "remover" del 
    arreglo. Como tal no lo borra del arreglo, crea uno nuevo sin ese valor con ayuda de arraycopy. */
    private static int[] remueveElemento(int[] arrayObjetos, int i) {
    int[] nuevoArray = new int[arrayObjetos.length - 1];
     if (i > 0){
           System.arraycopy(arrayObjetos, 0, nuevoArray, 0, i);
     }
     if (nuevoArray.length > i){
      System.arraycopy(arrayObjetos, i + 1, nuevoArray, i, nuevoArray.length - i);
     }
     return nuevoArray;
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