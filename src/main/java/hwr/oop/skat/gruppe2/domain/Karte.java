package hwr.oop.skat.gruppe2.domain;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Karte karte)) return false;
        return farbe == karte.farbe && wert == karte.wert;
    }

    @Override
    public int hashCode() {
        return Objects.hash(farbe, wert);
    }

    @Override
    public String toString() {
        return "Karte{" +
                "farbe=" + farbe +
                ", wert=" + wert +
                '}';
    }
}