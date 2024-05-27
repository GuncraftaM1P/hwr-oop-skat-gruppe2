package hwr.oop.skat.gruppe2.application;

import hwr.oop.skat.gruppe2.domain.KartenStapel;
import hwr.oop.skat.gruppe2.domain.SpielendeSpieler;

import java.util.List;

public class SpielVerwaltung {



    public SpielVerwaltung(List<SpielendeSpieler> spielers) {

        KartenStapel stapel = new KartenStapel();
        stapel.kartenVerteilen(spielers);

        starteSpielrunde();
    }

    private void starteSpielrunde() {

    }

}
