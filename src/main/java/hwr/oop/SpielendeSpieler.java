package hwr.oop;

import java.util.ArrayList;
import java.util.List;

public class SpielendeSpieler {
    Spieler spieler;
    List<Karte> handKarten;
    List<Karte> gewonneneKarten;


    public SpielendeSpieler(Spieler spieler) {
        this.spieler = spieler;
        this.handKarten = new ArrayList<>();
        this.gewonneneKarten = new ArrayList<>();
    }

    public boolean karteSetzen(Karte karte, KartenStapel kartenStapel) {
        // Karte auf der Hand?
        if (this.handKarten.contains(karte)) {
            // Trumpfkarte / Ungleiche Farbe
            if (karte.getFarbe() != kartenStapel.getGelegteKarte().getFarbe()) {
                for (Karte i : this.handKarten) {
                    if (i.getFarbe() == kartenStapel.getGelegteKarte().getFarbe()) {
                        return false;
                    }
                }
                this.handKarten.remove(karte);
                kartenStapel.addGelegteKarte(karte);
                return true;
            }
            // Gleiche Farbe
            this.handKarten.remove(karte);
            kartenStapel.addGelegteKarte(karte);
            return true;
        }
        return false;
    }

    public void karteAufDieHand(Karte karte) {
        this.handKarten.add(karte);
    }

    public void karteGewonnen(Karte karte) {
        this.gewonneneKarten.add(karte);
    }
}