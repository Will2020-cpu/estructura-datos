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
public class ListaEnlazada {
    //Declarar los atributos
    private Nodo inicio,fin;
    //Constructor
    ListaEnlazada(){
        inicio = fin = null;
    }
    //Get
    public Nodo getInicio() {
        return inicio;
    }
    public Nodo getFin() {
        return fin;
    }
    //Set
    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }
    public void setFin(Nodo fin) {
        this.fin = fin;
    }
    //Lista vacia
    public boolean estaVacia(){
        return inicio == null;
    }
    //Adicionar
    public void adicionarFinal(Nodo n){
        if(estaVacia()){
            inicio = fin = n;
        }
        else{
            fin.setDirSig(n);
            fin = n;
        }
    }
    public void adicionarInicio(Nodo n){
        if(estaVacia()){
            inicio = fin = n;
        }
        else{
            n.setDirSig(inicio);
            inicio = n;
        }
    }
    //Buscar
    public Nodo buscar(int dato){
        Nodo aux = inicio;
        if(estaVacia()){
            return null;
        }
        else{
            while(aux != null){
                if(dato == (int)aux.getDato()){
                    return aux;
                }
                else{
                    aux = aux.getDirSig();
                }
            }
            return null;
        }
    }
    //Eliminar
    public boolean eliminar(int dato){
        Nodo ant = null;
        Nodo aux = inicio;
        while(aux != null){
           if(dato == (int)aux.getDato()){
               //Dato al inicio de la ista
               if(aux == inicio){
                  inicio = aux.getDirSig();
                  aux.setDirSig(null);
                  return true;
               }
               else{
                   //Dato despues del inicio
                   ant.setDirSig(aux.getDirSig());
                   aux.setDirSig(null);
                   //Dato al final de la lista
                   if(aux == fin){
                       fin = ant;
                   }
                   return true;
               }
           }
            ant = aux;
            aux = aux.getDirSig();
        }
        return false;
    }
    //Mostrar datos de la Lista
    public void mostrar(){
        if(estaVacia()){
            System.out.println("Lista vacia");
        }
        else{
            Nodo aux = inicio;
            while(aux != null){
                System.out.println(aux.getDato());
                aux = aux.getDirSig();
            }
        }
    }
    //Modoficar
    public boolean modificar(int db,int d){
        if(estaVacia()){
            return false;
        }
        else{
            Nodo ne = buscar(db);
            if( ne == null){
                return false;
            }
            else{
                ne.setDato(d);
                return false;
            }
        }
    }

    // Adicionar antes del penultimo si no existe
    public boolean adicionarAntesDelPenultimo(Nodo nodo){
        Nodo aux = inicio;

        int dato = (int) nodo.getDato();
        if (buscar(dato) != null){
            return false;
        }else {
            if (inicio == null || inicio.getDirSig() == null || inicio.getDirSig().getDirSig() == null){
                adicionarInicio(nodo);
            }else {
                while (aux.getDirSig().getDirSig().getDirSig() != null){
                    aux = aux.getDirSig();
                }
                nodo.setDirSig(aux.getDirSig());
                aux.setDirSig(nodo);
            }
            return true;
        }
    }

    public void eliminarElementosRepetidos(int dato){
        if (estaVacia()){
            System.out.println("No tiene elementos");
            return;
        }
        Nodo aux = inicio;
        int count = 0;
        while (aux != null){
            if (dato == (int) aux.getDato() && count++ > 0){
                if (eliminarPorNodo(aux)){
                    System.out.println("Datos repetido elimado exitasosamente");
                }
            }
            aux = aux.getDirSig();
        }

        // Verificamos si aun tiene elementos repetidos aplicamos recursividad
        aux = inicio;
        count = 0;
        while (aux != null){
            if (dato == (int) aux.getDato() && count++ > 0){
                eliminarElementosRepetidos(dato);
            }
            aux = aux.getDirSig();
        }

    }

    // Metodo creado
    private boolean eliminarPorNodo(Nodo nodo){
        Nodo ant = null;
        Nodo aux = inicio;
        while(aux != null){
            if(nodo == aux){
                //Dato al inicio de la ista
                if(aux == inicio){
                    inicio = aux.getDirSig();
                    aux.setDirSig(null);
                    return true;
                }
                else{
                    //Dato despues del inicio
                    ant.setDirSig(aux.getDirSig());
                    aux.setDirSig(null);
                    //Dato al final de la lista
                    if(aux == fin){
                        fin = ant;
                    }
                    return true;
                }
            }
            ant = aux;
            aux = aux.getDirSig();
        }
        return false;
    }
}
