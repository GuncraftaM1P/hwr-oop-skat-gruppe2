package hwr.oop.skat.gruppe2;

import hwr.oop.skat.gruppe2.domain.Wert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class WertTest {
    @Test
    void testWert(){
        Wert testWert = Wert.ASS;
        Assertions.assertThat(testWert.getPunkte()).isEqualTo(11);
    }

    @Test
    void testStaerke(){
        Wert testWert = Wert.ASS;
        Assertions.assertThat(testWert.getStaerke()).isEqualTo(13);
    }

    @Test
    void testGetZahlen(){
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
}