package hwr.oop.skat.gruppe2;

import hwr.oop.skat.gruppe2.domain.Spieler;
import hwr.oop.skat.gruppe2.domain.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SpielerTest {
  @Test
  void testKarteSetzenStapelLeer() {
    Spielfeld testSpielfeld = new Spielfeld();
    Person testPerson = new Person("Spieler");
    Spieler testSpieler = new Spieler(testPerson);
    Karte testKarte = new Karte(Farbe.HERZ, Wert.ASS);

    testSpieler.karteAufDieHand(testKarte);

    testSpieler.karteSetzen(testKarte, testSpielfeld);

    List<Karte> gelegteKarten = testSpielfeld.getGelegteKarten();
    Assertions.assertThat(gelegteKarten).hasSize(1).contains(testKarte);
  }

  @Test
  void testKarteSetzenGleicheFarbe() {
    Spielfeld testSpielfeld = new Spielfeld();
    Person testPerson = new Person("Spieler");
    Spieler testSpieler = new Spieler(testPerson);
    Karte testSpielerKarte = new Karte(Farbe.HERZ, Wert.ASS);
    Karte testStapelKarte = new Karte(Farbe.HERZ, Wert.DAME);

    testSpieler.karteAufDieHand(testSpielerKarte);

    testSpielfeld.getGelegteKarten().add(testStapelKarte);

    testSpieler.karteSetzen(testSpielerKarte, testSpielfeld);

    List<Karte> gelegteKarten = testSpielfeld.getGelegteKarten();
    Assertions.assertThat(gelegteKarten).hasSize(2).contains(testSpielerKarte);
  }

  @Test
  void testKarteSetzenUngleicheFarbeIllegal() {
    Spielfeld testSpielfeld = new Spielfeld();
    Person testPerson = new Person("Spieler");
    Spieler testSpieler = new Spieler(testPerson);
    Karte testSpielerKarteEins = new Karte(Farbe.HERZ, Wert.ASS);
    Karte testSpielerKarteZwei = new Karte(Farbe.KARO, Wert.DAME);
    Karte testStapelKarte = new Karte(Farbe.KARO, Wert.ASS);

    testSpieler.karteAufDieHand(testSpielerKarteEins);
    testSpieler.karteAufDieHand(testSpielerKarteZwei);

    testSpielfeld.getGelegteKarten().add(testStapelKarte);

    testSpieler.karteSetzen(testSpielerKarteEins, testSpielfeld);

    List<Karte> gelegteKarten = testSpielfeld.getGelegteKarten();
    Assertions.assertThat(gelegteKarten).hasSize(1).doesNotContain(testSpielerKarteEins);
  }

  @Test
  void testKarteSetzenUngleicheFarbeLegal() {
    Spielfeld testSpielfeld = new Spielfeld();
    Person testPerson = new Person("Spieler");
    Spieler testSpieler = new Spieler(testPerson);
    Karte testSpielerKarteEins = new Karte(Farbe.HERZ, Wert.ASS);
    Karte testSpielerKarteZwei = new Karte(Farbe.HERZ, Wert.DAME);
    Karte testStapelKarte = new Karte(Farbe.KARO, Wert.ASS);

    testSpieler.karteAufDieHand(testSpielerKarteEins);
    testSpieler.karteAufDieHand(testSpielerKarteZwei);

    testSpielfeld.getGelegteKarten().add(testStapelKarte);

    testSpieler.karteSetzen(testSpielerKarteEins, testSpielfeld);

    List<Karte> gelegteKarten = testSpielfeld.getGelegteKarten();
    Assertions.assertThat(gelegteKarten).hasSize(2).contains(testSpielerKarteEins);
  }

  @Test
  void testKarteAufDieHand() {
    Person testPerson = new Person("Spieler");
    Spieler testSpieler = new Spieler(testPerson);
    Karte testKarte = new Karte(Farbe.HERZ, Wert.ASS);

    testSpieler.karteAufDieHand(testKarte);

    Assertions.assertThat(testSpieler.getHandKarten()).hasSize(1).contains(testKarte);
  }

  @Test
  void testKarteGewonnen() {
    Person testPerson = new Person("Spieler");
    Spieler testSpieler = new Spieler(testPerson);
    Karte testKarte = new Karte(Farbe.HERZ, Wert.ASS);

    testSpieler.karteGewonnen(testKarte);

    Assertions.assertThat(testSpieler.getGewonneneKarten())
        .hasSize(1)
        .contains(testKarte);
  }
}
