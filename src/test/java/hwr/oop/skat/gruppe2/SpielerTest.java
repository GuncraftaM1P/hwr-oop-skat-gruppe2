package hwr.oop.skat.gruppe2;

import hwr.oop.skat.gruppe2.domain.Spieler;
import hwr.oop.skat.gruppe2.domain.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class SpielerTest {

  @Test
  void testKannLegenKarteNichtEnthalten() {
    Spieler testSpieler = new Spieler(new Person("Person"));

    Assertions.assertThat(testSpieler.kannLegen(new Karte(Farbe.HERZ, Wert.ASS), null)).isFalse();
  }

  @Test
  void testKannLegenKarteStichLeer() {
    Spieler testSpieler = new Spieler(new Person("Person"));

    testSpieler.karteAufDieHand(new Karte(Farbe.HERZ, Wert.ASS));

    Assertions.assertThat(testSpieler.kannLegen(new Karte(Farbe.HERZ, Wert.ASS), null)).isTrue();
  }

  @Test
  void testKannLegenKarteGleicheFarbeTrue() {
    Spieler testSpieler = new Spieler(new Person("Person"));

    testSpieler.karteAufDieHand(new Karte(Farbe.HERZ, Wert.ASS));

    Assertions.assertThat(testSpieler.kannLegen(new Karte(Farbe.HERZ, Wert.ASS), Farbe.HERZ))
        .isTrue();
  }

  @Test
  void testKannLegenKarteGleicheFarbeTrueBube() {
    Spieler testSpieler = new Spieler(new Person("Person"));

    testSpieler.karteAufDieHand(new Karte(Farbe.HERZ, Wert.BUBE));

    Assertions.assertThat(testSpieler.kannLegen(new Karte(Farbe.HERZ, Wert.BUBE), Farbe.HERZ))
        .isTrue();
  }

  @Test
  void testKannLegenKarteGleicheFarbeFalseBube() {
    Spieler testSpieler = new Spieler(new Person("Person"));

    testSpieler.karteAufDieHand(new Karte(Farbe.HERZ, Wert.BUBE));
    testSpieler.karteAufDieHand(new Karte(Farbe.HERZ, Wert.ASS));

    Assertions.assertThat(testSpieler.kannLegen(new Karte(Farbe.HERZ, Wert.BUBE), Farbe.HERZ))
        .isFalse();
  }

  @Test
  void testKannLegenKarteUngleicheFarbeTrue() {
    Spieler testSpieler = new Spieler(new Person("Person"));

    testSpieler.karteAufDieHand(new Karte(Farbe.HERZ, Wert.ASS));

    Assertions.assertThat(testSpieler.kannLegen(new Karte(Farbe.HERZ, Wert.ASS), Farbe.KARO))
        .isTrue();
  }

  @Test
  void testKannLegenKarteUngleicheFarbeFalse() {
    Spieler testSpieler = new Spieler(new Person("Person"));

    testSpieler.karteAufDieHand(new Karte(Farbe.HERZ, Wert.ASS));
    testSpieler.karteAufDieHand(new Karte(Farbe.KARO, Wert.ASS));

    Assertions.assertThat(testSpieler.kannLegen(new Karte(Farbe.HERZ, Wert.ASS), Farbe.KARO))
        .isFalse();
  }

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
  void testSkatAblegenFalscheKartenSize() {
    Spieler testSpieler = new Spieler(new Person("Person"));

    testSpieler.setHandKarten(
        List.of(
            new Karte(Farbe.HERZ, Wert.SIEBEN),
            new Karte(Farbe.HERZ, Wert.ACHT),
            new Karte(Farbe.HERZ, Wert.NEUN),
            new Karte(Farbe.KARO, Wert.SIEBEN),
            new Karte(Farbe.KARO, Wert.ACHT),
            new Karte(Farbe.KARO, Wert.NEUN),
            new Karte(Farbe.PIK, Wert.SIEBEN),
            new Karte(Farbe.PIK, Wert.ACHT),
            new Karte(Farbe.PIK, Wert.NEUN),
            new Karte(Farbe.KREUZ, Wert.SIEBEN),
            new Karte(Farbe.KREUZ, Wert.ACHT),
            new Karte(Farbe.KREUZ, Wert.NEUN)));

    Assertions.assertThat(testSpieler.skatAblegen(List.of(new Karte(Farbe.HERZ, Wert.SIEBEN))))
        .isFalse();
  }

  @Test
  void testSkatAblegenFalscheHandKartenSize() {
    Spieler testSpieler = new Spieler(new Person("Person"));

    testSpieler.setHandKarten(
        List.of(
            new Karte(Farbe.HERZ, Wert.SIEBEN),
            new Karte(Farbe.HERZ, Wert.ACHT),
            new Karte(Farbe.HERZ, Wert.NEUN),
            new Karte(Farbe.KARO, Wert.SIEBEN),
            new Karte(Farbe.KARO, Wert.ACHT),
            new Karte(Farbe.KARO, Wert.NEUN),
            new Karte(Farbe.PIK, Wert.SIEBEN),
            new Karte(Farbe.PIK, Wert.ACHT),
            new Karte(Farbe.PIK, Wert.NEUN),
            new Karte(Farbe.KREUZ, Wert.SIEBEN),
            new Karte(Farbe.KREUZ, Wert.ACHT)));

    Assertions.assertThat(
            testSpieler.skatAblegen(
                List.of(new Karte(Farbe.HERZ, Wert.SIEBEN), new Karte(Farbe.HERZ, Wert.ACHT))))
        .isFalse();
  }

  @Test
  void testSkatAblegenFalscheKarten() {
    Spieler testSpieler = new Spieler(new Person("Person"));

    testSpieler.setHandKarten(
        List.of(
            new Karte(Farbe.HERZ, Wert.SIEBEN),
            new Karte(Farbe.HERZ, Wert.ACHT),
            new Karte(Farbe.HERZ, Wert.NEUN),
            new Karte(Farbe.KARO, Wert.SIEBEN),
            new Karte(Farbe.KARO, Wert.ACHT),
            new Karte(Farbe.KARO, Wert.NEUN),
            new Karte(Farbe.PIK, Wert.SIEBEN),
            new Karte(Farbe.PIK, Wert.ACHT),
            new Karte(Farbe.PIK, Wert.NEUN),
            new Karte(Farbe.KREUZ, Wert.SIEBEN),
            new Karte(Farbe.KREUZ, Wert.ACHT),
            new Karte(Farbe.KREUZ, Wert.NEUN)));

    Assertions.assertThat(
            testSpieler.skatAblegen(
                List.of(new Karte(Farbe.HERZ, Wert.BUBE), new Karte(Farbe.HERZ, Wert.BUBE))))
        .isFalse();
  }

  @Test
  void testSkatAblegenFalscheKarteEins() {
    Spieler testSpieler = new Spieler(new Person("Person"));

    testSpieler.setHandKarten(
        List.of(
            new Karte(Farbe.HERZ, Wert.SIEBEN),
            new Karte(Farbe.HERZ, Wert.ACHT),
            new Karte(Farbe.HERZ, Wert.NEUN),
            new Karte(Farbe.KARO, Wert.SIEBEN),
            new Karte(Farbe.KARO, Wert.ACHT),
            new Karte(Farbe.KARO, Wert.NEUN),
            new Karte(Farbe.PIK, Wert.SIEBEN),
            new Karte(Farbe.PIK, Wert.ACHT),
            new Karte(Farbe.PIK, Wert.NEUN),
            new Karte(Farbe.KREUZ, Wert.SIEBEN),
            new Karte(Farbe.KREUZ, Wert.ACHT),
            new Karte(Farbe.KREUZ, Wert.NEUN)));

    Assertions.assertThat(
            testSpieler.skatAblegen(
                List.of(new Karte(Farbe.HERZ, Wert.BUBE), new Karte(Farbe.HERZ, Wert.SIEBEN))))
        .isFalse();
  }

  @Test
  void testSkatAblegenFalscheKarteZwei() {
    Spieler testSpieler = new Spieler(new Person("Person"));

    testSpieler.setHandKarten(
        List.of(
            new Karte(Farbe.HERZ, Wert.SIEBEN),
            new Karte(Farbe.HERZ, Wert.ACHT),
            new Karte(Farbe.HERZ, Wert.NEUN),
            new Karte(Farbe.KARO, Wert.SIEBEN),
            new Karte(Farbe.KARO, Wert.ACHT),
            new Karte(Farbe.KARO, Wert.NEUN),
            new Karte(Farbe.PIK, Wert.SIEBEN),
            new Karte(Farbe.PIK, Wert.ACHT),
            new Karte(Farbe.PIK, Wert.NEUN),
            new Karte(Farbe.KREUZ, Wert.SIEBEN),
            new Karte(Farbe.KREUZ, Wert.ACHT),
            new Karte(Farbe.KREUZ, Wert.NEUN)));

    Assertions.assertThat(
            testSpieler.skatAblegen(
                List.of(new Karte(Farbe.HERZ, Wert.SIEBEN), new Karte(Farbe.HERZ, Wert.BUBE))))
        .isFalse();
  }

  /*
  @Test
  void testSkatAblegenRichtigeKarten() {
    Spieler testSpieler = new Spieler(new Person("Person"));

    testSpieler.setHandKarten(
            List.of(
                    new Karte(Farbe.HERZ, Wert.SIEBEN),
                    new Karte(Farbe.HERZ, Wert.ACHT),
                    new Karte(Farbe.HERZ, Wert.NEUN),
                    new Karte(Farbe.KARO, Wert.SIEBEN),
                    new Karte(Farbe.KARO, Wert.ACHT),
                    new Karte(Farbe.KARO, Wert.NEUN),
                    new Karte(Farbe.PIK, Wert.SIEBEN),
                    new Karte(Farbe.PIK, Wert.ACHT),
                    new Karte(Farbe.PIK, Wert.NEUN),
                    new Karte(Farbe.KREUZ, Wert.SIEBEN),
                    new Karte(Farbe.KREUZ, Wert.ACHT),
                    new Karte(Farbe.KREUZ, Wert.NEUN)));

    Assertions.assertThat(
                    testSpieler.skatAblegen(
                            List.of(new Karte(Farbe.HERZ, Wert.SIEBEN), new Karte(Farbe.HERZ, Wert.ACHT))))
            .isTrue();
  }
  */

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
  void testAlternativeConstructPerson() {
    Spieler testSpieler =
        new Spieler(
            new Person("Person"),
            List.of(new Karte(Farbe.HERZ, Wert.ASS)),
            List.of(new Karte(Farbe.KARO, Wert.ASS)));

    Assertions.assertThat(testSpieler.getPerson().getName()).isEqualTo("Person");
  }

  @Test
  void testAlternativeConstructHandKarten() {
    Spieler testSpieler =
        new Spieler(
            new Person("Person"),
            List.of(new Karte(Farbe.HERZ, Wert.ASS)),
            List.of(new Karte(Farbe.KARO, Wert.ASS)));

    Assertions.assertThat(testSpieler.getHandKarten())
        .containsExactlyElementsOf(List.of(new Karte(Farbe.HERZ, Wert.ASS)));
  }

  @Test
  void testAlternativeConstructGewonneneKarten() {
    Spieler testSpieler =
        new Spieler(
            new Person("Person"),
            List.of(new Karte(Farbe.HERZ, Wert.ASS)),
            List.of(new Karte(Farbe.KARO, Wert.ASS)));

    Assertions.assertThat(testSpieler.getGewonneneKarten())
        .containsExactlyElementsOf(List.of(new Karte(Farbe.KARO, Wert.ASS)));
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
