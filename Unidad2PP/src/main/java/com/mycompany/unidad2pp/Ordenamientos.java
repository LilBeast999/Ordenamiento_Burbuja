package com.mycompany.unidad2pp;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
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
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author gusta
 */
public class Ordenamientos {
    public int aux=20;
    public int opcion;
    public int TIEMPO_ESPERA = 2000; 
    public double rate=1;
    
    
    
    public void miCodigo(Stage stage, Button boton, Button boton2, Button boton3,Button boton4,int aux,int opcion){
        this.rate=1;
        this.TIEMPO_ESPERA=200;
        AnchorPane anchor = new AnchorPane(); 
        Scene scena = new Scene (anchor,1920,1080); 
        scena.setFill(Color.web("#AABDD8")); 
        stage.setMaximized(true); 
            
        // apartir de aca OJO
        ArrayList <Integer> arreglo = new ArrayList();
        Almacen almacen = new Almacen(0,0);
        
        int numerodecajas=aux;
        
        
        Lapiz lapiz= new Lapiz(anchor);
        
        if(opcion!=4){
            lapiz.dibujarfondo();
            lapiz.dibujargrua();
        }
        else if(opcion==4){
            lapiz.dibujarfondo2();
        }


        ArrayList<Double> escalas = new ArrayList();      
        for (int i = 1; i <= 49 ; i++) {
            escalas.add(0, (double)((i * 100) / 48)/100);
        }
        System.out.println("numero de cajas/vagones: "+this.aux);
  
        ArrayList<AnchorPane> cajasAnchor = new ArrayList();
        ArrayList<Double> coordenadasX = new ArrayList();
        double xAux;
                
        //Crea las cajas AnchorPane y las añade al arreglo de cajas de tipo Anchor y al arreglo de cajas de Almacén
        
        if (opcion!=4){
            for(int i=0;i<numerodecajas;i++){       
                Caja caja1 = new Caja((int)Math.floor(Math.random()*(99-1+1)+1));
                almacen.cajas.add(caja1);
                xAux = 150+((1500/numerodecajas)*i);
                cajasAnchor.add(almacen.dibujarcaja(150+((1500/numerodecajas)*i),850, anchor,i,escalas.get(numerodecajas-16)));
                coordenadasX.add(xAux);
            }
        }
        else{
            for(int i=0;i<numerodecajas;i++){       
                Caja caja1 = new Caja((int)Math.floor(Math.random()*(99-1+1)+1));
                almacen.cajas.add(caja1);
                xAux = ((1100/numerodecajas)*i);
                cajasAnchor.add(almacen.dibujarvagon(((1100/numerodecajas)*i)-200,490, anchor,i,escalas.get(numerodecajas-16)));
                coordenadasX.add(xAux);          
            }
        }
       
        
       

        
        
        //Obtiene los números generados previamente para que los valores calcen con los del arreglo que se muestra en consola
        for (int i=0; i<numerodecajas; i++){ 
            arreglo.add( almacen.cajas.get(i).peso);
            System.out.print(arreglo.get(i)+ " ");
        }
        
        anchor.setScaleX(1);
        anchor.setScaleY(1);
        
        switch (opcion) {
            //ORDENAMIENTO POR INSERCION
            case 1:
                Insercion(numerodecajas,arreglo,cajasAnchor,anchor);
                break;
                
            //ORDENAMIENTO POR BURBUJA
            case 2: 
                Burbuja(arreglo,numerodecajas,cajasAnchor,anchor,coordenadasX);
                break;
            
            //ORDENAMIENTO POR BURBUJA COCKTAIL    
            case 3:
                Cocktail(arreglo, numerodecajas, cajasAnchor, anchor,coordenadasX);
                break;
                
            case 4:
                Seleccion(arreglo, numerodecajas, cajasAnchor, anchor,coordenadasX);
                break;
             
            default:
                throw new AssertionError();
        }
        
       
        
        
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
            
            Rectangle pintalinea = new Rectangle(0,0,250,20);
            pintalinea.setFill(Color.WHITE);
            anchor=PseudocodigoInsercion(anchor, arreglo,pintalinea);
            
            ArrayList<Integer> alturasLineas = new ArrayList();
            for (int i = 1; i <= 5; i++) {
                alturasLineas.add(i*25);
            }
            imprimeArreglo(arreglo);
            
             this.rate=1;
            int velocidad = TIEMPO_ESPERA;
            boolean bajoGancho2;
            
            
            SequentialTransition movPintalinea = new SequentialTransition();
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
                TranslateTransition trasPinta1 = new TranslateTransition(Duration.millis(500),pintalinea);
                trasPinta1.setToY(alturasLineas.get(0)-15);
                movPintalinea.getChildren().add(trasPinta1);
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
            
            System.out.println(movPintalinea);
            movPintalinea.play();
            movCajas.play();
            movCuerda1.play();
            movGancho1.play();
            movCuerda2.play();
            movGancho2.play();
            
            Button masvelocidad = new Button ("+ velocidad");
            Button menosvelocidad = new Button ("- velocidad");
      
            masvelocidad.setOnAction(e -> {
             aumentarRate();
             movCajas.setRate(this.rate);
             movCuerda1.setRate(this.rate);
             movGancho1.setRate(this.rate);
             movCuerda2.setRate(this.rate);
             movGancho2.setRate(this.rate);
             
         
            });
            
            menosvelocidad.setOnAction(e -> {
             disminuirRate();
             movCajas.setRate(this.rate);
             movCuerda1.setRate(this.rate);
             movGancho1.setRate(this.rate);
             movCuerda2.setRate(this.rate);
             movGancho2.setRate(this.rate);
             
             
         
            });
            
            anchor.getChildren().add(masvelocidad);
            menosvelocidad.setLayoutX(1180);
            masvelocidad.setLayoutX(1270);
            menosvelocidad.setLayoutY(20);
            masvelocidad.setLayoutY(20);
            
            masvelocidad.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
            menosvelocidad.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
            anchor.getChildren().add(menosvelocidad);
            
        }
    
    public void Burbuja (ArrayList<Integer> arreglo, int numerodecajas, ArrayList<AnchorPane> cajasAnchor,AnchorPane anchor, ArrayList<Double> coordenadasX){
                
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
        
        Rectangle pintalinea = new Rectangle(0,0,380,20);
        pintalinea.setFill(Color.ORANGE);
        anchor=PseudocodigoBurbuja(anchor, arreglo,pintalinea);
            
        ArrayList<Integer> alturasLineas = new ArrayList();
        for (int i = 1; i <= 3; i++) {
            alturasLineas.add((i*25)-15);
        }
        
        System.out.println("Alturas de las lineas: "+alturasLineas.get(0)+", "+alturasLineas.get(1)+", "+alturasLineas.get(2));
        


   
        
        this.rate=1;
        int velocidad = 200;
        SequentialTransition movPintalineas = new SequentialTransition();
        SequentialTransition movCajas = new SequentialTransition();
        SequentialTransition movGancho = new SequentialTransition();
        SequentialTransition movCuerda = new SequentialTransition();
        
        
        AnchorPane cajaAux = new AnchorPane();
        int aux;
        for (int i=0; i<arreglo.size();i++){
            TranslateTransition trasPinta1 = new TranslateTransition(Duration.millis(velocidad),pintalinea);
            trasPinta1.setToY(alturasLineas.get(0) );
            movPintalineas.getChildren().add(trasPinta1);
            
            TranslateTransition trasVacioCaja71 = new TranslateTransition(Duration.millis(velocidad));
            movCajas.getChildren().add(trasVacioCaja71);
            TranslateTransition trasVacioCuerda61 = new TranslateTransition(Duration.millis(velocidad));
            movCuerda.getChildren().add(trasVacioCuerda61);
            TranslateTransition trasVacioGancho01 = new TranslateTransition(Duration.millis(velocidad));
            movGancho.getChildren().add(trasVacioGancho01);
            
            for (int j=0, contador=0;j<arreglo.size()-(i+1);j++,contador++){
                
                TranslateTransition trasPinta2 = new TranslateTransition(Duration.millis(velocidad),pintalinea);
                trasPinta2.setToY(alturasLineas.get(1) );
                movPintalineas.getChildren().add(trasPinta2);
                
                TranslateTransition trasVacioCaja70 = new TranslateTransition(Duration.millis(velocidad));
                movCajas.getChildren().add(trasVacioCaja70);
                TranslateTransition trasVacioCuerda60 = new TranslateTransition(Duration.millis(velocidad));
                movCuerda.getChildren().add(trasVacioCuerda60);
                TranslateTransition trasVacioGancho0 = new TranslateTransition(Duration.millis(velocidad));
                movGancho.getChildren().add(trasVacioGancho0);
                
                if (arreglo.get(j)>arreglo.get(j+1)){
                    
                    TranslateTransition trasPinta3 = new TranslateTransition(Duration.millis(velocidad),pintalinea);
                    trasPinta3.setToY(alturasLineas.get(2) );
                    movPintalineas.getChildren().add(trasPinta3);
                    
                    TranslateTransition trasVacioCaja72 = new TranslateTransition(Duration.millis(velocidad));
                    movCajas.getChildren().add(trasVacioCaja72);
                    TranslateTransition trasVacioCuerda62 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda.getChildren().add(trasVacioCuerda62);
                    TranslateTransition trasVacioGancho02 = new TranslateTransition(Duration.millis(velocidad));
                    movGancho.getChildren().add(trasVacioGancho02);
                                       
                    //Gancho y cuerda van a la caja pivote(NADA MAS SE MUEVE)
                    TranslateTransition trasCuerda1 = new TranslateTransition(Duration.millis(velocidad),cuerda);
                    trasCuerda1.setToX(coordenadasX.get(j) - 200 );
                    movCuerda.getChildren().add(trasCuerda1);
                    TranslateTransition trasGancho1 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho1.setToX(coordenadasX.get(j) - 200);
                    movGancho.getChildren().add(trasGancho1);

                    
                    TranslateTransition trasVacioCaja1 = new TranslateTransition(Duration.millis(velocidad));
                    movCajas.getChildren().add(trasVacioCaja1);
                    TranslateTransition trasVacioPinta1 = new TranslateTransition(Duration.millis(velocidad));
                    movPintalineas.getChildren().add(trasVacioPinta1);
                    
                    
                    
                    
                    //Baja gancho(NADA MAS SE MUEVE)
                    TranslateTransition trasGancho2 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho2.setByY(165);
                    movGancho.getChildren().add(trasGancho2);
                    
                    TranslateTransition trasVacioCuerda1 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda.getChildren().add(trasVacioCuerda1);
                    TranslateTransition trasVacioCaja2 = new TranslateTransition(Duration.millis(velocidad));
                    movCajas.getChildren().add(trasVacioCaja2);
                    TranslateTransition trasVacioPinta2 = new TranslateTransition(Duration.millis(velocidad));
                    movPintalineas.getChildren().add(trasVacioPinta2);
                    
                    
                    //Sube gancho (CUERDA NO SE MUEVE)
                    TranslateTransition trasGancho3 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho3.setByY(-165);
                    movGancho.getChildren().add(trasGancho3);
                    TranslateTransition trasCaja1 = new TranslateTransition(Duration.millis(velocidad),cajasAnchor.get(j));
                    trasCaja1.setByY(-165);
                    movCajas.getChildren().add(trasCaja1);
                    
                    TranslateTransition trasVacioCuerda2 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda.getChildren().add(trasVacioCuerda2);
                    TranslateTransition trasVacioPinta3 = new TranslateTransition(Duration.millis(velocidad));
                    movPintalineas.getChildren().add(trasVacioPinta3);
                    
                    
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
                    
                    TranslateTransition trasVacioPinta4 = new TranslateTransition(Duration.millis(velocidad));
                    movPintalineas.getChildren().add(trasVacioPinta4);
                    
                    //Gancho y cuerda se devuelven a mover a la caja a la izquierda una posición (NADA MAS SE MUEVE)
                    TranslateTransition trasGancho5 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho5.setByX( (-(((1500 - ((1500/numerodecajas)*j))+60)-((1500/numerodecajas)))) + (1500/numerodecajas) );
                    movGancho.getChildren().add(trasGancho5);
                    TranslateTransition trasCuerda3 = new TranslateTransition(Duration.millis(velocidad),cuerda);
                    trasCuerda3.setByX( (-(((1500 - ((1500/numerodecajas)*j))+60) - ((1500/numerodecajas)))) + (1500/numerodecajas) );
                    movCuerda.getChildren().add(trasCuerda3);
                    
                    TranslateTransition trasVacioCaja3 = new TranslateTransition(Duration.millis(velocidad));
                    movCajas.getChildren().add(trasVacioCaja3);
                    TranslateTransition trasVacioPinta5 = new TranslateTransition(Duration.millis(velocidad));
                    movPintalineas.getChildren().add(trasVacioPinta5);
                    
                    
                    //Baja gancho(NADA MAS SE MUEVE)
                    TranslateTransition trasGancho6 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho6.setByY(165);
                    movGancho.getChildren().add(trasGancho6);
                    
                    TranslateTransition trasVacioCuerda3 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda.getChildren().add(trasVacioCuerda3);
                    TranslateTransition trasVacioCaja4 = new TranslateTransition(Duration.millis(velocidad));
                    movCajas.getChildren().add(trasVacioCaja4);
                    TranslateTransition trasVacioPinta6 = new TranslateTransition(Duration.millis(velocidad));
                    movPintalineas.getChildren().add(trasVacioPinta6);
                    
                    
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
                    
                    TranslateTransition trasVacioPinta7 = new TranslateTransition(Duration.millis(velocidad));
                    movPintalineas.getChildren().add(trasVacioPinta7);
                    
                    //Sube gancho (NADA MAS SE MUEVE)
                    TranslateTransition trasGancho8 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho8.setByY(-165);
                    movGancho.getChildren().add(trasGancho8);
                    
                    TranslateTransition trasVacioCuerda4 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda.getChildren().add(trasVacioCuerda4);
                    TranslateTransition trasVacioCaja5 = new TranslateTransition(Duration.millis(velocidad));
                    movCajas.getChildren().add(trasVacioCaja5);
                    TranslateTransition trasVacioPinta8 = new TranslateTransition(Duration.millis(velocidad));
                    movPintalineas.getChildren().add(trasVacioPinta8);
                    
                    
                    //Gancho y cuerda van a buscar la caja que dejo antes en la repisa(se mueven a la derecha lo mismo que se movieron antes para dejar la caja en la repisa)(NADA MAS SE MUEVE)
                    TranslateTransition trasGancho9 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho9.setByX( ((1500 - ((1500/numerodecajas)*j))+60)- ((1500/numerodecajas)) );
                    movGancho.getChildren().add(trasGancho9);
                    TranslateTransition trasCuerda5 = new TranslateTransition(Duration.millis(velocidad),cuerda);
                    trasCuerda5.setByX( ((1500 - ((1500/numerodecajas)*j))+60)- ((1500/numerodecajas)) );
                    movCuerda.getChildren().add(trasCuerda5);
                    
                    TranslateTransition trasVacioCaja6 = new TranslateTransition(Duration.millis(velocidad));
                    movCajas.getChildren().add(trasVacioCaja6);
                    TranslateTransition trasVacioPinta9 = new TranslateTransition(Duration.millis(velocidad));
                    movPintalineas.getChildren().add(trasVacioPinta9);
                    
                    
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
                    TranslateTransition trasVacioPinta10 = new TranslateTransition(Duration.millis(velocidad));
                    movPintalineas.getChildren().add(trasVacioPinta10);
                    
                    //Baja gancho (CUERDA NO SE MUEVE)
                    TranslateTransition trasGancho11 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho11.setByY(165);
                    movGancho.getChildren().add(trasGancho11);
                    TranslateTransition trasCaja5 = new TranslateTransition(Duration.millis(velocidad), cajasAnchor.get(j));
                    trasCaja5.setByY(165);
                    movCajas.getChildren().add(trasCaja5);
                    
                    TranslateTransition trasVacioCuerda5 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda.getChildren().add(trasVacioCuerda5);
                    TranslateTransition trasVacioPinta11 = new TranslateTransition(Duration.millis(velocidad));
                    movPintalineas.getChildren().add(trasVacioPinta11);
                    
                    
                    
                    //Sube gancho(NADA MAS SE MUEVE)
                    TranslateTransition trasGancho12 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho12.setByY(-165);
                    movGancho.getChildren().add(trasGancho12);
                    
                    TranslateTransition trasVacioCuerda6 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda.getChildren().add(trasVacioCuerda6);
                    TranslateTransition trasVacioCaja7 = new TranslateTransition(Duration.millis(velocidad));
                    movCajas.getChildren().add(trasVacioCaja7);
                    TranslateTransition trasVacioPinta12 = new TranslateTransition(Duration.millis(velocidad));
                    movPintalineas.getChildren().add(trasVacioPinta12);
                    
                    
                                        
                    cajaAux = cajasAnchor.get(j);
                    cajasAnchor.set(j, cajasAnchor.get(j+1));
                    cajasAnchor.set(j+1,cajaAux);
                    
                    aux = arreglo.get(j);
                    arreglo.set(j, arreglo.get(j+1));
                    arreglo.set(j+1, aux);
                }else{
                    TranslateTransition trasPinta4 = new TranslateTransition(Duration.millis(velocidad),pintalinea);
                    trasPinta4.setToY(alturasLineas.get(1) );
                    movPintalineas.getChildren().add(trasPinta4);
                    
                    TranslateTransition trasVacioCaja7 = new TranslateTransition(Duration.millis(velocidad));
                    movCajas.getChildren().add(trasVacioCaja7);
                    TranslateTransition trasVacioCuerda6 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda.getChildren().add(trasVacioCuerda6);
                    TranslateTransition trasVacioGancho = new TranslateTransition(Duration.millis(velocidad));
                    movGancho.getChildren().add(trasVacioGancho);
                
                }
            
            }  
        
        }
            
        for (int i=0; i<arreglo.size();i++){
            System.out.print(arreglo.get(i)+" -> ");   
        }
        
        
        Button masvelocidad = new Button ("+ velocidad");
        Button menosvelocidad = new Button ("- velocidad");
        masvelocidad.setOnAction(e -> {
            aumentarRate();
            movPintalineas.setRate(this.rate);
            movCajas.setRate(this.rate);
            movCuerda.setRate(this.rate);
            movGancho.setRate(this.rate);
        });
        menosvelocidad.setOnAction(e -> {
            disminuirRate();
            movPintalineas.setRate(this.rate);
            movCajas.setRate(this.rate);
            movCuerda.setRate(this.rate);
            movGancho.setRate(this.rate);
        });
        anchor.getChildren().add(masvelocidad);
        menosvelocidad.setLayoutX(1180);
        masvelocidad.setLayoutX(1270);
        menosvelocidad.setLayoutY(20);
        masvelocidad.setLayoutY(20);
        masvelocidad.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        menosvelocidad.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        anchor.getChildren().add(menosvelocidad);

        movPintalineas.play();
        movCajas.play();
        movGancho.play();
        movCuerda.play();
    }  
    
    public void Cocktail (ArrayList<Integer> arreglo, int numerodecajas, ArrayList<AnchorPane> cajasAnchor,AnchorPane anchor, ArrayList<Double> coordenadasX){
        Rectangle repisa = new Rectangle(1625,745,100,25);
        repisa.setFill(Color.ORANGE);
        repisa.setStroke(Color.BLACK);
        anchor.getChildren().add(repisa);
        Rectangle repisa1 = new Rectangle(125,745,100,25);
        repisa1.setFill(Color.ORANGE);
        repisa1.setStroke(Color.BLACK);
        anchor.getChildren().add(repisa1);
        
        this.rate=1;
        int velocidad = 200;
        
        Rectangle pintalinea = new Rectangle(0,0,400,20);
        pintalinea.setFill(Color.ORANGE);
        
        anchor=PseudocodigoCocktail(anchor, arreglo, pintalinea);
        
        ArrayList<Integer> alturasLineas = new ArrayList();
        for (int i = 1; i <= 8; i++) {
            alturasLineas.add((i*25)-15);
        }
        
        SequentialTransition movPintalineas = new SequentialTransition();
        SequentialTransition movCajas = new SequentialTransition();
        SequentialTransition movGancho = new SequentialTransition();
        SequentialTransition movCuerda = new SequentialTransition();
        System.out.println("Arreglo sin ordenar: " + arreglo);
        
        Almacen almacen = new Almacen(0,0);
        Lapiz lapiz = new Lapiz(0,0);
        AnchorPane gancho = new AnchorPane();
        gancho = almacen.dibujargancho(anchor,210,462);
        AnchorPane cuerda = new AnchorPane();
        cuerda = lapiz.dibujarcuerda(210,442);
        anchor.getChildren().add(cuerda);
        AnchorPane cajaAux = new AnchorPane();
        int aux;
        
        boolean intercambio = true;
        int inicio = 0;
        int fin = arreglo.size() - 1;
        imprimeArreglo(arreglo);

        while (intercambio) {
            intercambio = false;
            
            TranslateTransition trasPinta1 = new TranslateTransition(Duration.millis(velocidad),pintalinea);
            trasPinta1.setToY(alturasLineas.get(1));
            movPintalineas.getChildren().add(trasPinta1);
            
            TranslateTransition trasVacioCuerda15 = new TranslateTransition(Duration.millis(velocidad));
            movCuerda.getChildren().add(trasVacioCuerda15);
            TranslateTransition trasVacioCaja25 = new TranslateTransition(Duration.millis(velocidad));
            movCajas.getChildren().add(trasVacioCaja25);
            TranslateTransition trasVacioGancho1 = new TranslateTransition(Duration.millis(velocidad));
            movGancho.getChildren().add(trasVacioGancho1);

            // Mover elementos grandes al final
            for (int i = inicio; i < fin; i++) {
                
                TranslateTransition trasPinta2 = new TranslateTransition(Duration.millis(velocidad),pintalinea);
                trasPinta2.setToY(alturasLineas.get(2));
                movPintalineas.getChildren().add(trasPinta2);
            
                TranslateTransition trasVacioCuerda16 = new TranslateTransition(Duration.millis(velocidad));
                movCuerda.getChildren().add(trasVacioCuerda16);
                TranslateTransition trasVacioCaja26 = new TranslateTransition(Duration.millis(velocidad));
                movCajas.getChildren().add(trasVacioCaja26);
                TranslateTransition trasVacioGancho2 = new TranslateTransition(Duration.millis(velocidad));
                movGancho.getChildren().add(trasVacioGancho2);
    
                if (arreglo.get(i) > arreglo.get(i + 1)) {
                    
                    TranslateTransition trasPinta3 = new TranslateTransition(Duration.millis(velocidad),pintalinea);
                    trasPinta3.setToY(alturasLineas.get(3));
                    movPintalineas.getChildren().add(trasPinta3);
            
                    TranslateTransition trasVacioCuerda17 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda.getChildren().add(trasVacioCuerda17);
                    TranslateTransition trasVacioCaja27 = new TranslateTransition(Duration.millis(velocidad));
                    movCajas.getChildren().add(trasVacioCaja27);
                    TranslateTransition trasVacioGancho3 = new TranslateTransition(Duration.millis(velocidad));
                    movGancho.getChildren().add(trasVacioGancho3);
                 
                    //Gancho y cuerda van a la caja pivote(NADA MAS SE MUEVE)
                    TranslateTransition trasCuerda1 = new TranslateTransition(Duration.millis(velocidad),cuerda);
                    trasCuerda1.setToX(coordenadasX.get(i) - 200 );
                    movCuerda.getChildren().add(trasCuerda1);
                    TranslateTransition trasGancho1 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho1.setToX(coordenadasX.get(i) - 200);
                    movGancho.getChildren().add(trasGancho1);
                    
                    TranslateTransition trasVacioCaja1 = new TranslateTransition(Duration.millis(velocidad));
                    movCajas.getChildren().add(trasVacioCaja1);
                    TranslateTransition trasVacioPinta1 = new TranslateTransition(Duration.millis(velocidad));
                    movPintalineas.getChildren().add(trasVacioPinta1);
                                      
                    //Baja gancho(NADA MAS SE MUEVE)
                    TranslateTransition trasGancho2 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho2.setByY(165);
                    movGancho.getChildren().add(trasGancho2);
                    
                    TranslateTransition trasVacioCuerda1 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda.getChildren().add(trasVacioCuerda1);
                    TranslateTransition trasVacioCaja2 = new TranslateTransition(Duration.millis(velocidad));
                    movCajas.getChildren().add(trasVacioCaja2);
                    TranslateTransition trasVacioPinta2 = new TranslateTransition(Duration.millis(velocidad));
                    movPintalineas.getChildren().add(trasVacioPinta2);
                                       
                    //Sube gancho (CUERDA NO SE MUEVE)
                    TranslateTransition trasGancho3 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho3.setByY(-165);
                    movGancho.getChildren().add(trasGancho3);
                    TranslateTransition trasCaja1 = new TranslateTransition(Duration.millis(velocidad),cajasAnchor.get(i));
                    trasCaja1.setByY(-165);
                    movCajas.getChildren().add(trasCaja1);
                    
                    TranslateTransition trasVacioCuerda2 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda.getChildren().add(trasVacioCuerda2);
                    TranslateTransition trasVacioPinta3 = new TranslateTransition(Duration.millis(velocidad));
                    movPintalineas.getChildren().add(trasVacioPinta3);
                                       
                    //Gancho y cuerda se mueven a la derecha lo mismo que la caja
                    TranslateTransition trasGancho4 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho4.setByX( ((1500 - ((1500/numerodecajas)*i))+60)- ((1500/numerodecajas)) );
                    movGancho.getChildren().add(trasGancho4);
                    TranslateTransition trasCuerda2 = new TranslateTransition(Duration.millis(velocidad),cuerda);
                    trasCuerda2.setByX( ((1500 - ((1500/numerodecajas)*i))+60)- ((1500/numerodecajas)) );
                    movCuerda.getChildren().add(trasCuerda2);
                    TranslateTransition trasCaja2 = new TranslateTransition(Duration.millis(velocidad),cajasAnchor.get(i));
                    trasCaja2.setByX( ((1500 - ((1500/numerodecajas)*i))+60)- ((1500/numerodecajas)) );
                    movCajas.getChildren().add(trasCaja2);
                    
                    TranslateTransition trasVacioPinta4 = new TranslateTransition(Duration.millis(velocidad));
                    movPintalineas.getChildren().add(trasVacioPinta4);
                    
                    //Gancho y cuerda se devuelven a mover a la caja a la izquierda una posición (NADA MAS SE MUEVE)
                    TranslateTransition trasGancho5 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho5.setByX( (-(((1500 - ((1500/numerodecajas)*i))+60)-((1500/numerodecajas)))) + (1500/numerodecajas) );
                    movGancho.getChildren().add(trasGancho5);
                    TranslateTransition trasCuerda3 = new TranslateTransition(Duration.millis(velocidad),cuerda);
                    trasCuerda3.setByX( (-(((1500 - ((1500/numerodecajas)*i))+60) - ((1500/numerodecajas)))) + (1500/numerodecajas) );
                    movCuerda.getChildren().add(trasCuerda3);
                    
                    TranslateTransition trasVacioCaja3 = new TranslateTransition(Duration.millis(velocidad));
                    movCajas.getChildren().add(trasVacioCaja3);
                    TranslateTransition trasVacioPinta5 = new TranslateTransition(Duration.millis(velocidad));
                    movPintalineas.getChildren().add(trasVacioPinta5);
                                       
                    //Baja gancho(NADA MAS SE MUEVE)
                    TranslateTransition trasGancho6 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho6.setByY(165);
                    movGancho.getChildren().add(trasGancho6);
                    
                    TranslateTransition trasVacioCuerda3 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda.getChildren().add(trasVacioCuerda3);
                    TranslateTransition trasVacioCaja4 = new TranslateTransition(Duration.millis(velocidad));
                    movCajas.getChildren().add(trasVacioCaja4);
                    TranslateTransition trasVacioPinta6 = new TranslateTransition(Duration.millis(velocidad));
                    movPintalineas.getChildren().add(trasVacioPinta6);
                                       
                    //Gancho y cuerda se mueven a la izquierda lo mismo que la caja
                    TranslateTransition trasGancho7 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho7.setByX(-(1500/numerodecajas));
                    movGancho.getChildren().add(trasGancho7);
                    TranslateTransition trasCuerda4 = new TranslateTransition(Duration.millis(velocidad),cuerda);
                    trasCuerda4.setByX( -(1500/numerodecajas) );
                    movCuerda.getChildren().add(trasCuerda4);
                    TranslateTransition trasCaja3 = new TranslateTransition(Duration.millis(velocidad), cajasAnchor.get(i+1));
                    trasCaja3.setByX(-(1500/numerodecajas));
                    movCajas.getChildren().add(trasCaja3);
                    
                    TranslateTransition trasVacioPinta7 = new TranslateTransition(Duration.millis(velocidad));
                    movPintalineas.getChildren().add(trasVacioPinta7);
                    
                    //Sube gancho (NADA MAS SE MUEVE)
                    TranslateTransition trasGancho8 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho8.setByY(-165);
                    movGancho.getChildren().add(trasGancho8);
                    
                    TranslateTransition trasVacioCuerda4 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda.getChildren().add(trasVacioCuerda4);
                    TranslateTransition trasVacioCaja5 = new TranslateTransition(Duration.millis(velocidad));
                    movCajas.getChildren().add(trasVacioCaja5);
                    TranslateTransition trasVacioPinta8 = new TranslateTransition(Duration.millis(velocidad));
                    movPintalineas.getChildren().add(trasVacioPinta8);
                                      
                    //Gancho y cuerda van a buscar la caja que dejo antes en la repisa(se mueven a la derecha lo mismo que se movieron antes para dejar la caja en la repisa)(NADA MAS SE MUEVE)
                    TranslateTransition trasGancho9 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho9.setByX( ((1500 - ((1500/numerodecajas)*i))+60)- ((1500/numerodecajas)) );
                    movGancho.getChildren().add(trasGancho9);
                    TranslateTransition trasCuerda5 = new TranslateTransition(Duration.millis(velocidad),cuerda);
                    trasCuerda5.setByX( ((1500 - ((1500/numerodecajas)*i))+60)- ((1500/numerodecajas)) );
                    movCuerda.getChildren().add(trasCuerda5);
                    
                    TranslateTransition trasVacioCaja6 = new TranslateTransition(Duration.millis(velocidad));
                    movCajas.getChildren().add(trasVacioCaja6);
                    TranslateTransition trasVacioPinta9 = new TranslateTransition(Duration.millis(velocidad));
                    movPintalineas.getChildren().add(trasVacioPinta9);
                                        
                    //Gancho y cuerda se mueven a la izquierda lo mismo que la caja
                    TranslateTransition trasGancho10 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho10.setByX( (-(((1500 - ((1500/numerodecajas)*i))+60)- ((1500/numerodecajas))))+(1500/numerodecajas) );
                    movGancho.getChildren().add(trasGancho10);
                    TranslateTransition trasCuerda6 = new TranslateTransition(Duration.millis(velocidad),cuerda);
                    trasCuerda6.setByX( (-(((1500 - ((1500/numerodecajas)*i))+60)- ((1500/numerodecajas))))+(1500/numerodecajas) );
                    movCuerda.getChildren().add(trasCuerda6);
                    
                    TranslateTransition trasCaja4 = new TranslateTransition(Duration.millis(velocidad), cajasAnchor.get(i));
                    trasCaja4.setByX((-(((1500 - ((1500/numerodecajas)*i))+60)- ((1500/numerodecajas))))+(1500/numerodecajas));
                    movCajas.getChildren().add(trasCaja4);
                    TranslateTransition trasVacioPinta10 = new TranslateTransition(Duration.millis(velocidad));
                    movPintalineas.getChildren().add(trasVacioPinta10);
                    
                    //Baja gancho (CUERDA NO SE MUEVE)
                    TranslateTransition trasGancho11 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho11.setByY(165);
                    movGancho.getChildren().add(trasGancho11);
                    TranslateTransition trasCaja5 = new TranslateTransition(Duration.millis(velocidad), cajasAnchor.get(i));
                    trasCaja5.setByY(165);
                    movCajas.getChildren().add(trasCaja5);
                    
                    TranslateTransition trasVacioCuerda5 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda.getChildren().add(trasVacioCuerda5);
                    TranslateTransition trasVacioPinta11 = new TranslateTransition(Duration.millis(velocidad));
                    movPintalineas.getChildren().add(trasVacioPinta11);
                    
                    //Sube gancho(NADA MAS SE MUEVE)
                    TranslateTransition trasGancho12 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho12.setByY(-165);
                    movGancho.getChildren().add(trasGancho12);
                    
                    TranslateTransition trasVacioCuerda6 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda.getChildren().add(trasVacioCuerda6);
                    TranslateTransition trasVacioCaja7 = new TranslateTransition(Duration.millis(velocidad));
                    movCajas.getChildren().add(trasVacioCaja7);
                    TranslateTransition trasVacioPinta12 = new TranslateTransition(Duration.millis(velocidad));
                    movPintalineas.getChildren().add(trasVacioPinta12);
                    
                    cajaAux = cajasAnchor.get(i);
                    cajasAnchor.set(i, cajasAnchor.get(i+1));
                    cajasAnchor.set(i+1,cajaAux);
 
                    int temp = arreglo.get(i);
                    arreglo.set(i, arreglo.get(i + 1));
                    arreglo.set(i + 1, temp);
                    intercambio = true;
                }else{
                    TranslateTransition trasPinta4 = new TranslateTransition(Duration.millis(velocidad),pintalinea);
                    trasPinta4.setToY(alturasLineas.get(2));
                    movPintalineas.getChildren().add(trasPinta4);

                    TranslateTransition trasVacioCuerda17 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda.getChildren().add(trasVacioCuerda17);
                    TranslateTransition trasVacioCaja27 = new TranslateTransition(Duration.millis(velocidad));
                    movCajas.getChildren().add(trasVacioCaja27);
                    TranslateTransition trasVacioGancho3 = new TranslateTransition(Duration.millis(velocidad));
                    movGancho.getChildren().add(trasVacioGancho3);
                    
                }
                
                TranslateTransition trasPinta5 = new TranslateTransition(Duration.millis(velocidad),pintalinea);
                trasPinta5.setToY(alturasLineas.get(4));
                movPintalineas.getChildren().add(trasPinta5);

                TranslateTransition trasVacioCuerda18 = new TranslateTransition(Duration.millis(velocidad));
                movCuerda.getChildren().add(trasVacioCuerda18);
                TranslateTransition trasVacioCaja28 = new TranslateTransition(Duration.millis(velocidad));
                movCajas.getChildren().add(trasVacioCaja28);
                TranslateTransition trasVacioGancho4 = new TranslateTransition(Duration.millis(velocidad));
                movGancho.getChildren().add(trasVacioGancho4);
            }
            fin--;


           // Mover elementos pequeños al inicio
           for (int i = fin; i > inicio; i--) {
                TranslateTransition trasPinta6 = new TranslateTransition(Duration.millis(velocidad),pintalinea);
                trasPinta6.setToY(alturasLineas.get(5));
                movPintalineas.getChildren().add(trasPinta6);

                TranslateTransition trasVacioCuerda19 = new TranslateTransition(Duration.millis(velocidad));
                movCuerda.getChildren().add(trasVacioCuerda19);
                TranslateTransition trasVacioCaja29 = new TranslateTransition(Duration.millis(velocidad));
                movCajas.getChildren().add(trasVacioCaja29);
                TranslateTransition trasVacioGancho5 = new TranslateTransition(Duration.millis(velocidad));
                movGancho.getChildren().add(trasVacioGancho5);
               
               
               if (arreglo.get(i) < arreglo.get(i - 1)) {
                    TranslateTransition trasPinta7 = new TranslateTransition(Duration.millis(velocidad),pintalinea);
                    trasPinta7.setToY(alturasLineas.get(6));
                    movPintalineas.getChildren().add(trasPinta7);

                    TranslateTransition trasVacioCuerda181 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda.getChildren().add(trasVacioCuerda181);
                    TranslateTransition trasVacioCaja281 = new TranslateTransition(Duration.millis(velocidad));
                    movCajas.getChildren().add(trasVacioCaja281);
                    TranslateTransition trasVacioGancho41 = new TranslateTransition(Duration.millis(velocidad));
                    movGancho.getChildren().add(trasVacioGancho41);
                    
                   
                    //Gancho y cuerda van a la caja pivote(NADA MAS SE MUEVE)
                    TranslateTransition trasCuerda1 = new TranslateTransition(Duration.millis(velocidad),cuerda);
                    trasCuerda1.setToX(coordenadasX.get(i) - 200 );
                    movCuerda.getChildren().add(trasCuerda1);
                    TranslateTransition trasGancho1 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho1.setToX(coordenadasX.get(i) - 200);
                    movGancho.getChildren().add(trasGancho1);
                    
                    TranslateTransition trasVacioCaja1 = new TranslateTransition(Duration.millis(velocidad));
                    movCajas.getChildren().add(trasVacioCaja1);                
                    TranslateTransition trasVacioPinta131 = new TranslateTransition(Duration.millis(velocidad));
                    movPintalineas.getChildren().add(trasVacioPinta131);
                    
                    
                    
                    //Baja gancho(NADA MAS SE MUEVE)
                    TranslateTransition trasGancho2 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho2.setByY(165);
                    movGancho.getChildren().add(trasGancho2);
                    
                    TranslateTransition trasVacioCuerda1 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda.getChildren().add(trasVacioCuerda1);
                    TranslateTransition trasVacioCaja2 = new TranslateTransition(Duration.millis(velocidad));
                    movCajas.getChildren().add(trasVacioCaja2);
                    TranslateTransition trasVacioPinta13 = new TranslateTransition(Duration.millis(velocidad));
                    movPintalineas.getChildren().add(trasVacioPinta13);
                    
                    
                    //Sube gancho (CUERDA NO SE MUEVE)
                    TranslateTransition trasGancho3 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho3.setByY(-165);
                    movGancho.getChildren().add(trasGancho3);
                    TranslateTransition trasCaja1 = new TranslateTransition(Duration.millis(velocidad),cajasAnchor.get(i));
                    trasCaja1.setByY(-165);
                    movCajas.getChildren().add(trasCaja1);
                    
                    TranslateTransition trasVacioCuerda2 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda.getChildren().add(trasVacioCuerda2);
                    TranslateTransition trasVacioPinta14 = new TranslateTransition(Duration.millis(velocidad));
                    movPintalineas.getChildren().add(trasVacioPinta14);
                    
                    
                    //Gancho y cuerda se mueven a la izquierda lo mismo que la caja
                    TranslateTransition trasGancho4 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho4.setByX( -((1500/numerodecajas)*i) );
                    movGancho.getChildren().add(trasGancho4);
                    TranslateTransition trasCuerda2 = new TranslateTransition(Duration.millis(velocidad),cuerda);
                    trasCuerda2.setByX( -((1500/numerodecajas)*i) );
                    movCuerda.getChildren().add(trasCuerda2);
                    TranslateTransition trasCaja2 = new TranslateTransition(Duration.millis(velocidad),cajasAnchor.get(i));
                    trasCaja2.setByX( -((1500/numerodecajas)*i) );
                    movCajas.getChildren().add(trasCaja2);
                    
                    TranslateTransition trasVacioPinta15 = new TranslateTransition(Duration.millis(velocidad));
                    movPintalineas.getChildren().add(trasVacioPinta15);
                    
                    //Gancho y cuerda se devuelven a mover a la caja a la DERECHA una posición (NADA MAS SE MUEVE)
                    TranslateTransition trasGancho5 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho5.setByX( ((1500/numerodecajas)*i) - (1500/numerodecajas) );
                    movGancho.getChildren().add(trasGancho5);
                    TranslateTransition trasCuerda3 = new TranslateTransition(Duration.millis(velocidad),cuerda);
                    trasCuerda3.setByX( ((1500/numerodecajas)*i) - (1500/numerodecajas) );
                    movCuerda.getChildren().add(trasCuerda3);
                    
                    TranslateTransition trasVacioCaja3 = new TranslateTransition(Duration.millis(velocidad));
                    movCajas.getChildren().add(trasVacioCaja3);
                    TranslateTransition trasVacioPinta16 = new TranslateTransition(Duration.millis(velocidad));
                    movPintalineas.getChildren().add(trasVacioPinta16);
                    
                    
                    //Baja gancho(NADA MAS SE MUEVE)
                    TranslateTransition trasGancho6 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho6.setByY(165);
                    movGancho.getChildren().add(trasGancho6);
                    
                    TranslateTransition trasVacioCuerda3 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda.getChildren().add(trasVacioCuerda3);
                    TranslateTransition trasVacioCaja4 = new TranslateTransition(Duration.millis(velocidad));
                    movCajas.getChildren().add(trasVacioCaja4);
                    TranslateTransition trasVacioPinta17 = new TranslateTransition(Duration.millis(velocidad));
                    movPintalineas.getChildren().add(trasVacioPinta17);
                    
                    
                    //Gancho y cuerda se mueven a la DERECHA lo mismo que la caja
                    TranslateTransition trasGancho7 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho7.setByX(1500/numerodecajas);
                    movGancho.getChildren().add(trasGancho7);
                    TranslateTransition trasCuerda4 = new TranslateTransition(Duration.millis(velocidad),cuerda);
                    trasCuerda4.setByX(1500/numerodecajas);
                    movCuerda.getChildren().add(trasCuerda4);
                    TranslateTransition trasCaja3 = new TranslateTransition(Duration.millis(velocidad), cajasAnchor.get(i-1));
                    trasCaja3.setByX(1500/numerodecajas);
                    movCajas.getChildren().add(trasCaja3);
                    TranslateTransition trasVacioPinta18 = new TranslateTransition(Duration.millis(velocidad));
                    movPintalineas.getChildren().add(trasVacioPinta18);
                    
                    //Sube gancho (NADA MAS SE MUEVE)
                    TranslateTransition trasGancho8 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho8.setByY(-165);
                    movGancho.getChildren().add(trasGancho8);
                    
                    TranslateTransition trasVacioCuerda4 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda.getChildren().add(trasVacioCuerda4);
                    TranslateTransition trasVacioCaja5 = new TranslateTransition(Duration.millis(velocidad));
                    movCajas.getChildren().add(trasVacioCaja5);
                    TranslateTransition trasVacioPinta19 = new TranslateTransition(Duration.millis(velocidad));
                    movPintalineas.getChildren().add(trasVacioPinta19);
                    
                    
                    //Gancho y cuerda van a buscar la caja que dejo antes en la repisa(se mueven a la IZQUIERDA lo mismo que se movieron antes para dejar la caja en la repisa)(Caja no se mueve)
                    TranslateTransition trasGancho9 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho9.setByX( -( ((1500/numerodecajas)*i)) );
                    movGancho.getChildren().add(trasGancho9);
                    TranslateTransition trasCuerda5 = new TranslateTransition(Duration.millis(velocidad),cuerda);
                    trasCuerda5.setByX( -( ((1500/numerodecajas)*i)) );
                    movCuerda.getChildren().add(trasCuerda5);
                    
                    TranslateTransition trasVacioCaja6 = new TranslateTransition(Duration.millis(velocidad));
                    movCajas.getChildren().add(trasVacioCaja6);
                    TranslateTransition trasVacioPinta20 = new TranslateTransition(Duration.millis(velocidad));
                    movPintalineas.getChildren().add(trasVacioPinta20);
                    
                    
                    //Gancho y cuerda se mueven a la DERECHA lo mismo que la caja
                    TranslateTransition trasGancho10 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho10.setByX( ((1500/numerodecajas)*i) - (1500/numerodecajas) );
                    movGancho.getChildren().add(trasGancho10);
                    TranslateTransition trasCuerda6 = new TranslateTransition(Duration.millis(velocidad),cuerda);
                    trasCuerda6.setByX( ((1500/numerodecajas)*i) - (1500/numerodecajas) );
                    movCuerda.getChildren().add(trasCuerda6);
                    TranslateTransition trasCaja4 = new TranslateTransition(Duration.millis(velocidad), cajasAnchor.get(i));
                    trasCaja4.setByX( ((1500/numerodecajas)*i) - (1500/numerodecajas) );
                    movCajas.getChildren().add(trasCaja4);
                    
                    TranslateTransition trasVacioPinta21 = new TranslateTransition(Duration.millis(velocidad));
                    movPintalineas.getChildren().add(trasVacioPinta21);
                    
                    //Baja gancho (CUERDA NO SE MUEVE)
                    TranslateTransition trasGancho11 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho11.setByY(165);
                    movGancho.getChildren().add(trasGancho11);
                    TranslateTransition trasCaja5 = new TranslateTransition(Duration.millis(velocidad), cajasAnchor.get(i));
                    trasCaja5.setByY(165);
                    movCajas.getChildren().add(trasCaja5);
                    
                    TranslateTransition trasVacioCuerda5 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda.getChildren().add(trasVacioCuerda5);
                    TranslateTransition trasVacioPinta22 = new TranslateTransition(Duration.millis(velocidad));
                    movPintalineas.getChildren().add(trasVacioPinta22);
                    
                    
                    
                    //Sube gancho(NADA MAS SE MUEVE)
                    TranslateTransition trasGancho12 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho12.setByY(-165);
                    movGancho.getChildren().add(trasGancho12);
                    
                    TranslateTransition trasVacioCuerda6 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda.getChildren().add(trasVacioCuerda6);
                    TranslateTransition trasVacioCaja7 = new TranslateTransition(Duration.millis(velocidad));
                    movCajas.getChildren().add(trasVacioCaja7);
                    TranslateTransition trasVacioPinta23 = new TranslateTransition(Duration.millis(velocidad));
                    movPintalineas.getChildren().add(trasVacioPinta23);
                                                                            
                    cajaAux = cajasAnchor.get(i);
                    cajasAnchor.set(i, cajasAnchor.get(i-1));
                    cajasAnchor.set(i-1,cajaAux);                                       
                   
                 int temp = arreglo.get(i);
                 arreglo.set(i, arreglo.get(i - 1));
                 arreglo.set(i - 1, temp);
                 intercambio = true;
                }else{
                    TranslateTransition trasPinta51 = new TranslateTransition(Duration.millis(velocidad),pintalinea);
                    trasPinta51.setToY(alturasLineas.get(5));
                    movPintalineas.getChildren().add(trasPinta51);

                    TranslateTransition trasVacioCuerda182 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda.getChildren().add(trasVacioCuerda182);
                    TranslateTransition trasVacioCaja282 = new TranslateTransition(Duration.millis(velocidad));
                    movCajas.getChildren().add(trasVacioCaja282);
                    TranslateTransition trasVacioGancho42 = new TranslateTransition(Duration.millis(velocidad));
                    movGancho.getChildren().add(trasVacioGancho42);
                }
               
                TranslateTransition trasPinta8 = new TranslateTransition(Duration.millis(velocidad),pintalinea);
                trasPinta8.setToY(alturasLineas.get(7));
                movPintalineas.getChildren().add(trasPinta8);

                TranslateTransition trasVacioCuerda183 = new TranslateTransition(Duration.millis(velocidad));
                movCuerda.getChildren().add(trasVacioCuerda183);
                TranslateTransition trasVacioCaja283 = new TranslateTransition(Duration.millis(velocidad));
                movCajas.getChildren().add(trasVacioCaja283);
                TranslateTransition trasVacioGancho43 = new TranslateTransition(Duration.millis(velocidad));
                movGancho.getChildren().add(trasVacioGancho43);
               
            }
         inicio++;
         imprimeArreglo(arreglo);
         System.out.println("");
        
        
         }
        
        movPintalineas.play();
        movCajas.play();
        movGancho.play();
        movCuerda.play();
        
        
        Button masvelocidad = new Button ("+ velocidad");
        Button menosvelocidad = new Button ("- velocidad");
        masvelocidad.setOnAction(e -> {
            aumentarRate();
            movPintalineas.setRate(this.rate);
            movCajas.setRate(this.rate);
            movCuerda.setRate(this.rate);
            movGancho.setRate(this.rate);
        });
        menosvelocidad.setOnAction(e -> {
            disminuirRate();
            movPintalineas.setRate(this.rate);
            movCajas.setRate(this.rate);
            movCuerda.setRate(this.rate);
            movGancho.setRate(this.rate);
        });
        anchor.getChildren().add(masvelocidad);
        menosvelocidad.setLayoutX(1180);
        masvelocidad.setLayoutX(1270);
        menosvelocidad.setLayoutY(20);
        masvelocidad.setLayoutY(20);
        masvelocidad.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        menosvelocidad.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        anchor.getChildren().add(menosvelocidad);
        
        
        System.out.println("ARREGLO ORDENADO:");
        imprimeArreglo(arreglo);
    }
    
    private Set<AnchorPane> vagonesUtilizados;
    public void Seleccion (ArrayList<Integer> arreglo, int numerodevagones, ArrayList<AnchorPane> vagonesAnchor,AnchorPane anchor, ArrayList<Double> coordenadasX){
        Rectangle pintalinea = new Rectangle(0,0,450,20);
        pintalinea.setFill(Color.ORANGE);
        anchor=PseudocodigoSeleccion(anchor, arreglo,pintalinea);
        
        ArrayList<Integer> alturasLineas = new ArrayList();
        for (int i = 1; i <= 3; i++) {
            alturasLineas.add((i*25)-15);
        }
        
        Lapiz lapiz = new Lapiz(0,0);
        
        /*DESCRIPCIÓN DE OBJETOS DE LAS ANIMACIONES
            locomotoraIzq: locomotora que esta a la izquierda en la vía principal
            locomotoraDer: locomotora que esta a la derecha en la vía principal
            locomotoraAux: locomotora auxiliar que esta en la vía auxiliar
            vagonI: vagón a intercambiar que se encuentra a la izquierda al incio del intercambio
            vagonR: vagón a intercambiar que se encuentre a la derecha al incio del intercambio (el vagón de menor número que se encontró)
        */
        
        //Creación de las locomotoras
        AnchorPane locomotoraDer = lapiz.dibujarLocomotora(anchor, 2100, 492); 
        AnchorPane locomotoraIzq = lapiz.dibujarLocomotora(anchor, -290, 492);
        locomotoraIzq.setRotate(180);
        AnchorPane locomotoraAux = lapiz.dibujarLocomotora(anchor, 1740, 35);
        locomotoraAux.setRotate(-27);
        
        int duracion = 1000;
        
        SequentialTransition seqPintaLinea = new SequentialTransition();
        SequentialTransition seqVagones = new SequentialTransition();
        SequentialTransition seqLocIzq = new SequentialTransition();
        SequentialTransition seqLocDer = new SequentialTransition();
        SequentialTransition seqLocAux = new SequentialTransition();
        
        
        anchor.setScaleX(0.8);
        anchor.setScaleY(0.8);
        
        
        
        double separacion = 1100;
        
        double ayuda;
        int num_iteracion = 0;
        
        ArrayList <Double> coordenadas_usadas = new ArrayList();
        ArrayList <AnchorPane> vagones_usados = new ArrayList();
        AnchorPane vagonAux;
        vagonesUtilizados = new HashSet<>();
        double agregado = 0;
        int indice = 0;
        //System.out.println("Arreglo sin ordenar: " + arreglo);
        for (int i = 0; i < arreglo.size() - 1; i++) {
            int minIndex = i;
            //REINICIO PINTALINEA
            TranslateTransition movPinta1 = new TranslateTransition(Duration.millis(duracion), pintalinea);
            movPinta1.setToY(alturasLineas.get(1));
            seqPintaLinea.getChildren().add(movPinta1);
            
            //MOVIMIENTOS VACIOS NECESARIOS
                TranslateTransition movVacio0 = new TranslateTransition(Duration.millis(duracion));
                seqVagones.getChildren().add(movVacio0);
                seqLocIzq.getChildren().add(movVacio0);
                seqLocDer.getChildren().add(movVacio0);
                seqLocAux.getChildren().add(movVacio0);

            // Encuentra el índice del elemento mínimo en el subarreglo restante
            for (int j = i + 1; j < arreglo.size(); j++) {
                if (arreglo.get(j) < arreglo.get(minIndex)) {
                    minIndex = j;
                }
            }

            // Intercambia el elemento mínimo con el elemento actual
            if(minIndex!=i){
                //REINICIO PINTALINEA
                    TranslateTransition movPinta2 = new TranslateTransition(Duration.millis(duracion), pintalinea);
                    movPinta2.setToY(alturasLineas.get(2));
                    seqPintaLinea.getChildren().add(movPinta2);
            
                //MOVIMIENTOS VACIOS NECESARIOS
                    TranslateTransition movVacio01 = new TranslateTransition(Duration.millis(duracion));
                    seqVagones.getChildren().add(movVacio01);
                    seqLocIzq.getChildren().add(movVacio01);
                    seqLocDer.getChildren().add(movVacio01);
                    seqLocAux.getChildren().add(movVacio01);
                
                
                
                
                
                
                AnchorPane vagonR = vagonesAnchor.get(minIndex);
                AnchorPane vagonI = vagonesAnchor.get(i);
                if(vagonesUtilizados.contains(vagonR)){
                        System.out.println("");
                        System.out.println("USADO ANTES: "+arreglo.get(minIndex)+" ("+num_iteracion+")");
                }
                //System.out.println("VAGONES A INTERCAMBIAR: "+arreglo.get(i)+" Y "+arreglo.get(minIndex));
                int temp = arreglo.get(i);
                arreglo.set(i, arreglo.get(minIndex));
                arreglo.set(minIndex, temp);

                //INTERCAMBIO DE VAGONES
                /*
                TranslateTransition movPrueba = new TranslateTransition(Duration.millis(duracion),vagonI);
                movPrueba.setByY(100);
                seqVagones.getChildren().add(movPrueba); 
                */


                //Solo si vagonR NO es el último de los vagones, se mueven los vagones a su derecha,ya que en caso contrario, no hay vagones a la derecha de vagonR que mover
                if(minIndex!=arreglo.size()-1){
                    //1.- locomotoraDer se mueve hasta la derecha del último vagón (se mueve a la izquierda, nada más se mueve)
                        //MOVIMIENTOS A REALIZAR
                            TranslateTransition movLocDerecha = new TranslateTransition(Duration.millis(duracion),locomotoraDer);
                            movLocDerecha.setByX(-(2250-coordenadasX.get(coordenadasX.size()-1)));
                            seqLocDer.getChildren().add(movLocDerecha);

                        //MOVIMIENTOS VACIOS NECESARIOS
                            TranslateTransition movVacio1 = new TranslateTransition(Duration.millis(duracion));
                            seqVagones.getChildren().add(movVacio1); 
                            seqLocIzq.getChildren().add(movVacio1);
                            seqLocAux.getChildren().add(movVacio1);
                            seqPintaLinea.getChildren().add(movVacio1);

                    //2.- locomotoraDer se lleva a los vagones a la derecha de vagonR (se mueve a al derecha junto con los vagones mencionados)
                        //MOVIMIENTOS A REALIZAR
                            TranslateTransition movLocDerecha2 = new TranslateTransition(Duration.millis(duracion),locomotoraDer);
                            movLocDerecha2.setToX(-20);
                            seqLocDer.getChildren().add(movLocDerecha2);

                            ParallelTransition movVagonesDerecha = new ParallelTransition();
                            for (int k = arreglo.size()-1, ind = 0; k > minIndex; k--, ind++){
                                TranslateTransition movVagonDer = new TranslateTransition (Duration.millis(duracion),vagonesAnchor.get(k));
                                movVagonDer.setByX(2210-coordenadasX.get(k)-((separacion/coordenadasX.size())*ind));
                                movVagonesDerecha.getChildren().add(movVagonDer);
                            }
                            seqVagones.getChildren().add(movVagonesDerecha);

                        //MOVIMIENTOS VACIOS NECESARIOS
                            TranslateTransition movVacio2 = new TranslateTransition(Duration.millis(duracion));
                            seqLocIzq.getChildren().add(movVacio2);
                            seqLocAux.getChildren().add(movVacio2);
                            seqPintaLinea.getChildren().add(movVacio2);
                }
                if(vagonesUtilizados.contains(vagonR)){
                        agregado = coordenadas_usadas.get(vagones_usados.indexOf(vagonR)) ;
                        indice++;
                }else{ agregado = 0;}

                //3.- locomotoraAux se mueve hasta la derecha de vagonR (locomotoraAux se mueve en curva descendente a la izquierda, nada más se mueve)
                    //MOVIMIENTOS A REALIZAR
                        Path path1 = new Path();
                        path1.getElements().add(new MoveTo(30, 30));
                        path1.getElements().add(new LineTo(-880, 475));
                        path1.getElements().add(new LineTo((vagonR.getLayoutX()-1700)+(separacion/coordenadasX.size())+agregado,475));                  
                        PathTransition pathLocAux1 = new PathTransition(Duration.millis(duracion), path1, locomotoraAux);
                        pathLocAux1.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);

                        seqLocAux.getChildren().add(pathLocAux1);

                    //MOVIMIENTOS VACIOS NECESARIOS
                        TranslateTransition movVacio3 = new TranslateTransition(Duration.millis(duracion));
                        seqLocDer.getChildren().add(movVacio3);
                        seqLocIzq.getChildren().add(movVacio3);
                        seqVagones.getChildren().add(movVacio3);
                        seqPintaLinea.getChildren().add(movVacio3);
                
                //SE COMPORTA DIFERENTE CUANDO vagonR FUE USADO ANTES COMO vagonI
                //4.- locomotoraAux se lleva a vagonR (se mueve en curva ascendente a la derecha junto con vagonR)
                
                    //MOVIMIENTOS A REALIZAR
                        Path path2 = new Path();
                        path2.getElements().add(new MoveTo((vagonR.getLayoutX()-1700)+(separacion/coordenadasX.size())+agregado,475));
                        path2.getElements().add(new LineTo(-880, 475));
                        path2.getElements().add(new LineTo(50,50));
                        PathTransition pathLocAux2 = new PathTransition(Duration.millis(duracion), path2, locomotoraAux);
                        pathLocAux2.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
                        seqLocAux.getChildren().add(pathLocAux2);

                        Path path = new Path();
                        path.getElements().add(new MoveTo(0+agregado, 0));
                        path.getElements().add(new LineTo(((separacion/numerodevagones)*(vagonesAnchor.size()-minIndex)+20)+agregado,0));
                        path.getElements().add(new LineTo(((separacion/numerodevagones)*(vagonesAnchor.size()-minIndex)+825)+agregado,-380));                
                        PathTransition pathTransition = new PathTransition(Duration.millis(duracion), path, vagonR);
                        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);

                        seqVagones.getChildren().add(pathTransition);
                        

                        num_iteracion++;
                    //MOVIMIENTOS VACIOS NECESARIOS
                    TranslateTransition movVacio4 = new TranslateTransition(Duration.millis(duracion));
                    seqLocDer.getChildren().add(movVacio4);
                    seqLocIzq.getChildren().add(movVacio4);
                    seqPintaLinea.getChildren().add(movVacio4);
                    
                
                    //5.- locomotoraDer se mueve junto con los vagones que tenga, hasta donde estaba vagonR(se mueve a la izquierda junto con los vagones que tenga en ese momento)
                        //MOVIMIENTOS A REALIZAR
                        TranslateTransition movLocDer3 = new TranslateTransition(Duration.millis(duracion),locomotoraDer);
                        movLocDer3.setByX(-(2250-coordenadasX.get(coordenadasX.size()-1)));
                        seqLocDer.getChildren().add(movLocDer3);
                        if(minIndex!=arreglo.size()-1){
                            ParallelTransition movVagonesIzq1 = new ParallelTransition();
                            for (int k = arreglo.size()-1, ind = 0; k > minIndex; k--, ind++){
                                TranslateTransition movVagonIzq = new TranslateTransition (Duration.millis(duracion),vagonesAnchor.get(k));
                                movVagonIzq.setByX(-(2210-coordenadasX.get(k)-((separacion/coordenadasX.size())*ind)+(separacion/numerodevagones)));
                                movVagonesIzq1.getChildren().add(movVagonIzq);
                            }
                                seqVagones.getChildren().add(movVagonesIzq1);
                        }else{
                            TranslateTransition movVacio05 = new TranslateTransition(Duration.millis(duracion));
                            seqVagones.getChildren().add(movVacio05);
                        }

                        //MOVIMIENTOS VACIOS NECESARIOS
                         TranslateTransition movVacio5 = new TranslateTransition(Duration.millis(duracion));
                         seqLocIzq.getChildren().add(movVacio5);
                         seqLocAux.getChildren().add(movVacio5);
                         seqPintaLinea.getChildren().add(movVacio5);
                

                    //6.- locomotoraDer se lleva a todos los vagones, incluido vagonI(se mueve a la derecha junto con todos los vagones menos vagonR (ciclo con condicional que excluya a vagonR))
                        //MOVIMIENTOS NECESARIOS
                            TranslateTransition movLocDer4 = new TranslateTransition(Duration.millis(duracion),locomotoraDer);
                            movLocDer4.setByX(2250-coordenadasX.get(coordenadasX.size()-1));
                            seqLocDer.getChildren().add(movLocDer4);

                            ParallelTransition movVagonesIzq2 = new ParallelTransition();
                            for (int k = arreglo.size()-1, ind = 0; k >= i; k--, ind++){
                                if(k!=minIndex){
                                    TranslateTransition movVagonDer = new TranslateTransition (Duration.millis(duracion),vagonesAnchor.get(k));
                                    movVagonDer.setByX(2210-coordenadasX.get(k)-((separacion/coordenadasX.size())*ind));
                                    movVagonesIzq2.getChildren().add(movVagonDer);
                                }
                            }
                            seqVagones.getChildren().add(movVagonesIzq2);        

                        //MOVIMIENTOS VACIOS NECESARIOS
                        TranslateTransition movVacio6 = new TranslateTransition(Duration.millis(duracion));
                        seqLocIzq.getChildren().add(movVacio6);
                        seqLocAux.getChildren().add(movVacio6);
                        seqPintaLinea.getChildren().add(movVacio6);
                

                //SE COMPORTA DIFERENTE CUANDO vagonR FUE USADO ANTES COMO vagonI
                //7.- locomotoraAux trae de vuelta a vagonR hasta donde estaba vagonI(se mueve locomotoraAux junto con vagonR en curva descendente a la izquierda)
                    //MOVIMIENTOS A REALIZAR
                        Path path3 = new Path();
                        path3.getElements().add(new MoveTo(40, 40));
                        path3.getElements().add(new LineTo(-880,475));
                        path3.getElements().add(new LineTo((vagonI.getLayoutX()-1740)+((separacion/numerodevagones)*2)+agregado,475));               
                        PathTransition pathTransition1 = new PathTransition(Duration.millis(duracion), path3, locomotoraAux);
                        pathTransition1.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
                        seqLocAux.getChildren().add(pathTransition1);

                        Path path4 = new Path();
                        path4.getElements().add(new MoveTo(((separacion/numerodevagones)*(vagonesAnchor.size()-minIndex)+825)+agregado,-380));
                        path4.getElements().add(new LineTo(((separacion/numerodevagones)*(vagonesAnchor.size()-minIndex)+20)+agregado,30));
                        path4.getElements().add(new LineTo(-(coordenadasX.get(minIndex)-coordenadasX.get(i))+((separacion/numerodevagones)/2)+agregado,30));               
                        PathTransition pathTransition2 = new PathTransition(Duration.millis(duracion), path4, vagonR);
                        pathTransition2.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT); 
                        seqVagones.getChildren().add(pathTransition2);

                        TranslateTransition movVacio7 = new TranslateTransition(Duration.millis(duracion));
                        seqLocDer.getChildren().add(movVacio7);
                        seqLocIzq.getChildren().add(movVacio7);
                        seqPintaLinea.getChildren().add(movVacio7);

                        RotateTransition rotateTransition0 = new RotateTransition(Duration.ONE, vagonR);
                        rotateTransition0.setByAngle(180);
                        seqVagones.getChildren().add(rotateTransition0);

                //8.- locomotoraAux se devuelve a su poscisión original(se mueve en curva ascendente a la derecha)
                    //MOVIMIENTOS A REALIZAR
                        Path path5 = new Path();
                        path5.getElements().add(new MoveTo((vagonI.getLayoutX()-1740)+(separacion/coordenadasX.size()*2),475));
                        path5.getElements().add(new LineTo(-880, 475));
                        path5.getElements().add(new LineTo(40,40));
                        PathTransition pathLocAux3 = new PathTransition(Duration.millis(duracion), path5, locomotoraAux);
                        pathLocAux3.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
                        seqLocAux.getChildren().add(pathLocAux3);
                    //MOVIMIENTOS VACIOS NECESARIOS
                    TranslateTransition movVacio8 = new TranslateTransition(Duration.millis(duracion));
                    seqLocDer.getChildren().add(movVacio8);
                    seqLocIzq.getChildren().add(movVacio8);
                    seqVagones.getChildren().add(movVacio8);
                    seqPintaLinea.getChildren().add(movVacio8);

                //9.- locomotoraIzq, junto con los vagones que ya estan ordenados y vagonR, se mueve hasta donde están todos los vagones(se mueve locomotoraIzq a la derecha junto con vagonR)
                    //MOVIMIENTOS A REALIZAR
                    TranslateTransition movLocIzq1 = new TranslateTransition(Duration.millis(duracion), locomotoraIzq);
                    movLocIzq1.setByX(2310-coordenadasX.get(0)-((separacion/coordenadasX.size())*numerodevagones)-(separacion/coordenadasX.size())*2);
                    seqLocIzq.getChildren().add(movLocIzq1);

                    ParallelTransition movVagonesDer = new ParallelTransition();
                    TranslateTransition movVagonR = new TranslateTransition (Duration.millis(duracion),vagonR);
                    movVagonR.setByX(2210-coordenadasX.get(0)-((separacion/coordenadasX.size())*numerodevagones));
                    movVagonesDer.getChildren().add(movVagonR);

                    if(i!=0){
                        for (int k = i-1,ind = i ; k >= 0; k--,ind++) {
                            TranslateTransition movVagon = new TranslateTransition(Duration.millis(duracion),vagonesAnchor.get(k));
                            movVagon.setByX((2210-coordenadasX.get(0)-((separacion/coordenadasX.size())*numerodevagones)));
                            movVagonesDer.getChildren().add(movVagon);
                        }
                    }
                    seqVagones.getChildren().add(movVagonesDer);

                    //MOVIMIENTOS VACIOS NECESARIOS
                    TranslateTransition movVacio9 = new TranslateTransition(Duration.millis(duracion));
                    seqLocDer.getChildren().add(movVacio9);
                    seqLocAux.getChildren().add(movVacio9);
                    seqPintaLinea.getChildren().add(movVacio9);


                //10.-locomotoraIzq se devuelve junto con vagonR y vagonI(se mueve locomotoraIzq a la izquierda junto con vagonR y vagonI)
                    //MOVIMIENTOS A REALIZAR
                    TranslateTransition movLocIzq2 = new TranslateTransition(Duration.millis(duracion), locomotoraIzq);
                    movLocIzq2.setByX(-(2310-coordenadasX.get(0)-((separacion/coordenadasX.size())*numerodevagones)-(separacion/coordenadasX.size())*2));
                    seqLocIzq.getChildren().add(movLocIzq2);

                    ParallelTransition movVagonesIzq = new ParallelTransition();

                    TranslateTransition movVagonI2 = new TranslateTransition (Duration.millis(duracion),vagonI);
                    movVagonI2.setByX(-(2210-coordenadasX.get(0)-((separacion/coordenadasX.size())*numerodevagones)));
                    movVagonesIzq.getChildren().add(movVagonI2);

                    TranslateTransition movVagonR1 = new TranslateTransition (Duration.millis(duracion),vagonR);
                    movVagonR1.setByX(-(2210-coordenadasX.get(0)-((separacion/coordenadasX.size())*numerodevagones)));
                    movVagonesIzq.getChildren().add(movVagonR1);

                    if(i!=0){
                        for (int k = i,ind = i ; k >= 0; k--,ind++) {
                            TranslateTransition movVagon = new TranslateTransition(Duration.millis(duracion),vagonesAnchor.get(k));
                            movVagon.setByX(-(2210-coordenadasX.get(0)-((separacion/coordenadasX.size())*numerodevagones)));
                            movVagonesIzq.getChildren().add(movVagon);
                        }
                    }
                    seqVagones.getChildren().add(movVagonesIzq);

                    //MOVIMIENTOS VACIOS NECESARIOS
                    TranslateTransition movVacio10 = new TranslateTransition(Duration.millis(duracion));
                    seqLocAux.getChildren().add(movVacio10);
                    seqLocDer.getChildren().add(movVacio10);
                    seqPintaLinea.getChildren().add(movVacio10);

                //11.-locomotoraAux viene a buscar a vagonI(locomotoraAux se mueve en curva descendiente a la izquierda, nada más se mueve)
                    //MOVIMIENTOS A REALIZAR
                        Path path6 = new Path();
                        path6.getElements().add(new MoveTo(20, 20));
                        path6.getElements().add(new LineTo(-880,475));
                        path6.getElements().add(new LineTo((vagonI.getLayoutX()-1740)+((separacion/numerodevagones)*2),475));               
                        PathTransition pathTransition3 = new PathTransition(Duration.millis(duracion), path6, locomotoraAux);
                        pathTransition3.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
                        seqLocAux.getChildren().add(pathTransition3);

                    //MOVIMIENTOS VACIOS NECESARIOS
                        TranslateTransition movVacio11 = new TranslateTransition(Duration.millis(duracion));
                        seqLocIzq.getChildren().add(movVacio11);
                        seqLocDer.getChildren().add(movVacio11);
                        seqVagones.getChildren().add(movVacio11);
                        seqPintaLinea.getChildren().add(movVacio11);


                //12.-locomotoraAux se lleva a vagonI(locomotoraAux junto con vagon I se mueven en curva ascendente a la derecha)
                    //MOVIMIENTOS A REALIZAR
                        Path path7 = new Path();
                        path7.getElements().add(new MoveTo((vagonI.getLayoutX()-1740)+((separacion/numerodevagones)*2),475));
                        path7.getElements().add(new LineTo(-880, 475));
                        path7.getElements().add(new LineTo(40,40));
                        PathTransition pathLocAux4 = new PathTransition(Duration.millis(duracion), path7, locomotoraAux);
                        pathLocAux4.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
                        seqLocAux.getChildren().add(pathLocAux4);

                        Path path8 = new Path();
                        path8.getElements().add(new MoveTo(0, 0));
                        path8.getElements().add(new LineTo(((separacion/numerodevagones)*(vagonesAnchor.size()-i))+20,0));
                        path8.getElements().add(new LineTo(((separacion/numerodevagones)*(vagonesAnchor.size()-i)+825),-380));                
                        PathTransition pathTransition4 = new PathTransition(Duration.millis(duracion), path8, vagonI);
                        pathTransition4.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
                        seqVagones.getChildren().add(pathTransition4);


                    //MOVIMIENTOS VACIOS NECESARIOS
                        TranslateTransition movVacio12 = new TranslateTransition(Duration.millis(duracion));
                        seqLocDer.getChildren().add(movVacio12);
                        seqLocIzq.getChildren().add(movVacio12);
                        seqPintaLinea.getChildren().add(movVacio12);

                //13.-locomotoraDer trae de vuelta a todos los vagones(se mueve a la izquierda locomotoraDer junto con todos los vagones que tenga en ese momento(excluye a vagonI y vagonR))
                    //MOVIMIENTOS A REALIZAR

                    TranslateTransition movLocDer1 = new TranslateTransition(Duration.millis(duracion),locomotoraDer);
                    movLocDer1.setToX((vagonesAnchor.get(vagonesAnchor.size()-1).getLayoutX()-locomotoraDer.getLayoutX())+(separacion/coordenadasX.size())-50);
                    seqLocDer.getChildren().add(movLocDer1);

                    ParallelTransition movVagonesIzq3 = new ParallelTransition();
                    for (int k = coordenadasX.size()-1, ind=0; k > i; k--,ind++) {
                        if(k!=i && k!=minIndex){
                            TranslateTransition movVagon = new TranslateTransition(Duration.millis(duracion),vagonesAnchor.get(k));
                            movVagon.setByX(-(2210-coordenadasX.get(k)-((separacion/coordenadasX.size())*ind)));
                            movVagonesIzq3.getChildren().add(movVagon);
                        }
                    }
                    seqVagones.getChildren().add(movVagonesIzq3);

                    //MOVIMIENTOS VACIOS NECESARIOS
                        TranslateTransition movVacio13 = new TranslateTransition(Duration.millis(duracion));
                        seqLocAux.getChildren().add(movVacio13);
                        seqLocIzq.getChildren().add(movVacio13);
                        seqPintaLinea.getChildren().add(movVacio13);

                //14.-locomotoraDer se devuelve a su posición junto con los vagones que estuvieran a la derecha de vagonR al principio del intercambio(se mueve a la derecha locomotoraDer junto con los vagones mencionados)
                    //MOVIMIENTOS A RELIZAR
                        TranslateTransition movLocDer2 = new TranslateTransition(Duration.millis(duracion),locomotoraDer);
                        movLocDer2.setByX(2190-coordenadasX.get(coordenadasX.size()-1));
                        seqLocDer.getChildren().add(movLocDer2);
                        if(minIndex!=arreglo.size()-1){
                            ParallelTransition movVagonesDer1 = new ParallelTransition();
                            for (int k = coordenadasX.size()-1, ind=0; k > minIndex ; k--,ind++) {
                                if(k!=i && k!=minIndex){
                                    TranslateTransition movVagon = new TranslateTransition(Duration.millis(duracion),vagonesAnchor.get(k));
                                    movVagon.setByX((2210-coordenadasX.get(k)-((separacion/coordenadasX.size())*ind)));
                                    movVagonesDer1.getChildren().add(movVagon);
                                }
                            }
                            seqVagones.getChildren().add(movVagonesDer1);
                        }else{
                            TranslateTransition movVacio14 = new TranslateTransition(Duration.millis(duracion));
                            seqVagones.getChildren().add(movVacio14);
                        }

                    //MOVIMIENTS VACIOS NECESARIOS
                        TranslateTransition movVacio14 = new TranslateTransition(Duration.millis(duracion));
                        seqLocAux.getChildren().add(movVacio14);
                        seqLocIzq.getChildren().add(movVacio14);
                        seqPintaLinea.getChildren().add(movVacio14);
                        
                        
                //15.-locomotoraAux viene a dejar a vagonI en la poscicion donde estaba vagonR en un principio(locomotoraAux se mueve en curva descendente a la izquierda junto con vagonI)
                    //MOVIMIENTOS A REALIZAR
                         
                        
                        Path path9 = new Path();
                        path9.getElements().add(new MoveTo(20, 20));
                        path9.getElements().add(new LineTo(-880, 475));
                        path9.getElements().add(new LineTo((vagonR.getLayoutX()-1740)+(separacion/coordenadasX.size()*2),475));                  
                        PathTransition pathLocAux5 = new PathTransition(Duration.millis(duracion), path9, locomotoraAux);
                        pathLocAux5.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
                        seqLocAux.getChildren().add(pathLocAux5);

                        Path path10 = new Path();
                        path10.getElements().add(new MoveTo(((separacion/numerodevagones)*(vagonesAnchor.size()-i)+825),-380));
                        path10.getElements().add(new LineTo(((separacion/numerodevagones)*(vagonesAnchor.size()-i))+20,30));
                        path10.getElements().add(new LineTo(-(coordenadasX.get(i)-coordenadasX.get(minIndex))+(separacion/numerodevagones)/2,30));               
                        PathTransition pathTransition5 = new PathTransition(Duration.millis(duracion), path10, vagonI);
                        pathTransition5.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT); 
                        seqVagones.getChildren().add(pathTransition5);

                        RotateTransition rotateTransition = new RotateTransition(Duration.ONE, vagonI);
                        rotateTransition.setByAngle(180);
                        seqVagones.getChildren().add(rotateTransition);
                        
                        

                    //MOVIMIENTOS VACIOS NECESARIOS
                        TranslateTransition movVacio15 = new TranslateTransition(Duration.millis(duracion));
                        seqLocDer.getChildren().add(movVacio15);
                        seqLocIzq.getChildren().add(movVacio15);
                        seqPintaLinea.getChildren().add(movVacio15);
                //16.-locomotoraAux se devuelve a su posición(locomotoraAux se mueve en curva ascendente a la derecha, nada más se mueve)
                    //MOVIMIENTOS A REALIZAR
                        Path path11 = new Path();
                        path11.getElements().add(new MoveTo((vagonR.getLayoutX()-1740)+(separacion/coordenadasX.size()*2),475));
                        path11.getElements().add(new LineTo(-920, 475));
                        path11.getElements().add(new LineTo(40,40));
                        PathTransition pathLocAux6 = new PathTransition(Duration.millis(duracion), path11, locomotoraAux);
                        pathLocAux6.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
                        seqLocAux.getChildren().add(pathLocAux6);

                    //MOVIMIENTOS VACIOS NECESARIOS
                        TranslateTransition movVacio16 = new TranslateTransition(Duration.millis(duracion));
                        seqVagones.getChildren().add(movVacio16);
                        seqLocDer.getChildren().add(movVacio16);
                        seqLocIzq.getChildren().add(movVacio16);
                        seqPintaLinea.getChildren().add(movVacio16);
                
                if(minIndex!=arreglo.size()-1){
                    //17.-locomotoraDer trae de vuelta a los vagones que tenía hasta ese momento(se mueve a la izquierda junto con los vagones que estaban a la derecha de vagonR en un principio)
                        //MOVMIENTOS A REALIZAR
                            TranslateTransition movLocDer5 = new TranslateTransition(Duration.millis(duracion),locomotoraDer);
                            movLocDer5.setByX(-(2190-coordenadasX.get(coordenadasX.size()-1)));
                            seqLocDer.getChildren().add(movLocDer5);

                            ParallelTransition movVagonesDer2 = new ParallelTransition();
                            for (int k = coordenadasX.size()-1, ind=0; k > minIndex ; k--,ind++) {
                                if(k!=i && k!=minIndex){
                                    TranslateTransition movVagon = new TranslateTransition(Duration.millis(duracion),vagonesAnchor.get(k));
                                    movVagon.setByX(-(2210-coordenadasX.get(k)-((separacion/coordenadasX.size())*(ind+1))));
                                    movVagonesDer2.getChildren().add(movVagon);
                                }
                            }
                            seqVagones.getChildren().add(movVagonesDer2);

                        //MOVIMIENTOS VACIOS NECESARIOS
                            TranslateTransition movVacio17 = new TranslateTransition(Duration.millis(duracion));
                            seqLocIzq.getChildren().add(movVacio17);
                            seqLocAux.getChildren().add(movVacio17);
                            seqPintaLinea.getChildren().add(movVacio17);

                    //18.-locomotoraDer se devuelve a su posición incial (locomotoraDer se mueve a la derecha, nada mas se mueve)
                        //MOVIMIENTOS A REALIZAR
                            TranslateTransition movLocDer6 = new TranslateTransition(Duration.millis(duracion),locomotoraDer);
                            movLocDer6.setByX(2210-coordenadasX.get(coordenadasX.size()-1));
                            seqLocDer.getChildren().add(movLocDer6);

                        //MOVIMIENTOS VACIOS NECESARIOS
                            TranslateTransition movVacio18 = new TranslateTransition(Duration.millis(duracion));
                            seqVagones.getChildren().add(movVacio18);
                            seqLocAux.getChildren().add(movVacio18);
                            seqLocIzq.getChildren().add(movVacio18);
                            seqPintaLinea.getChildren().add(movVacio18);
                }
                
                vagones_usados.add(vagonI);
                vagonesUtilizados.add(vagonI);
                coordenadas_usadas.add(coordenadasX.get(minIndex)-coordenadasX.get(i));
                
                vagonAux = vagonesAnchor.get(minIndex);
                vagonesAnchor.set(minIndex, vagonesAnchor.get(i));
                vagonesAnchor.set(i, vagonAux);
                
                
                
            }    
        }

        //System.out.println("Arreglo ordenado: " + arreglo);  // Para testear si está bien implementado
        
        seqPintaLinea.play();
        seqVagones.play();
        seqLocIzq.play();
        seqLocDer.play();
        seqLocAux.play();
        
        Button masvelocidad = new Button ("+ velocidad");
        Button menosvelocidad = new Button ("- velocidad");
        masvelocidad.setOnAction(e -> {
            aumentarRate();
            seqPintaLinea.setRate(this.rate);
            seqVagones.setRate(this.rate);
            seqLocIzq.setRate(this.rate);
            seqLocDer.setRate(this.rate);
            seqLocAux.setRate(this.rate);
        });
        menosvelocidad.setOnAction(e -> {
            disminuirRate();
            seqPintaLinea.setRate(this.rate);
            seqVagones.setRate(this.rate);
            seqLocIzq.setRate(this.rate);
            seqLocDer.setRate(this.rate);
            seqLocAux.setRate(this.rate);
        });
        anchor.getChildren().add(masvelocidad);
        menosvelocidad.setLayoutX(1180);
        masvelocidad.setLayoutX(1270);
        menosvelocidad.setLayoutY(20);
        masvelocidad.setLayoutY(20);
        masvelocidad.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        menosvelocidad.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        anchor.getChildren().add(menosvelocidad);
    
    }
      
    private void resaltarLineaCodigo(Text[] etiquetasCodigo, int indiceLinea) {
        for (int i = 0; i < etiquetasCodigo.length; i++) {
            if (i == indiceLinea) {
                etiquetasCodigo[i].setFill(Color.BLACK);
            } else {
                etiquetasCodigo[i].setFill(Color.BLACK);
            }
        }
    }
    
    public AnchorPane PseudocodigoInsercion(AnchorPane Anchor, ArrayList <Integer> caja, Rectangle rectangulo) {
        ArrayList <Integer> arreglo = new ArrayList();
        
        
        
        for(int i=0;i<caja.size();i++){ 
            arreglo.add(caja.get(i));
        }
        
        
        Text[] etiquetasCodigo = {
                new Text(" Para i = 1 hasta n-1 hacer:"),
                new Text("     j = i"),
                new Text("     mientras j > 0 y A[j-1] > A[j] hacer:"),
                new Text("         intercambiar A[j] y A[j-1]"),
                new Text("         j = j - 1")
        };
        
        for (int i = 1; i <= 5; i++) {
            etiquetasCodigo[i-1].setLayoutY(i*25);
        }
        
        Font font = new Font(15); // Crear un objeto Font con tamaño de fuente 18
        for (Text t : etiquetasCodigo) {
            t.setFont(font); // Establecer la fuente en cada instancia de Text
        }
        
        Text etiquetaArreglo = new Text(arreglo.toString());
        
        etiquetaArreglo.setLayoutY(155);
        
        AnchorPane root = new AnchorPane();
        
        
        
        root.getChildren().add(rectangulo);
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
    
    public AnchorPane PseudocodigoBurbuja(AnchorPane Anchor, ArrayList <Integer> caja,Rectangle pintalinea) {
        ArrayList <Integer> arreglo = new ArrayList();
        
        for(int i=0;i<caja.size();i++){ 
            arreglo.add(caja.get(i));
        }
      
        Text[] etiquetasCodigo = {
        new Text(" Para i = 0 hasta n-1 hacer:"),
        new Text("     Para j = 0 hasta n-i-1 hacer:"),
        new Text("         Si A[j] > A[j+1] entonces intercambiar A[j] y A[j+1]")
        };
        
        for (int i = 1; i <= 3; i++) {
            etiquetasCodigo[i-1].setLayoutY(i*25);
        }
        
        
        Font font = new Font(15); // Crear un objeto Font con tamaño de fuente 18
        for (Text t : etiquetasCodigo) {
            t.setFont(font); // Establecer la fuente en cada instancia de Text
        }
     
        Text etiquetaArreglo = new Text(arreglo.toString());
        etiquetaArreglo.setLayoutY(100);
        
        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(pintalinea);
        root.getChildren().addAll(etiquetasCodigo);
        root.getChildren().add(etiquetaArreglo);
        
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                for (int i = 0; i < arreglo.size() - 1; i++) {

            
            Thread.sleep(TIEMPO_ESPERA*7);

            for (int j = 0; j < arreglo.size() - i - 1; j++) {
                if (arreglo.get(j) > arreglo.get(j + 1)) {
                    int temp = arreglo.get(j);
                    arreglo.set(j, arreglo.get(j + 1));
                    arreglo.set(j + 1, temp);

                    
                    Thread.sleep(TIEMPO_ESPERA*7);


                   
                }
            }
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
        root.setPrefSize(290,120); 
        // Crear un borde con un ancho de 2 píxeles y un color rojo 
        Border border = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,  
        CornerRadii.EMPTY, BorderWidths.FULL)); 
 
    // Establecer el borde en el VBox 
    root.setBorder(border); 
        Anchor.getChildren().add(root);
        return Anchor; 
    }
    
    public AnchorPane PseudocodigoCocktail(AnchorPane Anchor, ArrayList <Integer> caja, Rectangle pintalineas) {
        ArrayList <Integer> arreglo = new ArrayList();
        
        for(int i=0;i<caja.size();i++){ 
            arreglo.add(caja.get(i));
        }
        
        
        Text[] etiquetasCodigo = {
            new Text(" Iniciar i en 0 y j en n-1"),
            new Text(" Mientras i < j, hacer:"),
            new Text("     Para k = i hasta j-1 hacer:"),
            new Text("         Si A[k] > A[k+1] entonces intercambiar A[k] y A[k+1]"),
            new Text("     Decrementar j"),
            new Text("     Para k = j-1 hasta i hacer:"),
            new Text("         Si A[k] > A[k+1] entonces intercambiar A[k] y A[k+1]"),
            new Text("     Incrementar i"),
        };
        
        for (int i = 1; i <= 8; i++) {
            etiquetasCodigo[i-1].setLayoutY(i*25);
        }
        
        Font font = new Font(15); // Crear un objeto Font con tamaño de fuente 18
        for (Text t : etiquetasCodigo) {
            t.setFont(font); // Establecer la fuente en cada instancia de Text
        }
     
        Text etiquetaArreglo = new Text(arreglo.toString());
        etiquetaArreglo.setLayoutY(225);
        
        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(pintalineas);
        root.getChildren().addAll(etiquetasCodigo);
        root.getChildren().add(etiquetaArreglo);
        
        Task<Void> task = new Task<Void>() {
        @Override
        protected Void call() throws Exception {
            int i = 0;
            int j = arreglo.size() - 1;

            while (i < j) {
                Thread.sleep(TIEMPO_ESPERA);

                for (int k = i; k < j; k++) {
                    if (arreglo.get(k) > arreglo.get(k + 1)) {
                        int temp = arreglo.get(k);
                        arreglo.set(k, arreglo.get(k + 1));
                        arreglo.set(k + 1, temp);

                        Thread.sleep(TIEMPO_ESPERA);

                        
                    }
                }

                Thread.sleep(TIEMPO_ESPERA);

                j--;

                for (int k = j - 1; k >= i; k--) {
                    if (arreglo.get(k) > arreglo.get(k + 1)) {
                        int temp = arreglo.get(k);
                        arreglo.set(k, arreglo.get(k + 1));
                        arreglo.set(k + 1, temp);

                        Thread.sleep(TIEMPO_ESPERA);

                       
                    }
                }

                Thread.sleep(TIEMPO_ESPERA);

                i++;
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
        root.setLayoutY(115); 
        root.setPrefSize(290,120); 
        // Crear un borde con un ancho de 2 píxeles y un color rojo 
        Border border = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,  
        CornerRadii.EMPTY, BorderWidths.FULL)); 
 
    // Establecer el borde en el VBox 
    root.setBorder(border); 
        Anchor.getChildren().add(root);
        return Anchor; 
    }
    
    public AnchorPane PseudocodigoSeleccion(AnchorPane Anchor, ArrayList <Integer> arreglo, Rectangle pintalineas){
    
    AnchorPane root = new AnchorPane();
    root.getChildren().add(pintalineas);
        
    Text[] etiquetasCodigo = {
        new Text("Para i = 0 hasta n-1 hacer:"),
        new Text("   Encontrar el índice del mínimo elemento en el subarreglo no ordenado"),
        new Text("   Intercambiar el elemento mínimo con el elemento en la posición i"),
    };

    Font font = new Font(15); // Crear un objeto Font con tamaño de fuente 18
    for (Text t : etiquetasCodigo) {
        t.setFont(font); // Establecer la fuente en cada instancia de Text
    }
    

    for (int i = 1; i <= 3; i++) {
            etiquetasCodigo[i-1].setLayoutY(i*25);

    }

    Text etiquetaArreglo = new Text(arreglo.toString());
    etiquetaArreglo.setLayoutY(100);

    root.getChildren().addAll(etiquetasCodigo);
    root.getChildren().add(etiquetaArreglo);
    

    Task<Void> task = new Task<Void>() {
        @Override
        protected Void call() throws Exception {
            int n = arreglo.size();

            for (int i = 0; i < n - 1; i++) {
                int minIndex = i;
                resaltarLineaCodigo(etiquetasCodigo,1);
                Thread.sleep(TIEMPO_ESPERA);
                
                for (int j = i + 1; j < n; j++) {
                    if (arreglo.get(j) < arreglo.get(minIndex)) {
                        minIndex = j;
                    }
                }
                
                resaltarLineaCodigo(etiquetasCodigo,2);
                Thread.sleep(TIEMPO_ESPERA);
                
                if (minIndex != i) {
                    int temp = arreglo.get(i);
                    arreglo.set(i, arreglo.get(minIndex));
                    arreglo.set(minIndex, temp);
                    
                    resaltarLineaCodigo(etiquetasCodigo,3);
                    Thread.sleep(TIEMPO_ESPERA);
                    
                    etiquetaArreglo.setText(arreglo.toString());
                }
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
    root.setLayoutY(115);
    root.setPrefSize(290, 120);

    // Crear un borde con un ancho de 2 píxeles y un color rojo
    Border border = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
            CornerRadii.EMPTY, BorderWidths.FULL));

    // Establecer el borde en el VBox
    root.setBorder(border);
    root.setScaleX(1.5);
    root.setScaleY(1.5);
    Anchor.getChildren().add(root);
    return Anchor;
    } 
    
    public void imprimeArreglo(ArrayList <Integer> arreglo){
        System.out.print("[ ");
        for (int i = 0; i < arreglo.size(); i++) {System.out.print(arreglo.get(i)+" ");}
        System.out.println("]");
    }

    public int getAux() {return aux;}

    public void setAux(int aux) {this.aux = aux;}

    public int getOpcion() {return opcion;}

    public void setOpcion(int opcion) {this.opcion = opcion;} 
    
    public void disminuir(){this.aux--;}
    
    public void aumentar(){this.aux++;}
    
    public void insercion(){this.opcion=1;}
    
    public void burbuja(){this.opcion=2;}
    
    public void cocktail(){this.opcion=3;}
    
    public void selection(){this.opcion=4;}
    
    public void aumentarRate(){
        this.rate=rate+0.25;
        this.TIEMPO_ESPERA=(int)(this.TIEMPO_ESPERA-25);
    }
    
    public void disminuirRate(){
        if (this.rate>0.25){
            this.rate=rate-0.25;
            this.TIEMPO_ESPERA=(int)(this.TIEMPO_ESPERA-25);
        }
    }
}
