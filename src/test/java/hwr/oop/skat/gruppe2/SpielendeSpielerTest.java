package hwr.oop.skat.gruppe2;

import hwr.oop.skat.gruppe2.domain.SpielendeSpieler;
import hwr.oop.skat.gruppe2.domain.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SpielendeSpielerTest {
    @Test
    void testKarteSetzenStapelLeer() {
        KartenStapel testKartenStapel = new KartenStapel();
        Spieler testSpieler = new Spieler("Spieler");
        SpielendeSpieler testSpielenderSpieler = new SpielendeSpieler(testSpieler);
        Karte testKarte = new Karte(Farbe.HERZ, Wert.ASS);

        testSpielenderSpieler.karteAufDieHand(testKarte);

        testSpielenderSpieler.karteSetzen(testKarte, testKartenStapel);

        List<Karte> gelegteKarten = testKartenStapel.getGelegteKarten();
        Assertions.assertThat(gelegteKarten)
                .hasSize(1)
                .contains(testKarte);
    }
    @Test
    void testKarteSetzenGleicheFarbe() {
        KartenStapel testKartenStapel = new KartenStapel();
        Spieler testSpieler = new Spieler("Spieler");
        SpielendeSpieler testSpielenderSpieler = new SpielendeSpieler(testSpieler);
        Karte testSpielerKarte = new Karte(Farbe.HERZ, Wert.ASS);
        Karte testStapelKarte = new Karte(Farbe.HERZ, Wert.DAME);

        testSpielenderSpieler.karteAufDieHand(testSpielerKarte);

        testKartenStapel.getGelegteKarten().add(testStapelKarte);

        testSpielenderSpieler.karteSetzen(testSpielerKarte, testKartenStapel);

        List<Karte> gelegteKarten = testKartenStapel.getGelegteKarten();
        Assertions.assertThat(gelegteKarten)
                .hasSize(2)
                .contains(testSpielerKarte);
    }
    @Test
    void testKarteSetzenUngleicheFarbeIllegal() {
        KartenStapel testKartenStapel = new KartenStapel();
        Spieler testSpieler = new Spieler("Spieler");
        SpielendeSpieler testSpielenderSpieler = new SpielendeSpieler(testSpieler);
        Karte testSpielerKarteEins = new Karte(Farbe.HERZ, Wert.ASS);
        Karte testSpielerKarteZwei = new Karte(Farbe.KARO, Wert.DAME);
        Karte testStapelKarte = new Karte(Farbe.KARO, Wert.ASS);

        testSpielenderSpieler.karteAufDieHand(testSpielerKarteEins);
        testSpielenderSpieler.karteAufDieHand(testSpielerKarteZwei);

        testKartenStapel.getGelegteKarten().add(testStapelKarte);

        testSpielenderSpieler.karteSetzen(testSpielerKarteEins, testKartenStapel);

        List<Karte> gelegteKarten = testKartenStapel.getGelegteKarten();
        Assertions.assertThat(gelegteKarten)
                .hasSize(1)
                .doesNotContain(testSpielerKarteEins);
    }
    @Test
    void testKarteSetzenUngleicheFarbeLegal() {
        KartenStapel testKartenStapel = new KartenStapel();
        Spieler testSpieler = new Spieler("Spieler");
        SpielendeSpieler testSpielenderSpieler = new SpielendeSpieler(testSpieler);
        Karte testSpielerKarteEins = new Karte(Farbe.HERZ, Wert.ASS);
        Karte testSpielerKarteZwei = new Karte(Farbe.HERZ, Wert.DAME);
        Karte testStapelKarte = new Karte(Farbe.KARO, Wert.ASS);

        testSpielenderSpieler.karteAufDieHand(testSpielerKarteEins);
        testSpielenderSpieler.karteAufDieHand(testSpielerKarteZwei);

        testKartenStapel.getGelegteKarten().add(testStapelKarte);

        testSpielenderSpieler.karteSetzen(testSpielerKarteEins, testKartenStapel);

        List<Karte> gelegteKarten = testKartenStapel.getGelegteKarten();
        Assertions.assertThat(gelegteKarten)
                .hasSize(2)
                .contains(testSpielerKarteEins);
    }

    @Test
    void testKarteAufDieHand() {
        Spieler testSpieler = new Spieler("Spieler");
        SpielendeSpieler testSpielenderSpieler = new SpielendeSpieler(testSpieler);
        Karte testKarte = new Karte(Farbe.HERZ, Wert.ASS);

        testSpielenderSpieler.karteAufDieHand(testKarte);

        Assertions.assertThat(testSpielenderSpieler.getHandKarten())
                .hasSize(1)
                .contains(testKarte);
    }
    @Test
    void testKarteGewonnen() {
        Spieler testSpieler = new Spieler("Spieler");
        SpielendeSpieler testSpielenderSpieler = new SpielendeSpieler(testSpieler);
        Karte testKarte = new Karte(Farbe.HERZ, Wert.ASS);

        testSpielenderSpieler.karteGewonnen(testKarte);

        Assertions.assertThat(testSpielenderSpieler.getGewonneneKarten())
                .hasSize(1)
                .contains(testKarte);
    }
}