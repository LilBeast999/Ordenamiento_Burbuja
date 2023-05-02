package com.mycompany.unidad2pp;

import java.util.ArrayList;
import java.util.Random;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import javafx.animation.SequentialTransition;
import static javafx.application.Application.launch;
import javafx.concurrent.Task;
import javafx.scene.layout.VBox;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.text.*;
import javafx.scene.paint.Color;

/**
 * JavaFX App
 */
public class App extends Application {
    public int aux=20;
   
public static final int TIEMPO_ESPERA = 200; 
    @Override
    public void start(Stage stage) {
       
        Ordenamientos ordenamientos = new Ordenamientos();
        
       
       Button boton = new Button("reiniciar");
       Button retroceder = new Button("disminuye cajas");
       Button avanzar = new Button("aumenta cajas");
       
       boton.setOnAction(e -> {
        
         ordenamientos.miCodigo(stage,boton,retroceder,avanzar,this.aux);
         
        });
       
        retroceder.setOnAction(e -> {
         if (aux>17){  
         ordenamientos.miCodigo(stage,boton,retroceder,avanzar,this.aux);
         disminuir();
         }
        });
        
        avanzar.setOnAction(e -> {
        
            
         if (aux<=63){   
         ordenamientos.miCodigo(stage,boton,retroceder,avanzar,this.aux);
         aumentar();
         }
        });
       
       
       
       ordenamientos.miCodigo(stage,boton,retroceder,avanzar,this.aux);
       
        
    }

 
    
    public void disminuir(){
        this.aux--;
                
    
    
    }
    
    public void aumentar(){
        this.aux++;
    }
    

public static void main(String[] args) {
    launch(args);
}
    
    
    
    }
    