package hwr.oop.skat.gruppe2;

import hwr.oop.skat.gruppe2.domain.Farbe;
import hwr.oop.skat.gruppe2.domain.Karte;
import hwr.oop.skat.gruppe2.domain.Wert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class KarteTest {
    @Test
    void testGetFarbe(){
        Karte testKarte = new Karte(Farbe.HERZ, Wert.ASS);
        Assertions.assertThat(testKarte.getFarbe().getWert()).isEqualTo(Farbe.HERZ.getWert());
    }

    @Test
    void testGetWert(){
        Karte testKarte = new Karte(Farbe.HERZ, Wert.ASS);
        Assertions.assertThat(testKarte.getWert().getPunkte()).isEqualTo(Wert.ASS.getPunkte());
    }

    @Test
    void testEqualsSelf(){
        Karte testKarte = new Karte(Farbe.HERZ, Wert.ASS);
        Assertions.assertThat(testKarte.equals(testKarte)).isTrue();
    }

    @Test
    void testEqualsKeineKarte(){
        Karte testKarte = new Karte(Farbe.HERZ, Wert.ASS);
        int testWert = 1;
        Assertions.assertThat(testKarte.equals(1)).isFalse();
    }

    @Test
    void testEquals(){
        Karte testErsteKarte = new Karte(Farbe.HERZ, Wert.ASS);
        Karte testZweiteKarte = new Karte(Farbe.HERZ, Wert.ASS);
        Assertions.assertThat(testErsteKarte.equals(testZweiteKarte)).isTrue();
    }
}


