/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabbleedd;

import java.io.FileWriter;
import java.io.PrintWriter;

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
            if(tmp.palabra.equals(palabra)){
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
    
    boolean eliminar(String palabra){
        Palabra tmp = inicio, anterior = null;
	while (tmp!=null){
            if (tmp.palabra.equals(palabra)){
                if (anterior == null)
		inicio = inicio.siguiente;
            else
		anterior.siguiente = tmp.siguiente;
            return true;
            }
            else{
		anterior = tmp;
		tmp = tmp.siguiente;				
                }			                    
	}
	return false;		
    }
    
    void escribirArchivo(){
        Palabra tmp = inicio;
        
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            
            fichero = new FileWriter("C:\\Users\\KMMG\\Desktop\\diccionario.dot");
            pw = new PrintWriter(fichero);
            pw.println("digraph G {");
            if (tmp.siguiente==null && tmp==inicio){
                pw.println(tmp.palabra);
            }else{
                while(tmp!=null){
                if(tmp.siguiente!=null){
                    pw.println(tmp.palabra+" -> "+tmp.siguiente.palabra);
                }
                tmp=tmp.siguiente;
            }
            }
            
            pw.println("}");
            pw.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
	
    }
    
}
