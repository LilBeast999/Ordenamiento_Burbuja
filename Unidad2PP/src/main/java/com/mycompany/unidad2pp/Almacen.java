/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.unidad2pp;

import java.util.ArrayList;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.util.Duration;

/**
 *
 * @author gusta
 */
public class Almacen extends Lapiz {
    ArrayList <Caja> cajas= new ArrayList();

    public Almacen(int posicionx, int posiciony) {
        super(posicionx, posiciony);
    }

    public int getPosicionx() {
        return posicionx;
    }

    public void setPosicionx(int posicionx) {
        this.posicionx = posicionx;
    }

    public int getPosiciony() {
        return posiciony;
    }

    public void setPosiciony(int posiciony) {
        this.posiciony = posiciony;
    }

    public AnchorPane getAnchor() {
        
        return anchor;
    }

   public AnchorPane dibujarcaja (int posx,int posy, AnchorPane anchor, int indiceCaja,double escala){
      AnchorPane caja= new AnchorPane();
      caja.setLayoutX(posx);
      caja.setLayoutY(posy);
      ArrayList <Group> numeros = new ArrayList();
      numeros=AlmacenarNumeros();
      
      numeros=AlmacenarNumeros();
      Rectangle rectangulo= new Rectangle(60,60);
      rectangulo.setFill(Color.web("#784A32"));
      rectangulo.setStroke(Color.BLACK);
      rectangulo.setStrokeWidth(2);
      Rectangle rectangulo1= new Rectangle(7.5,7.5,45,45);
      rectangulo1.setFill(Color.web("#A46644"));
      rectangulo1.setStroke(Color.BLACK);
      rectangulo1.setStrokeWidth(1);
      caja.getChildren().add(rectangulo);
      caja.getChildren().add(rectangulo1);
      
       
      
      caja.setScaleX(escala);
      caja.setScaleY(escala);
      
      DibujarNumeros(caja, cajas.get(indiceCaja).peso, numeros);
   
       
     
      anchor.getChildren().add(caja);
      return caja;
       
   }
    
   public AnchorPane dibujarvagon (int posx,int posy, AnchorPane anchor, int indiceCaja,double escala){
        AnchorPane caja= new AnchorPane();
        caja.setLayoutX(posx);
        caja.setLayoutY(posy);
        ArrayList <Group> numeros = new ArrayList();
        numeros = AlmacenarNumeros();
  
        numeros = AlmacenarNumeros();
        Rectangle rectangulo= new Rectangle(40,40);
        rectangulo.setFill(Color.web("808080"));
        rectangulo.setStroke(Color.GRAY);
        rectangulo.setStrokeWidth(2);
        Rectangle rectangulo1= new Rectangle(2.5,2.5,35,35);
        rectangulo1.setFill(Color.web("#6A6A6A"));
        rectangulo1.setStroke(Color.BLACK);
        rectangulo1.setStrokeWidth(1);
        caja.getChildren().add(rectangulo);
        caja.getChildren().add(rectangulo1);
      
        for (int i = 0; i < 3; i++) {
            Rectangle rectangulo4 = new Rectangle(10+(i*10),7.5,2,25); // sujeto a formula o a usar un scale por que funciona la wea
            rectangulo4.setFill(Color.web("#808080"));
            rectangulo4.setStroke(Color.web("808080"));
            caja.getChildren().add(rectangulo4);           
        }
      
        caja.setScaleX(escala);
        caja.setScaleY(escala);
      
        DibujarNumeros2(caja, cajas.get(indiceCaja).peso, numeros);
        
        

     
        anchor.getChildren().add(caja);
        
        if(cajas.get(indiceCaja).peso/10 == 1){
            TranslateTransition bajaCaja = new TranslateTransition(Duration.ZERO,caja);
            bajaCaja.setByY(500);
            bajaCaja.play();
        }
        else if(cajas.get(indiceCaja).peso == 1){
            TranslateTransition bajaCaja = new TranslateTransition(Duration.ZERO,caja);
            bajaCaja.setByY(500);
            bajaCaja.play();
        }
        
        return caja;
   }
    
   
    
    

}
