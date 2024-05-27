package hwr.oop.skat.gruppe2.application;

import hwr.oop.skat.gruppe2.Cli.Cli;
import hwr.oop.skat.gruppe2.domain.SpielVerwaltung;
import hwr.oop.skat.gruppe2.domain.Spieler;

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

  private void spielerAuswahlFuerSpiel(){
    List<SpielendeSpieler> spielendeSpieler = new ArrayList<>();
    System.out.println("Geben Sie den Namen des ersten Spieler ein.");
    Scanner in = new Scanner(System.in);
    String name = in.nextLine();
    if(nameExistiertBerits(name)==null){
      System.out.println("Anfang von Spiel wurde wegen falscher eingabe abgebrochen.");
      return;
    }
    spielendeSpieler.add(new SpielendeSpieler(nameExistiertBerits(name)));

    System.out.println("Geben Sie den Namen des zweiten Spieler ein.");
    name = in.nextLine();
    if(nameExistiertBerits(name)==null|| spielerMitNamenExisiertInListe(spielendeSpieler, name)){
      System.out.println("Anfang von Spiel wurde wegen falscher eingabe abgebrochen.");
      return;
    }
    spielendeSpieler.add(new SpielendeSpieler(nameExistiertBerits(name)));

    System.out.println("Geben Sie den Namen des dritten Spieler ein.");
    name = in.nextLine();
    if(nameExistiertBerits(name)==null|| spielerMitNamenExisiertInListe(spielendeSpieler, name)){
      System.out.println("Anfang von Spiel wurde wegen falscher eingabe abgebrochen.");
      return;
    }
    spielendeSpieler.add(new SpielendeSpieler(nameExistiertBerits(name)));

    System.out.println(spielendeSpieler.size());

    SpielVerwaltung spielVerwaltung = new SpielVerwaltung(spielendeSpieler);

  }

  private boolean spielerMitNamenExisiertInListe(List<SpielendeSpieler> spielendeSpielerList, String name){
    for (SpielendeSpieler spielendeSpieler : spielendeSpielerList) {
      if(spielendeSpieler.spieler.getName().equals(name)){
        return true;
      }
    }
    return false;
  }

  private void neuenSpielerAnlegen(){

    System.out.println("Geben Sie den Namen des Neuen Spieler ein.");
    Scanner in = new Scanner(System.in);
    String name = in.nextLine();
    if(nameExistiertBerits(name)!= null){
      System.out.println("Der Name " + name +" ist bereits belegt bitte geben sie einen anderen ein oder geben sie - ein um die Spieler neuerstellung abzubrechen");
      neuenSpielerAnlegen();
    }else if(name.equals("-")){
      return;
    }
    else{
      System.out.println("Der Name von den Neuen Spieler ist " + name);
      spieler.add(new Spieler(name));
    }
  }

  private Spieler nameExistiertBerits(String name){
    for (Spieler spieler : spieler) {
      if(spieler.getName().equals(name)){
        return spieler;
      }
    }
    return null;
  }

  private void spielerLoeschen(){
    System.out.println("Geben Sie den Namen des zulöschenden Spieler ein.");
    Scanner in = new Scanner(System.in);
    String name = in.nextLine();
    for (Spieler spieler : spieler) {
      if(spieler.getName().equals(name)){
        this.spieler.remove(spieler);
        System.out.println("Der Spieler mit den Namen "+ name+ " wurde gelöscht.");
        return;
      }
    }
    System.out.println("Der Spieler mit den Namen "+ name+ " wurde nicht gefunden.");
  }

  private void alleSpielerAnzeigen(){
    for (Spieler spieler : spieler) {
      System.out.println(spieler.getName()+"; ");
    }
  }
}
