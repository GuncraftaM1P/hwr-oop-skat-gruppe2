package hwr.oop;

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

        Assertions.assertThat(testSpielenderSpieler.getHandKarten().contains(testKarte)).isEqualTo(true);
    }
    @Test
    void testKarteGewonnen() {
        Spieler testSpieler = new Spieler("Spieler");
        SpielendeSpieler testSpielenderSpieler = new SpielendeSpieler(testSpieler);
        Karte testKarte = new Karte(Farbe.HERZ, Wert.ASS);

        testSpielenderSpieler.karteGewonnen(testKarte);

        Assertions.assertThat(testSpielenderSpieler.getGewonneneKarten().contains(testKarte)).isEqualTo(true);
    }
}