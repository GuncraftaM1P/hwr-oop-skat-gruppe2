package hwr.oop.skat.gruppe2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Spieler {
  Person person;
  List<Karte> handKarten;
  List<Karte> gewonneneKarten;

  public Spieler(Person person) {
    this.person = person;
    this.handKarten = new ArrayList<>();
    this.gewonneneKarten = new ArrayList<>();
  }

  public Spieler(Person person, List<Karte> handKarten, List<Karte> gewonneneKarten) {
    this.person = person;
    this.handKarten = handKarten;
    this.gewonneneKarten = gewonneneKarten;
  }

  public boolean kannLegen(Karte karte, Farbe ersteFarbe) {
    // Karte nicht enthalten
    if (!this.getHandKarten().contains(karte)) return false;

    // Stich leer
    if (ersteFarbe == null) return true;

    // Case: Gleiche Farbe
    if (karte.getFarbe() == ersteFarbe) {
      return karte.getWert() != Wert.BUBE || !this.kannBedienen(ersteFarbe);
    }
    // Case: Ungleiche Farbe
    else {
      return !this.kannBedienen(ersteFarbe);
    }
  }

  public boolean kannBedienen(Farbe bedienen) {
    for (Karte k : this.getHandKarten()) {
      if (k.getFarbe() == bedienen && k.getWert() != Wert.BUBE) return true;
    }
    return false;
  }

  public boolean skatAblegen(List<Karte> karten) {
    if (karten.size() != 2) return false;
    if (this.handKarten.size() != 12) return false;

    if (this.handKarten.contains(karten.getFirst()) && this.handKarten.contains(karten.getLast())) {
      this.handKarten.remove(karten.getFirst());
      this.handKarten.remove(karten.getLast());
      this.kartenGewonnen(karten);
      return true;
    }
    return false;
  }

  public void entferneVonHand(Karte karte) {
    this.handKarten.remove(karte);
  }

  public void karteAufDieHand(Karte karte) {
    this.handKarten.add(karte);
  }

  public void kartenAufDieHand(List<Karte> neueKarten) {
    this.handKarten.addAll(neueKarten);
  }

  public void kartenGewonnen(List<Karte> karte) {
    this.gewonneneKarten.addAll(karte);
  }

  // Getter
  public List<Karte> getHandKarten() {
    return this.handKarten;
  }

  public List<Karte> getGewonneneKarten() {
    return this.gewonneneKarten;
  }

  public Person getPerson() {
    return person;
  }

  public UUID getUUID() {
    return this.person.getUuid();
  }

  public void setHandKarten(List<Karte> handKarten) {
    this.handKarten = handKarten;
  }

  public void setGewonneneKarten(List<Karte> gewonneneKarten) {
    this.gewonneneKarten = gewonneneKarten;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Spieler that = (Spieler) o;
    return Objects.equals(person, that.person)
        && Objects.equals(handKarten, that.handKarten)
        && Objects.equals(gewonneneKarten, that.gewonneneKarten);
  }
}
