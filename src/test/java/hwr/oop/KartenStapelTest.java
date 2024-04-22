package hwr.oop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class KartenStapelTest {

    @Test
    public void testKartenStapelInitialisierung() {
        KartenStapel kartenStapel = new KartenStapel();
        List<Karte> Karten = kartenStapel.neuerKartenStapel();
        Assertions.assertThat(Karten.size()).isEqualTo(Farbe.getFarben().size()*Wert.getZahlen().size());
    }

}
