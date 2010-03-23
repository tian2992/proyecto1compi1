package com.tian2992.SkySerp;
import java.awt.Color;

public class Jugador {
  String nombre = "";
  int turno;
  int color = 0;
  int celda = Tablero.inicioCeldas;
  
  public Jugador(){
    
  }
  public Jugador(String n){
    setNombre(n);
  }
  public Jugador(String n, int t){
    setNombre(n);
    setTurno(t);
  }
  public Jugador(String n, int t, int c){
    setNombre(n);
    setTurno(t);
    setColor(c);
  }
  public Jugador (String n, int t, String c){
    setNombre(n);
    setTurno(t);
    setColor(Color.decode(c).getRGB());
  }
  public Jugador (String n, int t, String c, int cel){
    setNombre(n);
    setTurno(t);
    setColor(Color.decode(c).getRGB());
    setCelda(cel);
  }
  public Jugador (String n, int t, int c, int cel){
    setNombre(n);
    setTurno(t);
    setColor(c);
    setCelda(cel);
  }

  public int getCelda() {
    return celda;
  }

  public void setCelda(int celda) {
    this.celda = celda;
  }

  public int getColor() {
    return color;
  }

  public void setColor(int color) {
    this.color = color;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getTurno() {
    return turno;
  }

  public void setTurno(int turno) {
    this.turno = turno;
  }

}
