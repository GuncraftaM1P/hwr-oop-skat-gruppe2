package hwr.oop.skat.gruppe2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Spielfeld {
  private final List<Karte> deck;
  private final List<Karte> gelegteKarte;
  private final Random random;

  public Spielfeld() {
    this.deck = neuerKartenStapel();
    this.gelegteKarte = new ArrayList<>();
    this.random = new Random();
  }

  public List<Karte> neuerKartenStapel() {
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

  public void kartenVerteilen(List<Spieler> spieler) {
    int i = 0;
    while (this.deck.size() > 2) {
      int zufallsZahl = this.random.nextInt(this.deck.size());
      spieler.get(i).karteAufDieHand(this.deck.get(zufallsZahl));
      this.deck.remove(zufallsZahl);
      i++;
      if (i == spieler.size()) {
        i = 0;
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
