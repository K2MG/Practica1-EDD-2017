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
    
    boolean buscar(String nomb){
        Usuario tmp = inicio;
        boolean esta = false;
        
        if(tmp==null){
            System.out.println("Lista vacia, no existe el registro...");
        }else if(tmp==fin){
            if(tmp.nombre.equals(nomb)){
                System.out.println("Existe el elemento...");
                esta=true;
            }
        }else{
            while (tmp!=fin){
		if(tmp.nombre.equals(nomb)){
                System.out.println("Existe el elemento...");
                esta=true;
                break;
                }	
		tmp=tmp.siguiente;
            }
            
            if(tmp.nombre.equals(nomb) && esta==false){
                System.out.println("Existe el elemento...");
                esta=true;
            }
            
        }
        
        if(esta==false){
            System.out.println("NO Existe el elemento...");
        }
        System.out.println("Se va a retornar "+esta);
        return esta;
    }
    
    boolean eliminar(String nombre){
        Usuario tmp = inicio, anterior = fin;
	while (tmp!=fin){
            if (tmp.nombre.equals(nombre)){
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
        else if(tmp==fin){
            System.out.print("[");
            System.out.print(tmp.nombre+" ");	
            System.out.println("]");
	}else{
            System.out.print("[");
            while (tmp!=fin){
		System.out.print(tmp.nombre+" ");	
		tmp=tmp.siguiente;
            }	
            System.out.print(tmp.nombre+" ");
            System.out.println("]");
        }
    }
    
    
}
