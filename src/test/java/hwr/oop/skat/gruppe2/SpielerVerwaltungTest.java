package hwr.oop.skat.gruppe2;

import hwr.oop.skat.gruppe2.application.PersonenVerwaltung;
import org.junit.jupiter.api.Test;

class SpielerVerwaltungTest {

    @Test
    void testErstelleneneueperson(){
        PersonenVerwaltung person = new PersonenVerwaltung();
        person.main(new String[]{"ErstelleNeuePerson","Gustaff"});
        //TODO Log abgreifen und überprüfen
    }

}
