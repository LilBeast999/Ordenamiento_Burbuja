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
    public int opcion;
   
public static final int TIEMPO_ESPERA = 200; 
    @Override
    public void start(Stage stage) {
       AnchorPane anchor = new AnchorPane();
       Scene scena1 = new Scene (anchor,600,500); 
       Stage stage1 = new Stage();
       
       stage1.setScene(scena1);
       
       Ordenamientos ordenamientos = new Ordenamientos();
        
       
       Button boton = new Button("Reiniciar");
       Button retroceder = new Button("Disminuye cajas");
       Button avanzar = new Button("Aumenta cajas");
       Button Insercion = new Button ("Ordenamiento por insercion");
       Button Menu = new Button("Menu");
       Button Burbuja = new Button("Ordenamiento Burbuja");
       
       boton.setOnAction(e -> {
        
         ordenamientos.miCodigo(stage,boton,retroceder,avanzar,Menu,this.aux,this.opcion);
         
        });
       
        retroceder.setOnAction(e -> {
         if (aux>17){  
         ordenamientos.miCodigo(stage,boton,retroceder,avanzar,Menu,this.aux,this.opcion);
         disminuir();
         }
        });
        
        avanzar.setOnAction(e -> {
        
            
         if (aux<=63){   
         ordenamientos.miCodigo(stage,boton,retroceder,avanzar,Menu,this.aux,this.opcion);
         aumentar();
         }
        });
        
        Menu.setOnAction(e -> {
            
            stage.hide();
            stage1.show();
            
            
         
        });
       
        Insercion.setOnAction(e -> {
           
            stage1.hide();
            insercion();
            ordenamientos.miCodigo(stage,boton,retroceder,avanzar,Menu,this.aux,this.opcion);  
            
   
        });
        
        Burbuja.setOnAction(e -> {
           
            stage1.hide();
            burbuja();
            ordenamientos.miCodigo(stage,boton,retroceder,avanzar,Menu,this.aux,this.opcion);  
            
   
        });
       
        Insercion.setLayoutX(100);
        Insercion.setLayoutY(200);
        Burbuja.setLayoutX(300);
        Burbuja.setLayoutY(200);
        anchor.getChildren().add(Insercion);
        anchor.getChildren().add(Burbuja);
        
      
        
        stage1.show();

        
    }

 
    
    public void disminuir(){
        this.aux--;
                
    
    
    }
    
    public void aumentar(){
        this.aux++;
    }
    
    public void insercion(){
        this.opcion=1;
                
    
    
    }
    
    public void burbuja(){
        this.opcion=2;
    }
    
    
  
    

    public static void main(String[] args) {
       launch(args);
     }
    
    
}
    