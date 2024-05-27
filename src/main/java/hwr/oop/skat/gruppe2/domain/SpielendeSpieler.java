package hwr.oop.skat.gruppe2.domain;

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