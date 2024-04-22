package hwr.oop;

import java.util.ArrayList;
import java.util.List;

public class KartenStapel {

  KartenStapel() {}

  KartenStapel(List<Spieler> spieler) {}

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

  public void kartenVerteilen(List<Karte> karten, List<SpielendeSpieler> SpielendeSpieler){
      while (karten.size()>2) {
          int zufaelligeZahl = (int) (Math.random()*(SpielendeSpieler.size()));
          SpielendeSpieler.get(zufaelligeZahl).handKarten.add(karten.get(zufaelligeZahl));
      }
  }
}

