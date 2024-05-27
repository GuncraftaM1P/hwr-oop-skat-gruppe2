package hwr.oop.skat.gruppe2;

import hwr.oop.skat.gruppe2.domain.KartenListe;
import hwr.oop.skat.gruppe2.persistence.LadenUndSpeichern;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LadenUndSpeichernTest {

    @Test
    public void LandUndSpeichernTestVonKartenListen() {
        String test = "2-7,3-12,1-8";
        LadenUndSpeichern ladenUndSpeichern = new LadenUndSpeichern();
        KartenListe kartes = ladenUndSpeichern.kartenListeVonString(test);
        Assertions.assertThat(test).isEqualTo(ladenUndSpeichern.kartenListeZuString(kartes));
    }

    @Test
    public void LandUndSpeichernTestVonNeuenSpielerSpeicher() {
        String test = "2-7,3-12,1-8";
        LadenUndSpeichern ladenUndSpeichern = new LadenUndSpeichern();
        KartenListe kartes = ladenUndSpeichern.kartenListeVonString(test);
        Assertions.assertThat(test).isEqualTo(ladenUndSpeichern.kartenListeZuString(kartes));
    }

}
