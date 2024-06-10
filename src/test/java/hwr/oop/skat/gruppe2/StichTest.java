package hwr.oop.skat.gruppe2;

import hwr.oop.skat.gruppe2.domain.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
    Spieler testSieger = new Spieler(new Person("TestPerson"));
    Stich testStich = new Stich(testSieger, Farbe.HERZ);

    List<Karte> testKarten =
        Arrays.asList(new Karte(Farbe.HERZ, Wert.ASS), new Karte(Farbe.KARO, Wert.ASS));

    testStich.setGelegteKarten(testKarten);
    testStich.gibSiegerKarten(testSieger);

    Assertions.assertThat(testSieger.getGewonneneKarten()).hasSize(2);
  }

  @Test
  void testErmittleSiegerKreuzBube() {
    List<Spieler> testSpieler =
        Arrays.asList(
            new Spieler(new Person("TestPerson1")),
            new Spieler(new Person("TestPerson2")),
            new Spieler(new Person("TestPerson3")));

    Stich testStich = new Stich(testSpieler.getLast(), Farbe.HERZ);

    testStich.setGelegteKarten(
        Arrays.asList(
            new Karte(Farbe.KREUZ, Wert.KOENIG),
            new Karte(Farbe.KREUZ, Wert.DAME),
            new Karte(Farbe.KREUZ, Wert.BUBE)));

    boolean siegerErmittelt =
        testStich
            .ermittleSieger(testSpieler, new Trumpffarbe(Farbe.HERZ))
            .equals(testSpieler.get(1));

    Assertions.assertThat(siegerErmittelt).isTrue();
  }

  @Test
  void testErmittleSiegerPikBube() {
    List<Spieler> testSpieler =
        Arrays.asList(
            new Spieler(new Person("TestPerson1")),
            new Spieler(new Person("TestPerson2")),
            new Spieler(new Person("TestPerson3")));

    Stich testStich = new Stich(testSpieler.getLast(), Farbe.HERZ);

    testStich.setGelegteKarten(
        Arrays.asList(
            new Karte(Farbe.PIK, Wert.KOENIG),
            new Karte(Farbe.PIK, Wert.DAME),
            new Karte(Farbe.PIK, Wert.BUBE)));

    boolean siegerErmittelt =
        testStich
            .ermittleSieger(testSpieler, new Trumpffarbe(Farbe.HERZ))
            .equals(testSpieler.get(1));

    Assertions.assertThat(siegerErmittelt).isTrue();
  }

  @Test
  void testErmittleSiegerHerzBube() {
    List<Spieler> testSpieler =
        Arrays.asList(
            new Spieler(new Person("TestPerson1")),
            new Spieler(new Person("TestPerson2")),
            new Spieler(new Person("TestPerson3")));

    Stich testStich = new Stich(testSpieler.getLast(), Farbe.HERZ);

    testStich.setGelegteKarten(
        Arrays.asList(
            new Karte(Farbe.HERZ, Wert.KOENIG),
            new Karte(Farbe.HERZ, Wert.DAME),
            new Karte(Farbe.HERZ, Wert.BUBE)));

    boolean siegerErmittelt =
        testStich
            .ermittleSieger(testSpieler, new Trumpffarbe(Farbe.HERZ))
            .equals(testSpieler.get(1));

    Assertions.assertThat(siegerErmittelt).isTrue();
  }

  @Test
  void testErmittleSiegerKaroBube() {
    List<Spieler> testSpieler =
        Arrays.asList(
            new Spieler(new Person("TestPerson1")),
            new Spieler(new Person("TestPerson2")),
            new Spieler(new Person("TestPerson3")));

    Stich testStich = new Stich(testSpieler.getLast(), Farbe.HERZ);

    testStich.setGelegteKarten(
        Arrays.asList(
            new Karte(Farbe.KARO, Wert.KOENIG),
            new Karte(Farbe.KARO, Wert.DAME),
            new Karte(Farbe.KARO, Wert.BUBE)));

    boolean siegerErmittelt =
        testStich
            .ermittleSieger(testSpieler, new Trumpffarbe(Farbe.HERZ))
            .equals(testSpieler.get(1));

    Assertions.assertThat(siegerErmittelt).isTrue();
  }

  @Test
  void testErmittleSiegerTrumpf() {
    List<Spieler> testSpieler =
        Arrays.asList(
            new Spieler(new Person("TestPerson1")),
            new Spieler(new Person("TestPerson2")),
            new Spieler(new Person("TestPerson3")));

    Stich testStich = new Stich(testSpieler.getLast(), Farbe.KREUZ);

    testStich.setGelegteKarten(
        Arrays.asList(
            new Karte(Farbe.HERZ, Wert.SIEBEN),
            new Karte(Farbe.KREUZ, Wert.KOENIG),
            new Karte(Farbe.HERZ, Wert.DAME)));

    boolean siegerErmittelt =
        testStich
            .ermittleSieger(testSpieler, new Trumpffarbe(Farbe.HERZ))
            .equals(testSpieler.get(1));

    Assertions.assertThat(siegerErmittelt).isTrue();
  }

  @Test
  void testErmittleSieger() {
    List<Spieler> testSpieler =
        Arrays.asList(
            new Spieler(new Person("TestPerson1")),
            new Spieler(new Person("TestPerson2")),
            new Spieler(new Person("TestPerson3")));

    Stich testStich = new Stich(testSpieler.getLast(), Farbe.HERZ);

    testStich.setGelegteKarten(
        Arrays.asList(
            new Karte(Farbe.HERZ, Wert.SIEBEN),
            new Karte(Farbe.KREUZ, Wert.KOENIG),
            new Karte(Farbe.HERZ, Wert.DAME)));

    boolean siegerErmittelt =
        testStich
            .ermittleSieger(testSpieler, new Trumpffarbe(Farbe.KARO))
            .equals(testSpieler.get(1));

    Assertions.assertThat(siegerErmittelt).isTrue();
  }

  @Test
  void testErmittleSiegerGleicheKarte() {
    List<Spieler> testSpieler =
            Arrays.asList(
                    new Spieler(new Person("TestPerson1")),
                    new Spieler(new Person("TestPerson2")),
                    new Spieler(new Person("TestPerson3")));

    Stich testStich = new Stich(testSpieler.getLast(), Farbe.HERZ);

    testStich.setGelegteKarten(
            Arrays.asList(
                    new Karte(Farbe.HERZ, Wert.DAME),
                    new Karte(Farbe.HERZ, Wert.ACHT),
                    new Karte(Farbe.HERZ, Wert.DAME)));

    testStich.ermittleSieger(testSpieler, new Trumpffarbe(Farbe.KARO));

    Assertions.assertThat(testStich.getSiegerKarte()).isNull();
  }

  @Test
  void testErmittleSiegerFallsTrumpf() {
    List<Spieler> testSpieler =
        Arrays.asList(
            new Spieler(new Person("TestPerson1")),
            new Spieler(new Person("TestPerson2")),
            new Spieler(new Person("TestPerson3")));

    Stich testStich = new Stich(testSpieler.getLast(), Farbe.HERZ);

    testStich.setGelegteKarten(
        Arrays.asList(
            new Karte(Farbe.KARO, Wert.KOENIG),
            new Karte(Farbe.KREUZ, Wert.DAME),
            new Karte(Farbe.KARO, Wert.SIEBEN)));

    boolean siegerErmittelt =
        testStich
            .ermittleSieger(testSpieler, new Trumpffarbe(Farbe.KARO))
            .equals(testSpieler.getLast());

    Assertions.assertThat(siegerErmittelt).isTrue();
  }
  @Test
  void testErmittleSiegerFallsTrumpfGleicheKarte() {
    List<Spieler> testSpieler =
            Arrays.asList(
                    new Spieler(new Person("TestPerson1")),
                    new Spieler(new Person("TestPerson2")),
                    new Spieler(new Person("TestPerson3")));

    Stich testStich = new Stich(testSpieler.getLast(), Farbe.KREUZ);

    testStich.setGelegteKarten(
            Arrays.asList(
                    new Karte(Farbe.HERZ, Wert.DAME),
                    new Karte(Farbe.HERZ, Wert.ACHT),
                    new Karte(Farbe.HERZ, Wert.DAME)));

    testStich.ermittleSieger(testSpieler, new Trumpffarbe(Farbe.HERZ));

    Assertions.assertThat(testStich.getSiegerKarte()).isNull();
  }
  @Test
  void testErmittleSiegerFallsTrumpfKleinereKarte() {
    List<Spieler> testSpieler =
            Arrays.asList(
                    new Spieler(new Person("TestPerson1")),
                    new Spieler(new Person("TestPerson2")),
                    new Spieler(new Person("TestPerson3")));

    Stich testStich = new Stich(testSpieler.getLast(), Farbe.KREUZ);

    testStich.setGelegteKarten(
            Arrays.asList(
                    new Karte(Farbe.HERZ, Wert.DAME),
                    new Karte(Farbe.HERZ, Wert.ACHT),
                    new Karte(Farbe.HERZ, Wert.SIEBEN)));

    testStich.ermittleSieger(testSpieler, new Trumpffarbe(Farbe.HERZ));

    Assertions.assertThat(testStich.getSiegerKarte().equals(new Karte(Farbe.HERZ, Wert.DAME))).isTrue();
  }

  @Test
  void testErmittleSiegerFallsTrumpfNull() {
    List<Spieler> testSpieler =
        Arrays.asList(
            new Spieler(new Person("TestPerson1")),
            new Spieler(new Person("TestPerson2")),
            new Spieler(new Person("TestPerson3")));

    Stich testStich = new Stich(testSpieler.getLast(), Farbe.HERZ);

    testStich.setGelegteKarten(
        Arrays.asList(
            new Karte(Farbe.KREUZ, Wert.KOENIG),
            new Karte(Farbe.KREUZ, Wert.DAME),
            new Karte(Farbe.KARO, Wert.SIEBEN)));

    Assertions.assertThat(
            testStich.ermittleSiegerFallsTrumpf(testSpieler, new Trumpffarbe(Farbe.PIK)))
        .isNull();
  }

  @Test
  void testErmittleSiegerFallsBubeKreuz() {
    List<Spieler> testSpieler =
        Arrays.asList(
            new Spieler(new Person("TestPerson1")),
            new Spieler(new Person("TestPerson2")),
            new Spieler(new Person("TestPerson3")));

    Stich testStich = new Stich(testSpieler.getLast(), Farbe.HERZ);

    testStich.setGelegteKarten(
        Arrays.asList(
            new Karte(Farbe.PIK, Wert.SIEBEN),
            new Karte(Farbe.KREUZ, Wert.DAME),
            new Karte(Farbe.KREUZ, Wert.BUBE)));

    Assertions.assertThat(testStich.ermittleSiegerFallsBube(testSpieler)).isNotNull();
  }

  @Test
  void testErmittleSiegerFallsBubePik() {
    List<Spieler> testSpieler =
        Arrays.asList(
            new Spieler(new Person("TestPerson1")),
            new Spieler(new Person("TestPerson2")),
            new Spieler(new Person("TestPerson3")));

    Stich testStich = new Stich(testSpieler.getLast(), Farbe.HERZ);

    testStich.setGelegteKarten(
        Arrays.asList(
            new Karte(Farbe.PIK, Wert.SIEBEN),
            new Karte(Farbe.KREUZ, Wert.DAME),
            new Karte(Farbe.PIK, Wert.BUBE)));

    Assertions.assertThat(testStich.ermittleSiegerFallsBube(testSpieler)).isNotNull();
  }

  @Test
  void testErmittleSiegerFallsBubeHerz() {
    List<Spieler> testSpieler =
        Arrays.asList(
            new Spieler(new Person("TestPerson1")),
            new Spieler(new Person("TestPerson2")),
            new Spieler(new Person("TestPerson3")));

    Stich testStich = new Stich(testSpieler.getLast(), Farbe.HERZ);

    testStich.setGelegteKarten(
        Arrays.asList(
            new Karte(Farbe.PIK, Wert.SIEBEN),
            new Karte(Farbe.KREUZ, Wert.DAME),
            new Karte(Farbe.HERZ, Wert.BUBE)));

    Assertions.assertThat(testStich.ermittleSiegerFallsBube(testSpieler)).isNotNull();
  }

  @Test
  void testErmittleSiegerFallsBubeKaro() {
    List<Spieler> testSpieler =
        Arrays.asList(
            new Spieler(new Person("TestPerson1")),
            new Spieler(new Person("TestPerson2")),
            new Spieler(new Person("TestPerson3")));

    Stich testStich = new Stich(testSpieler.getLast(), Farbe.HERZ);

    testStich.setGelegteKarten(
        Arrays.asList(
            new Karte(Farbe.PIK, Wert.SIEBEN),
            new Karte(Farbe.KREUZ, Wert.DAME),
            new Karte(Farbe.KARO, Wert.BUBE)));

    Assertions.assertThat(testStich.ermittleSiegerFallsBube(testSpieler)).isNotNull();
  }
}
