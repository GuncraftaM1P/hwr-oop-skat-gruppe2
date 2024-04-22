package hwr.oop;

import java.util.List;

public class SpielVerwaltung {


    public static void main(String[] args){

    }

    public SpielVerwaltung(List<SpielendeSpieler> spielers) {
        KartenStapel stapel = new KartenStapel();
        stapel.kartenRandomVerteilenZweiBleibenUebrig(stapel.neuerKartenStapel(),spielers);

        starteSpielrunde();
    }

    private void starteSpielrunde() {
        boolean spielleuft = true;
        while (spielleuft) {

        }

    }

}
