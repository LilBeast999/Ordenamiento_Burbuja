/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.unidad2pp;

import javafx.util.Duration;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.shape.*;


/**
 *
 * @author gusta
 */
public class Lapiz {
    int posicionx, posiciony;
    AnchorPane anchor= new AnchorPane();

    public Lapiz(int posicionx, int posiciony) {
        this.posicionx = posicionx;
        this.posiciony = posiciony;
    }

    public Lapiz(AnchorPane anchor) {
        this.anchor= anchor;
    }
    
    
    
    public  AnchorPane dibujarfondo(){
        
     
        
        
        
     //lineas de las montanas   
     Line line= new Line();
     line.setStartX(0);
     line.setStartY(0);
     line.setEndX(400);
     line.setEndY(300);
     line.setStrokeWidth(5);
     
     
     Line line1= new Line();
     line1.setStartX(300);
     line1.setStartY(400);
     line1.setEndX(600);
     line1.setEndY(100);
     line1.setStrokeWidth(5);
     
     Line line2= new Line();
     line2.setStartX(600);
     line2.setStartY(100);
     line2.setEndX(900);
     line2.setEndY(400);
     line2.setStrokeWidth(5);
     
     Line line3= new Line();
     line3.setStartX(700);
     line3.setStartY(200);
     line3.setEndX(1000);
     line3.setEndY(100);
     line3.setStrokeWidth(5);
     
     Line line4= new Line();
     line4.setStartX(1000);
     line4.setStartY(100);
     line4.setEndX(1300);
     line4.setEndY(200);
     line4.setStrokeWidth(5);
     
     Line line5= new Line();
     line5.setStartX(1183);
     line5.setStartY(160);
     line5.setEndX(1300);
     line5.setEndY(100);
     line5.setStrokeWidth(5);
     
     
     
     Line line6= new Line();
     line6.setStartX(1300);
     line6.setStartY(100);
     line6.setEndX(1450);
     line6.setEndY(200);
     line6.setStrokeWidth(5);
     
     Line line7= new Line();
     line7.setStartX(1300);
     line7.setStartY(400);
     line7.setEndX(1525);
     line7.setEndY(100);
     line7.setStrokeWidth(5);
     
     Line line8= new Line();
     line8.setStartX(1525);
     line8.setStartY(100);
     line8.setEndX(1800);
     line8.setEndY(400);
     line8.setStrokeWidth(5);
     
     Line line9= new Line();
     line9.setStartX(1665);
     line9.setStartY(250);
     line9.setEndX(1920);
     line9.setEndY(120);
     line9.setStrokeWidth(5);
     
     Line line10= new Line();
     line10.setStartX(0);
     line10.setStartY(100);
     line10.setEndX(10);
     line10.setEndY(75);
     line10.setStrokeWidth(5);     
     
     Line line11= new Line();
     line11.setStartX(10);
     line11.setStartY(75);
     line11.setEndX(25);
     line11.setEndY(90);
     line11.setStrokeWidth(5); 
     
     Line line12= new Line();
     line12.setStartX(25);
     line12.setStartY(90);
     line12.setEndX(45);
     line12.setEndY(70);
     line12.setStrokeWidth(5); 
     
     Line line13= new Line();
     line13.setStartX(45);
     line13.setStartY(70);
     line13.setEndX(70);
     line13.setEndY(100);
     line13.setStrokeWidth(5); 
     
     Line line14= new Line();
     line14.setStartX(70);
     line14.setStartY(100);
     line14.setEndX(100);
     line14.setEndY(80);
     line14.setStrokeWidth(5); 
     
     Line line15= new Line();
     line15.setStartX(500);
     line15.setStartY(200);
     line15.setEndX(530);
     line15.setEndY(230);
     line15.setStrokeWidth(5); 
     
     Line line16= new Line();
     line16.setStartX(530);
     line16.setStartY(230);
     line16.setEndX(550);
     line16.setEndY(210);
     line16.setStrokeWidth(5);
     
     Line line17= new Line();
     line17.setStartX(550);
     line17.setStartY(210);
     line17.setEndX(580);
     line17.setEndY(240);
     line17.setStrokeWidth(5);
     
     Line line18= new Line();
     line18.setStartX(580);
     line18.setStartY(240);
     line18.setEndX(640);
     line18.setEndY(200);
     line18.setStrokeWidth(5);
     
     Line line19= new Line();
     line19.setStartX(640);
     line19.setStartY(200);
     line19.setEndX(670);
     line19.setEndY(250);
     line19.setStrokeWidth(5);
     
     Line line20= new Line();
     line20.setStartX(670);
     line20.setStartY(250);
     line20.setEndX(720);
     line20.setEndY(220);
     line20.setStrokeWidth(5);
     
     Line line21= new Line();
     line21.setStartX(900);
     line21.setStartY(135);
     line21.setEndX(950);
     line21.setEndY(190);
     line21.setStrokeWidth(5);
     
     Line line22= new Line();
     line22.setStartX(950);
     line22.setStartY(190);
     line22.setEndX(980);
     line22.setEndY(150);
     line22.setStrokeWidth(5);
     
     Line line23= new Line();
     line23.setStartX(980);
     line23.setStartY(150);
     line23.setEndX(1000);
     line23.setEndY(170);
     line23.setStrokeWidth(5);
     
     Line line24= new Line();
     line24.setStartX(1000);
     line24.setStartY(170);
     line24.setEndX(1020);
     line24.setEndY(140);
     line24.setStrokeWidth(5);
     
     Line line25= new Line();
     line25.setStartX(1020);
     line25.setStartY(140);
     line25.setEndX(1050);
     line25.setEndY(180);
     line25.setStrokeWidth(5);
     
     Line line26= new Line();
     line26.setStartX(1050);
     line26.setStartY(180);
     line26.setEndX(1148);
     line26.setEndY(150);
     line26.setStrokeWidth(5);
     
     Line line27= new Line();
     line27.setStartX(1230);
     line27.setStartY(140);
     line27.setEndX(1260);
     line27.setEndY(160);
     line27.setStrokeWidth(5);
     
     Line line28= new Line();
     line28.setStartX(1260);
     line28.setStartY(160);
     line28.setEndX(1290);
     line28.setEndY(140);
     line28.setStrokeWidth(5);
     
     Line line29= new Line();
     line29.setStartX(1290);
     line29.setStartY(140);
     line29.setEndX(1320);
     line29.setEndY(170);
     line29.setStrokeWidth(5);
     
     Line line30= new Line();
     line30.setStartX(1320);
     line30.setStartY(170);
     line30.setEndX(1340);
     line30.setEndY(150);
     line30.setStrokeWidth(5);
     
     Line line31= new Line();
     line31.setStartX(1340);
     line31.setStartY(150);
     line31.setEndX(1360);
     line31.setEndY(160);
     line31.setStrokeWidth(5);
     
     Line line32= new Line();
     line32.setStartX(1360);
     line32.setStartY(160);
     line32.setEndX(1380);
     line32.setEndY(155);
     line32.setStrokeWidth(5);
     
     Line line33= new Line();
     line33.setStartX(1475);
     line33.setStartY(170);
     line33.setEndX(1520);
     line33.setEndY(200);
     line33.setStrokeWidth(5);
     
     Line line34= new Line();
     line34.setStartX(1520);
     line34.setStartY(200);
     line34.setEndX(1550);
     line34.setEndY(180);
     line34.setStrokeWidth(5);
     
     Line line35= new Line();
     line35.setStartX(1550);
     line35.setStartY(180);
     line35.setEndX(1590);
     line35.setEndY(210);
     line35.setStrokeWidth(5);
     
     Line line36= new Line();
     line36.setStartX(1590);
     line36.setStartY(210);
     line36.setEndX(1603);
     line36.setEndY(190);
     line36.setStrokeWidth(5);
     
     Line line37= new Line();
     line37.setStartX(1825);
     line37.setStartY(170);
     line37.setEndX(1870);
     line37.setEndY(190);
     line37.setStrokeWidth(5);
     
     Line line38= new Line();
     line38.setStartX(1870);
     line38.setStartY(190);
     line38.setEndX(1900);
     line38.setEndY(160);
     line38.setStrokeWidth(5);
     
     Line line39= new Line();
     line39.setStartX(1900);
     line39.setStartY(160);
     line39.setEndX(1920);
     line39.setEndY(190);
     line39.setStrokeWidth(5);
     
     Rectangle rectangulo1 = new Rectangle();
     rectangulo1.setX(160);
     rectangulo1.setY(48);
     rectangulo1.setWidth(100);
     rectangulo1.setHeight(350);
     rectangulo1.setFill(Color.web("#326BBD"));
     rectangulo1.setRotate(-53);
     
     Rectangle rectangulo2 = new Rectangle();
     rectangulo2.setX(-30);
     rectangulo2.setY(166);
     rectangulo2.setWidth(300);
     rectangulo2.setHeight(400);
     rectangulo2.setFill(Color.web("#326BBD"));
     rectangulo2.setRotate(45);
     
     Rectangle rectangulo3 = new Rectangle();
     rectangulo3.setX(0);
     rectangulo3.setY(400);
     rectangulo3.setWidth(1920);
     rectangulo3.setHeight(220);
     rectangulo3.setFill(Color.web("#326BBD"));
     rectangulo3.setRotate(0);
     
     Rectangle rectangulo4 = new Rectangle();
     rectangulo4.setX(0);
     rectangulo4.setY(250);
     rectangulo4.setWidth(1920);
     rectangulo4.setHeight(200);
     rectangulo4.setFill(Color.web("#326BBD"));
     rectangulo4.setRotate(0);   
     
     Rectangle rectangulo5 = new Rectangle();
     rectangulo5.setX(0);
     rectangulo5.setY(70);
     rectangulo5.setWidth(1920);
     rectangulo5.setHeight(200);
     rectangulo5.setFill(Color.web("#326BBD"));
     rectangulo5.setRotate(0); 
     
     Rectangle rectangulo6 = new Rectangle();
     rectangulo6.setX(190);
     rectangulo6.setY(-105);
     rectangulo6.setWidth(200);
     rectangulo6.setHeight(390);
     rectangulo6.setFill(Color.web("#AABDD8"));
     rectangulo6.setRotate(127);
     
     Rectangle rectangulo7 = new Rectangle();
     rectangulo7.setX(368);
     rectangulo7.setY(-103);
     rectangulo7.setWidth(200);
     rectangulo7.setHeight(393);
     rectangulo7.setFill(Color.web("#AABDD8"));
     rectangulo7.setRotate(-135); 
     
     Rectangle rectangulo8 = new Rectangle();
     rectangulo8.setX(760);
     rectangulo8.setY(-156);
     rectangulo8.setWidth(200);
     rectangulo8.setHeight(393);
     rectangulo8.setFill(Color.web("#AABDD8"));
     rectangulo8.setRotate(72);
     
     Rectangle rectangulo9 = new Rectangle();
     rectangulo9.setX(533);
     rectangulo9.setY(-202);
     rectangulo9.setWidth(200);
     rectangulo9.setHeight(393);
     rectangulo9.setFill(Color.web("#AABDD8"));
     rectangulo9.setRotate(-45);
     
     Rectangle rectangulo10 = new Rectangle();
     rectangulo10.setX(1698);
     rectangulo10.setY(-126);
     rectangulo10.setWidth(200);
     rectangulo10.setHeight(393);
     rectangulo10.setFill(Color.web("#AABDD8"));
     rectangulo10.setRotate(64);
     
     Rectangle rectangulo11 = new Rectangle();
     rectangulo11.setX(1507);
     rectangulo11.setY(-157);
     rectangulo11.setWidth(200);
     rectangulo11.setHeight(393);
     rectangulo11.setFill(Color.web("#AABDD8"));
     rectangulo11.setRotate(-43);
     
     Rectangle rectangulo12 = new Rectangle();
     rectangulo12.setX(1239);
     rectangulo12.setY(-195);
     rectangulo12.setWidth(200);
     rectangulo12.setHeight(393);
     rectangulo12.setFill(Color.web("#AABDD8"));
     rectangulo12.setRotate(-56);
     
     Rectangle rectangulo13 = new Rectangle();
     rectangulo13.setX(1285);
     rectangulo13.setY(-170);
     rectangulo13.setWidth(100);
     rectangulo13.setHeight(393);
     rectangulo13.setFill(Color.web("#AABDD8"));
     rectangulo13.setRotate(64);
     
     Rectangle rectangulo14 = new Rectangle();
     rectangulo14.setX(962);
     rectangulo14.setY(-148);
     rectangulo14.setWidth(100);
     rectangulo14.setHeight(393);
     rectangulo14.setFill(Color.web("#AABDD8"));
     rectangulo14.setRotate(-71);
     
     Rectangle rectangulo15 = new Rectangle();
     rectangulo15.setX(1481);
     rectangulo15.setY(-182);
     rectangulo15.setWidth(100);
     rectangulo15.setHeight(393);
     rectangulo15.setFill(Color.web("#AABDD8"));
     rectangulo15.setRotate(38);
     
     //#e8ede5
     Rectangle rectangulo16 = new Rectangle();
     rectangulo16.setX(1261);
     rectangulo16.setY(100);
     rectangulo16.setWidth(30);
     rectangulo16.setHeight(59);
     rectangulo16.setFill(Color.web("#e8ede5"));
     rectangulo16.setRotate(59);
     
     Rectangle rectangulo17 = new Rectangle();
     rectangulo17.setX(1292);
     rectangulo17.setY(103);
     rectangulo17.setWidth(34);
     rectangulo17.setHeight(63);
     rectangulo17.setFill(Color.web("#e8ede5"));
     rectangulo17.setRotate(-48);
     
     Rectangle rectangulo18 = new Rectangle();
     rectangulo18.setX(1322);
     rectangulo18.setY(90);
     rectangulo18.setWidth(14);
     rectangulo18.setHeight(80);
     rectangulo18.setFill(Color.web("#e8ede5"));
     rectangulo18.setRotate(-55);
     
     Rectangle rectangulo19 = new Rectangle();
     rectangulo19.setX(1345);
     rectangulo19.setY(116);
     rectangulo19.setWidth(14);
     rectangulo19.setHeight(50);
     rectangulo19.setFill(Color.web("#e8ede5"));
     rectangulo19.setRotate(-55);
     
     Rectangle rectangulo20 = new Rectangle();
     rectangulo20.setX(1243);
     rectangulo20.setY(127);
     rectangulo20.setWidth(14);
     rectangulo20.setHeight(32);
     rectangulo20.setFill(Color.web("#e8ede5"));
     rectangulo20.setRotate(-53);
     
     Rectangle rectangulo21 = new Rectangle();
     rectangulo21.setX(24);
     rectangulo21.setY(-16);
     rectangulo21.setWidth(25);
     rectangulo21.setHeight(120);
     rectangulo21.setFill(Color.web("#e8ede5"));
     rectangulo21.setRotate(-53);
     
     Rectangle rectangulo22 = new Rectangle();
     rectangulo22.setX(-19);
     rectangulo22.setY(-25);
     rectangulo22.setWidth(32);
     rectangulo22.setHeight(120);
     rectangulo22.setFill(Color.web("#e8ede5"));
     rectangulo22.setRotate(-45);
     
     Rectangle rectangulo23 = new Rectangle();
     rectangulo23.setX(-19);
     rectangulo23.setY(23);
     rectangulo23.setWidth(32);
     rectangulo23.setHeight(80);
     rectangulo23.setFill(Color.web("#e8ede5"));
     rectangulo23.setRotate(25);
     
     Rectangle rectangulo24 = new Rectangle();
     rectangulo24.setX(49.5);
     rectangulo24.setY(62);
     rectangulo24.setWidth(38);
     rectangulo24.setHeight(25);
     rectangulo24.setFill(Color.web("#e8ede5"));
     rectangulo24.setRotate(49);
     
     Rectangle rectangulo25 = new Rectangle();
     rectangulo25.setX(73);
     rectangulo25.setY(65);
     rectangulo25.setWidth(20);
     rectangulo25.setHeight(25);
     rectangulo25.setFill(Color.web("#e8ede5"));
     rectangulo25.setRotate(49);
     
     Rectangle rectangulo26 = new Rectangle();
     rectangulo26.setX(545);
     rectangulo26.setY(95);
     rectangulo26.setWidth(40);
     rectangulo26.setHeight(142);
     rectangulo26.setFill(Color.web("#e8ede5"));
     rectangulo26.setRotate(45);
     
     Rectangle rectangulo27 = new Rectangle();
     rectangulo27.setX(572);
     rectangulo27.setY(125);
     rectangulo27.setWidth(55);
     rectangulo27.setHeight(110);
     rectangulo27.setFill(Color.web("#e8ede5"));
     rectangulo27.setRotate(45);
    
     Rectangle rectangulo28 = new Rectangle();
     rectangulo28.setX(647);
     rectangulo28.setY(134);
     rectangulo28.setWidth(35);
     rectangulo28.setHeight(110);
     rectangulo28.setFill(Color.web("#e8ede5"));
     rectangulo28.setRotate(-43);
     
     Rectangle rectangulo29 = new Rectangle();
     rectangulo29.setX(646);
     rectangulo29.setY(166);
     rectangulo29.setWidth(35);
     rectangulo29.setHeight(80);
     rectangulo29.setFill(Color.web("#e8ede5"));
     rectangulo29.setRotate(-32);
     
     Rectangle rectangulo30 = new Rectangle();
     rectangulo30.setX(590);
     rectangulo30.setY(158);
     rectangulo30.setWidth(35);
     rectangulo30.setHeight(80);
     rectangulo30.setFill(Color.web("#e8ede5"));
     rectangulo30.setRotate(57);
     
     Rectangle rectangulo31 = new Rectangle();
     rectangulo31.setX(697);
     rectangulo31.setY(210);
     rectangulo31.setWidth(15);
     rectangulo31.setHeight(20);
     rectangulo31.setFill(Color.web("#e8ede5"));
     rectangulo31.setRotate(57);
     
     Rectangle rectangulo32 = new Rectangle(944,100,25,80);
     rectangulo32.setFill(Color.web("#e8ede5"));
     rectangulo32.setRotate(54);
     
     Rectangle rectangulo33 = new Rectangle(1040,100,25,80);
     rectangulo33.setFill(Color.web("#e8ede5"));
     rectangulo33.setRotate(-54);
     
     Rectangle rectangulo34 = new Rectangle(1030,109,24,72);
     rectangulo34.setFill(Color.web("#e8ede5"));
     rectangulo34.setRotate(-36);
     
     
     Rectangle rectangulo35 = new Rectangle(992,115,24,50);
     rectangulo35.setFill(Color.web("#e8ede5"));
     rectangulo35.setRotate(36);
     
     Rectangle rectangulo36 = new Rectangle(955,108,24,80);
     rectangulo36.setFill(Color.web("#e8ede5"));
     rectangulo36.setRotate(41);
     
     Rectangle rectangulo37 = new Rectangle(947,75.5,21,102);
     rectangulo37.setFill(Color.web("#e8ede5"));
     rectangulo37.setRotate(70);
     
     Rectangle rectangulo38 = new Rectangle(1045,72,21,120);
     rectangulo38.setFill(Color.web("#e8ede5"));
     rectangulo38.setRotate(-72);
     
     Rectangle rectangulo39 = new Rectangle(1080,118,16,80);
     rectangulo39.setFill(Color.web("#e8ede5"));
     rectangulo39.setRotate(72);
     
     Rectangle rectangulo40 = new Rectangle(918,112,10,40);
     rectangulo40.setFill(Color.web("#e8ede5"));
     rectangulo40.setRotate(72);
     
     Rectangle rectangulo41 = new Rectangle(967,116,10,40);
     rectangulo41.setFill(Color.web("#e8ede5"));
     rectangulo41.setRotate(125);
     
     Rectangle rectangulo42 = new Rectangle(1115,133,10,40);
     rectangulo42.setFill(Color.web("#e8ede5"));
     rectangulo42.setRotate(75);
     
     Rectangle rectangulo43 = new Rectangle(1110,133,10,40);
     rectangulo43.setFill(Color.web("#e8ede5"));
     rectangulo43.setRotate(75);
     
     Rectangle rectangulo44 = new Rectangle(0,600,1920,1920);
     rectangulo44.setFill(Color.web("#0C8527"));
     rectangulo44.setRotate(90);
     
     Rectangle rectangulo45 = new Rectangle(0,650,1920,1920);
     rectangulo45.setFill(Color.web("#1DB23B"));
     rectangulo45.setRotate(90);
     
     Rectangle rectangulo46 = new Rectangle(0,750,1920,1920);
     rectangulo46.setFill(Color.web("#829085"));
     rectangulo46.setRotate(90);
     
     Polygon poly = new Polygon();
     poly.getPoints().addAll(new Double[] {1525.0,102.0,1477.0,168.0,1520.0,198.0,1550.0,178.0,1590.0,207.0,1602.0,188.0});
     poly.setFill(Color.web("#e8ede5"));
     
     Polygon poly1 = new Polygon();
     poly1.getPoints().addAll(new Double[] {1930.0,115.0, 1820.0,170.0,1870.0,190.0, 1900.0, 158.0,1920.0,190.0});
     poly1.setFill(Color.web("#e8ede5"));
     
     Polygon poly2 = new Polygon();
     poly2.getPoints().addAll(new Double[] {0.0,0.0,400.0,300.0,600.0,100.0,700.0,200.0,1000.0,100.0,1183.0,158.0,1300.0,100.0,1450.0,200.0,1525.0,100.0,1665.0,250.0,1920.0,120.0,1920.0,-100.0});
     poly2.setFill(Color.web("#AABDD8"));
     
     //sol
     Circle circulo1 = new Circle(950,100,40);
     circulo1.setFill(Color.YELLOW);
     circulo1.opacityProperty().set(1);
     
     //nubes
     Circle circulo2 = new Circle(750,100,40);
     circulo2.setFill(Color.WHITE);
     circulo2.opacityProperty().set(1);

     Circle circulo3 = new Circle(710,100,30);
     circulo3.setFill(Color.WHITE);
     circulo3.opacityProperty().set(1);
     
     Circle circulo4 = new Circle(740,100,40);
     circulo4.setFill(Color.WHITE);
     circulo4.opacityProperty().set(1);
     
     Circle circulo5 = new Circle(770,100,50);
     circulo5.setFill(Color.WHITE);
     circulo5.opacityProperty().set(1);
     
     Circle circulo6 = new Circle(810,100,45);
     circulo6.setFill(Color.WHITE);
     circulo6.opacityProperty().set(1);
     
     Circle circulo7 = new Circle(830,100,35);
     circulo7.setFill(Color.WHITE);
     circulo7.opacityProperty().set(1);
     
     Circle circulo8 = new Circle(850,105,20);
     circulo8.setFill(Color.WHITE);
     circulo8.opacityProperty().set(1);
     
     //nube 2
     Circle circulo9 = new Circle(1480,100,60);
     circulo9.setFill(Color.WHITE);
     circulo9.opacityProperty().set(1);
     
     Circle circulo10 = new Circle(1540,100,50);
     circulo10.setFill(Color.WHITE);
     circulo10.opacityProperty().set(1);
     
     Circle circulo11 = new Circle(1510,80,50);
     circulo11.setFill(Color.WHITE);
     circulo11.opacityProperty().set(1);
     
     Circle circulo12 = new Circle(1430,120,50);
     circulo12.setFill(Color.WHITE);
     circulo12.opacityProperty().set(1);
     
     Circle circulo13 = new Circle(1400,120,35);
     circulo13.setFill(Color.WHITE);
     circulo13.opacityProperty().set(1);
     
     Circle circulo14 = new Circle(1380,120,22);
     circulo14.setFill(Color.WHITE);
     circulo14.opacityProperty().set(1);
     
     Circle circulo15 = new Circle(1570,110,35);
     circulo15.setFill(Color.WHITE);
     circulo15.opacityProperty().set(1);
     
     Circle circulo16 = new Circle(1600,110,22);
     circulo16.setFill(Color.WHITE);
     circulo16.opacityProperty().set(1);
     
     Circle circulo17 = new Circle(1600,110,22);
     circulo17.setFill(Color.WHITE);
     circulo17.opacityProperty().set(1);
     
     // Grua
     
     
     //agregar al fondo
     //aqui depende del orden que se coloque va hacia el fondo o adelante
     
     this.anchor.getChildren().add(rectangulo1);
     this.anchor.getChildren().add(rectangulo2);
     this.anchor.getChildren().add(rectangulo3);
     

     //detras de las montanas

     
     this.anchor.getChildren().add(rectangulo4);
     
    
     this.anchor.getChildren().add(rectangulo5);
     this.anchor.getChildren().add(poly2);
     this.anchor.getChildren().add(circulo1);

     this.anchor.getChildren().add(rectangulo16);
     this.anchor.getChildren().add(rectangulo17);
     this.anchor.getChildren().add(rectangulo18);
     this.anchor.getChildren().add(rectangulo19);
     this.anchor.getChildren().add(rectangulo20);
     this.anchor.getChildren().add(rectangulo21);
     this.anchor.getChildren().add(rectangulo22);
     this.anchor.getChildren().add(rectangulo23);
   
     this.anchor.getChildren().add(rectangulo24);
     this.anchor.getChildren().add(rectangulo25);
     this.anchor.getChildren().add(rectangulo26);
     this.anchor.getChildren().add(rectangulo27);
     this.anchor.getChildren().add(rectangulo28);
     this.anchor.getChildren().add(rectangulo29);
     this.anchor.getChildren().add(rectangulo30);
     this.anchor.getChildren().add(rectangulo31);
     this.anchor.getChildren().add(rectangulo32);
     this.anchor.getChildren().add(rectangulo33);
     this.anchor.getChildren().add(rectangulo34);
     this.anchor.getChildren().add(rectangulo35);
     this.anchor.getChildren().add(rectangulo36);
     this.anchor.getChildren().add(rectangulo37);
     this.anchor.getChildren().add(rectangulo38);
     this.anchor.getChildren().add(rectangulo39);
     this.anchor.getChildren().add(rectangulo40);
     this.anchor.getChildren().add(rectangulo41);
     this.anchor.getChildren().add(rectangulo42);
     this.anchor.getChildren().add(rectangulo43);
     this.anchor.getChildren().add(rectangulo44);
     this.anchor.getChildren().add(rectangulo45);
     this.anchor.getChildren().add(rectangulo46);
     this.anchor.getChildren().add(poly);
     this.anchor.getChildren().add(poly1);
     

     
     this.anchor.getChildren().add(line);
     this.anchor.getChildren().add(line1);
     this.anchor.getChildren().add(line2);
     this.anchor.getChildren().add(line3);
     this.anchor.getChildren().add(line4);
     this.anchor.getChildren().add(line5);
     this.anchor.getChildren().add(line6);
     this.anchor.getChildren().add(line7);
     this.anchor.getChildren().add(line8);
     this.anchor.getChildren().add(line9);
     this.anchor.getChildren().add(line10);
     this.anchor.getChildren().add(line11);
     this.anchor.getChildren().add(line12);
     this.anchor.getChildren().add(line13);
     this.anchor.getChildren().add(line14);
     this.anchor.getChildren().add(line15);
     this.anchor.getChildren().add(line16);
     this.anchor.getChildren().add(line17);
     this.anchor.getChildren().add(line18);
     this.anchor.getChildren().add(line19);
     this.anchor.getChildren().add(line20);
     this.anchor.getChildren().add(line21);
     this.anchor.getChildren().add(line22);
     this.anchor.getChildren().add(line23);
     this.anchor.getChildren().add(line24);
     this.anchor.getChildren().add(line25);
     this.anchor.getChildren().add(line26);
     this.anchor.getChildren().add(line27);
     this.anchor.getChildren().add(line28);
     this.anchor.getChildren().add(line29);
     this.anchor.getChildren().add(line30);
     this.anchor.getChildren().add(line31);
     this.anchor.getChildren().add(line32);
     this.anchor.getChildren().add(line33);
     this.anchor.getChildren().add(line34);
     this.anchor.getChildren().add(line35);
     this.anchor.getChildren().add(line36);
     this.anchor.getChildren().add(line37);
     this.anchor.getChildren().add(line38);
     this.anchor.getChildren().add(line39);
     this.anchor.getChildren().add(circulo2);
     this.anchor.getChildren().add(circulo3);
     this.anchor.getChildren().add(circulo4);
     this.anchor.getChildren().add(circulo5);
     this.anchor.getChildren().add(circulo6);
     this.anchor.getChildren().add(circulo7);
     this.anchor.getChildren().add(circulo8);
     this.anchor.getChildren().add(circulo9);
     this.anchor.getChildren().add(circulo10);
     this.anchor.getChildren().add(circulo11);
     this.anchor.getChildren().add(circulo12);
     this.anchor.getChildren().add(circulo13);
     this.anchor.getChildren().add(circulo14);
     this.anchor.getChildren().add(circulo15);
     this.anchor.getChildren().add(circulo16);
     //this.anchor.getChildren().add(circulo17);
     //this.anchor.getChildren().add(circulo18);
     //this.anchor.getChildren().add(circulo19);



     
     
     return this.anchor;
     
    }
    
    public AnchorPane dibujarfondo2(){
        
 
     //rail principal
     Rectangle rectangulo1= new Rectangle(-5000,500,10000,15); //sujeta a formula
     rectangulo1.setFill(Color.web("#8A6012"));
     rectangulo1.setStroke(Color.BLACK);
     rectangulo1.setStrokeWidth(1);
     
     //rail auxiliar
     Rectangle rectangulo2= new Rectangle(400,-1612,10000,15); //sujeta a formula
     rectangulo2.setFill(Color.web("#8A6012"));
     rectangulo2.setStroke(Color.BLACK);
     rectangulo2.setStrokeWidth(1);
     rectangulo2.setRotate(-25);
     
     
     Rectangle rectangulo3= new Rectangle(-5000,-5000,10000,10000);
     rectangulo3.setFill(Color.GREEN);
     

     Group Railes = new Group ();
     Railes.getChildren().addAll(rectangulo2,rectangulo1);
     
     
        
        
     
     this.anchor.getChildren().add(rectangulo3);
     this.anchor.getChildren().add(Railes);
     for (int i = 0; i < 10000; i++) {
            Rectangle rectangulo = new Rectangle(-5000+(20*(i+1)),485,10,50); // sujeto a formula o a usar un scale por que funciona la wea
            rectangulo.setFill(Color.web("#6A4502"));
            rectangulo.setStroke(Color.BLACK);
            rectangulo2.setStrokeWidth(1);
            rectangulo.setScaleX(0.5);
            rectangulo.setScaleY(0.5);
            this.anchor.getChildren().add(rectangulo);
        }
     
     for (int i = 0; i < 5000; i++) {
            Rectangle rectangulo = new Rectangle(877.5+(20*(i+1)),470-(i*9.33),10,50); // sujeto a formula o a usar un scale por que funciona la wea
            rectangulo.setRotate(-25);
            rectangulo.setFill(Color.web("#6A4502"));
            rectangulo.setStroke(Color.BLACK);
            rectangulo2.setStrokeWidth(1);
            rectangulo.setScaleX(0.5);
            rectangulo.setScaleY(0.5);
            this.anchor.getChildren().add(rectangulo);
        }
     
     
     return this.anchor;
    }
        
    public AnchorPane dibujargrua(){

         
         Rectangle rectangulo1= new Rectangle(25,460,100,450);
         rectangulo1.setRotate(0);
         rectangulo1.setFill(Color.ORANGE);
         rectangulo1.setStroke(Color.BLACK);
     
         Rectangle rectangulo2= new Rectangle(50,375,20,100);
         rectangulo2.setRotate(30);
         rectangulo2.setFill(Color.ORANGE);
         rectangulo2.setStroke(Color.BLACK);
         
         Rectangle rectangulo3= new Rectangle(85,375,20,100);
         rectangulo3.setRotate(-35);
         rectangulo3.setFill(Color.ORANGE);
         rectangulo3.setStroke(Color.BLACK);
         
         Rectangle rectangulo4 = new Rectangle(905,-485,30,1750);
         rectangulo4.setRotate(90);
         rectangulo4.setFill(Color.ORANGE);
         rectangulo4.setStroke(Color.BLACK);
         
         Rectangle rectangulo5 = new Rectangle(940,-378,25,1700);
         rectangulo5.setRotate(90);
         rectangulo5.setFill(Color.ORANGE);
         rectangulo5.setStroke(Color.BLACK);
         
         Circle circulo1 = new Circle(72,390,7);
         circulo1.setFill(Color.GRAY);
         circulo1.setStroke(Color.BLACK);
         
         Circle circulo2 = new Circle(1772,390,7);
         circulo2.setFill(Color.GRAY);
         circulo2.setStroke(Color.BLACK);
         
         Rectangle rectangulo6= new Rectangle(1725,460,100,450);
         rectangulo6.setRotate(0);
         rectangulo6.setFill(Color.ORANGE);
         rectangulo6.setStroke(Color.BLACK);
         
         Rectangle rectangulo7= new Rectangle(1742,374,20,100);
         rectangulo7.setRotate(35);
         rectangulo7.setFill(Color.ORANGE);
         rectangulo7.setStroke(Color.BLACK);
         
         Rectangle rectangulo8= new Rectangle(1778,375,20,100);
         rectangulo8.setRotate(-35);
         rectangulo8.setFill(Color.ORANGE);
         rectangulo8.setStroke(Color.BLACK);
         
         Line line1=new Line();
         line1.setStartX(100);
         line1.setStartY(420);
         line1.setEndX(1750);
         line1.setEndY(420);
         line1.setStrokeWidth(5);
         
         Line line2=new Line();
         line2.setStartX(100);
         line2.setStartY(440);
         line2.setEndX(1750);
         line2.setEndY(440);
         line2.setStrokeWidth(5);
         
         this.anchor.getChildren().add(line1);
         this.anchor.getChildren().add(line2);
         this.anchor.getChildren().add(rectangulo5);
         this.anchor.getChildren().add(rectangulo3);
         
         this.anchor.getChildren().add(rectangulo2);  
         this.anchor.getChildren().add(rectangulo1);
         
         this.anchor.getChildren().add(rectangulo7);
         this.anchor.getChildren().add(rectangulo8);
         this.anchor.getChildren().add(rectangulo6);
         this.anchor.getChildren().add(rectangulo4);
         
          
         this.anchor.getChildren().add(circulo1);
         this.anchor.getChildren().add(circulo2);
       
         return this.anchor;
       
    }
     
    public ArrayList<Group> AlmacenarNumeros(){
        ArrayList <Group> numeros= new ArrayList();
        
        Rectangle cero1 = new Rectangle(5, 0, 40, 10); 
        cero1.setFill(Color.BLACK); 
        Rectangle cero2 = new Rectangle(5, 0, 10, 60); 
        cero2.setFill(Color.BLACK); 
        Rectangle cero3 = new Rectangle(5, 50, 40, 10); 
        cero3.setFill(Color.BLACK); 
        Rectangle cero4 = new Rectangle(45, 0, 10, 60); 
        cero4.setFill(Color.BLACK); 
        Group grupo0= new Group(cero1,cero2,cero3,cero4);
        grupo0.setScaleX(0.5);
        grupo0.setScaleY(0.5);
        
       
        Rectangle uno1 = new Rectangle(15, 0, 30, 60); 
        uno1.setFill(Color.BLACK);
        uno1.setScaleX(0.5);
        uno1.setScaleY(0.5);
        Group grupo1= new Group(uno1);
        
        Rectangle dos1 = new Rectangle(10, 0, 40, 10); 
        dos1.setFill(Color.BLACK); 
        Rectangle dos2 = new Rectangle(40, 0, 10, 30); 
        dos2.setFill(Color.BLACK); 
        Rectangle dos3 = new Rectangle(10, 30, 40, 10); 
        dos3.setFill(Color.BLACK); 
        Rectangle dos4 = new Rectangle(10, 30, 10, 30); 
        dos4.setFill(Color.BLACK); 
        Rectangle dos5 = new Rectangle(10, 50, 40, 10); 
        dos5.setFill(Color.BLACK); 
        Group grupo2= new Group(dos1,dos2,dos3,dos4,dos5);
        grupo2.setScaleX(0.5);
        grupo2.setScaleY(0.5);
        
        Rectangle tres1 = new Rectangle(10, 0, 40, 10); 
        tres1.setFill(Color.BLACK); 
        Rectangle tres2 = new Rectangle(40, 10, 10, 30); 
        tres2.setFill(Color.BLACK); 
        Rectangle tres3 = new Rectangle(10, 30, 40, 10); 
        tres3.setFill(Color.BLACK); 
        Rectangle tres4 = new Rectangle(40, 30, 10, 30); 
        tres4.setFill(Color.BLACK); 
        Rectangle tres5 = new Rectangle(10, 50, 40, 10); 
        tres5.setFill(Color.BLACK); 
        Group grupo3= new Group(tres1,tres2,tres3,tres4,tres5);
        grupo3.setScaleX(0.5);
        grupo3.setScaleY(0.5);
        
        Rectangle cuatro1 = new Rectangle(10, 0, 10, 30); 
        cuatro1.setFill(Color.BLACK); 
        Rectangle cuatro2 = new Rectangle(40, 0, 10, 60); 
        cuatro2.setFill(Color.BLACK); 
        Rectangle cuatro3 = new Rectangle(10, 30, 40, 10); 
        cuatro3.setFill(Color.BLACK); 
        Group grupo4= new Group(cuatro1,cuatro2,cuatro3);
        grupo4.setScaleX(0.5);
        grupo4.setScaleY(0.5);
        
        Rectangle cinco1 = new Rectangle(10, 0, 40, 10); 
        cinco1.setFill(Color.BLACK); 
        Rectangle cinco2 = new Rectangle(10, 10, 10, 30); 
        cinco2.setFill(Color.BLACK); 
        Rectangle cinco3 = new Rectangle(10, 30, 40, 10); 
        cinco3.setFill(Color.BLACK); 
        Rectangle cinco4 = new Rectangle(40, 30, 10, 30); 
        cinco4.setFill(Color.BLACK); 
        Rectangle cinco5 = new Rectangle(10, 50, 40, 10); 
        cinco5.setFill(Color.BLACK); 
        Group grupo5= new Group(cinco1,cinco2,cinco3,cinco4,cinco5);
        grupo5.setScaleX(0.5);
        grupo5.setScaleY(0.5);
        
        Rectangle seis1 = new Rectangle(10, 0, 30, 10); 
        seis1.setFill(Color.BLACK); 
        Rectangle seis2 = new Rectangle(10, 0, 10, 60); 
        seis2.setFill(Color.BLACK); 
        Rectangle seis3 = new Rectangle(10, 30, 40, 10); 
        seis3.setFill(Color.BLACK); 
        Rectangle seis4 = new Rectangle(40, 30, 10, 30); 
        seis4.setFill(Color.BLACK); 
        Rectangle seis5 = new Rectangle(10, 50, 40, 10); 
        seis5.setFill(Color.BLACK);
        Group grupo6= new Group(seis1,seis2,seis3,seis4,seis5);
        grupo6.setScaleX(0.5);
        grupo6.setScaleY(0.5);
        
        Rectangle siete1 = new Rectangle(15, 0, 30, 10); 
        siete1.setFill(Color.BLACK); 
        Rectangle siete2 = new Rectangle(35, 0, 10, 60); 
        siete2.setFill(Color.BLACK); 
        Group grupo7= new Group(siete1,siete2);
        grupo7.setScaleX(0.5);
        grupo7.setScaleY(0.5);
    
         Rectangle ocho1 = new Rectangle(10, 0, 40, 10); 
        ocho1.setFill(Color.BLACK); 
        Rectangle ocho2 = new Rectangle(10, 0, 10, 60); 
        ocho2.setFill(Color.BLACK); 
        Rectangle ocho3 = new Rectangle(10, 30, 40, 10); 
        ocho3.setFill(Color.BLACK); 
        Rectangle ocho4 = new Rectangle(10, 50, 40, 10); 
        ocho4.setFill(Color.BLACK); 
        Rectangle ocho5 = new Rectangle(40, 0, 10, 60); 
        ocho5.setFill(Color.BLACK); 
        Group grupo8= new Group(ocho1,ocho2,ocho3,ocho4,ocho5);
        grupo8.setScaleX(0.5);
        grupo8.setScaleY(0.5);
        
        Rectangle nueve1 = new Rectangle(10, 0, 40, 10); 
        nueve1.setFill(Color.BLACK); 
        Rectangle nueve2 = new Rectangle(10, 0, 10, 40); 
        nueve2.setFill(Color.BLACK); 
        Rectangle nueve3 = new Rectangle(10, 30, 40, 10); 
        nueve3.setFill(Color.BLACK); 
        Rectangle nueve4 = new Rectangle(40, 0, 10, 60); 
        nueve4.setFill(Color.BLACK); 
        Group grupo9= new Group(nueve1,nueve2,nueve3,nueve4);
        grupo9.setScaleX(0.5);
        grupo9.setScaleY(0.5);
        
        Rectangle cero11 = new Rectangle(5, 0, 40, 10); 
        cero1.setFill(Color.BLACK); 
        Rectangle cero22 = new Rectangle(5, 0, 10, 60); 
        cero2.setFill(Color.BLACK); 
        Rectangle cero33 = new Rectangle(5, 50, 40, 10); 
        cero3.setFill(Color.BLACK); 
        Rectangle cero44 = new Rectangle(45, 0, 10, 60); 
        cero4.setFill(Color.BLACK); 
        Group grupo00= new Group(cero11,cero22,cero33,cero44);
        grupo00.setScaleX(0.5);
        grupo00.setScaleY(0.5);
        
       
        Rectangle uno11 = new Rectangle(15, 0, 30, 60); 
        uno11.setFill(Color.BLACK);
        uno11.setScaleX(0.5);
        uno11.setScaleY(0.5);
        Group grupo11= new Group(uno11);
        
        Rectangle dos11 = new Rectangle(10, 0, 40, 10); 
        dos11.setFill(Color.BLACK); 
        Rectangle dos22 = new Rectangle(40, 0, 10, 30); 
        dos22.setFill(Color.BLACK); 
        Rectangle dos33 = new Rectangle(10, 30, 40, 10); 
        dos33.setFill(Color.BLACK); 
        Rectangle dos44 = new Rectangle(10, 30, 10, 30); 
        dos44.setFill(Color.BLACK); 
        Rectangle dos55 = new Rectangle(10, 50, 40, 10); 
        dos55.setFill(Color.BLACK); 
        Group grupo22= new Group(dos11,dos22,dos33,dos44,dos55);
        grupo22.setScaleX(0.5);
        grupo22.setScaleY(0.5);
        
        Rectangle tres11 = new Rectangle(10, 0, 40, 10); 
        tres11.setFill(Color.BLACK); 
        Rectangle tres22 = new Rectangle(40, 10, 10, 30); 
        tres22.setFill(Color.BLACK); 
        Rectangle tres33 = new Rectangle(10, 30, 40, 10); 
        tres33.setFill(Color.BLACK); 
        Rectangle tres44 = new Rectangle(40, 30, 10, 30); 
        tres44.setFill(Color.BLACK); 
        Rectangle tres55 = new Rectangle(10, 50, 40, 10); 
        tres55.setFill(Color.BLACK); 
        Group grupo33= new Group(tres11,tres22,tres33,tres44,tres55);
        grupo33.setScaleX(0.5);
        grupo33.setScaleY(0.5);
        
        Rectangle cuatro11 = new Rectangle(10, 0, 10, 30); 
        cuatro11.setFill(Color.BLACK); 
        Rectangle cuatro22 = new Rectangle(40, 0, 10, 60); 
        cuatro22.setFill(Color.BLACK); 
        Rectangle cuatro33 = new Rectangle(10, 30, 40, 10); 
        cuatro33.setFill(Color.BLACK); 
        Group grupo44= new Group(cuatro11,cuatro22,cuatro33);
        grupo44.setScaleX(0.5);
        grupo44.setScaleY(0.5);
        
        Rectangle cinco11 = new Rectangle(10, 0, 40, 10); 
        cinco11.setFill(Color.BLACK); 
        Rectangle cinco22 = new Rectangle(10, 10, 10, 30); 
        cinco22.setFill(Color.BLACK); 
        Rectangle cinco33 = new Rectangle(10, 30, 40, 10); 
        cinco33.setFill(Color.BLACK); 
        Rectangle cinco44 = new Rectangle(40, 30, 10, 30); 
        cinco44.setFill(Color.BLACK); 
        Rectangle cinco55 = new Rectangle(10, 50, 40, 10); 
        cinco55.setFill(Color.BLACK); 
        Group grupo55= new Group(cinco11,cinco22,cinco33,cinco44,cinco55);
        grupo55.setScaleX(0.5);
        grupo55.setScaleY(0.5);
        
        Rectangle seis11 = new Rectangle(10, 0, 30, 10); 
        seis11.setFill(Color.BLACK); 
        Rectangle seis22 = new Rectangle(10, 0, 10, 60); 
        seis22.setFill(Color.BLACK); 
        Rectangle seis33 = new Rectangle(10, 30, 40, 10); 
        seis33.setFill(Color.BLACK); 
        Rectangle seis44 = new Rectangle(40, 30, 10, 30); 
        seis44.setFill(Color.BLACK); 
        Rectangle seis55 = new Rectangle(10, 50, 40, 10); 
        seis55.setFill(Color.BLACK);
        Group grupo66= new Group(seis11,seis22,seis33,seis44,seis55);
        grupo66.setScaleX(0.5);
        grupo66.setScaleY(0.5);
        
        Rectangle siete11 = new Rectangle(15, 0, 30, 10); 
        siete11.setFill(Color.BLACK); 
        Rectangle siete22 = new Rectangle(35, 0, 10, 60); 
        siete22.setFill(Color.BLACK); 
        Group grupo77= new Group(siete11,siete22);
        grupo77.setScaleX(0.5);
        grupo77.setScaleY(0.5);
    
         Rectangle ocho11 = new Rectangle(10, 0, 40, 10); 
        ocho11.setFill(Color.BLACK); 
        Rectangle ocho22 = new Rectangle(10, 0, 10, 60); 
        ocho22.setFill(Color.BLACK); 
        Rectangle ocho33 = new Rectangle(10, 30, 40, 10); 
        ocho33.setFill(Color.BLACK); 
        Rectangle ocho44 = new Rectangle(10, 50, 40, 10); 
        ocho44.setFill(Color.BLACK); 
        Rectangle ocho55= new Rectangle(40, 0, 10, 60); 
        ocho5.setFill(Color.BLACK); 
        Group grupo88= new Group(ocho11,ocho22,ocho33,ocho44,ocho55);
        grupo88.setScaleX(0.5);
        grupo88.setScaleY(0.5);
        
        Rectangle nueve11 = new Rectangle(10, 0, 40, 10); 
        nueve11.setFill(Color.BLACK); 
        Rectangle nueve22 = new Rectangle(10, 0, 10, 40); 
        nueve22.setFill(Color.BLACK); 
        Rectangle nueve33 = new Rectangle(10, 30, 40, 10); 
        nueve33.setFill(Color.BLACK); 
        Rectangle nueve44 = new Rectangle(40, 0, 10, 60); 
        nueve44.setFill(Color.BLACK); 
        Group grupo99= new Group(nueve11,nueve22,nueve33,nueve44);
        grupo99.setScaleX(0.5);
        grupo99.setScaleY(0.5);
        
        numeros.add(grupo0);
        numeros.add(grupo1);
        numeros.add(grupo2);
        numeros.add(grupo3);
        numeros.add(grupo4);
        numeros.add(grupo5);
        numeros.add(grupo6);
        numeros.add(grupo7);
        numeros.add(grupo8);
        numeros.add(grupo9); 
        numeros.add(grupo00);
        numeros.add(grupo11);
        numeros.add(grupo22);
        numeros.add(grupo33);
        numeros.add(grupo44);
        numeros.add(grupo55);
        numeros.add(grupo66);
        numeros.add(grupo77);
        numeros.add(grupo88);
        numeros.add(grupo99); 
        

       return numeros;
    } 
     
    public ArrayList<Group> AlmacenarNumeros2(){
        ArrayList <Group> numeros= new ArrayList();
        
        Rectangle cero1 = new Rectangle(5, 0, 40, 10); 
        cero1.setFill(Color.WHITE); 
        Rectangle cero2 = new Rectangle(5, 0, 10, 60); 
        cero2.setFill(Color.WHITE); 
        Rectangle cero3 = new Rectangle(5, 50, 40, 10); 
        cero3.setFill(Color.WHITE); 
        Rectangle cero4 = new Rectangle(45, 0, 10, 60); 
        cero4.setFill(Color.WHITE); 
        Group grupo0= new Group(cero1,cero2,cero3,cero4);
        grupo0.setScaleX(0.5);
        grupo0.setScaleY(0.5);
        
       
        Rectangle uno1 = new Rectangle(15, 0, 30, 60); 
        uno1.setFill(Color.WHITE);
        uno1.setScaleX(0.5);
        uno1.setScaleY(0.5);
        Group grupo1= new Group(uno1);
        
        Rectangle dos1 = new Rectangle(10, 0, 40, 10); 
        dos1.setFill(Color.WHITE); 
        Rectangle dos2 = new Rectangle(40, 0, 10, 30); 
        dos2.setFill(Color.WHITE); 
        Rectangle dos3 = new Rectangle(10, 30, 40, 10); 
        dos3.setFill(Color.WHITE); 
        Rectangle dos4 = new Rectangle(10, 30, 10, 30); 
        dos4.setFill(Color.WHITE); 
        Rectangle dos5 = new Rectangle(10, 50, 40, 10); 
        dos5.setFill(Color.WHITE); 
        Group grupo2= new Group(dos1,dos2,dos3,dos4,dos5);
        grupo2.setScaleX(0.5);
        grupo2.setScaleY(0.5);
        
        Rectangle tres1 = new Rectangle(10, 0, 40, 10); 
        tres1.setFill(Color.WHITE); 
        Rectangle tres2 = new Rectangle(40, 10, 10, 30); 
        tres2.setFill(Color.WHITE); 
        Rectangle tres3 = new Rectangle(10, 30, 40, 10); 
        tres3.setFill(Color.WHITE); 
        Rectangle tres4 = new Rectangle(40, 30, 10, 30); 
        tres4.setFill(Color.WHITE); 
        Rectangle tres5 = new Rectangle(10, 50, 40, 10); 
        tres5.setFill(Color.WHITE); 
        Group grupo3= new Group(tres1,tres2,tres3,tres4,tres5);
        grupo3.setScaleX(0.5);
        grupo3.setScaleY(0.5);
        
        Rectangle cuatro1 = new Rectangle(10, 0, 10, 30); 
        cuatro1.setFill(Color.WHITE); 
        Rectangle cuatro2 = new Rectangle(40, 0, 10, 60); 
        cuatro2.setFill(Color.WHITE); 
        Rectangle cuatro3 = new Rectangle(10, 30, 40, 10); 
        cuatro3.setFill(Color.WHITE); 
        Group grupo4= new Group(cuatro1,cuatro2,cuatro3);
        grupo4.setScaleX(0.5);
        grupo4.setScaleY(0.5);
        
        Rectangle cinco1 = new Rectangle(10, 0, 40, 10); 
        cinco1.setFill(Color.WHITE); 
        Rectangle cinco2 = new Rectangle(10, 10, 10, 30); 
        cinco2.setFill(Color.WHITE); 
        Rectangle cinco3 = new Rectangle(10, 30, 40, 10); 
        cinco3.setFill(Color.WHITE); 
        Rectangle cinco4 = new Rectangle(40, 30, 10, 30); 
        cinco4.setFill(Color.WHITE); 
        Rectangle cinco5 = new Rectangle(10, 50, 40, 10); 
        cinco5.setFill(Color.WHITE); 
        Group grupo5= new Group(cinco1,cinco2,cinco3,cinco4,cinco5);
        grupo5.setScaleX(0.5);
        grupo5.setScaleY(0.5);
        
        Rectangle seis1 = new Rectangle(10, 0, 30, 10); 
        seis1.setFill(Color.WHITE); 
        Rectangle seis2 = new Rectangle(10, 0, 10, 60); 
        seis2.setFill(Color.WHITE); 
        Rectangle seis3 = new Rectangle(10, 30, 40, 10); 
        seis3.setFill(Color.WHITE); 
        Rectangle seis4 = new Rectangle(40, 30, 10, 30); 
        seis4.setFill(Color.WHITE); 
        Rectangle seis5 = new Rectangle(10, 50, 40, 10); 
        seis5.setFill(Color.WHITE);
        Group grupo6= new Group(seis1,seis2,seis3,seis4,seis5);
        grupo6.setScaleX(0.5);
        grupo6.setScaleY(0.5);
        
        Rectangle siete1 = new Rectangle(15, 0, 30, 10); 
        siete1.setFill(Color.WHITE); 
        Rectangle siete2 = new Rectangle(35, 0, 10, 60); 
        siete2.setFill(Color.WHITE); 
        Group grupo7= new Group(siete1,siete2);
        grupo7.setScaleX(0.5);
        grupo7.setScaleY(0.5);
    
         Rectangle ocho1 = new Rectangle(10, 0, 40, 10); 
        ocho1.setFill(Color.WHITE); 
        Rectangle ocho2 = new Rectangle(10, 0, 10, 60); 
        ocho2.setFill(Color.WHITE); 
        Rectangle ocho3 = new Rectangle(10, 30, 40, 10); 
        ocho3.setFill(Color.WHITE); 
        Rectangle ocho4 = new Rectangle(10, 50, 40, 10); 
        ocho4.setFill(Color.WHITE); 
        Rectangle ocho5 = new Rectangle(40, 0, 10, 60); 
        ocho5.setFill(Color.WHITE); 
        Group grupo8= new Group(ocho1,ocho2,ocho3,ocho4,ocho5);
        grupo8.setScaleX(0.5);
        grupo8.setScaleY(0.5);
        
        Rectangle nueve1 = new Rectangle(10, 0, 40, 10); 
        nueve1.setFill(Color.WHITE); 
        Rectangle nueve2 = new Rectangle(10, 0, 10, 40); 
        nueve2.setFill(Color.WHITE); 
        Rectangle nueve3 = new Rectangle(10, 30, 40, 10); 
        nueve3.setFill(Color.WHITE); 
        Rectangle nueve4 = new Rectangle(40, 0, 10, 60); 
        nueve4.setFill(Color.WHITE); 
        Group grupo9= new Group(nueve1,nueve2,nueve3,nueve4);
        grupo9.setScaleX(0.5);
        grupo9.setScaleY(0.5);
        
        Rectangle cero11 = new Rectangle(5, 0, 40, 10); 
        cero1.setFill(Color.WHITE); 
        Rectangle cero22 = new Rectangle(5, 0, 10, 60); 
        cero2.setFill(Color.WHITE); 
        Rectangle cero33 = new Rectangle(5, 50, 40, 10); 
        cero3.setFill(Color.WHITE); 
        Rectangle cero44 = new Rectangle(45, 0, 10, 60); 
        cero4.setFill(Color.WHITE); 
        Group grupo00= new Group(cero11,cero22,cero33,cero44);
        grupo00.setScaleX(0.5);
        grupo00.setScaleY(0.5);
        
       
        Rectangle uno11 = new Rectangle(15, 0, 30, 60); 
        uno11.setFill(Color.WHITE);
        uno11.setScaleX(0.5);
        uno11.setScaleY(0.5);
        Group grupo11= new Group(uno11);
        
        Rectangle dos11 = new Rectangle(10, 0, 40, 10); 
        dos11.setFill(Color.WHITE); 
        Rectangle dos22 = new Rectangle(40, 0, 10, 30); 
        dos22.setFill(Color.WHITE); 
        Rectangle dos33 = new Rectangle(10, 30, 40, 10); 
        dos33.setFill(Color.WHITE); 
        Rectangle dos44 = new Rectangle(10, 30, 10, 30); 
        dos44.setFill(Color.WHITE); 
        Rectangle dos55 = new Rectangle(10, 50, 40, 10); 
        dos55.setFill(Color.WHITE); 
        Group grupo22= new Group(dos11,dos22,dos33,dos44,dos55);
        grupo22.setScaleX(0.5);
        grupo22.setScaleY(0.5);
        
        Rectangle tres11 = new Rectangle(10, 0, 40, 10); 
        tres11.setFill(Color.WHITE); 
        Rectangle tres22 = new Rectangle(40, 10, 10, 30); 
        tres22.setFill(Color.WHITE); 
        Rectangle tres33 = new Rectangle(10, 30, 40, 10); 
        tres33.setFill(Color.WHITE); 
        Rectangle tres44 = new Rectangle(40, 30, 10, 30); 
        tres44.setFill(Color.WHITE); 
        Rectangle tres55 = new Rectangle(10, 50, 40, 10); 
        tres55.setFill(Color.WHITE); 
        Group grupo33= new Group(tres11,tres22,tres33,tres44,tres55);
        grupo33.setScaleX(0.5);
        grupo33.setScaleY(0.5);
        
        Rectangle cuatro11 = new Rectangle(10, 0, 10, 30); 
        cuatro11.setFill(Color.WHITE); 
        Rectangle cuatro22 = new Rectangle(40, 0, 10, 60); 
        cuatro22.setFill(Color.WHITE); 
        Rectangle cuatro33 = new Rectangle(10, 30, 40, 10); 
        cuatro33.setFill(Color.WHITE); 
        Group grupo44= new Group(cuatro11,cuatro22,cuatro33);
        grupo44.setScaleX(0.5);
        grupo44.setScaleY(0.5);
        
        Rectangle cinco11 = new Rectangle(10, 0, 40, 10); 
        cinco11.setFill(Color.WHITE); 
        Rectangle cinco22 = new Rectangle(10, 10, 10, 30); 
        cinco22.setFill(Color.WHITE); 
        Rectangle cinco33 = new Rectangle(10, 30, 40, 10); 
        cinco33.setFill(Color.WHITE); 
        Rectangle cinco44 = new Rectangle(40, 30, 10, 30); 
        cinco44.setFill(Color.WHITE); 
        Rectangle cinco55 = new Rectangle(10, 50, 40, 10); 
        cinco55.setFill(Color.WHITE); 
        Group grupo55= new Group(cinco11,cinco22,cinco33,cinco44,cinco55);
        grupo55.setScaleX(0.5);
        grupo55.setScaleY(0.5);
        
        Rectangle seis11 = new Rectangle(10, 0, 30, 10); 
        seis11.setFill(Color.WHITE); 
        Rectangle seis22 = new Rectangle(10, 0, 10, 60); 
        seis22.setFill(Color.WHITE); 
        Rectangle seis33 = new Rectangle(10, 30, 40, 10); 
        seis33.setFill(Color.WHITE); 
        Rectangle seis44 = new Rectangle(40, 30, 10, 30); 
        seis44.setFill(Color.WHITE); 
        Rectangle seis55 = new Rectangle(10, 50, 40, 10); 
        seis55.setFill(Color.WHITE);
        Group grupo66= new Group(seis11,seis22,seis33,seis44,seis55);
        grupo66.setScaleX(0.5);
        grupo66.setScaleY(0.5);
        
        Rectangle siete11 = new Rectangle(15, 0, 30, 10); 
        siete11.setFill(Color.WHITE); 
        Rectangle siete22 = new Rectangle(35, 0, 10, 60); 
        siete22.setFill(Color.WHITE); 
        Group grupo77= new Group(siete11,siete22);
        grupo77.setScaleX(0.5);
        grupo77.setScaleY(0.5);
    
         Rectangle ocho11 = new Rectangle(10, 0, 40, 10); 
        ocho11.setFill(Color.WHITE); 
        Rectangle ocho22 = new Rectangle(10, 0, 10, 60); 
        ocho22.setFill(Color.WHITE); 
        Rectangle ocho33 = new Rectangle(10, 30, 40, 10); 
        ocho33.setFill(Color.WHITE); 
        Rectangle ocho44 = new Rectangle(10, 50, 40, 10); 
        ocho44.setFill(Color.WHITE); 
        Rectangle ocho55= new Rectangle(40, 0, 10, 60); 
        ocho55.setFill(Color.WHITE); 
        Group grupo88= new Group(ocho11,ocho22,ocho33,ocho44,ocho55);
        grupo88.setScaleX(0.5);
        grupo88.setScaleY(0.5);
        
        Rectangle nueve11 = new Rectangle(10, 0, 40, 10); 
        nueve11.setFill(Color.WHITE); 
        Rectangle nueve22 = new Rectangle(10, 0, 10, 40); 
        nueve22.setFill(Color.WHITE); 
        Rectangle nueve33 = new Rectangle(10, 30, 40, 10); 
        nueve33.setFill(Color.WHITE); 
        Rectangle nueve44 = new Rectangle(40, 0, 10, 60); 
        nueve44.setFill(Color.WHITE); 
        Group grupo99= new Group(nueve11,nueve22,nueve33,nueve44);
        grupo99.setScaleX(0.5);
        grupo99.setScaleY(0.5);
        
        numeros.add(grupo0);
        numeros.add(grupo1);
        numeros.add(grupo2);
        numeros.add(grupo3);
        numeros.add(grupo4);
        numeros.add(grupo5);
        numeros.add(grupo6);
        numeros.add(grupo7);
        numeros.add(grupo8);
        numeros.add(grupo9); 
        numeros.add(grupo00);
        numeros.add(grupo11);
        numeros.add(grupo22);
        numeros.add(grupo33);
        numeros.add(grupo44);
        numeros.add(grupo55);
        numeros.add(grupo66);
        numeros.add(grupo77);
        numeros.add(grupo88);
        numeros.add(grupo99); 
        

       return numeros;
    } 
    
    public AnchorPane DibujarNumeros(AnchorPane caja, int numero, ArrayList <Group> numeros){
        
        if (numero>9){
            //agregar excepcion cuando los numeros sean iguales
            if ((numero/10) == (numero%10)){
                
       
                                
                numeros.get(numero/10).setLayoutX(-10);
                numeros.get(numero/10).setScaleX(0.4);
                caja.getChildren().add(numeros.get(numero/10));
                numeros.get((numero%10)+10).setLayoutX(10);
                numeros.get((numero%10)+10).setScaleX(0.4);
                caja.getChildren().add(numeros.get((numero%10)+10));
                
            }else{
                numeros.get(numero/10).setLayoutX(-10);
                numeros.get(numero/10).setScaleX(0.4);
                caja.getChildren().add(numeros.get(numero/10));
                numeros.get(numero%10).setLayoutX(10);
                numeros.get(numero%10).setScaleX(0.4);
                caja.getChildren().add(numeros.get(numero%10));       
            } 
            
        }else{
             
            if (numero==1){
                numeros.get(numero).setScaleX(0.4);              
                caja.getChildren().add(numeros.get(numero));
            }
            else{
                caja.getChildren().add(numeros.get(numero));
            }
        }
        
    return caja;
    }
    
    public AnchorPane DibujarNumeros2(AnchorPane caja, int numero, ArrayList <Group> numeros){
        
        if (numero>9){
            //agregar excepcion cuando los numeros sean iguales
            if ((numero/10) == (numero%10)){
                
                if (numero/10==1){ // en caso de que el numero sea 11
                    
                    numeros.get(numero/10).setLayoutX(-10);
                    numeros.get(numero/10).setLayoutY(0);
                    numeros.get(numero/10).setScaleX(0.6);
                    numeros.get(numero/10).setScaleY(1.2);
                    caja.getChildren().add(numeros.get(numero/10));
                    numeros.get((numero%10)+10).setLayoutX(10);
                    numeros.get((numero%10)+10).setLayoutY(0);
                    numeros.get((numero%10)+10).setScaleX(0.6);
                    numeros.get((numero%10)+10).setScaleY(1.2);
                    caja.getChildren().add(numeros.get((numero%10)+10));                
                }
                else{  //en caso de que sean 2 numeros iguales distintos a 11
                   numeros.get(numero/10).setLayoutX(-12);
                   numeros.get(numero/10).setLayoutY(0);
                   numeros.get(numero/10).setScaleX(0.45);
                   numeros.get(numero/10).setScaleY(0.65);
                   caja.getChildren().add(numeros.get(numero/10));
                   numeros.get((numero%10)+10).setLayoutX(12);
                   numeros.get((numero%10)+10).setLayoutY(0);
                   numeros.get((numero%10)+10).setScaleX(0.45);
                   numeros.get((numero%10)+10).setScaleY(0.65);
                  caja.getChildren().add(numeros.get((numero%10)+10));

                }
                
  
                
            }else{
                
                if((numero/10)==1){
                numeros.get(numero/10).setLayoutX(-12);
                numeros.get(numero/10).setScaleX(0.45);
                numeros.get(numero/10).setScaleY(1.3);
                 numeros.get(numero/10).setLayoutY(0);
                caja.getChildren().add(numeros.get(numero/10));
                numeros.get(numero%10).setLayoutX(12);
                numeros.get((numero%10)).setLayoutY(0);
                numeros.get(numero%10).setScaleX(0.45);
                numeros.get(numero%10).setScaleY(0.65);
                caja.getChildren().add(numeros.get(numero%10));  
                }
                else if((numero%10)==1){
                numeros.get(numero/10).setLayoutX(-12);
                numeros.get(numero/10).setScaleX(0.45);
                numeros.get(numero/10).setScaleY(0.65);
                 numeros.get(numero/10).setLayoutY(0);
                caja.getChildren().add(numeros.get(numero/10));
                numeros.get(numero%10).setLayoutX(12);
                numeros.get((numero%10)).setLayoutY(0);
                numeros.get(numero%10).setScaleX(0.45);
                numeros.get(numero%10).setScaleY(1.3);
                caja.getChildren().add(numeros.get(numero%10));  
                }
                
                else{
                numeros.get(numero/10).setLayoutX(-12);
                numeros.get(numero/10).setScaleX(0.45);
                numeros.get(numero/10).setScaleY(0.65);
                numeros.get(numero/10).setLayoutY(0);
                caja.getChildren().add(numeros.get(numero/10));
                numeros.get(numero%10).setLayoutX(12);
                numeros.get((numero%10)).setLayoutY(0);
                numeros.get(numero%10).setScaleX(0.45);
                numeros.get(numero%10).setScaleY(0.65);
                caja.getChildren().add(numeros.get(numero%10));
                
                
                }
                
 
            } 
            
        }else{
             
            if (numero==1){
                numeros.get(numero).setScaleX(0.5);             
                numeros.get(numero).setLayoutX(0); 
                numeros.get(numero).setLayoutY(0); 
                caja.getChildren().add(numeros.get(numero));
            }
            else{
                numeros.get(numero).setLayoutX(0);
                numeros.get(numero).setLayoutY(0);
                numeros.get(numero).setScaleY(0.65);
                numeros.get(numero).setScaleX(0.7);
                caja.getChildren().add(numeros.get(numero));
                
            }
        }
        
    return caja;
    }
    
    
    public AnchorPane dibujarLocomotora(AnchorPane anchor, int x, int y){
    AnchorPane locomotora = new AnchorPane();
    
    Rectangle rectangulo1 = new Rectangle(0,0,80,35);
    rectangulo1.setFill(Color.web("#FEF300"));
    rectangulo1.setStroke(Color.BLACK);
    
    Rectangle rectangulo2 = new Rectangle(0,0,5,25);
    rectangulo2.setFill(Color.web("#C9F5F0"));
    rectangulo2.setStroke(Color.BLACK);
    rectangulo2.setLayoutX(75);
    rectangulo2.setLayoutY(5);
    
    Line linea1= new Line();
    linea1.setStartX(80);
    linea1.setStartY(0);
    linea1.setEndX(90);
    linea1.setEndY(17.5);
     linea1.setStrokeWidth(3);

    Line linea2= new Line();
    linea2.setStartX(90);
    linea2.setStartY(17.5);
    linea2.setEndX(80);
    linea2.setEndY(35);
    linea2.setStrokeWidth(3); 
    
    Line linea3= new Line();
    linea3.setStartX(81);
    linea3.setStartY(11.5);
    linea3.setEndX(84);
    linea3.setEndY(11.5);
    linea3.setStrokeWidth(3); 
    
    Line linea4= new Line();
    linea4.setStartX(81);
    linea4.setStartY(23);
    linea4.setEndX(84);
    linea4.setEndY(23);
    linea4.setStrokeWidth(3); 
    
    Line linea5= new Line();
    linea5.setStartX(81);
    linea5.setStartY(17.5);
    linea5.setEndX(88);
    linea5.setEndY(17.5);
    linea5.setStrokeWidth(3); 
     
    Circle circulo= new Circle(20,17.5,10);
    circulo.setFill(Color.web("#5C5D5D"));
    
    Circle circulo2= new Circle(20,17.5,5);
    circulo2.setFill(Color.BLACK);
    
    Circle circulo4= new Circle(50,17.5,10);
    circulo4.setFill(Color.web("#5C5D5D"));
    
    Circle circulo5= new Circle(50,17.5,5);
    circulo5.setFill(Color.BLACK);
    
    
    locomotora.getChildren().add(rectangulo1);
    locomotora.getChildren().add(rectangulo2);
    locomotora.getChildren().add(linea1);
    locomotora.getChildren().add(linea2);
    locomotora.getChildren().add(linea3);
    locomotora.getChildren().add(linea4);
    locomotora.getChildren().add(linea5);
    locomotora.getChildren().add(circulo);
    locomotora.getChildren().add(circulo2);
    locomotora.getChildren().add(circulo4);
    locomotora.getChildren().add(circulo5);
    locomotora.setLayoutX(x);
    locomotora.setLayoutY(y);
    
    
    
    anchor.getChildren().add(locomotora);
    
    return anchor;
    } 
    
    public AnchorPane dibujargancho(AnchorPane anchor, int posx, int posy){
        AnchorPane gancho= new AnchorPane();
        gancho.setPrefSize(100,500);
        gancho.setLayoutX(posx);
        gancho.setLayoutY(posy);
        
        Rectangle rectangulo1 = new Rectangle(20,0,10,180);
        rectangulo1.setFill(Color.BLUE);
        rectangulo1.setStroke(Color.BLACK);
        rectangulo1.setStrokeWidth(2);
        
        
        
        Rectangle rectangulo2 = new Rectangle(20,185,40,10);
        rectangulo2.setFill(Color.BLUE);
        rectangulo2.setRotate(45);
        rectangulo2.setStroke(Color.BLACK);
        rectangulo2.setStrokeWidth(2);
       
        Rectangle rectangulo3 = new Rectangle(22,210,40,10);
        rectangulo3.setFill(Color.BLUE);
        rectangulo3.setRotate(-53);
        rectangulo3.setStroke(Color.BLACK);
        rectangulo3.setStrokeWidth(2);
        
        Rectangle rectangulo4 = new Rectangle(-12,185,40,10);
        rectangulo4.setFill(Color.BLUE);
        rectangulo4.setRotate(-45);
        rectangulo4.setStroke(Color.BLACK);
        rectangulo4.setStrokeWidth(2);
       
        Rectangle rectangulo5 = new Rectangle(-17,210,40,10);
        rectangulo5.setFill(Color.BLUE);
        rectangulo5.setRotate(53);
        rectangulo5.setStroke(Color.BLACK);
        rectangulo5.setStrokeWidth(2);
        
        gancho.getChildren().add(rectangulo1);
        gancho.getChildren().add(rectangulo2);
        gancho.getChildren().add(rectangulo3);
        gancho.getChildren().add(rectangulo4);
        gancho.getChildren().add(rectangulo5);
        anchor.getChildren().add(gancho);
        
        return gancho;
    }
    
    public AnchorPane dibujarcuerda (int posx, int posy){
        AnchorPane cuerda= new AnchorPane();
        cuerda.setPrefSize(100,500);
        cuerda.setLayoutX(posx);
        cuerda.setLayoutY(posy);
        
        Rectangle rectangulo6 = new Rectangle(20,0,10,200);
        rectangulo6.setFill(Color.RED);
        rectangulo6.setStroke(Color.BLACK);
        rectangulo6.setStrokeWidth(2);
        
        cuerda.getChildren().add(rectangulo6);
        
        
        return cuerda;
    }
}
