/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.unidad2pp;

import java.util.ArrayList;

/**
 *
 * @author gusta
 */
public class Ordenamientos {
    
    public void Burbuja (ArrayList<Integer> numerodecajas){
        int aux;
        for (int i=0; i<numerodecajas.size();i++){
            for (int j=i;j<numerodecajas.size()-1;j++){
            if (numerodecajas.get(j)>numerodecajas.get(j+1)){
                aux=numerodecajas.get(j);
                numerodecajas.set(j, numerodecajas.get(j+1));
                numerodecajas.set(j+1, aux);
            
            }
            
            }
        
        
        
        }
    
         for (int i=0; i<numerodecajas.size();i++){
             System.out.print(numerodecajas.get(i)+" -> ");
         
         
         }
    
    
    
    }
    
    
    
    
    
}
