/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabbleedd;

class Nodo{
    int x;
    int y;
    int valor;
    int total;
    boolean lleno;
    Nodo up;
    Nodo dw;
    Nodo r;
    Nodo l;
    
    public Nodo(int x, int y){
        this.x=x;
        this.y=y;
        this.valor=1;
        this.total=1;
        this.lleno=false;
        this.up=this.dw=this.r=this.l=null;
    }
    
}
//---------------------------------
class Cabecera{
    
    int x;
    Cabecera sig;
    Cabecera ant;
    Nodo abajo;
    
    public Cabecera(int x){
        this.x=x;
        sig=null;
        ant=null;
        abajo=null;
    }
}
//-----------------------------------
class Fila{
    
    int y;
    Fila sig;
    Fila ant;
    Nodo der;
    
    public Fila(int y){
        this.y=y;
        sig=null;
        ant=null;
        der=null;
    }
}
//-----------------------------------
public class MatrizOrtogonal {
    Fila yini;
    Cabecera xini;
    
    public MatrizOrtogonal(int dim){
        for( int i=0;i<dim;i++){
            agregarFila(i);
            agregarCabecera(i);
        }
    }
    
    void agregarFila(int y){
        
        if(yini==null){
            yini=new Fila(y);
        }else{
            Fila tmp=yini;
            while(tmp.sig!=null){
                tmp=tmp.sig;
            }
            tmp.sig=new Fila(y);
            tmp.sig.ant=tmp;
        }
    }
    
    void agregarCabecera(int x){
        
        if(xini==null){
            xini=new Cabecera(x);
        }else{
            Cabecera tmp=xini;
            while(tmp.sig!=null){
                tmp=tmp.sig;
            }
            tmp.sig=new Cabecera(x);
            tmp.sig.ant=tmp;
        }
    }
    
    void insertarEnY(int y, Nodo nuevo){
        
        Fila tmp = yini;
        while(tmp!=null){
            if(y==tmp.y){
                if(tmp.der==null){
                    tmp.der=nuevo;
                }else{
                    Nodo aux = tmp.der;
                    while(aux.r!=null){
                        aux=aux.r;
                    }
                    aux.r=nuevo;
                    aux.r.l=aux;
                }
            }
            tmp=tmp.sig;
        }
        
    }
    
}
