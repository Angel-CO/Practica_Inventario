/**
 * Clase Teclado
 * 
 * Contiene todos los metodos para leer datos desde el teclado
 * 
 * @author Ángel José Calderón Ortega
 * @version 1.0
 */

package vistas;

import java.util.Scanner;

public class Teclado {


    /**
    * Permite leer un número entero desde el teclado
    *
    * @return Retorna el número entero aque leyó desde el teclado
    */
    public int leerEntero() {
        int entero = 0;
        Scanner sc = new Scanner(System.in);
        try {
            entero = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Error al leer el dato");
        }
        return entero;
    }
    

    /**
    * Permite leer un número flotante desde el teclado
    *
    * @return Retorna el número flotante que leyó
    */
    public float leerFlotante() {
        float flotante = 0;
        Scanner sc = new Scanner(System.in);
        try {
            flotante = sc.nextFloat();
        } catch (Exception e) {
            System.out.println("Error al leer el flotante");
        }
        return flotante;
    }

    /**
    * Permite leer una cadena desde el teclado
    *
    *@return Retorna la cadena que leyó desde el teclado 
    */
    public String leerCadena() {
        String cadena = "";
        Scanner sc = new Scanner(System.in);
        try {
            cadena = sc.nextLine();
        } catch (Exception e) {
            System.out.println("Error al leer la cadena");
        }
        return cadena;
    }
}