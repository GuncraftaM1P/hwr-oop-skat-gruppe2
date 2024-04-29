package hwr.oop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SpielerVerwaltungTest {

    @Test
    public void testErstelleneneuenspieler(){
        SpielerVerwaltung spieler = new SpielerVerwaltung();
        spieler.main(new String[]{"ErstelleNeuenSpieler","Gustaff"});
        //TODO Log abgreifen und überprüfen
    }

}
