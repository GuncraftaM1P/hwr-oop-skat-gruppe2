package hwr.oop.skat.gruppe2.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Stich {
  private List<Karte> gelegteKarten;
  private final Spieler spielerAnDerReihe;
  private final Farbe ersteFarbe;


  public Stich(Spieler spieler, Farbe farbe) {
    this.gelegteKarten = new ArrayList<>();
    this.spielerAnDerReihe = spieler;
    this.ersteFarbe = farbe;
  }

  public Spieler ermittleSiegerFallsBube(List<Spieler> spieler) {
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
    return null;
  }

  public Spieler ermittleSiegerFallsTrumpf(List<Spieler> spieler, Trumpffarbe trumpffarbe) {
    List<Karte> trumpfListe = Arrays.asList(
            new Karte(trumpffarbe.getTrumpffarbe(), Wert.SIEBEN),
            new Karte(trumpffarbe.getTrumpffarbe(), Wert.ACHT),
            new Karte(trumpffarbe.getTrumpffarbe(), Wert.NEUN),
            new Karte(trumpffarbe.getTrumpffarbe(), Wert.ZEHN),
            new Karte(trumpffarbe.getTrumpffarbe(), Wert.BUBE),
            new Karte(trumpffarbe.getTrumpffarbe(), Wert.DAME),
            new Karte(trumpffarbe.getTrumpffarbe(), Wert.KOENIG),
            new Karte(trumpffarbe.getTrumpffarbe(), Wert.ASS)
    );

    for (Karte i : trumpfListe) {
      if (this.getGelegteKarten().contains(i)) {
        Karte gewinnerKarte = new Karte(trumpffarbe.getTrumpffarbe(), Wert.SIEBEN);
        for (Karte j : this.getGelegteKarten()) {
          if (j.getFarbe() == trumpffarbe.getTrumpffarbe() && j.getWert().getStaerke() > gewinnerKarte.getWert().getStaerke()) {
            gewinnerKarte = j;
          }
        }
        return spieler.get((this.getGelegteKarten().indexOf(gewinnerKarte) + spieler.indexOf(this.getSpielerAnDerReihe())) % 3);
      }
    }
    return null;
  }

  public Spieler ermittleSieger(List<Spieler> spieler, Trumpffarbe trumpffarbe) {
    if (this.getGelegteKarten().size() != 3) return null;

    Spieler bubenSieger = this.ermittleSiegerFallsBube(spieler);
    if (bubenSieger != null) {return bubenSieger;}

    Spieler trumpfSieger = this.ermittleSiegerFallsTrumpf(spieler, trumpffarbe);
    if (trumpfSieger != null) {return trumpfSieger;}

    // Normale Karten
    Karte gewinnerKarte = new Karte(this.getErsteFarbe(), Wert.SIEBEN);
    for (Karte i : this.getGelegteKarten()) {
      if (i.getFarbe() == this.getErsteFarbe() && i.getWert().getStaerke() > gewinnerKarte.getWert().getStaerke()) {
        gewinnerKarte = i;
      }
    }
    return spieler.get((this.getGelegteKarten().indexOf(gewinnerKarte) + spieler.indexOf(this.getSpielerAnDerReihe())) % 3);
  }

  public void gibSiegerKarten(Spieler sieger) {
    for (Karte i : this.getGelegteKarten()) {
      List<Karte> neueGewonneneKarten = sieger.getGewonneneKarten();

      neueGewonneneKarten.add(i);

      sieger.setGewonneneKarten(neueGewonneneKarten);
    }
  }

  public List<Karte> getGelegteKarten() {
    return this.gelegteKarten;
  }

  public Spieler getSpielerAnDerReihe() {
    return this.spielerAnDerReihe;
  }

  public Farbe getErsteFarbe() {
    return this.ersteFarbe;
  }

  public void setGelegteKarten(List<Karte> karten) {
    this.gelegteKarten = karten;
  }
}