/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programa1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Raquel Tapia Ortiz
 */
public class Aemet {

    public static void main(String[] args) throws FileNotFoundException {

        double maximo,maximo2, minima=0, minima2;
        double mediaMaximos=0, mediaMinimos=0;

        //guardo los datos de las fechas maximas y minimas temperaturas
        ArrayList<String> listaMaximos = new ArrayList<>();
        ArrayList<String> listaMinimos = new ArrayList<>();
        ArrayList<String> listafechas = new ArrayList<>();

        
        //pedimos el archivo 
        Scanner leer = new Scanner(System.in);
        System.out.println("Escribir el archivo:");
        String archivo = leer.nextLine();

        File file = new File(archivo);
        
        
        //empezamos a recorrer el archivo y guardamos en sus respectivos arrays
        Scanner recorrer = new Scanner(file);
        String linea = null;
        while (recorrer.hasNext()) {
            linea = recorrer.nextLine();
            String[] parts = linea.split("\\s+"); // separamos el comando del argumento
                String part1 = parts[0];
                String part2 = parts[1];
                String part3 = parts[2];
            listafechas.add(part1);
            listaMaximos.add(part2);
            listaMinimos.add(part3);
        }
       
        
        //enviamos los arrays a las funciones para los calculos
        mediaMaximos=calcularMedia(listaMaximos);
        mediaMinimos=calcularMedia(listaMinimos);
        maximo=calcularMaxima(listaMaximos);
        maximo2=calcularMaxima(listaMinimos);
        minima=calcularMinimo(listaMaximos);
        minima2=calcularMinimo(listaMinimos);
        double mediaDEmedias=(mediaMaximos+mediaMinimos)/2;
        
       
        
        //Se imprime toda la informacion 
        System.out.println("Datos: \n Temperatura máxima más alta y más baja:" + maximo+" "+minima + "\n Temperatura máxima más alta y más baja:" + maximo2+" "+minima2
        + "\n Temperatura máxima media:" + mediaMaximos + "\n Temperatura minima media:" + mediaMinimos +"\nTemperatura intermedia de las dos medias anteriores '"+mediaDEmedias);
        recorrer.close();
    }
    
    /**
     * recibe un arraylist y da la media
     * @param lista
     * @return doble media
     */
     private static double calcularMedia(ArrayList<String> lista) {
          int contador=0;
          double media=0;
        for (String i : lista) {           
            media+= Double.parseDouble(i);
            contador++;
        }
        media=media/contador;
        return media;
     }
     
     /**
      * recibe un arraylist y da la maxima
      * @param lista
      * @return 
      */
    private static double calcularMaxima(ArrayList<String> lista) {
        double maximo=0;
         double comprobar=0 ;
        
        for  (String i : lista) {
       comprobar= Double.parseDouble(i);
        if(comprobar>maximo){
            maximo=comprobar;
        }
       }
        return maximo;
    }
    
    /**
     * recibe un arraylist y da la tempreatura minima
     * @param lista
     * @return 
     */
    private static double calcularMinimo(ArrayList<String> lista) {
        double minimo=100;
         double comprobar=0 ;
        
        for  (String i : lista) {
       comprobar= Double.parseDouble(i);
        if(comprobar<minimo){
            minimo=comprobar;
        }
       }
        return minimo;
    }
}


