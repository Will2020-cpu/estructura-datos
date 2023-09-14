/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuradedatos_1;

/**
 *
 * @author Oscar Perez
 */
public class Nodo {
    //Decclaracion de atributos
    private Object dato;
    private Nodo dirSig;
    //Constructor
    Nodo(){
        dato = 0;
        dirSig = null;
    }
    //Get
    public Object getDato() {
        return dato;
    }
    public Nodo getDirSig() {
        return dirSig;
    }
    //Set
    public void setDato(Object dato) {
        this.dato = dato;
    }
    public void setDirSig(Nodo dirSig) {
        this.dirSig = dirSig;
    }
}
