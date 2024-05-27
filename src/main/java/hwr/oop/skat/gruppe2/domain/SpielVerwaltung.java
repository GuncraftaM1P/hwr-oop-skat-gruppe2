<<<<<<<< HEAD:src/main/java/hwr/oop/skat/gruppe2/domain/SpielVerwaltung.java
package hwr.oop.skat.gruppe2.domain;

import hwr.oop.skat.gruppe2.application.SpielendeSpieler;
========
package skat.application;
>>>>>>>> origin/main:src/skat/application/SpielVerwaltung.java

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
