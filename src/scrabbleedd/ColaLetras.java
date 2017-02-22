/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabbleedd;

import java.io.FileWriter;
import java.io.PrintWriter;

class Letra{
    
    int id;
    String letra;
    int valor;
    Letra sig;
    
    public Letra(int id, String letra, int valor){
        this.letra=letra;
        this.valor = valor;
        this.id=id;
        sig=null;
    }
    
}


public class ColaLetras {
    
    Letra inicio;
    int tam;
    
    public ColaLetras(){
        inicio=null;
        this.tam=0;
    }
    
    void agregar(int id, String letra, int valor){
        
	if (inicio==null)
            inicio = new Letra(id,letra,valor);
	else{
            
            Letra tmp = inicio;
            while(tmp.sig!=null){
                tmp=tmp.sig;
            }
            tmp.sig = new Letra(id,letra,valor);
	}
        this.tam++;
    }
    
    boolean buscarExistencia(int id){
        boolean res=false;
        Letra tmp=inicio;
        while(tmp!=null){
            if(tmp.id==id){
                res=true;
                break;
            }
            tmp=tmp.sig;
        }
        
        return res;
    }
    
    Letra expulsar(){
        Letra salida=null;
        
        if(inicio!=null){
            salida=inicio;
            inicio=inicio.sig;
        }
        
        return salida;
    }
    
    void escribirArchivo(){
        Letra tmp = inicio;
        
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            
            fichero = new FileWriter("C:\\Users\\KMMG\\Desktop\\colaletras.dot");
            pw = new PrintWriter(fichero);
            pw.println("digraph G {");
            if(tmp!=null){
                if (tmp.sig==null && tmp==inicio){
                pw.println(Integer.toString(tmp.hashCode())+"[label=\""+tmp.letra+"\" ]");
                }else{
                    while(tmp!=null){
                        if(tmp.sig!=null){
                            pw.println(Integer.toString(tmp.hashCode())+"[label=\""+tmp.letra+"\" ]");
                            pw.println(Integer.toString(tmp.hashCode())+" -> "+Integer.toString(tmp.sig.hashCode()));
                        }else{
                            pw.println(Integer.toString(tmp.hashCode())+"[label=\""+tmp.letra+"\" ]");
                        }
                        tmp=tmp.sig;
                    }
                }
            }
            
            pw.println("}");
            pw.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
	
    }
    
    
}
