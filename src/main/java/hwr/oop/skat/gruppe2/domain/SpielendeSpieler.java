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
        if (!this.getHandKarten().isEmpty()) {
            // Trumpfkarte / Ungleiche Farbe
            if (karte.getFarbe().getWert() != kartenStapel.getGelegteKarten().getFirst().getFarbe().getWert()) {
                for (Karte i : this.getHandKarten()) {
                    if (i.getFarbe().getWert() == kartenStapel.getGelegteKarten().getFirst().getFarbe().getWert()) {
                        return;
                    }
                }
                this.getHandKarten().remove(karte);
                kartenStapel.addGelegteKarte(karte);
                return;
            }
            // Gleiche Farbe
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
        return Objects.equals(spieler, that.spieler) && Objects.equals(handKarten, that.handKarten) && Objects.equals(gewonneneKarten, that.gewonneneKarten);
    }

    @Override
    public int hashCode() {
        return Objects.hash(spieler, handKarten, gewonneneKarten);
    }
}