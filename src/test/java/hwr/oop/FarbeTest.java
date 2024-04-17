package hwr.oop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class FarbeTest {
    @Test
    void testWert(){
        Farbe testFarbe = Farbe.KREUZ;
        Assertions.assertThat(testFarbe.getWert()).isEqualTo(1);
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
