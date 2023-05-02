package com.mycompany.unidad2pp;

import static com.mycompany.unidad2pp.App.TIEMPO_ESPERA;
import java.util.Scanner;
import java.util.ArrayList;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author gusta
 */
public class Ordenamientos {
    
   
    
    public void miCodigo(Stage stage, Button boton, Button boton2, Button boton3,Button boton4,int aux,int opcion){
        
        AnchorPane anchor = new AnchorPane(); 
        Ordenamientos ordenamientos = new Ordenamientos(); 
        
        Scene scena = new Scene (anchor); 
        scena.setFill(Color.web("#AABDD8")); 
        stage.setMaximized(true); 
        
        // apartir de aca OJO
        ArrayList <Integer> arreglo = new ArrayList();
        Almacen almacen = new Almacen(0,0);
        
        int numerodecajas=aux;
        
        
        Lapiz lapiz= new Lapiz(anchor);
        lapiz.dibujarfondo();
        lapiz.dibujargrua();
        
        ArrayList<Double> escalas = new ArrayList();      
        for (int i = 1; i <= 49 ; i++) {
            escalas.add(0, (double)((i * 100) / 48)/100);
        }
  
        ArrayList<AnchorPane> cajasAnchor = new ArrayList();
                
        //Crea las cajas AnchorPane y las añade al arreglo de cajas de tipo Anchor y al arreglo de cajas de Almacén
        for(int i=0;i<numerodecajas;i++){       
            Caja caja1 = new Caja((int)Math.floor(Math.random()*(99-1+1)+1));
            almacen.cajas.add(caja1);
            cajasAnchor.add(almacen.dibujarcaja(150+((1500/numerodecajas)*i),850, anchor,i,escalas.get(numerodecajas-16)));
        }

        
        
        //Obtiene los números generados previamente para que los valores calcen con los del arreglo que se muestra en consola
        for (int i=0; i<numerodecajas; i++){ 
            arreglo.add( almacen.cajas.get(i).peso);
            System.out.print(arreglo.get(i)+ " ");
        }
        
        
        
        
        switch (opcion) {
            case 1:
                Insercion(numerodecajas,arreglo,cajasAnchor,anchor);
                break;
                
            case 2:
                Burbuja(arreglo, opcion, cajasAnchor, anchor);
                break;
            default:
                throw new AssertionError();
        }
       

        anchor=Pseudocodigo(anchor, almacen.cajas);
        anchor.getChildren().add(boton);
        boton.setLayoutX(830);
        boton2.setLayoutX(900);
        boton3.setLayoutX(1010);
        boton4.setLayoutX(1120);
        boton.setLayoutY(20);
        boton2.setLayoutY(20);
        boton3.setLayoutY(20);
        boton4.setLayoutY(20);
        anchor.getChildren().add(boton3);
        anchor.getChildren().add(boton2);
        anchor.getChildren().add(boton4);
        
        boton.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        boton2.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        boton3.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        boton4.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        stage.setScene(scena);
        stage.show();
    
    
    
    
    
    
    }
    
    public void Insercion (int numerodecajas, ArrayList<Integer> arreglo, ArrayList<AnchorPane>cajasAnchor,AnchorPane anchor){
            imprimeArreglo(arreglo);
            int velocidad = TIEMPO_ESPERA ;
            boolean bajoGancho2;
            SequentialTransition movCajas = new SequentialTransition();
            SequentialTransition movGancho1 = new SequentialTransition();
            SequentialTransition movCuerda1 = new SequentialTransition();
            SequentialTransition movGancho2 = new SequentialTransition();
            SequentialTransition movCuerda2 = new SequentialTransition();
            int aux=0,j=0;
            Almacen almacen =new Almacen(0,0);
            Lapiz lapiz= new Lapiz(0,0);
            AnchorPane cajaAux = new AnchorPane();
            AnchorPane gancho1 = new AnchorPane();
            gancho1 = almacen.dibujargancho(anchor,210,462);     
            AnchorPane cuerda1 = new AnchorPane();
            cuerda1 = lapiz.dibujarcuerda(210,442);
            AnchorPane gancho2 = new AnchorPane ();
            gancho2 = almacen.dibujargancho(anchor, 350, 442);
            AnchorPane cuerda2 = new AnchorPane();
            cuerda2 = lapiz.dibujarcuerda(350,422);
            anchor.getChildren().add(cuerda2);
            anchor.getChildren().add(cuerda1);
            
            
            
            for(int i=1;i<arreglo.size();i++){
                
                bajoGancho2 = false;
                aux = arreglo.get(i);       //Se saca el elemento que se va a comparar
                cajaAux = cajasAnchor.get(i);
                
                
                TranslateTransition trasVacioCaja = new TranslateTransition(Duration.millis(velocidad));
                movCajas.getChildren().add(trasVacioCaja);
                TranslateTransition trasVacioGancho2_1 = new TranslateTransition(Duration.millis(velocidad));
                movGancho2.getChildren().add(trasVacioGancho2_1);
                TranslateTransition trasVacioCuerda2_1 = new TranslateTransition(Duration.millis(velocidad));
                movCuerda2.getChildren().add(trasVacioCuerda2_1);
                TranslateTransition trasCuerda1_1 = new TranslateTransition(Duration.millis(velocidad),cuerda1);
                trasCuerda1_1.setToX(cajaAux.getLayoutX()-200);
                movCuerda1.getChildren().add(trasCuerda1_1);               
                TranslateTransition trasGancho1_1 = new TranslateTransition(Duration.millis(velocidad),gancho1);
                trasGancho1_1.setToX(cajaAux.getLayoutX()-200);
                movGancho1.getChildren().add(trasGancho1_1);
                                                                                                                            //LINEA 2
                TranslateTransition trasVacioGancho2_2 = new TranslateTransition(Duration.millis(velocidad));
                movGancho2.getChildren().add(trasVacioGancho2_2);
                TranslateTransition trasVacioCuerda2_2 = new TranslateTransition(Duration.millis(velocidad));
                movCuerda2.getChildren().add(trasVacioCuerda2_2);
                TranslateTransition trasVacioCaja1 = new TranslateTransition(Duration.millis(velocidad));                        
                movCajas.getChildren().add(trasVacioCaja1);
                TranslateTransition trasVacioCuerda1_1 = new TranslateTransition(Duration.millis(velocidad));
                movCuerda1.getChildren().add(trasVacioCuerda1_1);
                TranslateTransition bajaGancho1_1 = new TranslateTransition(Duration.millis(velocidad),gancho1);
                bajaGancho1_1.setByY(165);
                movGancho1.getChildren().add(bajaGancho1_1);
                                           
                TranslateTransition trasVacioGancho2_3 = new TranslateTransition(Duration.millis(velocidad));
                movGancho2.getChildren().add(trasVacioGancho2_3);
                TranslateTransition trasVacioCuerda2_3 = new TranslateTransition(Duration.millis(velocidad));
                movCuerda2.getChildren().add(trasVacioCuerda2_3);
                TranslateTransition subeGancho1 = new TranslateTransition(Duration.millis(velocidad),gancho1);
                subeGancho1.setByY(-165);
                movGancho1.getChildren().add(subeGancho1);              
                TranslateTransition trasVacioCuerda1_2 = new TranslateTransition(Duration.millis(velocidad));
                movCuerda1.getChildren().add(trasVacioCuerda1_2); 
                TranslateTransition trasCaja = new TranslateTransition(Duration.millis(velocidad),cajaAux);
                trasCaja.setByY(-165);
                movCajas.getChildren().add(trasCaja);         
                j=i-1;
                              
                if(j>=0 && aux<arreglo.get(j)){
                    
                    //Gancho2 va a la caja que debe mover
                    TranslateTransition trasVacioGancho1_2 = new TranslateTransition(Duration.millis(velocidad));
                    movGancho1.getChildren().add(trasVacioGancho1_2);
                    TranslateTransition trasVacioCuerda1_3 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda1.getChildren().add(trasVacioCuerda1_3);
                    TranslateTransition trasVacioCaja2 = new TranslateTransition(Duration.millis(velocidad));
                    movCajas.getChildren().add(trasVacioCaja2);
                    TranslateTransition trasCuerda2_1 = new TranslateTransition(Duration.millis(velocidad),cuerda2);
                    trasCuerda2_1.setToX((cajasAnchor.get(i).getLayoutX()-((((numerodecajas/7)-9)*((numerodecajas/7)-9))+364)));
                    movCuerda2.getChildren().add(trasCuerda2_1);
                    TranslateTransition trasGancho2_1 = new TranslateTransition(Duration.millis(velocidad),gancho2);
                    trasGancho2_1.setToX((cajasAnchor.get(i).getLayoutX()-((((numerodecajas/7)-9)*((numerodecajas/7)-9))+364)));
                    movGancho2.getChildren().add(trasGancho2_1);
                    
                    bajoGancho2 = true;
                    TranslateTransition trasVacioGancho1_3 = new TranslateTransition(Duration.millis(velocidad));
                    movGancho1.getChildren().add(trasVacioGancho1_3);
                    TranslateTransition trasVacioCuerda1_4 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda1.getChildren().add(trasVacioCuerda1_4);
                    TranslateTransition trasVacioCaja3 = new TranslateTransition(Duration.millis(velocidad));
                    movCajas.getChildren().add(trasVacioCaja3);
                    TranslateTransition trasVacioCuerda2_4 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda2.getChildren().add(trasVacioCuerda2_4);
                    TranslateTransition bajaGancho2_1 = new TranslateTransition(Duration.millis(velocidad),gancho2);
                    bajaGancho2_1.setByY(180);
                    movGancho2.getChildren().add(bajaGancho2_1);
                }
                
                while (j>=0 && aux<arreglo.get(j)){                                                                                     //LINEA 3
                                        
                    arreglo.set(j+1, arreglo.get(j));
                    cajasAnchor.set(j+1, cajasAnchor.get(j));
                    bajoGancho2 = true;
                    
                    //Gancho2 mueve la caja inferior que debe mover                                    
                    TranslateTransition trasVacioGancho1_5 = new TranslateTransition(Duration.millis(velocidad));
                    movGancho1.getChildren().add(trasVacioGancho1_5);
                    TranslateTransition trasVacioCuerda1_6 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda1.getChildren().add(trasVacioCuerda1_6);
                    TranslateTransition trasCuerda2_1 = new TranslateTransition(Duration.millis(velocidad),cuerda2);
                    trasCuerda2_1.setByX(1500/numerodecajas);
                    movCuerda2.getChildren().add(trasCuerda2_1);
                    TranslateTransition trasGancho2_2 = new TranslateTransition(Duration.millis(velocidad),gancho2);
                    trasGancho2_2.setByX(1500/numerodecajas);
                    movGancho2.getChildren().add(trasGancho2_2); 
                    TranslateTransition trasCaja1 = new TranslateTransition(Duration.millis(velocidad),cajasAnchor.get(j));
                    trasCaja1.setByX(1500/numerodecajas);
                    movCajas.getChildren().add(trasCaja1);

                    
                    TranslateTransition trasCaja2 = new TranslateTransition(Duration.millis(velocidad),cajaAux);
                    trasCaja2.setByX(-(1500/numerodecajas));                                                                        //LINEA 4
                    movCajas.getChildren().add(trasCaja2);
                    TranslateTransition trasGancho1_2 = new TranslateTransition(Duration.millis(velocidad),gancho1);
                    trasGancho1_2.setByX(-(1500/numerodecajas));
                    movGancho1.getChildren().add(trasGancho1_2);
                    TranslateTransition trasCuerda1_3 = new TranslateTransition(Duration.millis(velocidad),cuerda1);
                    trasCuerda1_3.setByX(-(1500/numerodecajas));
                    movCuerda1.getChildren().add(trasCuerda1_3);
                    
                    TranslateTransition trasCuerda2_2 = new TranslateTransition(Duration.millis(velocidad),cuerda2);
                    trasCuerda2_2.setByX(-((1500/numerodecajas)*2));
                    movCuerda2.getChildren().add(trasCuerda2_2);
                    TranslateTransition trasGancho2_3 = new TranslateTransition(Duration.millis(velocidad),gancho2);
                    trasGancho2_3.setByX(-((1500/numerodecajas)*2));
                    movGancho2.getChildren().add(trasGancho2_3);

                    j--;
                
                    //imprimeArreglo(arreglo);
                }
                
                if(bajoGancho2){
                    TranslateTransition trasVacioGancho1_5 = new TranslateTransition(Duration.millis(velocidad));
                    movGancho1.getChildren().add(trasVacioGancho1_5);
                    TranslateTransition trasVacioCuerda1_6 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda1.getChildren().add(trasVacioCuerda1_6);
                    TranslateTransition trasVacioCaja4 = new TranslateTransition(Duration.millis(velocidad));
                    movCajas.getChildren().add(trasVacioCaja4);
                    TranslateTransition trasVacioCuerda2_6 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda2.getChildren().add(trasVacioCuerda2_6);
                    TranslateTransition bajaGancho2_1 = new TranslateTransition(Duration.millis(velocidad),gancho2);
                    bajaGancho2_1.setByY(-180);
                    movGancho2.getChildren().add(bajaGancho2_1);
                
                }
                
                arreglo.set(j+1, aux);
                
                //Gancho1 inserta la caja donde corresponde
                TranslateTransition trasVacioCuerda2_6 = new TranslateTransition(Duration.millis(velocidad));
                movCuerda2.getChildren().add(trasVacioCuerda2_6);
                TranslateTransition trasVacioGancho2_4 = new TranslateTransition(Duration.millis(velocidad));
                movGancho2.getChildren().add(trasVacioGancho2_4);
                TranslateTransition trasVacioCuerda1_4 = new TranslateTransition(Duration.millis(velocidad));
                movCuerda1.getChildren().add(trasVacioCuerda1_4);
                TranslateTransition bajaGancho1 = new TranslateTransition(Duration.millis(velocidad),gancho1);
                bajaGancho1.setByY(165);
                movGancho1.getChildren().add(bajaGancho1);
                TranslateTransition trasCaja3 = new TranslateTransition(Duration.millis(velocidad),cajaAux);
                trasCaja3.setByY(165);
                movCajas.getChildren().add(trasCaja3);
                                                                                                                                    //LINEA 5
                //Gancho1 sube
                TranslateTransition trasVacioCuerda2_7 = new TranslateTransition(Duration.millis(velocidad));
                movCuerda2.getChildren().add(trasVacioCuerda2_7);
                TranslateTransition trasVacioGancho2_5 = new TranslateTransition(Duration.millis(velocidad));
                movGancho2.getChildren().add(trasVacioGancho2_5);
                TranslateTransition trasVacioCaja2 = new TranslateTransition(Duration.millis(velocidad));
                movCajas.getChildren().add(trasVacioCaja2);                
                TranslateTransition subeGancho1_2 = new TranslateTransition(Duration.millis(velocidad),gancho1);
                subeGancho1_2.setByY(-165);
                movGancho1.getChildren().add(subeGancho1_2);                
                TranslateTransition trasVacioCuerda1_5 = new TranslateTransition(Duration.millis(velocidad));
                movCuerda1.getChildren().add(trasVacioCuerda1_5);
                
                
                cajasAnchor.set(j+1, cajaAux);
            }
            System.out.print("--->  ");
            imprimeArreglo(arreglo);
            
            movCajas.play();
            movCuerda1.play();
            movGancho1.play();
            movCuerda2.play();
            movGancho2.play();
        }
    
    public void Burbuja (ArrayList<Integer> arreglo, int numerodecajas, ArrayList<AnchorPane> cajasAnchor,AnchorPane anchor){
        
        
        double cordX = 1625;
        Rectangle repisa = new Rectangle(cordX,745,100,25);
        repisa.setFill(Color.ORANGE);
        repisa.setStroke(Color.BLACK);
        anchor.getChildren().add(repisa);
        
        Almacen almacen = new Almacen(0,0);
        Lapiz lapiz = new Lapiz(0,0);
        AnchorPane gancho = new AnchorPane();
        gancho = almacen.dibujargancho(anchor,210,462);
        AnchorPane cuerda = new AnchorPane();
        cuerda = lapiz.dibujarcuerda(210,442);
        anchor.getChildren().add(cuerda);
        
        
        int velocidad = 1000;
        SequentialTransition movCajas = new SequentialTransition();
        SequentialTransition movGancho = new SequentialTransition();
        SequentialTransition movCuerda = new SequentialTransition();
        
        AnchorPane cajaAux = new AnchorPane();
        int aux;
        for (int i=0; i<arreglo.size();i++){
            
            for (int j=i;j<arreglo.size()-1;j++){
                
                if (arreglo.get(j)>arreglo.get(j+1)){
                    
                    //Gancho y cuerda van a la caja pivote(NADA MAS SE MUEVE)
                    TranslateTransition trasCuerda1 = new TranslateTransition(Duration.millis(velocidad),cuerda);
                    trasCuerda1.setToX(cajasAnchor.get(j).getLayoutX());
                    movCuerda.getChildren().add(trasCuerda1);
                    TranslateTransition trasGancho1 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho1.setToX(cajasAnchor.get(j).getLayoutX());
                    movGancho.getChildren().add(trasGancho1);
                    
                    TranslateTransition trasVacioCaja1 = new TranslateTransition(Duration.millis(velocidad));
                    movCajas.getChildren().add(trasVacioCaja1);
                    
                    
                    
                    //Baja gancho(NADA MAS SE MUEVE)
                    TranslateTransition trasGancho2 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho2.setByY(165);
                    movGancho.getChildren().add(trasGancho2);
                    
                    TranslateTransition trasVacioCuerda1 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda.getChildren().add(trasVacioCuerda1);
                    TranslateTransition trasVacioCaja2 = new TranslateTransition(Duration.millis(velocidad));
                    movCajas.getChildren().add(trasVacioCaja2);
                    
                    
                    //Sube gancho (CUERDA NO SE MUEVE)
                    TranslateTransition trasGancho3 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho3.setByY(-165);
                    movGancho.getChildren().add(trasGancho3);
                    TranslateTransition trasCaja1 = new TranslateTransition(Duration.millis(velocidad),cajasAnchor.get(j));
                    trasCaja1.setByY(-165);
                    movCajas.getChildren().add(trasCaja1);
                    
                    TranslateTransition trasVacioCuerda2 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda.getChildren().add(trasVacioCuerda2);
                    
                    
                    //Gancho y cuerda se mueven a la derecha lo mismo que la caja
                    TranslateTransition trasGancho4 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho4.setByX( ((1500 - ((1500/numerodecajas)*j))+60)- ((1500/numerodecajas)) );
                    movGancho.getChildren().add(trasGancho4);
                    TranslateTransition trasCuerda2 = new TranslateTransition(Duration.millis(velocidad),cuerda);
                    trasCuerda2.setByX( ((1500 - ((1500/numerodecajas)*j))+60)- ((1500/numerodecajas)) );
                    movCuerda.getChildren().add(trasCuerda2);
                    TranslateTransition trasCaja2 = new TranslateTransition(Duration.millis(velocidad),cajasAnchor.get(j));
                    trasCaja2.setByX( ((1500 - ((1500/numerodecajas)*j))+60)- ((1500/numerodecajas)) );
                    movCajas.getChildren().add(trasCaja2);
                    
                    //Gancho y cuerda se devuelven a mover a la caja a la izquierda una posición (NADA MAS SE MUEVE)
                    TranslateTransition trasGancho5 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho5.setByX( (-(((1500 - ((1500/numerodecajas)*j))+60)-((1500/numerodecajas)))) + (1500/numerodecajas) );
                    movGancho.getChildren().add(trasGancho5);
                    TranslateTransition trasCuerda3 = new TranslateTransition(Duration.millis(velocidad),cuerda);
                    trasCuerda3.setByX( (-(((1500 - ((1500/numerodecajas)*j))+60) - ((1500/numerodecajas)))) + (1500/numerodecajas) );
                    movCuerda.getChildren().add(trasCuerda3);
                    
                    TranslateTransition trasVacioCaja3 = new TranslateTransition(Duration.millis(velocidad));
                    movCajas.getChildren().add(trasVacioCaja3);
                    
                    
                    //Baja gancho(NADA MAS SE MUEVE)
                    TranslateTransition trasGancho6 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho6.setByY(165);
                    movGancho.getChildren().add(trasGancho6);
                    
                    TranslateTransition trasVacioCuerda3 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda.getChildren().add(trasVacioCuerda3);
                    TranslateTransition trasVacioCaja4 = new TranslateTransition(Duration.millis(velocidad));
                    movCajas.getChildren().add(trasVacioCaja4);
                    
                    
                    //Gancho y cuerda se mueven a la izquierda lo mismo que la caja
                    TranslateTransition trasGancho7 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho7.setByX(-(1500/numerodecajas));
                    movGancho.getChildren().add(trasGancho7);
                    TranslateTransition trasCuerda4 = new TranslateTransition(Duration.millis(velocidad),cuerda);
                    trasCuerda4.setByX( -(1500/numerodecajas) );
                    movCuerda.getChildren().add(trasCuerda4);
                    TranslateTransition trasCaja3 = new TranslateTransition(Duration.millis(velocidad), cajasAnchor.get(j+1));
                    trasCaja3.setByX(-(1500/numerodecajas));
                    movCajas.getChildren().add(trasCaja3);
                    
                    //Sube gancho (NADA MAS SE MUEVE)
                    TranslateTransition trasGancho8 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho8.setByY(-165);
                    movGancho.getChildren().add(trasGancho8);
                    
                    TranslateTransition trasVacioCuerda4 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda.getChildren().add(trasVacioCuerda4);
                    TranslateTransition trasVacioCaja5 = new TranslateTransition(Duration.millis(velocidad));
                    movCajas.getChildren().add(trasVacioCaja5);
                    
                    
                    //Gancho y cuerda van a buscar la caja que dejo antes en la repisa(se mueven a la derecha lo mismo que se movieron antes para dejar la caja en la repisa)(NADA MAS SE MUEVE)
                    TranslateTransition trasGancho9 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho9.setByX( ((1500 - ((1500/numerodecajas)*j))+60)- ((1500/numerodecajas)) );
                    movGancho.getChildren().add(trasGancho9);
                    TranslateTransition trasCuerda5 = new TranslateTransition(Duration.millis(velocidad),cuerda);
                    trasCuerda5.setByX( ((1500 - ((1500/numerodecajas)*j))+60)- ((1500/numerodecajas)) );
                    movCuerda.getChildren().add(trasCuerda5);
                    
                    TranslateTransition trasVacioCaja6 = new TranslateTransition(Duration.millis(velocidad));
                    movCajas.getChildren().add(trasVacioCaja6);
                    
                    
                    //Gancho y cuerda se mueven a la izquierda lo mismo que la caja
                    TranslateTransition trasGancho10 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho10.setByX( (-(((1500 - ((1500/numerodecajas)*j))+60)- ((1500/numerodecajas))))+(1500/numerodecajas) );
                    movGancho.getChildren().add(trasGancho10);
                    TranslateTransition trasCuerda6 = new TranslateTransition(Duration.millis(velocidad),cuerda);
                    trasCuerda6.setByX( (-(((1500 - ((1500/numerodecajas)*j))+60)- ((1500/numerodecajas))))+(1500/numerodecajas) );
                    movCuerda.getChildren().add(trasCuerda6);
                    
                    
                    TranslateTransition trasCaja4 = new TranslateTransition(Duration.millis(velocidad), cajasAnchor.get(j));
                    trasCaja4.setByX((-(((1500 - ((1500/numerodecajas)*j))+60)- ((1500/numerodecajas))))+(1500/numerodecajas));
                    movCajas.getChildren().add(trasCaja4);
                    
                    //Baja gancho (CUERDA NO SE MUEVE)
                    TranslateTransition trasGancho11 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho11.setByY(165);
                    movGancho.getChildren().add(trasGancho11);
                    TranslateTransition trasCaja5 = new TranslateTransition(Duration.millis(velocidad), cajasAnchor.get(j));
                    trasCaja5.setByY(165);
                    movCajas.getChildren().add(trasCaja5);
                    
                    TranslateTransition trasVacioCuerda5 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda.getChildren().add(trasVacioCuerda5);
                    
                    
                    
                    //Sube gancho(NADA MAS SE MUEVE)
                    TranslateTransition trasGancho12 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho12.setByY(-165);
                    movGancho.getChildren().add(trasGancho12);
                    
                    TranslateTransition trasVacioCuerda6 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda.getChildren().add(trasVacioCuerda6);
                    TranslateTransition trasVacioCaja7 = new TranslateTransition(Duration.millis(velocidad));
                    movCajas.getChildren().add(trasVacioCaja7);
                    
                    
                                        
                    cajaAux = cajasAnchor.get(j);
                    cajasAnchor.set(j, cajasAnchor.get(j+1));
                    cajasAnchor.set(j+1,cajaAux);
                    
                    aux = arreglo.get(j);
                    arreglo.set(j, arreglo.get(j+1));
                    arreglo.set(j+1, aux);
                }
            
            }  
        
        }
            
        for (int i=0; i<arreglo.size();i++){
            System.out.print(arreglo.get(i)+" -> ");   
        }
        
        movCajas.play();
        movGancho.play();
        movCuerda.play();
    }
    
    private void resaltarLineaCodigo(Text[] etiquetasCodigo, int indiceLinea) {
        for (int i = 0; i < etiquetasCodigo.length; i++) {
            if (i == indiceLinea) {
                etiquetasCodigo[i].setFill(Color.RED);
            } else {
                etiquetasCodigo[i].setFill(Color.BLACK);
            }
        }
    }
    
    public AnchorPane Pseudocodigo(AnchorPane Anchor, ArrayList <Caja> caja) {
        ArrayList <Integer> arreglo = new ArrayList();
        
        for(int i=0;i<caja.size();i++){ 
            arreglo.add(caja.get(i).peso);
        }
        
        
        Text[] etiquetasCodigo = {
                new Text("1. Para i = 1 hasta n-1 hacer:"),
                new Text("2.     j = i"),
                new Text("3.     mientras j > 0 y A[j-1] > A[j] hacer:"),
                new Text("4.         intercambiar A[j] y A[j-1]"),
                new Text("5.         j = j - 1")
        };
        
        Font font = new Font(15); // Crear un objeto Font con tamaño de fuente 18
        for (Text t : etiquetasCodigo) {
            t.setFont(font); // Establecer la fuente en cada instancia de Text
        }
     
        Text etiquetaArreglo = new Text(arreglo.toString());
        
        VBox root = new VBox(10);
        root.getChildren().addAll(etiquetasCodigo);
        root.getChildren().add(etiquetaArreglo);
        
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                for (int i = 1; i < arreglo.size(); i++) {
                    
                    
                    int valorActual = arreglo.get(i);
                    int j = i;
                    
                    resaltarLineaCodigo(etiquetasCodigo, 1);
                    Thread.sleep(TIEMPO_ESPERA);
                    Thread.sleep(TIEMPO_ESPERA);
                    
                    while (j > 0 && arreglo.get(j-1) > valorActual) {
                        arreglo.set(j, arreglo.get(j-1));
                        j--;
                        
                        resaltarLineaCodigo(etiquetasCodigo, 2);
                        Thread.sleep(TIEMPO_ESPERA);
                        Thread.sleep(TIEMPO_ESPERA);
                       
                        
                        etiquetaArreglo.setText(arreglo.toString());
                        
                        resaltarLineaCodigo(etiquetasCodigo, 3);
                        Thread.sleep(TIEMPO_ESPERA);
                        
                        
                        
                        
                        
                    }
                    resaltarLineaCodigo(etiquetasCodigo, 4);
                    Thread.sleep(TIEMPO_ESPERA);
                    Thread.sleep(TIEMPO_ESPERA);
                    Thread.sleep(TIEMPO_ESPERA);
                    
                    arreglo.set(j, valorActual);
                    etiquetaArreglo.setText(arreglo.toString());
                }
                return null;
            }
            
            
        };
        
        task.setOnSucceeded(event -> {
            resaltarLineaCodigo(etiquetasCodigo, -1);
        });
        
        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();
        root.setStyle("-fx-background-color: #FFFFFF;"); 
        root.setLayoutX(200); 
        root.setLayoutY(210); 
        root.setPrefSize(290,165); 
        // Crear un borde con un ancho de 2 píxeles y un color rojo 
        Border border = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,  
        CornerRadii.EMPTY, BorderWidths.FULL)); 
 
    // Establecer el borde en el VBox 
    root.setBorder(border); 
        Anchor.getChildren().add(root);
        return Anchor; 
    }
     
    public void imprimeArreglo(ArrayList <Integer> arreglo){
        System.out.print("[ ");
        for (int i = 0; i < arreglo.size(); i++) {
            System.out.print(arreglo.get(i)+" "); 
        }
        System.out.println("]");
    }
}
