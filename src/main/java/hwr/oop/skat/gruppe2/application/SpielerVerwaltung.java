package hwr.oop.skat.gruppe2.application;

import hwr.oop.skat.gruppe2.Cli.Cli;
import hwr.oop.skat.gruppe2.domain.Spieler;
import hwr.oop.skat.gruppe2.domain.SpielendeSpieler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpielerVerwaltung {


  public static void main(String[] args) {
   //TODO noch erstellen@SuppressWarnings()
    new Cli( System.out, args);


  }

  List<Spieler> spieler; // TODO Laden Liste

  public SpielerVerwaltung() {
    spieler = new ArrayList<>(); //TODO Laden Liste
  }
}




