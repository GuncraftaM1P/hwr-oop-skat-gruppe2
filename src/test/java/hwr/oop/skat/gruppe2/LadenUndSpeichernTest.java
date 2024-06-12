package hwr.oop.skat.gruppe2;

import hwr.oop.skat.gruppe2.domain.Karte;
import hwr.oop.skat.gruppe2.persistence.LadenUndSpeichern;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

class LadenUndSpeichernTest {

    @Test
    void LandUndSpeichernTestVonKartenListen() {
        String test = "2-7,3-12,1-8";
        LadenUndSpeichern ladenUndSpeichern = new LadenUndSpeichern();
        List<Karte> karten = ladenUndSpeichern.kartenStringZuListe(test);
        Assertions.assertThat(test).isEqualTo(ladenUndSpeichern.kartenListeZuString(karten));
    }

    @Test
    void LandUndSpeichernTestVonNeuenSpielerSpeicher() {
        String test = "2-7,3-12,1-8";
        LadenUndSpeichern ladenUndSpeichern = new LadenUndSpeichern();
        List<Karte> karten = ladenUndSpeichern.kartenStringZuListe(test);
        Assertions.assertThat(test).isEqualTo(ladenUndSpeichern.kartenListeZuString(karten));
    }

}
