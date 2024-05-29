package hwr.oop.skat.gruppe2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SpielendeSpieler {
  Spieler spieler;
  List<Karte> handKarten;
  List<Karte> gewonneneKarten;

  public SpielendeSpieler(Spieler spieler) {
    this.spieler = spieler;
    this.handKarten = new ArrayList<>();
    this.gewonneneKarten = new ArrayList<>();
  }

  public void karteSetzen(Karte karte, KartenStapel kartenStapel) {
    // Karte auf der Hand?
    if (handKarten.contains(karte)) {
      // Kartenstapel Leer?
      if (!kartenStapel.getGelegteKarten().isEmpty()) {
        // Ungleiche Farbe
        if (karte.getFarbe()
                != kartenStapel.getGelegteKarten().getFirst().getFarbe()) {
          // Schauen ob Spieler nicht bedienen kann
          for (Karte kartensuche : this.getHandKarten()) {
            if (kartensuche.getFarbe() == kartenStapel.getGelegteKarten().getFirst().getFarbe()) {
              return;
            }
          }
          // TODO Bube auf Nichttrumph
        }
        // TODO Bube gleicher Farbe auf Farbe
        // Gleiche Farbe
        this.getHandKarten().remove(karte);
        kartenStapel.addGelegteKarte(karte);
        return;
      }
      this.getHandKarten().remove(karte);
      kartenStapel.addGelegteKarte(karte);
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    SpielendeSpieler that = (SpielendeSpieler) o;
    return Objects.equals(spieler, that.spieler)
        && Objects.equals(handKarten, that.handKarten)
        && Objects.equals(gewonneneKarten, that.gewonneneKarten);
  }

  @Override
  public int hashCode() {
    return Objects.hash(spieler, handKarten, gewonneneKarten);
  }
}
