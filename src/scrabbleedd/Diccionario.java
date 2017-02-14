/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabbleedd;

class Palabra {
    
    String palabra;
    Palabra siguiente;
    
    public Palabra(String palabra){
        this.palabra=palabra;
        this.siguiente=null;
    }
    
}

public class Diccionario {
    Palabra inicio = null;
    
    void agregar(String palabra){
        
	if (inicio==null)
            inicio = new Palabra(palabra);
	else{
            Palabra tmp = inicio;
            inicio = new Palabra(palabra);
            inicio.siguiente = tmp;
	}
    }
    
    boolean buscar(String palabra){
        Palabra tmp = inicio;
        boolean esta = false;
        while(tmp!=null){
            if(tmp.palabra == palabra){
                esta=true;
                System.out.println("Palabra econtrada");
                break;
            }else{
                tmp=tmp.siguiente;
            }
        }
        if(!esta)
            System.out.println("No se encontró");
        return esta;
    }
    
}
