package hwr.oop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class KartenStapelTest {

    @Test
    void testNeuerKartenStapel() {
        KartenStapel testKartenStapel = new KartenStapel();

        List<Karte> testKarten = new ArrayList<>();
        testKarten.add(new Karte(Farbe.KARO, Wert.SIEBEN));
        testKarten.add(new Karte(Farbe.HERZ, Wert.SIEBEN));
        testKarten.add(new Karte(Farbe.PIK, Wert.SIEBEN));
        testKarten.add(new Karte(Farbe.KREUZ, Wert.SIEBEN));
        testKarten.add(new Karte(Farbe.KARO, Wert.ACHT));
        testKarten.add(new Karte(Farbe.HERZ, Wert.ACHT));
        testKarten.add(new Karte(Farbe.PIK, Wert.ACHT));
        testKarten.add(new Karte(Farbe.KREUZ, Wert.ACHT));
        testKarten.add(new Karte(Farbe.KARO, Wert.NEUN));
        testKarten.add(new Karte(Farbe.HERZ, Wert.NEUN));
        testKarten.add(new Karte(Farbe.PIK, Wert.NEUN));
        testKarten.add(new Karte(Farbe.KREUZ, Wert.NEUN));
        testKarten.add(new Karte(Farbe.KARO, Wert.ZEHN));
        testKarten.add(new Karte(Farbe.HERZ, Wert.ZEHN));
        testKarten.add(new Karte(Farbe.PIK, Wert.ZEHN));
        testKarten.add(new Karte(Farbe.KREUZ, Wert.ZEHN));
        testKarten.add(new Karte(Farbe.KARO, Wert.BUBE));
        testKarten.add(new Karte(Farbe.HERZ, Wert.BUBE));
        testKarten.add(new Karte(Farbe.PIK, Wert.BUBE));
        testKarten.add(new Karte(Farbe.KREUZ, Wert.BUBE));
        testKarten.add(new Karte(Farbe.KARO, Wert.DAME));
        testKarten.add(new Karte(Farbe.HERZ, Wert.DAME));
        testKarten.add(new Karte(Farbe.PIK, Wert.DAME));
        testKarten.add(new Karte(Farbe.KREUZ, Wert.DAME));
        testKarten.add(new Karte(Farbe.KARO, Wert.KOENIG));
        testKarten.add(new Karte(Farbe.HERZ, Wert.KOENIG));
        testKarten.add(new Karte(Farbe.PIK, Wert.KOENIG));
        testKarten.add(new Karte(Farbe.KREUZ, Wert.KOENIG));
        testKarten.add(new Karte(Farbe.KARO, Wert.ASS));
        testKarten.add(new Karte(Farbe.HERZ, Wert.ASS));
        testKarten.add(new Karte(Farbe.PIK, Wert.ASS));
        testKarten.add(new Karte(Farbe.KREUZ, Wert.ASS));

        Assertions.assertThat(testKartenStapel.getDeck()).isEqualTo(testKarten);
    }

    @Test
    void testKartenVerteilenDeck() {
        KartenStapel testKartenStapel = new KartenStapel();

        List<SpielendeSpieler> testSpielendeSpieler = new ArrayList<>();
        testSpielendeSpieler.add(new SpielendeSpieler(new Spieler("Spieler 1")));
        testSpielendeSpieler.add(new SpielendeSpieler(new Spieler("Spieler 2")));
        testSpielendeSpieler.add(new SpielendeSpieler(new Spieler("Spieler 3")));

        testKartenStapel.kartenVerteilen(testSpielendeSpieler);

        Assertions.assertThat(testKartenStapel.deck.size()).isEqualTo(2);
    }
    @Test
    void testKartenVerteilenSpielerEins() {
        KartenStapel testKartenStapel = new KartenStapel();

        List<SpielendeSpieler> testSpielendeSpieler = new ArrayList<>();
        testSpielendeSpieler.add(new SpielendeSpieler(new Spieler("Spieler 1")));
        testSpielendeSpieler.add(new SpielendeSpieler(new Spieler("Spieler 2")));
        testSpielendeSpieler.add(new SpielendeSpieler(new Spieler("Spieler 3")));

        testKartenStapel.kartenVerteilen(testSpielendeSpieler);

        Assertions.assertThat(testSpielendeSpieler.getFirst().handKarten.size()).isEqualTo(10);
    }
    @Test
    void testKartenVerteilenSpielerZwei() {
        KartenStapel testKartenStapel = new KartenStapel();

        List<SpielendeSpieler> testSpielendeSpieler = new ArrayList<>();
        testSpielendeSpieler.add(new SpielendeSpieler(new Spieler("Spieler 1")));
        testSpielendeSpieler.add(new SpielendeSpieler(new Spieler("Spieler 2")));
        testSpielendeSpieler.add(new SpielendeSpieler(new Spieler("Spieler 3")));

        testKartenStapel.kartenVerteilen(testSpielendeSpieler);

        Assertions.assertThat(testSpielendeSpieler.get(1).handKarten.size()).isEqualTo(10);
    }
    @Test
    void testKartenVerteilenSpielerDrei() {
        KartenStapel testKartenStapel = new KartenStapel();

        List<SpielendeSpieler> testSpielendeSpieler = new ArrayList<>();
        testSpielendeSpieler.add(new SpielendeSpieler(new Spieler("Spieler 1")));
        testSpielendeSpieler.add(new SpielendeSpieler(new Spieler("Spieler 2")));
        testSpielendeSpieler.add(new SpielendeSpieler(new Spieler("Spieler 3")));

        testKartenStapel.kartenVerteilen(testSpielendeSpieler);

        Assertions.assertThat(testSpielendeSpieler.get(2).handKarten.size()).isEqualTo(10);
    }
}
