package hwr.oop;

import java.util.Arrays;
import java.util.List;

public enum Farbe {
  KARO(1),
  HERZ(2),
  PIK(3),
  KREUZ(4);

  private final int wert;

  private Farbe(int neuerWert) {
    this.wert = neuerWert;
  }

  public static Farbe getFarbeByWert(int vergleichWert){
    for(Farbe farbe : Farbe.values()){if(farbe.getWert()==vergleichWert){return farbe;}}
    return null;
  }

  public int getWert() {
    return wert;
  }

  public static List<Farbe> getFarben() {
    return Arrays.asList(Farbe.values());
  }
}
