package hwr.oop.skat.gruppe2;

import hwr.oop.skat.gruppe2.domain.*;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class StichTest {

  @Test
  void testConstructorSpieler() {
    Stich testStich = new Stich(new Spieler(new Person("TestPerson")), Farbe.HERZ);

    Assertions.assertThat(testStich.getSpielerAnDerReihe().getPerson().getName())
        .isEqualTo("TestPerson");
  }

  @Test
  void testConstructorFarbe() {
    Stich testStich = new Stich(new Spieler(new Person("TestPerson")), Farbe.HERZ);

    Assertions.assertThat(testStich.getErsteFarbe()).isEqualTo(Farbe.HERZ);
  }

  @Test
  void testConstructorGelegteKarten() {
    Stich testStich = new Stich(new Spieler(new Person("TestPerson")), Farbe.HERZ);

    Assertions.assertThat(testStich.getGelegteKarten()).isEmpty();
  }

  @Test
  void testGetGelegteKarten() {
    Stich testStich = new Stich(new Spieler(new Person("TestPerson")), Farbe.HERZ);

    testStich.setGelegteKarten(
        Arrays.asList(new Karte(Farbe.HERZ, Wert.ASS), new Karte(Farbe.KARO, Wert.ASS)));

    Assertions.assertThat(testStich.getGelegteKarten())
        .containsExactlyElementsOf(
            Arrays.asList(new Karte(Farbe.HERZ, Wert.ASS), new Karte(Farbe.KARO, Wert.ASS)));
  }

  @Test
  void testGibSiegerKarten() {
    Stich testStich = new Stich(new Spieler(new Person("TestPerson")), Farbe.HERZ);

    testStich.setGelegteKarten(
        Arrays.asList(new Karte(Farbe.HERZ, Wert.ASS), new Karte(Farbe.KARO, Wert.ASS)));

    Spieler testSieger = new Spieler(new Person("TestPerson"));

    testStich.gibSiegerKarten(testSieger);

    Assertions.assertThat(testSieger.getGewonneneKarten())
        .hasSize(2)
        .containsExactlyElementsOf(
            Arrays.asList(new Karte(Farbe.HERZ, Wert.ASS), new Karte(Farbe.KARO, Wert.ASS)));
  }
}
