/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programa3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author DAW
 */
public class Bombones {

    public static void main(String[] args) throws IOException {
        Scanner leer = new Scanner(System.in);
        int bombones = 0;
        int alumnos = 0;
       
        //comprueba que se escriban numeros enteros
        try {
            
            System.out.println("Escribir cantidad de alumnos:");
            alumnos = leer.nextInt();
            System.out.println("Escribir cantidad de bombones:");
            bombones = leer.nextInt();
            
        } catch (Exception e) {
            System.err.println("Escribir un numero Entero");
        }

        int valorNumero;

        File file = new File("participants.csv");
         BufferedReader lector = new BufferedReader(new FileReader("participants.csv"));
        String linea = null;
        ArrayList<String> listaPartes = new ArrayList<>();
      int contador=0;
      
      //lee los nombres y los guarda en el array 
        try {
            
            while ((linea=lector.readLine()) !=null) {
                String[] parts = linea.split(","); // separamos el comando del argumento
                String part1 = parts[0];
              
              listaPartes.add(part1);
            }

        } catch (Exception e) {
            System.out.println("Ha ocurrido un Error");
            e.printStackTrace();
        }
        
        
        
        
        HashMap<String, String> mapalisto = new HashMap<String, String>();

        for (int i = 0; i <= alumnos; i++) {
            valorNumero = (int) (Math.random() * bombones);
            mapalisto.put(listaPartes.get(valorNumero), String.valueOf(valorNumero));
        }
        
        System.out.println(mapalisto);
        leer.nextLine();
        System.out.println("Escribir un alumnos:");
        String nombrealumnos = leer.next();
        boolean impimirmensaje= true;
        //comprobamos que exista el alumno 
         for (Map.Entry<String, String> entry : mapalisto.entrySet()) {
                if (Objects.equals(entry.getKey(), nombrealumnos)) {
                    System.out.print(entry.getValue()+ "\n");
                    impimirmensaje=false;
                    break;
                }
            }
        if(impimirmensaje){
            System.out.println("NoHayBombonesParaTi");
        }
            


    }
}



