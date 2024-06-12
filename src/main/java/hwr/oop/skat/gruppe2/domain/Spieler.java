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

  public void karteSetzen(Karte karte, Stich stich, List<Spieler> spieler) {
    // Check: Spieler an der Reihe
    if (!stich.getSpielerAnDerReihe().equals(this)) return;

    // Check: Karte enthalten
    if (!this.getHandKarten().contains(karte)) return;

    // Check: Stich leer
    if (stich.getGelegteKarten().isEmpty()) {
      this.getHandKarten().remove(karte);
      stich.legeKarte(karte);
      stich.setErsteFarbe(karte.getFarbe());
      stich.setSpielerAnDerReihe(spieler.get((spieler.indexOf(this) + 1) % 3));
      return;
    }

    // Check: Gleiche Farbe
    if (karte.getFarbe() == stich.getErsteFarbe()) {
      this.getHandKarten().remove(karte);
      stich.legeKarte(karte);
      stich.setSpielerAnDerReihe(spieler.get((spieler.indexOf(this) + 1) % 3));
    }
    else {
      // Check: Kann der Spieler bedienen?
      for (Karte i : this.getHandKarten()) {
        if (i.getFarbe() == stich.getErsteFarbe()) return;
      }

      this.getHandKarten().remove(karte);
      stich.legeKarte(karte);
      stich.setSpielerAnDerReihe(spieler.get((spieler.indexOf(this) + 1) % 3));
    }
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
