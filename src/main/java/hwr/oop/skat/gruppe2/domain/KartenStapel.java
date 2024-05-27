package hwr.oop.skat.gruppe2.domain;

import hwr.oop.skat.gruppe2.application.*;

import java.util.ArrayList;
import java.util.List;

public class KartenStapel {
    private List<Karte> deck;
    private List<Karte> gelegteKarte;

  public KartenStapel() {
      this.deck = neuerKartenStapel();
      this.gelegteKarte = new ArrayList<>();
  }

  public List<Karte> neuerKartenStapel() {
    // TODO warum Array List ?
    List<Karte> karten = new ArrayList<>();
    List<Wert> werte = Wert.getZahlen();
    List<Farbe> farben = Farbe.getFarben();
    for (Wert wert : werte) {
      for (Farbe farbe : farben) {
        karten.add(new Karte(farbe, wert));
      }
    }
    return karten;
  }

  public void kartenVerteilen(List<SpielendeSpieler> spielendeSpieler){
      int i = 0;
      while (this.deck.size() > 2) {
          int zufallsZahl = (int) Math.floor(Math.random() * this.deck.size());
          if (zufallsZahl != this.deck.size()) {
              spielendeSpieler.get(i).karteAufDieHand(this.deck.get(zufallsZahl));
              this.deck.remove(zufallsZahl);
              i ++;
              if (i == spielendeSpieler.size()) {
                  i = 0;
              }
          }
      }
  }

  // Getter
  public List<Karte> getGelegteKarten() {
      return this.gelegteKarte;
  }
  public List<Karte> getDeck() {
      return this.deck;
  }
  // Setter
    public void addGelegteKarte(Karte karte) {
      this.gelegteKarte.add(karte);
    }
}

