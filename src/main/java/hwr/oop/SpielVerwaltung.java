package hwr.oop;

import java.util.List;

public class SpielVerwaltung {
    KartenStapel stapel;

    public static void main(String[] args){

    }

    public SpielVerwaltung(List<SpielendeSpieler> spielers) {

        this.stapel = new KartenStapel();
        stapel.kartenVerteilen(spielers);

        starteSpielrunde();
    }

    private void starteSpielrunde() {
        boolean spielleuft = true;
        while (spielleuft) {

        }

    }

}
