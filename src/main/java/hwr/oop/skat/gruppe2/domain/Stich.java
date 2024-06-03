package hwr.oop.skat.gruppe2.domain;

import java.util.ArrayList;
import java.util.List;

public class Stich {

    public Stich(SpielendeSpieler spieler, Farbe farbe) {
        List<Karte> gelegteKarten = new ArrayList<Karte>();
        SpielendeSpieler spielerAnDerReihe = spieler;
        Farbe ersteFarbe = farbe;
    }

    public SpielendeSpieler ermittleSieger() {
        if (this.getGelegteKarten().size() != 3) return null;


    }

    public List<Karte> getGelegteKarten() {
        return this.getGelegteKarten();
    }

}