package hwr.oop.skat.gruppe2.cli;

import hwr.oop.skat.gruppe2.persistence.LadenUndSpeichern;
import hwr.oop.skat.gruppe2.domain.Person;

import java.io.PrintStream;



public class Cli {

    private final PrintStream Systemout;
    public Cli(PrintStream SystemOut,String[] args) {
        this.Systemout = SystemOut;
        ArgumentAuswerten(args);
    }

    private void ArgumentAuswerten(String[] args) {
        if(args.length>=2&& args[0].equals("ErstelleNeuenSpieler")){
            neuerSpieler(args);
        }
    }

    private void neuerSpieler(String[] args){

        Person person = new Person(args[1]);
        LadenUndSpeichern ladenUndSpeichern = new LadenUndSpeichern();
        ladenUndSpeichern.personNeuErstellen(person);
        Systemout.println("Der neue Spieler "+person.getName()+" wurde gespeichert. Und hat die UUID:"+person.getUuid());

    }
}
