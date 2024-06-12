package hwr.oop.skat.gruppe2.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stich {
  private List<Karte> gelegteKarten;
  private Spieler spielerAnDerReihe;
  private final Farbe ersteFarbe;
  private Karte siegerKarte;

  public Stich(Spieler spieler, List<Karte> gelegteKarten) {
    this.gelegteKarten = gelegteKarten;
    this.spielerAnDerReihe = spieler;
    this.ersteFarbe = gelegteKarten.getFirst().getFarbe();
    this.siegerKarte = null;
  }

  public Stich(Spieler spieler) {
    this.gelegteKarten = new ArrayList<>();
    this.spielerAnDerReihe = spieler;
    this.ersteFarbe = gelegteKarten.getFirst().getFarbe();
    this.siegerKarte = null;
  }

  public Stich(Spieler spieler, Farbe ersteFarbe) {
    this.gelegteKarten = new ArrayList<>();
    this.spielerAnDerReihe = spieler;
    this.ersteFarbe = ersteFarbe;
    this.siegerKarte = null;
  }

  public Spieler ermittleSiegerFallsBube(List<Spieler> spieler) {
    if (this.getGelegteKarten().contains(new Karte(Farbe.KREUZ, Wert.BUBE))) {
      return spieler.get(
          (this.getGelegteKarten().indexOf(new Karte(Farbe.KREUZ, Wert.BUBE))
              + spieler.indexOf(this.getSpielerAnDerReihe()))
              % 3);
    }
    if (this.getGelegteKarten().contains(new Karte(Farbe.PIK, Wert.BUBE))) {
      return spieler.get(
          (this.getGelegteKarten().indexOf(new Karte(Farbe.PIK, Wert.BUBE))
              + spieler.indexOf(this.getSpielerAnDerReihe()))
              % 3);
    }
    if (this.getGelegteKarten().contains(new Karte(Farbe.HERZ, Wert.BUBE))) {
      return spieler.get(
          (this.getGelegteKarten().indexOf(new Karte(Farbe.HERZ, Wert.BUBE))
              + spieler.indexOf(this.getSpielerAnDerReihe()))
              % 3);
    }
    if (this.getGelegteKarten().contains(new Karte(Farbe.KARO, Wert.BUBE))) {
      return spieler.get(
          (this.getGelegteKarten().indexOf(new Karte(Farbe.KARO, Wert.BUBE))
              + spieler.indexOf(this.getSpielerAnDerReihe()))
              % 3);
    }
    return null;
  }

  public Spieler ermittleSiegerFallsTrumpf(List<Spieler> spieler, Trumpffarbe trumpffarbe) {
    List<Karte> trumpfListe =
        List.of(
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
      if (!this.getGelegteKarten().contains(i))
        continue;
      Karte gewinnerKarte = null;
      for (Karte j : this.getGelegteKarten()) {
        if (gewinnerKarte == null) {
          gewinnerKarte = j;
          continue;
        }
        if (j.equals(gewinnerKarte)) return null;
        if (j.getFarbe() == trumpffarbe.getTrumpffarbe()
            && j.getWert().getStaerke() > gewinnerKarte.getWert().getStaerke()) {
          gewinnerKarte = j;
        }
      }
      this.setSiegerKarte(gewinnerKarte);
      return spieler.get(
          (this.getGelegteKarten().indexOf(gewinnerKarte)
              + spieler.indexOf(this.getSpielerAnDerReihe()))
              % 3);
    }
    return null;
  }

  public Spieler ermittleSieger(List<Spieler> spieler, Trumpffarbe trumpffarbe) {
    if (this.getGelegteKarten().size() != 3) return null;

    Spieler bubenSieger = this.ermittleSiegerFallsBube(spieler);
    if (bubenSieger != null) {
      return bubenSieger;
    }

    Spieler trumpfSieger = this.ermittleSiegerFallsTrumpf(spieler, trumpffarbe);
    if (trumpfSieger != null) {
      return trumpfSieger;
    }

    // Normale Karten
    Karte gewinnerKarte = null;
    for (Karte j : this.getGelegteKarten()) {
      if (gewinnerKarte == null) gewinnerKarte = j;
      else {
        if (j.equals(gewinnerKarte)) return null;
        if (j.getFarbe() == this.getErsteFarbe()
            && j.getWert().getStaerke() > gewinnerKarte.getWert().getStaerke()) {
          gewinnerKarte = j;
        }
      }
    }
    this.setSiegerKarte(gewinnerKarte);
    return spieler.get(
        (this.getGelegteKarten().indexOf(gewinnerKarte)
            + spieler.indexOf(this.getSpielerAnDerReihe()))
            % 3);
  }

  public void gibSiegerKarten(Spieler sieger) {
    List<Karte> gewonneneKarten = new ArrayList<>(sieger.getGewonneneKarten());
    gewonneneKarten.addAll(this.getGelegteKarten());

    sieger.setGewonneneKarten(gewonneneKarten);
  }

  public boolean isEmpty() {
    return this.gelegteKarten.isEmpty();
  }

  public Farbe getFarbeZumBedienen() {
    return this.gelegteKarten.getFirst().getFarbe();
  }

  public void legeKarte(Karte karte) {
    this.gelegteKarten.add(karte);
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

  public Karte getSiegerKarte() {
    return siegerKarte;
  }

  public void setGelegteKarten(List<Karte> karten) {
    this.gelegteKarten = karten;
  }

  public void setSiegerKarte(Karte karte) {
    this.siegerKarte = karte;
  }

  public void setSpielerAnDerReihe(Spieler spielerAnDerReihe) {
    this.spielerAnDerReihe = spielerAnDerReihe;
  }
}
