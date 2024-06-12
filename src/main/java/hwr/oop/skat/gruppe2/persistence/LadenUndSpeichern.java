package hwr.oop.skat.gruppe2.persistence;

import hwr.oop.skat.gruppe2.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class LadenUndSpeichern {
  private final SqlVerbinder sqlVerbinder;

  public LadenUndSpeichern() {
    this.sqlVerbinder = new SqlVerbinder();
  }

  public List<Karte> kartenStringZuListe(String kartenListenString) {
    return Arrays.stream(kartenListenString.split(",")).map(Karte::new).toList();
  }

  public Person getPersonVonUUID(UUID uuid) {
    return this.sqlVerbinder.getPersonByUUIDPerson(uuid.toString());
  }

  public Spielfeld ladeSpielfeldVonSpiel(UUID spiel) {
    return this.sqlVerbinder.ladeSpielfeld(spiel);
  }

  public List<Spieler> ladeSpielerVonSpiel(UUID spiel) {
    List<Spieler> spielerListe = this.sqlVerbinder.ladeSpieler(spiel);
    if (spielerListe.size() == 3)
      return spielerListe;
    return null;
  }

  public Stich ladeStichVonSpiel(UUID spiel) {
    return this.sqlVerbinder.ladeStich(spiel);
  }

  public boolean speicherPerson(Person person) {
    return this.sqlVerbinder.speicherPerson(person);
  }

  public boolean speicherSpiel(List<Spieler> spieler, Stich stich, Spielfeld stapel, UUID spiel) {
    return sqlVerbinder.speicherSpiel(spieler, stich, stapel, spiel);
  }
}
