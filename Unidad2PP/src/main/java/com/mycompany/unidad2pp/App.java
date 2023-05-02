package com.mycompany.unidad2pp;

import java.util.ArrayList;
import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static javafx.application.Application.launch;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * JavaFX App
 */
public class App extends Application {
    public int aux=20;
   
public static final int TIEMPO_ESPERA = 200; 
    @Override
    public void start(Stage stage) {
       AnchorPane anchor = new AnchorPane();
       Scene scena1 = new Scene (anchor,500,500); 
       Stage stage1 = new Stage();
       
       stage1.setScene(scena1);
       
       Ordenamientos ordenamientos = new Ordenamientos();
        
       
       Button boton = new Button("Reiniciar");
       Button retroceder = new Button("Disminuye cajas");
       Button avanzar = new Button("Aumenta cajas");
       Button Insercion = new Button ("Algoritmo por insercion");
       Button Menu = new Button("Menu");
       
       boton.setOnAction(e -> {
        
         ordenamientos.miCodigo(stage,boton,retroceder,avanzar,Menu,this.aux);
         
        });
       
        retroceder.setOnAction(e -> {
         if (aux>17){  
         ordenamientos.miCodigo(stage,boton,retroceder,avanzar,Menu,this.aux);
         disminuir();
         }
        });
        
        avanzar.setOnAction(e -> {
        
            
         if (aux<=63){   
         ordenamientos.miCodigo(stage,boton,retroceder,avanzar,Menu,this.aux);
         aumentar();
         }
        });
        
        Menu.setOnAction(e -> {
            
            stage.hide();
            stage1.show();
            
            
         
        });
       
        Insercion.setOnAction(e -> {
           
            stage1.hide();
            ordenamientos.miCodigo(stage,boton,retroceder,avanzar,Menu,this.aux);  
            
   
        });
       
        Insercion.setLayoutX(200);
        Insercion.setLayoutY(200);
        anchor.getChildren().add(Insercion);
        
      
        
        stage1.show();

        
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
    