/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabbleedd;

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
    
}
