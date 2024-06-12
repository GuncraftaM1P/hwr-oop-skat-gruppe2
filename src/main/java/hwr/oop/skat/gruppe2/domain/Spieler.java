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

  public boolean kannLegen(Karte karte, Farbe ersteFarbe) {
    // Check: Karte enthalten
    if (!this.getHandKarten().contains(karte)) return false;

    // Check: Stich leer
    if (ersteFarbe == null)
      return true;

    // Check: Gleiche Farbe
    if (karte.getFarbe() == ersteFarbe) {
      if(karte.getWert() == Wert.BUBE && this.kannBedienen(ersteFarbe))
        return false;
    }
    else {
      // Check: Kann der Spieler bedienen?
      if(this.kannBedienen(ersteFarbe))
        return false;
    }

    return true;
  }

  private boolean kannBedienen(Farbe bedienen){
    for (Karte k : this.getHandKarten()) {
      if (k.getFarbe() == bedienen && k.getWert() != Wert.BUBE)
        return true;
    }
    return false;
  }

  public Boolean skatAblegen(List<Karte> karten) {
    if (this.handKarten.size() < 12) {
      return false;
    }
    List<Karte> handKartenTemp = this.handKarten;
    int possible = 0;
    for (Karte karte : karten) {
      for (Karte k : this.getHandKarten()) {
        if (k.equals(karte)) {
          possible++;
          break;
        }
      }
    }
    if (possible == handKarten.size()) {
      this.handKarten = handKartenTemp;
      return true;
    }
    return false;
  }

  public void entferneVonHand(Karte karte){
    this.handKarten.remove(karte);
  }

  public void karteAufDieHand(Karte karte) {
    this.handKarten.add(karte);
  }

  public void kartenAufDieHand(List<Karte> neueKarten) {
    this.handKarten.addAll(neueKarten);
  }

  public void karteGewonnen(Karte karte) {
    this.gewonneneKarten.add(karte);
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
  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
