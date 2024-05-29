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
  public List<Karte> kartenListeVonString(String kartenListenString) {
    return Arrays.stream(kartenListenString.split(",")).map(this::stringZuKarte).toList();
  }

  private Karte stringZuKarte(String stringZuKarte) {
    String[] temp = stringZuKarte.split("-");
    return new Karte(
        Farbe.getFarbeByWert(Integer.parseInt(temp[0])),
        Wert.getWertByStaerke(Integer.parseInt(temp[1])));
  }

  public String kartenListeZuString(List<Karte> kartenListe) {
    return kartenListe.stream().map(this::kartezuString).reduce((a, b) -> a + "," + b).orElse("");
  }

  private String kartezuString(Karte karte) {
    return karte.getFarbe().getWert() + "-" + karte.getWert().getStaerke();
  }

  // Neuer Spieler in DatenBank Speichern
  public UUID spielerNeuErstellen(Spieler spieler) {
    SQLVerbinder.getSingletonSchnitstelle()
        .NeuenSpielerInDatenbank(spieler.getName(), spieler.getUuid());
    return spieler.getUuid();
  }

  public Spieler getSpielerVonUUID(UUID uuid) {
    return SQLVerbinder.getSingletonSchnitstelle().getSpielerByUUIDSpieler(uuid.toString());
  }
}
