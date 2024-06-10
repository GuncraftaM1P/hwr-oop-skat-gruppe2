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

  public void karteSetzen(Karte karte, Stich stich) {
    // Karte auf der Hand?
    if (handKarten.contains(karte)) {
      // Kartenstapel Leer?
      if (!stich.isEmpty()) {
        // Ungleiche Farbe
        if (karte.getFarbe() != stich.getFarbeZumBedienen()) {
          // Schauen ob Spieler nicht bedienen kann
          for (Karte kartensuche : this.getHandKarten()) {
            if (kartensuche.getFarbe() == stich.getFarbeZumBedienen()) {
              return;
            }
          }
          // TODO Bube auf NichtTrumpf
        }
        // TODO Bube gleicher Farbe auf Farbe
        // Gleiche Farbe
        this.getHandKarten().remove(karte);
        stich.legeKarte(karte);
        return;
      }
      this.getHandKarten().remove(karte);
      stich.legeKarte(karte);
    }
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
