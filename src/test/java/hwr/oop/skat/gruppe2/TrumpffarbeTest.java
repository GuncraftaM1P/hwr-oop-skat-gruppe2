package hwr.oop.skat.gruppe2;

import hwr.oop.skat.gruppe2.domain.Farbe;
import hwr.oop.skat.gruppe2.domain.Trumpffarbe;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TrumpffarbeTest {

    @Test
    void testConstructor() {
        Trumpffarbe trumpffarbe = new Trumpffarbe(Farbe.HERZ);

        Assertions.assertThat(trumpffarbe.getTrumpffarbe()).isEqualTo(Farbe.HERZ);
    }
}