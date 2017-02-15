/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabbleedd;


public class Triples {
    
    Casilla inicio;
    
    void agregar(int x, int y){
        
	if (inicio==null)
            inicio = new Casilla(x,y);
	else{
            Casilla tmp = inicio;
            inicio = new Casilla(x,y);
            inicio.sig = tmp;
	}
    }
    
}
