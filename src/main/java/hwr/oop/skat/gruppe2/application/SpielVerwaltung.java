package hwr.oop.skat.gruppe2.application;

import hwr.oop.skat.gruppe2.domain.*;
import hwr.oop.skat.gruppe2.persistence.LadenUndSpeichern;

import java.util.List;
import java.util.UUID;

public class SpielVerwaltung {
  private UUID uuid;
  private Stich stich;
  private Spielfeld stapel;
  private List<Spieler> spieler;
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

  public SpielVerwaltung(UUID spiel) {
    this.uuid = spiel;
    this.ladeVonPersistenz();
  }

  public SpielVerwaltung(String uuid) {
    this.uuid = UUID.fromString(uuid);
    this.ladeVonPersistenz();
  }

  public SpielVerwaltung() {
  }

  private void ladeVonPersistenz() {
    this.spieler = ls.ladeSpielerVonSpiel(this.uuid);
    this.stapel = ls.ladeSpielfeldVonSpiel(this.uuid);
    this.stich = ls.ladeStichVonSpiel(this.uuid);
  }

  private Spieler getSpielerFromUUIDString(String uuid) {
    Person person = ls.getPersonVonUUID(UUID.fromString(uuid));
    return new Spieler(person);
  }

  public boolean neuesSpiel(List<Spieler> spieler) {
    this.stapel = new Spielfeld();
    stapel.kartenVerteilen(spieler);

    // vorübergehend wird der erste Spieler immer der Einzelspieler
    spieler.getFirst().kartenAufDieHand(this.stapel.getDeck());
    return true;
  }

  public boolean waehleSkat(String spielerUUIDString, List<Karte> skat, Farbe trumpf) {
    UUID spielerUUID = UUID.fromString(spielerUUIDString);
    Boolean erfolgreich = false;
    for (Spieler s : this.spieler) {
      if (s.getUUID().equals(spielerUUID)) {
        erfolgreich = s.skatAblegen(skat);
      }
    }

    if (erfolgreich) {
      starteSpielrunde();
    }
    return erfolgreich;
    //todo trumpf verarbeiten
  }

  public UUID erstelleSpieler(String name) {
    Person person = new Person(name);
    if(ls.speicherPerson(person)){
      return person.getUuid();
    }
    return null;
  }

  private boolean starteSpielrunde() {
    /*
      TODO: Neues Stich Objekt erstellen
            Falls Stich voll -> Sieger ermitteln
              neuen Stich erstellen
    */
    return true;
  }

  /*public boolean karteLegen(UUID spieler, Karte karte) {
    if (spieler == stich.getSpielerAnDerReihe().getUUID()) {
      /*
        TODO: Alle Spieler per Liste als Parameter übergeben (Die Funktion ermittelt dadurch den
              nächsten Spieler ab der Reihe)
      */
      stich.getSpielerAnDerReihe().karteSetzen(karte, stich, List.of());
    }
    // Sieger überprüfen
    // ->Spiel weitergeben an nächsten Spieler oder neuen Stich erstellen und Spiel an Sieger geben
  }*/

  public UUID getUUID() {
    return this.uuid;
  }
}
