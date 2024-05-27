package hwr.oop.skat.gruppe2;

import hwr.oop.skat.gruppe2.domain.Farbe;
import hwr.oop.skat.gruppe2.domain.Karte;
import hwr.oop.skat.gruppe2.domain.Wert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class KarteTest {
    @Test
    void testKarteWert(){
        Karte testKarte = new Karte(Farbe.HERZ, Wert.ASS);
        Assertions.assertThat(testKarte.getFarbe().getWert()).isEqualTo(Farbe.HERZ.getWert());
    }

    @Test
    void testKartePunkte(){
    Karte testKarte = new Karte(Farbe.HERZ, Wert.ASS);
    Assertions.assertThat(testKarte.getWert().getPunkte()).isEqualTo(Wert.ASS.getPunkte());
    }

    @Test
    void testKarteStaerke(){
        Karte testKarte = new Karte(Farbe.HERZ, Wert.ASS);
        Assertions.assertThat(testKarte.getWert().getStaerke()).isEqualTo(Wert.ASS.getStaerke());
    }
}

