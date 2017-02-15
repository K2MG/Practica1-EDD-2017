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
    
    boolean buscar(String nombre){
        Usuario tmp = inicio;
        boolean esta = false;
        
        if(inicio!=null){
            do{
                if(tmp.nombre == nombre){
                    esta=true;
                    System.out.println("Usuario econtrado");
                    break;
                }else{
                    tmp=tmp.siguiente;
                }
            }
            while(tmp!=fin);
        }
        
        if(!esta)
            System.out.println("No se encontró");
        return esta;
    }
    
    boolean eliminar(String nombre){
        Usuario tmp = inicio, anterior = fin;
	while (tmp!=fin){
            if (tmp.nombre==nombre){
                if (anterior == fin){
		inicio = inicio.siguiente;
                fin.siguiente = inicio;
                }else{
                    anterior.siguiente = tmp.siguiente;
                }
            return true;
            }
            else{
		anterior = tmp;
		tmp = tmp.siguiente;				
            }			                    
	}
	return false;		
    }
    
    void mostrar(){
        Usuario tmp = inicio;
	if (tmp==null)
            System.out.println("lista vacia...");
	else{
            System.out.print("[");
            while (tmp!=null){
		System.out.print(tmp.nombre+" ");	
		tmp=tmp.siguiente;
            }			
            System.out.println("]");
	}
    }
    
    
}
