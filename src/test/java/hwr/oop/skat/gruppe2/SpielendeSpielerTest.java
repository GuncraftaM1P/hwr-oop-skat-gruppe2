package hwr.oop.skat.gruppe2;

import hwr.oop.skat.gruppe2.application.SpielendeSpieler;
import hwr.oop.skat.gruppe2.domain.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SpielendeSpielerTest {
    @Test
    void testKarteSetzen() {
        KartenStapel testKartenStapel = new KartenStapel();
        Spieler testSpieler = new Spieler("Spieler");
        SpielendeSpieler testSpielenderSpieler = new SpielendeSpieler(testSpieler);
        Karte testKarte = new Karte(Farbe.HERZ, Wert.ASS);

        testSpielenderSpieler.karteAufDieHand(testKarte);

        testSpielenderSpieler.karteSetzen(testKarte, testKartenStapel);

        Assertions.assertThat(testKartenStapel.getGelegteKarten().contains(testKarte)).isEqualTo(true);
    }
    @Test
    void testKarteAufDieHand() {
        Spieler testSpieler = new Spieler("Spieler");
        SpielendeSpieler testSpielenderSpieler = new SpielendeSpieler(testSpieler);
        Karte testKarte = new Karte(Farbe.HERZ, Wert.ASS);

        testSpielenderSpieler.karteAufDieHand(testKarte);

        Assertions.assertThat(testSpielenderSpieler.getHandKarten().istKarteEnthalten(testKarte)).isEqualTo(true);
    }
    @Test
    void testKarteGewonnen() {
        Spieler testSpieler = new Spieler("Spieler");
        SpielendeSpieler testSpielenderSpieler = new SpielendeSpieler(testSpieler);
        Karte testKarte = new Karte(Farbe.HERZ, Wert.ASS);

        testSpielenderSpieler.karteGewonnen(testKarte);

        Assertions.assertThat(testSpielenderSpieler.getGewonneneKarten().istKarteEnthalten(testKarte)).isEqualTo(true);
    }
}