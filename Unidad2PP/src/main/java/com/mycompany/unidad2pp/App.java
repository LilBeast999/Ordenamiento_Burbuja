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
    public int aux=32;
   
public static final int TIEMPO_ESPERA = 200; 
    @Override
    public void start(Stage stage) {
       AnchorPane anchor = new AnchorPane();
       Scene scena1 = new Scene (anchor); 
       Stage stage1 = new Stage();
       
       stage1.setScene(scena1);
       
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
      
       anchor.getChildren().addAll(avanzar,retroceder,boton);
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
    