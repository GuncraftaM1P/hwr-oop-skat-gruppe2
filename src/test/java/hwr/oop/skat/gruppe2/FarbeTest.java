package hwr.oop.skat.gruppe2;

import hwr.oop.skat.gruppe2.domain.Farbe;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class FarbeTest {
    @Test
    void testWert(){
        Farbe testFarbe = Farbe.KREUZ;
        Assertions.assertThat(testFarbe.getWert()).isEqualTo(4);
    }

    @Test
    void TestGetFarbeByWert(){
        int testWert = 5;

        Assertions.assertThat(Farbe.getFarbeByWert(testWert)).isNull();
    }

    @Test
    void testGetFarben(){
        List<Farbe> tempList = Farbe.getFarben();
        List<Farbe> shouldBe = new ArrayList<>();
        shouldBe.add(Farbe.KARO);
        shouldBe.add(Farbe.HERZ);
        shouldBe.add(Farbe.PIK);
        shouldBe.add(Farbe.KREUZ);
        Assertions.assertThat(tempList).isEqualTo(shouldBe);
    }
}
