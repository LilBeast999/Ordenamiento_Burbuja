package com.mycompany.unidad2pp;

import java.util.ArrayList;
import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static javafx.application.Application.launch;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * JavaFX App
 */
public class App extends Application {
   
    @Override
    public void start(Stage stage) {

       AnchorPane anchor = new AnchorPane();
       anchor.setPrefSize(400, 300);
       Scene scena1 = new Scene (anchor); 
       Stage stage1 = new Stage();
       stage1.setScene(scena1);
       stage1.setTitle("Algoritmos de ordenamiento");
       Ordenamientos ordenamientos = new Ordenamientos();
       Text titulo= new Text("¡Bienvenido!");
       
       Button reiniciar = new Button("Reiniciar");
       Button disminuir = new Button("Disminuye cajas");
       Button aumentar = new Button("Aumenta cajas");
       Button Insercion = new Button ("Ordenamiento por insercion");
       Button Menu = new Button("Menu");
       Button Burbuja = new Button("Ordenamiento Burbuja");
       Button Cocktail = new Button("Ordenamiento Cocktail");
       Button Selection = new Button("Ordenamiento por seleccion");
   
       
       reiniciar.setOnAction(e -> {
        
         ordenamientos.miCodigo(stage,reiniciar,disminuir,aumentar,Menu,ordenamientos.getAux(),ordenamientos.getOpcion());
         
        });
       
        disminuir.setOnAction(e -> { //disminuye el numero de cajas
         if (ordenamientos.getAux()>17){  
         ordenamientos.miCodigo(stage,reiniciar,disminuir,aumentar,Menu,ordenamientos.getAux(),ordenamientos.getOpcion());
         ordenamientos.disminuir();
         }
        });
        
        aumentar.setOnAction(e -> { //aumenta el numero de cajas
        
            
         if (ordenamientos.getAux()<=63){   
         ordenamientos.miCodigo(stage,reiniciar,disminuir,aumentar,Menu,ordenamientos.getAux(),ordenamientos.getOpcion());
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
            ordenamientos.miCodigo(stage,reiniciar,disminuir,aumentar,Menu,ordenamientos.getAux(),ordenamientos.getOpcion());  
            
   
        });
        
        Burbuja.setOnAction(e -> {
           
            stage1.hide();
            ordenamientos.burbuja();
            ordenamientos.miCodigo(stage,reiniciar,disminuir,aumentar,Menu,ordenamientos.getAux(),ordenamientos.getOpcion());  
            
   
        });
        
        Cocktail.setOnAction(e -> {
           
            stage1.hide();
            ordenamientos.cocktail();
            ordenamientos.miCodigo(stage,reiniciar,disminuir,aumentar,Menu,ordenamientos.getAux(),ordenamientos.getOpcion());  
            
   
        });
        
        Selection.setOnAction(e -> {
           
            stage1.hide();
            ordenamientos.selection();
            ordenamientos.miCodigo(stage,reiniciar,disminuir,aumentar,Menu,ordenamientos.getAux(),ordenamientos.getOpcion());  
            
   
        });
        stage1.show();
       
        Insercion.setPrefSize(200, 40);
        Burbuja.setPrefSize(200, 40);
        Cocktail.setPrefSize(200, 40);
        Selection.setPrefSize(200, 40);

        anchor.getChildren().add(Insercion);
        
        anchor.getChildren().add(Burbuja);
        anchor.getChildren().add(Cocktail);
        anchor.getChildren().add(Selection);
        anchor.getChildren().add(titulo);
        titulo.setLayoutX(165);
        titulo.setLayoutY(30);
        titulo.setScaleX(3);
        titulo.setScaleY(3);
        Insercion.setLayoutX((anchor.getWidth()-Insercion.getPrefWidth())/2);
        Insercion.setLayoutY(65);
        Insercion.setFont(Font.font("Times New Roman",15));
        Burbuja.setLayoutX((anchor.getWidth()-Burbuja.getPrefWidth())/2);
        Burbuja.setLayoutY(115);
        Burbuja.setFont(Font.font("Times New Roman",15));
        Cocktail.setLayoutX((anchor.getWidth()-Cocktail.getPrefWidth())/2);
        Cocktail.setLayoutY(165);
        Cocktail.setFont(Font.font("Times New Roman",15));
        Selection.setLayoutX((anchor.getWidth()-Cocktail.getPrefWidth())/2);
        Selection.setLayoutY(215);
        Selection.setFont(Font.font("Times New Roman",15));


        
    }

 

    public static void main(String[] args) {
       launch(args);
     }
    
    
}
    