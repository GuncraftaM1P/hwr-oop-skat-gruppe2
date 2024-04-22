package hwr.oop;

import java.util.ArrayList;
import java.util.List;

public class KartenStapel {
    List<Karte> deck;
    List<Karte> gelegteKarten;

  public KartenStapel() {
      this.deck = neuerKartenStapel();
      this.gelegteKarten = new ArrayList<>();
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
  public Karte getGelegteKarte() {
      return this.gelegteKarten.getFirst();
  }

  // Setter
    public void addGelegteKarte(Karte karte) {
      this.gelegteKarten.add(karte);
    }
}

