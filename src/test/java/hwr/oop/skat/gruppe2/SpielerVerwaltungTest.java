package hwr.oop.skat.gruppe2;

import hwr.oop.skat.gruppe2.application.SpielerVerwaltung;
import org.junit.jupiter.api.Test;

public class SpielerVerwaltungTest {

    @Test
    public void testErstelleneneuenspieler(){
        SpielerVerwaltung spieler = new SpielerVerwaltung();
        spieler.main(new String[]{"ErstelleNeuenSpieler","Gustaff"});
        //TODO Log abgreifen und überprüfen
    }

}
