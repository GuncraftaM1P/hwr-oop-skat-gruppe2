package hwr.oop.skat.gruppe2.domain;

import java.util.ArrayList;
import java.util.List;

public class Stich {
  private List<Karte> gelegteKarten;
  private Spieler spielerAnDerReihe;
  private Farbe ersteFarbe;
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

  public Spieler ermittleSiegerFallsTrumpf(List<Spieler> spieler, Farbe trumpffarbe) {
    List<Karte> trumpfListe =
        List.of(
            new Karte(trumpffarbe, Wert.SIEBEN),
            new Karte(trumpffarbe, Wert.ACHT),
            new Karte(trumpffarbe, Wert.NEUN),
            new Karte(trumpffarbe, Wert.ZEHN),
            new Karte(trumpffarbe, Wert.BUBE),
            new Karte(trumpffarbe, Wert.DAME),
            new Karte(trumpffarbe, Wert.KOENIG),
            new Karte(trumpffarbe, Wert.ASS)
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
        if (j.getFarbe() == trumpffarbe
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

  public Spieler ermittleSieger(List<Spieler> spieler, Farbe trumpffarbe) {
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

  public void legeKarte(Karte karte, Spieler naechster) {
    this.gelegteKarten.add(karte);
    this.spielerAnDerReihe = naechster;
    this.ersteFarbe = this.gelegteKarten.getFirst().getFarbe();
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
}
