package hwr.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpielerVerwaltung {


  public static void main(String[] args) {
    // TODO
    // Das laden von allen Spielern und auswählen von den Spielern die Spielen wollen.

      //TODO
    // Neue Spieler anlegen gewonnene runden anzeigen lassen
    SpielerVerwaltung spielerVerwaltung = new SpielerVerwaltung();

    while(true) {
      System.out.println("Geben Sie ein, was sie tun möchten: \n 1 - Neuen Spieler anlegen \n 2 - Spieler löschen \n 3 - Alle Spieler anzeigen \n 4 - Spieler auswählen \n 5 - Spielende Spieler anzeigen \n 0 - Beenden");
      Scanner in = new Scanner(System.in);
      String input = in.nextLine();
      switch (input) {
        case "1":spielerVerwaltung.neuenSpielerAnlegen();
            break;
        case "2": spielerVerwaltung.spielerLoeschen();
          break;
        case "3": spielerVerwaltung.alleSpielerAnzeigen();
        break;
        case "4":spielerVerwaltung.spielerAuswahlFueSpiel();
          break;
        case "5":List<SpielendeSpieler> temp = new ArrayList<>();
          temp.add(new SpielendeSpieler(new Spieler("a")));
          temp.add(new SpielendeSpieler(new Spieler("b")));
          temp.add(new SpielendeSpieler(new Spieler("c")));
          new SpielVerwaltung(temp);
          break;
        case "0": return;
      }
    }

  }

  List<Spieler> spieler; // TODO Laden Liste

  public SpielerVerwaltung() {
    spieler = new ArrayList<>(); //TODO Laden Liste
  }

  private void spielerAuswahlFueSpiel(){
    List<SpielendeSpieler> spielendeSpielers = new ArrayList<>();
    System.out.println("Geben Sie den Namen des ersten Spieler ein.");
    Scanner in = new Scanner(System.in);
    String name = in.nextLine();
    if(nameExistiertBerits(name)==null){
      System.out.println("Anfang von Spiel wurde wegen falscher eingabe abgebrochen.");
      return;
    }
    spielendeSpielers.add(new SpielendeSpieler(nameExistiertBerits(name)));

    System.out.println("Geben Sie den Namen des zweiten Spieler ein.");
    name = in.nextLine();
    if(nameExistiertBerits(name)==null||spielerMitNAmenExisiertInListe(spielendeSpielers, name)){
      System.out.println("Anfang von Spiel wurde wegen falscher eingabe abgebrochen.");
      return;
    }
    spielendeSpielers.add(new SpielendeSpieler(nameExistiertBerits(name)));

    System.out.println("Geben Sie den Namen des dritten Spieler ein.");
    name = in.nextLine();
    if(nameExistiertBerits(name)==null||spielerMitNAmenExisiertInListe(spielendeSpielers, name)){
      System.out.println("Anfang von Spiel wurde wegen falscher eingabe abgebrochen.");
      return;
    }
    spielendeSpielers.add(new SpielendeSpieler(nameExistiertBerits(name)));

    System.out.println(spielendeSpielers.size());

    SpielVerwaltung spielVerwaltung = new SpielVerwaltung(spielendeSpielers);

  }

  private boolean spielerMitNAmenExisiertInListe(List<SpielendeSpieler> spielendeSpielerList, String name){
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
