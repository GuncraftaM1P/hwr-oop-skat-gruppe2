package hwr.oop.skat.gruppe2;

import hwr.oop.skat.gruppe2.domain.Farbe;
import hwr.oop.skat.gruppe2.domain.Karte;
import hwr.oop.skat.gruppe2.domain.Wert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class KarteTest {
  @Test
  void testGetFarbe() {
    Karte testKarte = new Karte(Farbe.HERZ, Wert.ASS);
    Assertions.assertThat(testKarte.getFarbe().getWert()).isEqualTo(Farbe.HERZ.getWert());
  }

  @Test
  void testGetWert() {
    Karte testKarte = new Karte(Farbe.HERZ, Wert.ASS);
    Assertions.assertThat(testKarte.getWert().getPunkte()).isEqualTo(Wert.ASS.getPunkte());
  }

  @Test
  void testEqualsSelf() {
    Karte testKarte = new Karte(Farbe.HERZ, Wert.ASS);
    Assertions.assertThat(testKarte.equals(testKarte)).isTrue();
  }

  @Test
  void testEqualsKeineKarte() {
    Karte testKarte = new Karte(Farbe.HERZ, Wert.ASS);
    int testWert = 1;
    Assertions.assertThat(testKarte.equals(testWert)).isFalse();
  }

  @Test
  void testEquals() {
    Karte testErsteKarte = new Karte(Farbe.HERZ, Wert.ASS);
    Karte testZweiteKarte = new Karte(Farbe.HERZ, Wert.ASS);
    Assertions.assertThat(testErsteKarte.equals(testZweiteKarte)).isTrue();
  }

  @Test
  void testEquals_DifferentFarbe() {
    Karte karte1 = new Karte(Farbe.HERZ, Wert.ASS);
    Karte karte2 = new Karte(Farbe.PIK, Wert.ASS);
    Assertions.assertThat(karte1.equals(karte2)).isFalse();
  }

  @Test
  void testEquals_DifferentWert() {
    Karte karte1 = new Karte(Farbe.HERZ, Wert.ASS);
    Karte karte2 = new Karte(Farbe.HERZ, Wert.BUBE);
    Assertions.assertThat(karte1.equals(karte2)).isFalse();
  }

  @Test
  void testHashCode() {
    Karte testKarte = new Karte(Farbe.HERZ, Wert.ASS);

    Assertions.assertThat(testKarte.hashCode()).isNotZero();
  }

  @Test
  void testToString() {
    Karte testKarte = new Karte(Farbe.HERZ, Wert.ASS);

    Assertions.assertThat(testKarte.toString()).hasToString("Karte{farbe=HERZ, wert=ASS}");
  }

  @Test
  void testFarbeWert() {
    Farbe testFarbe = Farbe.KREUZ;
    Assertions.assertThat(testFarbe.getWert()).isEqualTo(4);
  }

  @Test
  void testGetFarbeByWert() {
    int testWert = 1;
    Farbe testFarbe = Farbe.KARO;

    Assertions.assertThat(Farbe.getFarbeByWert(testWert).getWert()).isEqualTo(testFarbe.getWert());
  }

  @Test
  void testGetFarbeByWertNull() {
    int testWert = 5;

    Assertions.assertThat(Farbe.getFarbeByWert(testWert)).isNull();
  }

  @Test
  void testGetFarben() {
    List<Farbe> tempList = Farbe.getFarben();
    List<Farbe> shouldBe = new ArrayList<>();
    shouldBe.add(Farbe.KARO);
    shouldBe.add(Farbe.HERZ);
    shouldBe.add(Farbe.PIK);
    shouldBe.add(Farbe.KREUZ);
    Assertions.assertThat(tempList).isEqualTo(shouldBe);
  }

  @Test
  void testWert() {
    Wert testWert = Wert.ASS;
    Assertions.assertThat(testWert.getPunkte()).isEqualTo(11);
  }

  @Test
  void testStaerke() {
    Wert testWert = Wert.ASS;
    Assertions.assertThat(testWert.getStaerke()).isEqualTo(13);
  }

  @Test
  void testGetZahlen() {
    List<Wert> tempList = Wert.getZahlen();
    List<Wert> shouldBe = new ArrayList<>();
    shouldBe.add(Wert.SIEBEN);
    shouldBe.add(Wert.ACHT);
    shouldBe.add(Wert.NEUN);
    shouldBe.add(Wert.ZEHN);
    shouldBe.add(Wert.BUBE);
    shouldBe.add(Wert.DAME);
    shouldBe.add(Wert.KOENIG);
    shouldBe.add(Wert.ASS);
    Assertions.assertThat(tempList).isEqualTo(shouldBe);
  }

  @Test
  void getTestByStaerkeNull() {
    int testWert = 0;
    Assertions.assertThat(Wert.getWertByStaerke(testWert)).isNull();
  }
}
