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
    Letra cabeza;
    
    public Usuario(String nombre){
        this.nombre=nombre;
        this.siguiente=null;
        this.cabeza=null;
    }
    
    void agregarLetra(Letra nueva){
        nueva.sig=null;
	if (cabeza==null){
            cabeza = nueva;
            cabeza.sig = null;
        }else{
            Letra tmp = cabeza;
            while(tmp.sig!=null){
                tmp=tmp.sig;
            }
            tmp.sig=nueva;
	}
    }
    
    Letra expulsar(int id){
        
        Letra aux = this.cabeza;
        Letra ant=null;
        Letra pos=null;
        Letra ssig=null;
        
        if(id==aux.id){
            pos=aux;
            cabeza=aux.sig;
        }else{
            aux=aux.sig;
            while(aux!=null){
                if(id==aux.sig.id){
                    ant=aux;
                    pos=aux.sig;
                    ssig=aux.sig.sig;
                    break;
                }
                aux=aux.sig;
            }
            ant.sig=ssig;
        }
        
        return pos;
    }
    
    void escribirArchivo(){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("C:\\Users\\KMMG\\Desktop\\userfichas.dot");
            pw = new PrintWriter(fichero);
            pw.println("digraph G {");
            pw.println(Integer.toString(this.hashCode())+"[label=\""+this.nombre+"\" ]");
            Letra ini = this.cabeza;
            if (ini!=null){
                pw.println(Integer.toString(this.hashCode())+" -> "+Integer.toString(ini.hashCode()));
                while(ini!=null){
                    pw.println(Integer.toString(ini.hashCode())+"[label=\""+ini.letra+"\", shape=box ]");
                    if(ini.sig!=null){
                        pw.println(Integer.toString(ini.hashCode())+" -> "+Integer.toString(ini.sig.hashCode()));
                    }
                    ini=ini.sig;
                }
            }
            pw.println("}");
            pw.close();

            

        } catch (Exception e) {
            e.printStackTrace();
        }
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
    
    Usuario buscarJugadorConcreto(String nomb){
        Usuario res = null;
        Usuario tmp = inicio;
        boolean esta = false;
        
        if(tmp==null){
            res=null;
        }else if(tmp==fin){
            if(tmp.nombre.equals(nomb)){
                res= tmp;
                esta=true;
            }
        }else{
            while (tmp!=fin){
		if(tmp.nombre.equals(nomb)){
                System.out.println("Existe el elemento...");
                esta=true;
                res=tmp;
                break;
                }	
		tmp=tmp.siguiente;
            }
            
            if(tmp.nombre.equals(nomb) && esta==false){
                System.out.println("Existe el elemento...");
                esta=true;
                res=tmp;
            }
            
        }
        
        if(esta==false){
            System.out.println("NO Existe el elemento...");
            res=null;
        }
        System.out.println("Se va a retornar "+esta);
        return res;
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
                    pw.println(Integer.toString(tmp.hashCode())+"[label=\""+tmp.nombre+"\" ]");
                    //pw.println(tmp.nombre);
                }else{
                    while(tmp!=fin){
                        pw.println(Integer.toString(tmp.hashCode())+"[label=\""+tmp.nombre+"\" ]");
                        pw.println(Integer.toString(tmp.hashCode())+" -> "+Integer.toString(tmp.siguiente.hashCode()));
                        System.out.println(tmp.nombre+" -> "+tmp.siguiente.nombre);
                        tmp=tmp.siguiente;
                    }
                    pw.println(Integer.toString(tmp.hashCode())+"[label=\""+tmp.nombre+"\" ]");
                    pw.println(Integer.toString(tmp.hashCode())+" -> "+Integer.toString(tmp.siguiente.hashCode()));
                }
            }
            pw.println("}");
            pw.close();

            

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
	
    }
    
    
}
