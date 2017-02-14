/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabbleedd;

class Usuario{
    String nombre;
    Usuario siguiente;
    
    public Usuario(String nombre){
        this.nombre=nombre;
        this.siguiente=null;
    }
    
}
public class Jugadores {
    
    Usuario inicio;
    Usuario fin;
    
    void agregar(String nombre){
        
	if (inicio==null){
            inicio = fin = new Usuario(nombre);
            inicio.siguiente= fin;
            fin.siguiente = inicio;
        }else{
            Usuario tmp = inicio;
            inicio = new Usuario(nombre);
            inicio.siguiente = tmp;
            fin.siguiente=inicio;
            
	}
    }
    
}
