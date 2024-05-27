package hwr.oop.skat.gruppe2;

import hwr.oop.skat.gruppe2.domain.SpielendeSpieler;
import hwr.oop.skat.gruppe2.domain.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SpielendeSpielerTest {
    @Test
    void testKarteSetzen() {
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