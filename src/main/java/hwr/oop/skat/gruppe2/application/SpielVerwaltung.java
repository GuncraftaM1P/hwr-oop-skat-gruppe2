package hwr.oop.skat.gruppe2.application;

import hwr.oop.skat.gruppe2.domain.Spielfeld;
import hwr.oop.skat.gruppe2.domain.Spieler;

import java.util.List;

public class SpielVerwaltung {

  public SpielVerwaltung(List<Spieler> spielers) {
    Spielfeld stapel = new Spielfeld();
    stapel.kartenVerteilen(spielers);

    starteSpielrunde();
  }

  private void starteSpielrunde() {}

  /*
  private void neuerSpieler(String[] args){
    Spieler spieler = new Spieler(args[1]);
    LadenUndSpeichern ladenUndSpeichern = new LadenUndSpeichern();
    ladenUndSpeichern.spielerNeuErstellen(spieler);
    Systemout.println("Der neue Spieler "+spieler.getName()+" wurde gespeichert. Und hat die UUID:"+spieler.getUuid());

  }
  */
}

//TODO: Spieler braucht Referenz auf aktuellen Stich
