package hwr.oop.skat.gruppe2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Spielfeld {
  private final List<Karte> deck;
  private final List<Karte> gelegteKarte;

  public Spielfeld() {
    this.deck = neuerKartenStapel();
    this.gelegteKarte = new ArrayList<>();
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

  public void kartenVerteilen(List<SpielendeSpieler> spielendeSpieler) {
    int i = 0;
    Random random;
    while (this.deck.size() > 2) {
        random = new Random();
        int zufallsZahl = random.nextInt(this.deck.size());
        spielendeSpieler.get(i).karteAufDieHand(this.deck.get(zufallsZahl));
        this.deck.remove(zufallsZahl);
        i++;
        if (i == spielendeSpieler.size()) {
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