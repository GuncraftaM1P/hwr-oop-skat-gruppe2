package hwr.oop.skat.gruppe2;

import hwr.oop.skat.gruppe2.domain.Spieler;
import hwr.oop.skat.gruppe2.domain.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class SpielerTest {
  @Test
  void testKarteSetzenStapelLeerHandkarten() {

    Spieler testSpieler1 = new Spieler(new Person("Spieler1"));
    Spieler testSpieler2 = new Spieler(new Person("Spieler2"));
    Spieler testSpieler3 = new Spieler(new Person("Spieler3"));

    Karte testKarte = new Karte(Farbe.HERZ, Wert.ASS);
    testSpieler1.karteAufDieHand(testKarte);

    Stich testStich = new Stich(testSpieler1);
    testSpieler1.karteSetzen(
        testKarte, testStich, Arrays.asList(testSpieler1, testSpieler2, testSpieler3));

    Assertions.assertThat(testSpieler1.getHandKarten()).isEmpty();
  }

  @Test
  void testKarteSetzenStapelLeerGelegteKarten() {

    Spieler testSpieler1 = new Spieler(new Person("Spieler1"));
    Spieler testSpieler2 = new Spieler(new Person("Spieler2"));
    Spieler testSpieler3 = new Spieler(new Person("Spieler3"));

    Karte testKarte = new Karte(Farbe.HERZ, Wert.ASS);
    testSpieler1.karteAufDieHand(testKarte);

    Stich testStich = new Stich(testSpieler1);
    testSpieler1.karteSetzen(
        testKarte, testStich, Arrays.asList(testSpieler1, testSpieler2, testSpieler3));

    Assertions.assertThat(testStich.getGelegteKarten()).hasSize(1);
  }

  @Test
  void testKarteSetzenStapelLeerErsteFarbe() {

    Spieler testSpieler1 = new Spieler(new Person("Spieler1"));
    Spieler testSpieler2 = new Spieler(new Person("Spieler2"));
    Spieler testSpieler3 = new Spieler(new Person("Spieler3"));

    Karte testKarte = new Karte(Farbe.HERZ, Wert.ASS);
    testSpieler1.karteAufDieHand(testKarte);

    Stich testStich = new Stich(testSpieler1);
    testSpieler1.karteSetzen(
        testKarte, testStich, Arrays.asList(testSpieler1, testSpieler2, testSpieler3));

    Assertions.assertThat(testStich.getErsteFarbe()).isEqualTo(Farbe.HERZ);
  }

  @Test
  void testKarteSetzenStapelLeerSpielerAnDerReihe() {

    Person testPerson = new Person("Spieler");
    Spieler testSpieler1 = new Spieler(testPerson);
    Spieler testSpieler2 = new Spieler(testPerson);
    Spieler testSpieler3 = new Spieler(testPerson);

    Karte testKarte = new Karte(Farbe.HERZ, Wert.ASS);
    testSpieler1.karteAufDieHand(testKarte);

    Stich testStich = new Stich(testSpieler1);
    testSpieler1.karteSetzen(
        testKarte, testStich, Arrays.asList(testSpieler1, testSpieler2, testSpieler3));

    boolean gleicherSpieler = testStich.getSpielerAnDerReihe().equals(testSpieler2);

    Assertions.assertThat(gleicherSpieler).isTrue();
  }

  @Test
  void testKarteSetzenNichtAnDerReihe() {

    Person testPerson = new Person("Spieler");
    Spieler testSpieler1 = new Spieler(testPerson);
    Spieler testSpieler2 = new Spieler(testPerson);
    Spieler testSpieler3 = new Spieler(testPerson);

    Karte testKarte = new Karte(Farbe.HERZ, Wert.ASS);
    testSpieler1.karteAufDieHand(testKarte);

    Stich testStich = new Stich(testSpieler2);
    testSpieler1.karteSetzen(
        testKarte, testStich, Arrays.asList(testSpieler1, testSpieler2, testSpieler3));

    Assertions.assertThat(testStich.getGelegteKarten()).isEmpty();
  }

  @Test
  void testKarteSetzenKarteNichtEnthalten() {

    Person testPerson = new Person("Spieler");
    Spieler testSpieler1 = new Spieler(testPerson);
    Spieler testSpieler2 = new Spieler(testPerson);
    Spieler testSpieler3 = new Spieler(testPerson);

    Karte testKarte = new Karte(Farbe.HERZ, Wert.ASS);

    Stich testStich = new Stich(testSpieler1);
    testSpieler1.karteSetzen(
        testKarte, testStich, Arrays.asList(testSpieler1, testSpieler2, testSpieler3));

    Assertions.assertThat(testStich.getGelegteKarten()).isEmpty();
  }

  @Test
  void testKarteSetzenGleicheFarbe() {

    Person testPerson = new Person("Spieler");
    Spieler testSpieler1 = new Spieler(testPerson);
    Spieler testSpieler2 = new Spieler(testPerson);
    Spieler testSpieler3 = new Spieler(testPerson);

    Karte testKarte1 = new Karte(Farbe.HERZ, Wert.ASS);
    Karte testKarte2 = new Karte(Farbe.HERZ, Wert.ZEHN);

    testSpieler1.karteAufDieHand(testKarte1);
    testSpieler2.karteAufDieHand(testKarte2);

    Stich testStich = new Stich(testSpieler1);
    testSpieler1.karteSetzen(
        testKarte1, testStich, Arrays.asList(testSpieler1, testSpieler2, testSpieler3));
    testSpieler2.karteSetzen(
        testKarte2, testStich, Arrays.asList(testSpieler1, testSpieler2, testSpieler3));

    Assertions.assertThat(testStich.getGelegteKarten()).hasSize(2);
  }

  @Test
  void testKarteSetzenGleicheFarbeSpielerAnDerReihe() {

    Spieler testSpieler1 = new Spieler(new Person("Spieler1"));
    Spieler testSpieler2 = new Spieler(new Person("Spieler2"));
    Spieler testSpieler3 = new Spieler(new Person("Spieler3"));

    Karte testKarte1 = new Karte(Farbe.HERZ, Wert.ASS);
    Karte testKarte2 = new Karte(Farbe.HERZ, Wert.ZEHN);

    testSpieler1.karteAufDieHand(testKarte1);
    testSpieler2.karteAufDieHand(testKarte2);

    Stich testStich = new Stich(testSpieler1);
    testSpieler1.karteSetzen(
        testKarte1, testStich, Arrays.asList(testSpieler1, testSpieler2, testSpieler3));
    testSpieler2.karteSetzen(
        testKarte2, testStich, Arrays.asList(testSpieler1, testSpieler2, testSpieler3));

    boolean gleicherSpieler = testStich.getSpielerAnDerReihe().equals(testSpieler3);

    Assertions.assertThat(gleicherSpieler).isTrue();
  }

  @Test
  void testKarteSetzenUngleicheFarbeLegal() {

    Spieler testSpieler1 = new Spieler(new Person("Spieler1"));
    Spieler testSpieler2 = new Spieler(new Person("Spieler2"));
    Spieler testSpieler3 = new Spieler(new Person("Spieler3"));

    Karte testKarte1 = new Karte(Farbe.HERZ, Wert.ASS);
    Karte testKarte2 = new Karte(Farbe.KARO, Wert.ZEHN);

    testSpieler1.karteAufDieHand(testKarte1);
    testSpieler2.karteAufDieHand(testKarte2);

    Stich testStich = new Stich(testSpieler1);
    testSpieler1.karteSetzen(
        testKarte1, testStich, Arrays.asList(testSpieler1, testSpieler2, testSpieler3));
    testSpieler2.karteSetzen(
        testKarte2, testStich, Arrays.asList(testSpieler1, testSpieler2, testSpieler3));

    Assertions.assertThat(testStich.getGelegteKarten()).hasSize(2);
  }

  @Test
  void testKarteSetzenUngleicheFarbeLegalSpielerAnDerReihe() {

    Person testPerson = new Person("Spieler");
    Spieler testSpieler1 = new Spieler(testPerson);
    Spieler testSpieler2 = new Spieler(testPerson);
    Spieler testSpieler3 = new Spieler(testPerson);

    Karte testKarte1 = new Karte(Farbe.HERZ, Wert.ASS);
    Karte testKarte2 = new Karte(Farbe.KARO, Wert.ZEHN);

    testSpieler1.karteAufDieHand(testKarte1);
    testSpieler2.karteAufDieHand(testKarte2);

    Stich testStich = new Stich(testSpieler1);
    testSpieler1.karteSetzen(
        testKarte1, testStich, Arrays.asList(testSpieler1, testSpieler2, testSpieler3));
    testSpieler2.karteSetzen(
        testKarte2, testStich, Arrays.asList(testSpieler1, testSpieler2, testSpieler3));

    boolean gleicherSpieler = testStich.getSpielerAnDerReihe().equals(testSpieler2);

    Assertions.assertThat(gleicherSpieler).isTrue();
  }

  @Test
  void testKarteSetzenUngleicheFarbeIllegal() {

    Person testPerson = new Person("Spieler");
    Spieler testSpieler1 = new Spieler(testPerson);
    Spieler testSpieler2 = new Spieler(testPerson);
    Spieler testSpieler3 = new Spieler(testPerson);

    Karte testKarte1 = new Karte(Farbe.HERZ, Wert.ASS);
    Karte testKarte2 = new Karte(Farbe.KARO, Wert.ZEHN);
    Karte testKarte3 = new Karte(Farbe.HERZ, Wert.NEUN);

    testSpieler1.karteAufDieHand(testKarte1);
    testSpieler2.karteAufDieHand(testKarte2);
    testSpieler2.karteAufDieHand(testKarte3);

    Stich testStich = new Stich(testSpieler1);
    testSpieler1.karteSetzen(
        testKarte1, testStich, Arrays.asList(testSpieler1, testSpieler2, testSpieler3));
    testSpieler2.karteSetzen(
        testKarte2, testStich, Arrays.asList(testSpieler1, testSpieler2, testSpieler3));

    Assertions.assertThat(testStich.getGelegteKarten()).hasSize(1);
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

    Assertions.assertThat(testSpieler.getGewonneneKarten()).hasSize(1).contains(testKarte);
  }

  @Test
  void testSetHandkarten() {
    List<Karte> testKarten =
        Arrays.asList(new Karte(Farbe.HERZ, Wert.ASS), new Karte(Farbe.KARO, Wert.ASS));

    Spieler testSpieler = new Spieler(new Person("testPerson"));

    testSpieler.setHandKarten(testKarten);

    Assertions.assertThat(testSpieler.getHandKarten())
        .hasSize(2)
        .containsExactlyElementsOf(testKarten);
  }

  @Test
  void testSetGewonneneKarten() {
    List<Karte> testKarten =
        Arrays.asList(new Karte(Farbe.HERZ, Wert.ASS), new Karte(Farbe.KARO, Wert.ASS));

    Spieler testSpieler = new Spieler(new Person("testPerson"));

    testSpieler.setGewonneneKarten(testKarten);

    Assertions.assertThat(testSpieler.getGewonneneKarten())
        .hasSize(2)
        .containsExactlyElementsOf(testKarten);
  }

  @Test
  void testKartenAufDieHand() {
    Person testPerson = new Person("Spieler");
    Spieler testSpieler = new Spieler(testPerson);

    testSpieler.kartenAufDieHand(
        List.of(
            new Karte(Farbe.HERZ, Wert.BUBE),
            new Karte(Farbe.KARO, Wert.BUBE),
            new Karte(Farbe.PIK, Wert.BUBE)));

    Assertions.assertThat(testSpieler.getHandKarten())
        .containsExactlyInAnyOrderElementsOf(
            List.of(
                new Karte(Farbe.HERZ, Wert.BUBE),
                new Karte(Farbe.KARO, Wert.BUBE),
                new Karte(Farbe.PIK, Wert.BUBE)));
  }

  @Test
  void testEquals() {
    Person testPerson = new Person("Spieler");
    Spieler testSpieler = new Spieler(testPerson);

    Spieler testSpieler2 = new Spieler(testPerson);

    boolean equals = testSpieler.equals(testSpieler2);

    Assertions.assertThat(equals).isTrue();
  }

  @Test
  void testHash() {
    Person testPerson = new Person("Spieler");
    Spieler testSpieler = new Spieler(testPerson);
    int testSpieler1 = testSpieler.hashCode();
    int testSpieler2 = testSpieler.hashCode();

    Assertions.assertThat(testSpieler1).isEqualTo(testSpieler2);
  }
}
