package hwr.oop.skat.gruppe2;

import hwr.oop.skat.gruppe2.domain.Spieler;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SpielerTest {

    @Test
    public void testSpielerName() {
        Spieler testSpieler = new Spieler("Spieler");
        Assertions.assertThat(testSpieler.getName()).isEqualTo("Spieler");
    }

    @Test
    public void testSpielerGespielt() {
        Spieler testSpieler = new Spieler("Spieler");
        Assertions.assertThat(testSpieler.getGespielteRunden()).isEqualTo(0);
    }

    @Test
    public void testSpielerGewonnen() {
        Spieler testSpieler = new Spieler("Spieler");
        Assertions.assertThat(testSpieler.getGewonneneRunden()).isEqualTo(0);
    }
}
