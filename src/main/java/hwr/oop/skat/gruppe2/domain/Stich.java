package hwr.oop.skat.gruppe2.domain;

import java.util.ArrayList;
import java.util.List;

public class Stich {
  private final List<Karte> gelegteKarten;
  private final SpielendeSpieler spielerAnDerReihe;
  private final Farbe ersteFarbe;
  private SpielendeSpieler sieger;


  public Stich(SpielendeSpieler spieler, Farbe farbe) {
    this.gelegteKarten = new ArrayList<Karte>();
    this.spielerAnDerReihe = spieler;
    this.ersteFarbe = farbe;
  }

  public SpielendeSpieler ermittleSieger(List<SpielendeSpieler> spieler, Trumpffarbe trumpffarbe) {
    if (this.getGelegteKarten().size() != 3) return null;

    // Buben
    if (this.getGelegteKarten().contains(new Karte(Farbe.KREUZ, Wert.BUBE))) {
      return spieler.get((this.getGelegteKarten().indexOf(new Karte(Farbe.KREUZ, Wert.BUBE)) + spieler.indexOf(this.getSpielerAnDerReihe())) % 3);
    }
    if (this.getGelegteKarten().contains(new Karte(Farbe.PIK, Wert.BUBE))) {
      return spieler.get((this.getGelegteKarten().indexOf(new Karte(Farbe.PIK, Wert.BUBE)) + spieler.indexOf(this.getSpielerAnDerReihe())) % 3);
    }
    if (this.getGelegteKarten().contains(new Karte(Farbe.HERZ, Wert.BUBE))) {
      return spieler.get((this.getGelegteKarten().indexOf(new Karte(Farbe.HERZ, Wert.BUBE)) + spieler.indexOf(this.getSpielerAnDerReihe())) % 3);
    }
    if (this.getGelegteKarten().contains(new Karte(Farbe.KARO, Wert.BUBE))) {
      return spieler.get((this.getGelegteKarten().indexOf(new Karte(Farbe.KARO, Wert.BUBE)) + spieler.indexOf(this.getSpielerAnDerReihe())) % 3);
    }

    // Trumpfkarten
    if (this.getGelegteKarten().contains(trumpffarbe)) {
      Karte gewinnerKarte = new Karte(trumpffarbe.getTrumpffarbe(), Wert.SIEBEN);
      for (Karte i : this.getGelegteKarten()) {
        if (i.getFarbe() == trumpffarbe.getTrumpffarbe()) {
          if (i.getWert().getStaerke() > gewinnerKarte.getWert().getStaerke()) {
            gewinnerKarte = i;
          }
        }
      }
      return spieler.get((this.getGelegteKarten().indexOf(gewinnerKarte) + spieler.indexOf(this.getSpielerAnDerReihe())) % 3);
    }

    // Normale Karten
    Karte gewinnerKarte = new Karte(this.getErsteFarbe(), Wert.SIEBEN);
    for (Karte i : this.getGelegteKarten()) {
      if (i.getFarbe() == this.getErsteFarbe()) {
        if (i.getWert().getStaerke() > gewinnerKarte.getWert().getStaerke()) {
          gewinnerKarte = i;
        }
      }
    }
    return spieler.get((this.getGelegteKarten().indexOf(gewinnerKarte) + spieler.indexOf(this.getSpielerAnDerReihe())) % 3);
  }

  public void gibSiegerKarten(SpielendeSpieler sieger) {
    for (Karte i : this.getGelegteKarten()) {
      List<Karte> neueGewonneneKarten = sieger.getGewonneneKarten();

      neueGewonneneKarten.add(i);

      sieger.setGewonneneKarten(neueGewonneneKarten);
    }
  }

  public List<Karte> getGelegteKarten() {
    return this.getGelegteKarten();
  }

  public SpielendeSpieler getSpielerAnDerReihe() {
    return this.spielerAnDerReihe;
  }

  public Farbe getErsteFarbe() {
    return this.ersteFarbe;
  }

  public SpielendeSpieler getSieger() {
    return this.sieger;
  }
}