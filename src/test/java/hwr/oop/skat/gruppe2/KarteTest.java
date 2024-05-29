package hwr.oop.skat.gruppe2;

import hwr.oop.skat.gruppe2.domain.Farbe;
import hwr.oop.skat.gruppe2.domain.Karte;
import hwr.oop.skat.gruppe2.domain.Wert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

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
    Karte testKarteEins = new Karte(Farbe.HERZ, Wert.ASS);
    Karte testKarteZwei = new Karte(Farbe.HERZ, Wert.ASS);

    Assertions.assertThat(testKarteEins.hashCode()).isEqualTo(testKarteZwei.hashCode());
  }

  @Test
  void testToString() {
    Karte testKarte = new Karte(Farbe.HERZ, Wert.ASS);

    Assertions.assertThat(testKarte.toString()).isEqualTo("Karte{farbe=HERZ, wert=ASS}");
  }
}
