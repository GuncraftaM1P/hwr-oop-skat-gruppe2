package hwr.oop.skat.gruppe2.persistence;

import hwr.oop.skat.gruppe2.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class LadenUndSpeichern {
  // Karten list transformation
  // Formate des Strings: wert der Farbe (1 digit) + "-" + Staerke des Wertes (1-2 digits)
  // die Karten sind durch "," von einander getrennt
  // z.B. "2-7,3-12,1-8" -> Herz sieben, Pik Zehn, Karo Acht
  private SqlVerbinder sqlVerbinder;

  public LadenUndSpeichern() {
    this.sqlVerbinder = new SqlVerbinder();
  }

  public List<Karte> kartenListeVonString(String kartenListenString) {
    return Arrays.stream(kartenListenString.split(",")).map(Karte::new).toList();
  }

  public String kartenListeZuString(List<Karte> kartenListe) {
    return kartenListe.stream().map(this::kartezuString).reduce((a, b) -> a + "," + b).orElse("");
  }

  private String kartezuString(Karte karte) {
    return karte.getFarbe().getWert() + "-" + karte.getWert().getStaerke();
  }

  // Neuer Spieler in DatenBank Speichern
  public UUID personNeuErstellen(Person person) {
    this.sqlVerbinder.neuePersonInDatenbank(person.getName(), person.getUuid());
    return person.getUuid();
  }

  public Person getPersonVonUUID(UUID uuid) {
    return this.sqlVerbinder.getPersonByUUIDPerson(uuid.toString());
  }

  public Spielfeld ladeSpeilfeld(UUID spiel) {
    return this.sqlVerbinder.ladeSpielfeld(spiel);
  }
}
