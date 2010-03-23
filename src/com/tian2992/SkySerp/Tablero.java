package com.tian2992.SkySerp;
//http://processing.org/learning/eclipse/

//http://kuler.adobe.com/#themeID/793579
//http://kuler.adobe.com/#themeID/792586

import processing.core.*;
import java.awt.Color;
import java.util.*;

/**
 *
 * @author tian
 */
public class Tablero extends PApplet {

  static int inicioCeldas = 1;
  
  int HORZ = 600;
  int VERT = 600;
  int MARG = 20;
  int cols, fils;
  PFont font;
  int anchoCol;
  int altuFils;

  boolean orienta = true; //true si es vertical y false si es horizontal

  ArrayList<Serpiente> serpientes = new ArrayList<Serpiente>();
  ArrayList<Escalera>  escaleras  = new ArrayList<Escalera> ();
  ArrayList<Jugador>   jugadores  = new ArrayList<Jugador>  ();

  ArrayList<Integer> jugadors = new ArrayList<Integer>();

  ArrayList<Integer> serpsIni = new ArrayList<Integer>();
  ArrayList<Integer> serpsFin = new ArrayList<Integer>();

  ArrayList<Integer> escalIni = new ArrayList<Integer>();
  ArrayList<Integer> escalFin = new ArrayList<Integer>();

  int fondin = Color.decode("#543112").getRGB();
  int bgCell = Color.decode("#9EA191").getRGB();

  int numCol = Color.decode("#2F3536").getRGB();

  int escIni = Color.decode("#E40000").getRGB();
  int escFin = Color.decode("#400000").getRGB();

  int serIni = Color.decode("#00E400").getRGB();
  int serFin = Color.decode("#004000").getRGB();

  int grey = 128;

  void dibuja() {
    boolean bandera = true;
    int numCel = inicioCeldas;
    if (!orienta){
      for (int j=fils-1;j>=0;j--){
        if (bandera){
          for (int i = 0; i<cols; i++){
            dibujaCuadro(i,j,numCel);
            numCel++;
          }
          bandera = false;
        } else {
          for (int i = cols - 1; i >= 0; i--) {
            dibujaCuadro(i,0, numCel);
            numCel++;
          }
          bandera = true;
        }
      }
    } else {
      for (int i=cols-1;i>=0;i--){
        if (bandera){
          for (int j=fils-1;j>=0;j--){
            dibujaCuadro(i,j,numCel);
            numCel++;
          }
          bandera = false;
        } else {
          for (int j=0;j<fils;j++){
            dibujaCuadro(i,j,numCel);
            numCel++;
          }
          bandera = true;
        }
      }
    }
  }
  private int anclaY;
  private int anclaX;

  private Boolean isHover;

  void dibujaCuadro(int i, int j, int numCel){
    anclaX = MARG + anchoCol * i;
    anclaY = MARG + altuFils * j;

    fill(bgCell);

    if ((mouseX > anclaX && mouseX < anclaX + anchoCol) && (mouseY > anclaY && mouseY < anclaY + altuFils)) {
      isHover = true;
      fill(grey);
    }
    else {
      isHover = false;
    }

    if (serpsIni.contains(numCel)){
      fill(serIni);
    } else
    if (serpsFin.contains(numCel)){
      fill(serFin);
    }

    if (escalIni.contains(numCel)){
      fill(escIni);
    } else
    if (escalFin.contains(numCel)){
      fill(escFin);
    }


    rect(anclaX, anclaY, anchoCol, altuFils);
    fill(numCol);
    text(numCel, anclaX + 5, anclaY + 25);

    for (Jugador jug: jugadores){
      if (jug.celda == numCel){
        if (isHover){
          //System.out.println("blarg");
        }
        fill(jug.color);
        ellipse((anchoCol/2)+anclaX+jug.getTurno()*10,(altuFils/2)+anclaY+jug.getTurno()*10,anchoCol/3,altuFils/3);
      }
    }

  }

  @Override
  public void setup() {
    //size(HORZ,VERT,PConstants.P3D);
    size(HORZ, VERT);
    smooth();

    cols=4;
    fils=4;

    anchoCol = (HORZ - 2 * MARG) / cols;
    altuFils = (VERT - 2 * MARG) / fils;

    font = loadFont("AvenirLT-Black-24.vlw");
    textFont(font);
    ellipseMode(CENTER);

    serpientes.add(new Serpiente(5,2));

    escaleras.add(new Escalera(6,8));

    jugadores.add(new Jugador("Pepe",1,"#FFFCCC",2));
    jugadores.add(new Jugador("Carlos",2,"#CCCFFF",12));
    
    for (Serpiente serp: serpientes){ //Solo se hace una vez porque no se cambian
      serpsIni.add(serp.getIni());
      serpsFin.add(serp.getFin());
    }
    for (Escalera   esc: escaleras){ //Solo se hace una vez porque no se cambian
      escalIni.add(esc.getIni());
      escalFin.add(esc.getFin());
    }

    orienta = true;

  }
  @Override
  public void draw() {

    //jugadores.get(0).setCelda(jugadores.get(0).getCelda()+1);

    background(fondin);

    dibuja();
  }
}
