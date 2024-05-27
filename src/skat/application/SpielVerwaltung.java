package skat.application;

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
