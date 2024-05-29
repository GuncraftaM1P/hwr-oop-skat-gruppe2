package hwr.oop.skat.gruppe2;

import hwr.oop.skat.gruppe2.domain.SpielendeSpieler;
import hwr.oop.skat.gruppe2.domain.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SpielfeldTest {

    @Test
    void testNeuerKartenStapel() {
        Spielfeld testSpielfeld = new Spielfeld();

        List<Karte> testKarten = List.of(
                new Karte(Farbe.KARO, Wert.SIEBEN),
                new Karte(Farbe.HERZ, Wert.SIEBEN),
                new Karte(Farbe.PIK, Wert.SIEBEN),
                new Karte(Farbe.KREUZ, Wert.SIEBEN),
                new Karte(Farbe.KARO, Wert.ACHT),
                new Karte(Farbe.HERZ, Wert.ACHT),
                new Karte(Farbe.PIK, Wert.ACHT),
                new Karte(Farbe.KREUZ, Wert.ACHT),
                new Karte(Farbe.KARO, Wert.NEUN),
                new Karte(Farbe.HERZ, Wert.NEUN),
                new Karte(Farbe.PIK, Wert.NEUN),
                new Karte(Farbe.KREUZ, Wert.NEUN),
                new Karte(Farbe.KARO, Wert.ZEHN),
                new Karte(Farbe.HERZ, Wert.ZEHN),
                new Karte(Farbe.PIK, Wert.ZEHN),
                new Karte(Farbe.KREUZ, Wert.ZEHN),
                new Karte(Farbe.KARO, Wert.BUBE),
                new Karte(Farbe.HERZ, Wert.BUBE),
                new Karte(Farbe.PIK, Wert.BUBE),
                new Karte(Farbe.KREUZ, Wert.BUBE),
                new Karte(Farbe.KARO, Wert.DAME),
                new Karte(Farbe.HERZ, Wert.DAME),
                new Karte(Farbe.PIK, Wert.DAME),
                new Karte(Farbe.KREUZ, Wert.DAME),
                new Karte(Farbe.KARO, Wert.KOENIG),
                new Karte(Farbe.HERZ, Wert.KOENIG),
                new Karte(Farbe.PIK, Wert.KOENIG),
                new Karte(Farbe.KREUZ, Wert.KOENIG),
                new Karte(Farbe.KARO, Wert.ASS),
                new Karte(Farbe.HERZ, Wert.ASS),
                new Karte(Farbe.PIK, Wert.ASS),
                new Karte(Farbe.KREUZ, Wert.ASS)
        );

        List<Karte> deck = testSpielfeld.getDeck();
        Assertions.assertThat(deck)
                .hasSize(testKarten.size())
                .containsExactlyInAnyOrderElementsOf(testKarten);
    }

    @Test
    void testKartenVerteilenDeck() {
        Spielfeld testSpielfeld = new Spielfeld();

        List<SpielendeSpieler> testSpielendeSpieler = new ArrayList<>();
        testSpielendeSpieler.add(new SpielendeSpieler(new Person("Spieler 1")));
        testSpielendeSpieler.add(new SpielendeSpieler(new Person("Spieler 2")));
        testSpielendeSpieler.add(new SpielendeSpieler(new Person("Spieler 3")));

        testSpielfeld.kartenVerteilen(testSpielendeSpieler);

        Assertions.assertThat(testSpielfeld.getDeck()).hasSize(2);
    }
    @Test
    void testKartenVerteilenSpielerEins() {
        Spielfeld testSpielfeld = new Spielfeld();

        List<SpielendeSpieler> testSpielendeSpieler = new ArrayList<>();
        testSpielendeSpieler.add(new SpielendeSpieler(new Person("Spieler 1")));
        testSpielendeSpieler.add(new SpielendeSpieler(new Person("Spieler 2")));
        testSpielendeSpieler.add(new SpielendeSpieler(new Person("Spieler 3")));

        testSpielfeld.kartenVerteilen(testSpielendeSpieler);

        Assertions.assertThat(testSpielendeSpieler.getFirst().getHandKarten()).hasSize(10);
    }
    @Test
    void testKartenVerteilenSpielerZwei() {
        Spielfeld testSpielfeld = new Spielfeld();

        List<SpielendeSpieler> testSpielendeSpieler = new ArrayList<>();
        testSpielendeSpieler.add(new SpielendeSpieler(new Person("Spieler 1")));
        testSpielendeSpieler.add(new SpielendeSpieler(new Person("Spieler 2")));
        testSpielendeSpieler.add(new SpielendeSpieler(new Person("Spieler 3")));

        testSpielfeld.kartenVerteilen(testSpielendeSpieler);

        Assertions.assertThat(testSpielendeSpieler.get(1).getHandKarten()).hasSize(10);
    }
    @Test
    void testKartenVerteilenSpielerDrei() {
        Spielfeld testSpielfeld = new Spielfeld();

        List<SpielendeSpieler> testSpielendeSpieler = new ArrayList<>();
        testSpielendeSpieler.add(new SpielendeSpieler(new Person("Spieler 1")));
        testSpielendeSpieler.add(new SpielendeSpieler(new Person("Spieler 2")));
        testSpielendeSpieler.add(new SpielendeSpieler(new Person("Spieler 3")));

        testSpielfeld.kartenVerteilen(testSpielendeSpieler);

        Assertions.assertThat(testSpielendeSpieler.get(2).getHandKarten()).hasSize(10);
    }
}
