package hwr.oop.skat.gruppe2.domain;
import java.util.ArrayList;
import java.util.List;

//TODO: "SpielendeSpieler" refactor zu "Spieler"
public class SpielendeSpieler {
  Person person;
  List<Karte> handKarten;
  List<Karte> gewonneneKarten;

  public SpielendeSpieler (Person person) {
    this.person = person;
    this.handKarten = new ArrayList<>();
    this.gewonneneKarten = new ArrayList<>();
  }

  //TODO: Spielfeldreferenz muss zu Stichreferenz geändert werden
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
}
