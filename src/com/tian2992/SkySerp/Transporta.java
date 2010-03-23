package com.tian2992.SkySerp;

public abstract class Transporta {
  static final int TIPOSERP = 1;
  static final int TIPOESCA = 2;

  private int ini;
  private int fin;
  private int tipo;

  Transporta(int i, int f){
    setIni(i);
    setFin(f);
  }

  public int getFin() {
    return fin;
  }

  public void setFin(int fin) {
    this.fin = fin;
  }

  public int getIni() {
    return ini;
  }

  public void setIni(int ini) {
    this.ini = ini;
  }

  public int getTipo() {
    return tipo;
  }

  public void setTipo(int tipo) {
    this.tipo = tipo;
  }
}
