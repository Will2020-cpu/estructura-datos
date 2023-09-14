/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuradedatos_1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Oscar Perez
 */
public class EstructuraDeDatos {

    /**
     * @param args the command line arguments
     */
    static Scanner entrada = new Scanner(System.in);
    static int dato;
    public static void main(String[] args) {
        // TODO code application logic here
        ListaEnlazada l = new ListaEnlazada();
        int op = -1;
        while (op != 8){
            System.out.print("Menu Principal de la Lista\n 1. Adicionar\n 2. Buscar\n 3. Eliminar\n 4. Modificar\n 5. Mostrar\n 6. Adicionar antes del penultimo \n 7. Eliminar elementos repetidos \n 8. Salir\n Digite la opcion: ");
            op = entrada.nextInt();
            switch (op){
                case 1:
                   adicionarDatosLista(l);
                   break;
                case 2:
                   buscarDatoLista(l);
                   break;
                case 3:
                   eliminarDatoLista(l);
                   break;
                case 4:
                   modificarDatoLista(l);
                   break;
                case 5:
                   mostrarDatosLista(l);
                   break;
                case 6:
                insertarAntesDelPenultimo(l);
                break;
                case 7:
                    eliminarElementosRepetidos(l);
                    break;
            }
        }
    }
    //Limpiar pantalla
    public static void cls(){
      try  
        {  
            Robot pressbot = new Robot();
            pressbot.keyPress(KeyEvent.VK_CONTROL);
            pressbot.keyPress(KeyEvent.VK_L);
            pressbot.keyRelease(KeyEvent.VK_CONTROL);
            pressbot.keyRelease(KeyEvent.VK_L);
        }  
        catch (AWTException e)  
        {  
           System.err.println("Error al limpiar pantalla"+e.getMessage());  
        }
    }
    //Adicionar datos en la Lista
    public static void adicionarDatosLista(ListaEnlazada l){
        //Enrada de datos
        while(true){
            System.out.print("Digite un dato entero 0-termina: ");
            dato = entrada.nextInt();
            if(dato == 0){
               break; 
            }
            else{
               Nodo n = new Nodo();
               n.setDato(dato);
               l.adicionarFinal(n);
            }
         }
    }
    //Buscar dato en la Lista
    public static void buscarDatoLista(ListaEnlazada l){
       //Buscar un dato
        System.out.print("Digite un dato entero a buscar: ");
        dato = entrada.nextInt();
        if(l.buscar(dato)!=null){
            System.out.println("Dato entero encontrado en la lista");
        }
        else{
            System.out.println("No se encontro dato entero en la lista");
        } 
    }
    //Eliminar dato en la Lista
    public static void eliminarDatoLista(ListaEnlazada l){
        System.out.print("Digite el dato a eliminar en la Lista:");
        dato = entrada.nextInt();
        if(l.eliminar(dato)){
            System.out.println("El dato fue eliminado de la lista");
        }
        else{
            System.out.print("No se elimino el dato en la lista");
        }
    }
    //Modificar dato en la Lista
    public static void modificarDatoLista(ListaEnlazada l){
        Nodo ne;
        System.out.println("Digite el dato a buscar en la Lista:");
        dato = entrada.nextInt();
        ne = l.buscar(dato);
        if(ne != null){
            System.out.print("Digite el dato que reemplazara al anterior:");
            dato = entrada.nextInt();
            ne.setDato(dato);
            System.out.print("Modificacion exitosa");
        }
        else{
            System.out.println("Dato no encontrado, no se puede modificar");
        }
    }
    //Mostra datos de la Lista
    public static void mostrarDatosLista(ListaEnlazada l){
        //Mostrar datos de la Lista
        System.out.println("Los datos de la Lista son:");
        l.mostrar();
    }

    public static void insertarAntesDelPenultimo(ListaEnlazada l){

        System.out.print("Digite un dato entero para insertar antes del penultimo ");
        dato = entrada.nextInt();
        Nodo n = new Nodo();
        n.setDato(dato);
        if (l.adicionarAntesDelPenultimo(n)){
            System.out.println("Dato agregado");
        }else {
            System.out.println("Dato no fue agregado");
        }
    }

    public static void eliminarElementosRepetidos(ListaEnlazada l){

        System.out.println("Digite el dato a eliminar en la Lista:");
        dato = entrada.nextInt();
        l.eliminarElementosRepetidos(dato);
    }
}
