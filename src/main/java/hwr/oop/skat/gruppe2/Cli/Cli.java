package hwr.oop.skat.gruppe2.Cli;

import hwr.oop.skat.gruppe2.application.SpielVerwaltung;
import hwr.oop.skat.gruppe2.domain.SpielendeSpieler;
import hwr.oop.skat.gruppe2.persistence.LadenUndSpeichern;
import hwr.oop.skat.gruppe2.domain.Spieler;

import java.io.PrintStream;
import java.util.UUID;


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
        else if(args.length>=4&& args[0].equals("ErstelleSpiel")){
            neuesSpiel(args);
        }
    }

    private void neuerSpieler(String[] args){

        Spieler spieler = new Spieler(args[1]);
        LadenUndSpeichern ladenUndSpeichern = new LadenUndSpeichern();
        ladenUndSpeichern.spielerNeuErstellen(spieler);
        Systemout.println("Der neue Spieler "+spieler.getName()+" wurde gespeichert. Und hat die UUID:"+spieler.getUuid());

    }

  private void neuesSpiel(String[] args) {
        try{
            LadenUndSpeichern ladenUndSpeichern = new LadenUndSpeichern();
            SpielVerwaltung spielVerwaltung = new SpielVerwaltung(new SpielendeSpieler(ladenUndSpeichern.getSpielerVonUUID(UUID.fromString(args[1]))),new SpielendeSpieler(ladenUndSpeichern.getSpielerVonUUID(UUID.fromString(args[2]))),new SpielendeSpieler(ladenUndSpeichern.getSpielerVonUUID(UUID.fromString(args[3]))));
        }catch (Exception e){
            Systemout.println("Fehler beim aufgetreten der Spieler");
        }

  }
}
