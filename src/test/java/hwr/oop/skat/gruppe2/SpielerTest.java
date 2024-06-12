package hwr.oop.skat.gruppe2;

import hwr.oop.skat.gruppe2.domain.Spieler;
import hwr.oop.skat.gruppe2.domain.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class SpielerTest {

  @Test
  void testKannBedienenTrue() {
    Spieler testSpieler = new Spieler(new Person("Person"));

    testSpieler.setHandKarten(
        List.of(new Karte(Farbe.HERZ, Wert.ASS), new Karte(Farbe.KARO, Wert.ASS)));

    Assertions.assertThat(testSpieler.kannBedienen(Farbe.HERZ)).isTrue();
  }

  @Test
  void testKannBedienenFalseBube() {
    Spieler testSpieler = new Spieler(new Person("Person"));

    testSpieler.setHandKarten(
        List.of(new Karte(Farbe.HERZ, Wert.BUBE), new Karte(Farbe.KARO, Wert.ASS)));

    Assertions.assertThat(testSpieler.kannBedienen(Farbe.HERZ)).isFalse();
  }

  @Test
  void testKannBedienenFalseFarbe() {
    Spieler testSpieler = new Spieler(new Person("Person"));

    testSpieler.setHandKarten(
        List.of(new Karte(Farbe.PIK, Wert.ASS), new Karte(Farbe.KARO, Wert.ASS)));

    Assertions.assertThat(testSpieler.kannBedienen(Farbe.HERZ)).isFalse();
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
  void testKartenGewonnen() {
    Person testPerson = new Person("Spieler");
    Spieler testSpieler = new Spieler(testPerson);
    List<Karte> testKarten =
        List.of(new Karte(Farbe.HERZ, Wert.ASS), new Karte(Farbe.PIK, Wert.ASS));

    testSpieler.kartenGewonnen(testKarten);

    Assertions.assertThat(testSpieler.getGewonneneKarten()).hasSize(2).containsAll(testKarten);
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
