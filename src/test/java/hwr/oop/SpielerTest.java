package hwr.oop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SpielerTest {

    @Test
    public void testSpieler(){
        Spieler testSpieler = new Spieler("Spieler");
        Assertions.assertThat(testSpieler.getName()).isEqualTo("Spieler");
        Assertions.assertThat(testSpieler.getGewonneneRunden()).isEqualTo(0);
        Assertions.assertThat(testSpieler.getGespielteRunden()).isEqualTo(0);

    }
}
