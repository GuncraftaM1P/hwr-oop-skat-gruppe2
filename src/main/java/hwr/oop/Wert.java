package hwr.oop;

import java.util.Arrays;
import java.util.List;

public enum Wert {
  SIEBEN(0,7),
  ACHT(0,8),
  NEUN(0,9),
  ZEHN(10,12),
  BUBE(2,14),
  DAME(3,10),
  KOENIG(4,11),
  ASS(11,13);

  private int punkte;
  private int staerke;

  private Wert(int punkte, int staerke) {
    this.punkte = punkte;
    this.staerke = staerke;
  }

  public int getPunkte() {
    return punkte;
  }

  public int getStaerke() {return staerke;}

  public static List<hwr.oop.Wert> getZahlen() {
    return Arrays.asList(hwr.oop.Wert.values());
  }
}