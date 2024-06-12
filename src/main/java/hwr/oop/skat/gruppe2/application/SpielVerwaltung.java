package hwr.oop.skat.gruppe2.application;

import hwr.oop.skat.gruppe2.domain.*;
import hwr.oop.skat.gruppe2.persistence.LadenUndSpeichern;

import java.util.List;
import java.util.UUID;

public class SpielVerwaltung {
  private UUID uuid;
  private Stich stich;
  private Spielfeld stapel;
  private final LadenUndSpeichern ls = new LadenUndSpeichern();

  public SpielVerwaltung(List<String> spielerStrings) {
    List<Spieler> spieler =
        List.of(
            this.getSpielerFromUUIDString(spielerStrings.get(0)),
            this.getSpielerFromUUIDString(spielerStrings.get(1)),
            this.getSpielerFromUUIDString(spielerStrings.get(2)));
    neuesSpiel(spieler);
    this.uuid = UUID.randomUUID();
  }

  /*public SpielVerwaltung(UUID spiel) {
    this.uuid = spiel;
  }*/

  private Spieler getSpielerFromUUIDString(String uuid) {
    Person pers = ls.getPersonVonUUID(UUID.fromString(uuid));
    return new Spieler(pers);
  }

  public void neuesSpiel(List<Spieler> spieler) {
    this.stapel = new Spielfeld();
    stapel.kartenVerteilen(spieler);

    // vorübergehend wird der erste Spieler immer der Einzelspieler
    spieler.getFirst().kartenAufDieHand(this.stapel.getDeck());
    // todo variable setzen, dass der skat noch abgelegt werden muss
  }

  public void waehleSkat() {
    // todo Skat karten ablegen
    starteSpielrunde();
  }

  private void starteSpielrunde() {
    /*
      TODO: Neues Stich Objekt erstellen
            Falls Stich voll -> Sieger ermitteln
              neuen Stich erstellen
    */
  }

  public void karteLegen(UUID spieler, Karte karte) {
    if (spieler == stich.getSpielerAnDerReihe().getUUID()) {
      /*
        TODO: Alle Spieler per Liste als Parameter übergeben (Die Funktion ermittelt dadurch den
              nächsten Spieler ab der Reihe)
      */
      stich.getSpielerAnDerReihe().karteSetzen(karte, stich, List.of());
    }
    // Sieger überprüfen
    // ->Spiel weitergeben an nächsten Spieler oder neuen Stich erstellen und Spiel an Sieger geben
  }

  public UUID getUUID() {
    return this.uuid;
  }

  /*
  private void neuerSpieler(String[] args){
    Spieler spieler = new Spieler(args[1]);
    LadenUndSpeichern ladenUndSpeichern = new LadenUndSpeichern();
    ladenUndSpeichern.spielerNeuErstellen(spieler);
    Systemout.println("Der neue Spieler "+spieler.getName()+" wurde gespeichert. Und hat die UUID:"+spieler.getUuid());

  }
  */
}

// TODO: Spieler braucht Referenz auf aktuellen Stich
