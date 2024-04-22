package hwr.oop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class KartenStapelTest {

    @Test
    void testNeuerKartenStapel() {
        KartenStapel kartenStapel = new KartenStapel();
        List<Karte> Karten = kartenStapel.neuerKartenStapel();
        assertThat(Karten.size()).isEqualTo(Farbe.getFarben().size() * Wert.getZahlen().size());
    }

}
