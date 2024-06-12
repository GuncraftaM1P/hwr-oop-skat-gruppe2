package hwr.oop.skat.gruppe2.domain;

import java.util.Arrays;
import java.util.List;

public enum Wert {
  SIEBEN(0, 7),
  ACHT(0, 8),
  NEUN(0, 9),
  ZEHN(10, 12),
  BUBE(2, 28),
  DAME(3, 10),
  KOENIG(4, 11),
  ASS(11, 13);

  private int punkte;
  private int staerke;

  private Wert(int punkte, int staerke) {
    this.punkte = punkte;
    this.staerke = staerke;
  }

  public static Wert getWertByStaerke(int vergleichStearke) {
    for (Wert wert : Wert.values()) {
      if (wert.getStaerke() == vergleichStearke) return wert;
    }
    return null;
  }

  public int getPunkte() {
    return punkte;
  }

  public int getStaerke() {
    return staerke;
  }

  public static List<Wert> getZahlen() {
    return Arrays.asList(Wert.values());
  }
}
