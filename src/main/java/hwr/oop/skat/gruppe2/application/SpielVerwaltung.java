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
      this.stich = new Stich(this.spieler.getFirst());
    }
    return erfolgreich;
  }

  public UUID erstelleSpieler(String name) {
    Person person = new Person(name);
    if (ls.speicherPerson(person)) {
      return person.getUuid();
    }
    return null;
  }

  public boolean karteLegen(UUID spieler, Karte karte) {
    if (spieler == stich.getSpielerAnDerReihe().getUUID() &&
      stich.getSpielerAnDerReihe().kannLegen(karte, stich.getErsteFarbe())) {
      int i = 0;
      for (Spieler s : this.spieler) {
        if (s.getUUID().equals(spieler)) {
          i = this.spieler.indexOf(s);
        }
      }
      Spieler naechster = this.spieler.get((i+1)%3);
      stich.getSpielerAnDerReihe().entferneVonHand(karte);
      stich.legeKarte(karte, naechster);

    }
    // Sieger überprüfen
    // ->Spiel weitergeben an nächsten Spieler oder neuen Stich erstellen und Spiel an Sieger geben
    return true;
  }

  public UUID getUUID() {
    return this.uuid;
  }
}
