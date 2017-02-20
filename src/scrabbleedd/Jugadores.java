/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabbleedd;

import java.io.FileWriter;
import java.io.PrintWriter;

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
            ///inicio.siguiente= fin;
            fin.siguiente = inicio;
        }else{
            //Usuario tmp = fin;
            fin.siguiente = new Usuario(nombre);
            fin.siguiente.siguiente=inicio;
            fin=fin.siguiente;
            
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
    
    void escribirArchivo(){
        Usuario tmp = inicio;
        
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            System.out.println("VA A EScribir Archivo");
            fichero = new FileWriter("C:\\Users\\KMMG\\Desktop\\usuarios.dot");
            pw = new PrintWriter(fichero);
            pw.println("digraph G {");
            if (tmp!=null){
                if (tmp==fin){
                    pw.println(tmp.nombre);
                }else{
                    while(tmp!=fin){
                        pw.println(tmp.nombre+" -> "+tmp.siguiente.nombre);
                        System.out.println(tmp.nombre+" -> "+tmp.siguiente.nombre);
                        tmp=tmp.siguiente;
                    }
                    pw.println(tmp.nombre+" -> "+tmp.siguiente.nombre);
                }
            }
            pw.println("}");
            pw.close();

            for (int i = 0; i < 10; i++)
                pw.println("Linea " + i);

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
	
    }
    
    
}
