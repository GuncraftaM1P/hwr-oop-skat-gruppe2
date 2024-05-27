package hwr.oop.skat.gruppe2.domain;

import hwr.oop.skat.gruppe2.application.*;

import java.util.ArrayList;
import java.util.List;

public class KartenStapel {
    private KartenListe deck;

  public KartenStapel() {
      this.deck = neuerKartenStapel();
  }

  public KartenListe neuerKartenStapel() {
      KartenListe karten = new KartenListe();
    List<Wert> werte = Wert.getZahlen();
    List<Farbe> farben = Farbe.getFarben();
    for (Wert wert : werte) {
      for (Farbe farbe : farben) {
        karten.addKarte(new Karte(farbe,wert));
      }
    }
    return karten;
  }

  public KartenListe kartenVerteilen(List<SpielendeSpieler> spielendeSpieler){
      int i = 0;
      while (this.deck.size() > 2) {
          int zufallsZahl = (int) Math.floor(Math.random() * this.deck.size());
          if (zufallsZahl != this.deck.size()) {
              spielendeSpieler.get(i).karteAufDieHand(this.deck.getKarte(zufallsZahl));
              this.deck.removeKarte(deck.getKarte(zufallsZahl));
              i ++;
              if (i == spielendeSpieler.size()) {
                  i = 0;
              }
          }
      }
      return this.deck;
  }

}

