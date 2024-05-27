<<<<<<<< HEAD:src/main/java/hwr/oop/skat/gruppe2/domain/Karte.java
package hwr.oop.skat.gruppe2.domain;
========
package skat.domain;
>>>>>>>> origin/main:src/skat/domain/Karte.java

public class Karte {

    private Farbe farbe;
    private Wert wert;

    public Karte(Farbe farbe, Wert wert) {
        this.farbe = farbe;
        this.wert = wert;
    }

    public Farbe getFarbe() {
        return farbe;
    }

    public Wert getWert() {
        return wert;
    }
}