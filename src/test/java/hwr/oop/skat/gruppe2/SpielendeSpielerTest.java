package hwr.oop.skat.gruppe2;

import hwr.oop.skat.gruppe2.domain.SpielendeSpieler;
import hwr.oop.skat.gruppe2.domain.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SpielendeSpielerTest {
  @Test
  void testKarteSetzenStapelLeer() {
    Spielfeld testSpielfeld = new Spielfeld();
    Person testPerson = new Person("Spieler");
    SpielendeSpieler testSpielenderSpieler = new SpielendeSpieler(testPerson);
    Karte testKarte = new Karte(Farbe.HERZ, Wert.ASS);

    testSpielenderSpieler.karteAufDieHand(testKarte);

    testSpielenderSpieler.karteSetzen(testKarte, testSpielfeld);

    List<Karte> gelegteKarten = testSpielfeld.getGelegteKarten();
    Assertions.assertThat(gelegteKarten).hasSize(1).contains(testKarte);
  }

  @Test
  void testKarteSetzenGleicheFarbe() {
    Spielfeld testSpielfeld = new Spielfeld();
    Person testPerson = new Person("Spieler");
    SpielendeSpieler testSpielenderSpieler = new SpielendeSpieler(testPerson);
    Karte testSpielerKarte = new Karte(Farbe.HERZ, Wert.ASS);
    Karte testStapelKarte = new Karte(Farbe.HERZ, Wert.DAME);

    testSpielenderSpieler.karteAufDieHand(testSpielerKarte);

    testSpielfeld.getGelegteKarten().add(testStapelKarte);

    testSpielenderSpieler.karteSetzen(testSpielerKarte, testSpielfeld);

    List<Karte> gelegteKarten = testSpielfeld.getGelegteKarten();
    Assertions.assertThat(gelegteKarten).hasSize(2).contains(testSpielerKarte);
  }

  @Test
  void testKarteSetzenUngleicheFarbeIllegal() {
    Spielfeld testSpielfeld = new Spielfeld();
    Person testPerson = new Person("Spieler");
    SpielendeSpieler testSpielenderSpieler = new SpielendeSpieler(testPerson);
    Karte testSpielerKarteEins = new Karte(Farbe.HERZ, Wert.ASS);
    Karte testSpielerKarteZwei = new Karte(Farbe.KARO, Wert.DAME);
    Karte testStapelKarte = new Karte(Farbe.KARO, Wert.ASS);

    testSpielenderSpieler.karteAufDieHand(testSpielerKarteEins);
    testSpielenderSpieler.karteAufDieHand(testSpielerKarteZwei);

    testSpielfeld.getGelegteKarten().add(testStapelKarte);

    testSpielenderSpieler.karteSetzen(testSpielerKarteEins, testSpielfeld);

    List<Karte> gelegteKarten = testSpielfeld.getGelegteKarten();
    Assertions.assertThat(gelegteKarten).hasSize(1).doesNotContain(testSpielerKarteEins);
  }

  @Test
  void testKarteSetzenUngleicheFarbeLegal() {
    Spielfeld testSpielfeld = new Spielfeld();
    Person testPerson = new Person("Spieler");
    SpielendeSpieler testSpielenderSpieler = new SpielendeSpieler(testPerson);
    Karte testSpielerKarteEins = new Karte(Farbe.HERZ, Wert.ASS);
    Karte testSpielerKarteZwei = new Karte(Farbe.HERZ, Wert.DAME);
    Karte testStapelKarte = new Karte(Farbe.KARO, Wert.ASS);

    testSpielenderSpieler.karteAufDieHand(testSpielerKarteEins);
    testSpielenderSpieler.karteAufDieHand(testSpielerKarteZwei);

    testSpielfeld.getGelegteKarten().add(testStapelKarte);

    testSpielenderSpieler.karteSetzen(testSpielerKarteEins, testSpielfeld);

    List<Karte> gelegteKarten = testSpielfeld.getGelegteKarten();
    Assertions.assertThat(gelegteKarten).hasSize(2).contains(testSpielerKarteEins);
  }

  @Test
  void testKarteAufDieHand() {
    Person testPerson = new Person("Spieler");
    SpielendeSpieler testSpielenderSpieler = new SpielendeSpieler(testPerson);
    Karte testKarte = new Karte(Farbe.HERZ, Wert.ASS);

    testSpielenderSpieler.karteAufDieHand(testKarte);

    Assertions.assertThat(testSpielenderSpieler.getHandKarten()).hasSize(1).contains(testKarte);
  }

  @Test
  void testKarteGewonnen() {
    Person testPerson = new Person("Spieler");
    SpielendeSpieler testSpielenderSpieler = new SpielendeSpieler(testPerson);
    Karte testKarte = new Karte(Farbe.HERZ, Wert.ASS);

    testSpielenderSpieler.karteGewonnen(testKarte);

    Assertions.assertThat(testSpielenderSpieler.getGewonneneKarten())
        .hasSize(1)
        .contains(testKarte);
  }
}
