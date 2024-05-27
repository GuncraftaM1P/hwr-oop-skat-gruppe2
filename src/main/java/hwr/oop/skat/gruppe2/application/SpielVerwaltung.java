package hwr.oop.skat.gruppe2.application;

import hwr.oop.skat.gruppe2.domain.*;
import hwr.oop.skat.gruppe2.persistence.LadenUndSpeichern;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SpielVerwaltung {

  private List<SpielendeSpieler> spielendeSpielerList = new ArrayList<>();

  private Farbe trumpf;
  private KartenListe skat;
  private Runde runde;

  public SpielVerwaltung(SpielendeSpieler spielendeSpieler1, SpielendeSpieler spielendeSpieler2,SpielendeSpieler spielendeSpieler3) {
    spielendeSpielerList = List.of(spielendeSpieler1, spielendeSpieler2,spielendeSpieler3);
     skat =  new KartenStapel().kartenVerteilen(spielendeSpielerList);
     runde =  null;

     //TODO trumpf soll null sein später
    trumpf =  Farbe.KREUZ;

  }

  public SpielVerwaltung(List<SpielendeSpieler> spielendeSpielern) {
    this.spielendeSpielerList = spielendeSpielern;
  }

  private void starteSpielrunde() {}
}
