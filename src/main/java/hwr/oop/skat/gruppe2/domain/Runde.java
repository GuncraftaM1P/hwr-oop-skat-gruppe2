package hwr.oop.skat.gruppe2.domain;

import java.util.ArrayList;
import java.util.List;

public class Runde {
    Farbe bedinnFarbe;
    List<KarteMitGelegterSpieler> gelegteKarten;
    private class KarteMitGelegterSpieler{
        public Karte gelegteKarte;
        public SpielendeSpieler spielendeSpieler;
        KarteMitGelegterSpieler(Karte gelegteKarte, SpielendeSpieler spielendeSpieler) {
            this.gelegteKarte = gelegteKarte;
            this.spielendeSpieler = spielendeSpieler;
        }
    }

    Runde(List<KarteMitGelegterSpieler> gelegteKarten) {
        this.gelegteKarten = gelegteKarten;
    }

    Runde(){
        KartenListe gelegteKarten = new KartenListe();
    }

    public void addGelegteKarte(Karte karte, SpielendeSpieler spielendeSpieler) {
        gelegteKarten.add(new KarteMitGelegterSpieler(karte,spielendeSpieler));
    }

    public KartenListe getGelegteKarten() {
        KartenListe temp = new KartenListe();
        for(KarteMitGelegterSpieler kartenMitGespielenSpieler: gelegteKarten){
            temp.addKarte(kartenMitGespielenSpieler.gelegteKarte);
        }
        return temp;
    }

    public SpielendeSpieler rundenGewonenderSpieler(Farbe trumpf, SpielendeSpieler AleinSpielendeSpieler){
        //TODO wie berechnet man wer in einer runde die KArten bekommt
        return null;
    }

    public Farbe getBedinnFarbe() {
        return bedinnFarbe;
    }

}
