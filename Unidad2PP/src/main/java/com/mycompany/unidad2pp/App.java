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
       Button Cocktail = new Button("Ordenamiento Cocktail");
 
       
       boton.setOnAction(e -> {
        
         ordenamientos.miCodigo(stage,boton,retroceder,avanzar,Menu,ordenamientos.getAux(),ordenamientos.getOpcion());
         
        });
       
        retroceder.setOnAction(e -> {
         if (ordenamientos.getAux()>17){  
         ordenamientos.miCodigo(stage,boton,retroceder,avanzar,Menu,ordenamientos.getAux(),ordenamientos.getOpcion());
         ordenamientos.disminuir();
         }
        });
        
        avanzar.setOnAction(e -> {
        
            
         if (ordenamientos.getAux()<=63){   
         ordenamientos.miCodigo(stage,boton,retroceder,avanzar,Menu,ordenamientos.getAux(),ordenamientos.getOpcion());
         ordenamientos.aumentar();
         }
        });
        
        Menu.setOnAction(e -> {
            
            stage.hide();
            stage1.show();
            
            
         
        });
       
        Insercion.setOnAction(e -> {
           
            stage1.hide();
            ordenamientos.insercion();
            ordenamientos.miCodigo(stage,boton,retroceder,avanzar,Menu,ordenamientos.getAux(),ordenamientos.getOpcion());  
            
   
        });
        
        Burbuja.setOnAction(e -> {
           
            stage1.hide();
            ordenamientos.burbuja();
            ordenamientos.miCodigo(stage,boton,retroceder,avanzar,Menu,ordenamientos.getAux(),ordenamientos.getOpcion());  
            
   
        });
        
        Cocktail.setOnAction(e -> {
           
            stage1.hide();
            ordenamientos.cocktail();
            ordenamientos.miCodigo(stage,boton,retroceder,avanzar,Menu,ordenamientos.getAux(),ordenamientos.getOpcion());  
            
   
        });
       
        Insercion.setLayoutX(100);
        Insercion.setLayoutY(230);
        Burbuja.setLayoutX(100);
        Burbuja.setLayoutY(260);
        Cocktail.setLayoutX(100);
        Cocktail.setLayoutY(290);
        anchor.getChildren().add(Insercion);
        anchor.getChildren().add(Burbuja);
        anchor.getChildren().add(Cocktail);
        stage1.show();

        
    }

 

    public static void main(String[] args) {
       launch(args);
     }
    
    
}
    