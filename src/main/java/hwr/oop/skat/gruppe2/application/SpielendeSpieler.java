<<<<<<<< HEAD:src/main/java/hwr/oop/skat/gruppe2/application/SpielendeSpieler.java
package hwr.oop.skat.gruppe2.application;
========
package skat.domain;
>>>>>>>> origin/main:src/skat/domain/SpielendeSpieler.java

import hwr.oop.skat.gruppe2.domain.Karte;
import hwr.oop.skat.gruppe2.domain.KartenListe;
import hwr.oop.skat.gruppe2.domain.KartenStapel;
import hwr.oop.skat.gruppe2.domain.Spieler;

public class SpielendeSpieler {
    Spieler spieler;
    KartenListe handKarten;
    KartenListe gewonneneKarten;


    public SpielendeSpieler(Spieler spieler) {
        this.spieler = spieler;
        this.handKarten = new KartenListe();
        this.gewonneneKarten = new KartenListe();
    }

    public boolean karteSetzen(Karte karte, KartenStapel kartenStapel) {
        // Karte auf der Hand?
        if (!handKarten.istEmpte()) {
            // Trumpfkarte / Ungleiche Farbe
            if (karte.getFarbe() != kartenStapel.getGelegteKarten().getFirst().getFarbe()) {
                for (Karte i : handKarten.getKartenListe()) {
                    if (i.getFarbe() == kartenStapel.getGelegteKarten().getFirst().getFarbe()) {
                        return false;
                    }
                }
                this.handKarten.getKartenListe().remove(karte);
                kartenStapel.addGelegteKarte(karte);
                return true;
            }
            // Gleiche Farbe
            this.handKarten.getKartenListe().remove(karte);
            kartenStapel.addGelegteKarte(karte);
            return true;
        }
        return false;
    }

    public void karteAufDieHand(Karte karte) {
        this.handKarten.addKarte(karte);
    }

    public void karteGewonnen(Karte karte) {
        this.gewonneneKarten.addKarte(karte);
    }

    // Getter
    public KartenListe getHandKarten() {
        return this.handKarten;
    }
    public KartenListe getGewonneneKarten() {
        return this.gewonneneKarten;
    }
}