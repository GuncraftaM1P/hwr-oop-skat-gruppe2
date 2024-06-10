package hwr.oop.skat.gruppe2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Spieler {
  Person person;
  List<Karte> handKarten;
  List<Karte> gewonneneKarten;

  public Spieler(Person person) {
    this.person = person;
    this.handKarten = new ArrayList<>();
    this.gewonneneKarten = new ArrayList<>();
  }

  // TODO: Spielfeldreferenz muss zu Stichreferenz geändert werden
  public void karteSetzen(Karte karte, Spielfeld spielfeld) {
    // Karte auf der Hand?
    if (handKarten.contains(karte)) {
      // Kartenstapel Leer?
      if (!spielfeld.getGelegteKarten().isEmpty()) {
        // Ungleiche Farbe
        if (karte.getFarbe() != spielfeld.getGelegteKarten().getFirst().getFarbe()) {
          // Schauen ob Spieler nicht bedienen kann
          for (Karte kartensuche : this.getHandKarten()) {
            if (kartensuche.getFarbe() == spielfeld.getGelegteKarten().getFirst().getFarbe()) {
              return;
            }
          }
          // TODO Bube auf Nichttrumph
        }
        // TODO Bube gleicher Farbe auf Farbe
        // Gleiche Farbe
        this.getHandKarten().remove(karte);
        spielfeld.addGelegteKarte(karte);
        return;
      }
      this.getHandKarten().remove(karte);
      spielfeld.addGelegteKarte(karte);
    }
  }

  public void karteAufDieHand(Karte karte) {
    this.handKarten.add(karte);
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
    return Objects.equals(person, that.person) && Objects.equals(handKarten, that.handKarten) && Objects.equals(gewonneneKarten, that.gewonneneKarten);
  }
}
