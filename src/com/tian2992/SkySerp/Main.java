package com.tian2992.SkySerp;

import java.io.*;
import java.util.*;

public class Main {

  static ArrayList<String> arrList = new ArrayList<String>();

  static ArrayList<String> colourList = new ArrayList<String>();

  public static void main(String[] args) {
    Lexer scanner = null;
    Parser oParser = null; // Con 'P' al inicio.

    try {
      Boolean debu = true;

      //Escaner = new com.tian2992.SkySerp.Lexer(new StringReader(args[0]));

        FileReader x = new FileReader("/home/tian/Compi1/blag.xml");

        //FileReader x = new FileReader ((args[0]));

      //StringReader q = new StringReader("<tablero color_default=\"#FFFF00\" color_alternativo=\"#FF8000\"> </tablero>");

      scanner = new com.tian2992.SkySerp.Lexer(x);
      
      java_cup.runtime.Symbol ns;

      if (!debu){
         ns = scanner.next_token();
        while(ns!=null){
          System.out.println(ns.value + "\t"+ ns.sym);
          ns = scanner.next_token();
        }
      } else {
      
      oParser = new Parser(scanner);
      oParser.parse();
      //oParser.debug_parse();

        System.out.println(oParser.estadoLista);

      for (String s : arrList) {
        System.out.println(s);
      }

      }
      
    } catch (Exception ex) {
      System.out.println(ex.toString());
    }
  }
}

