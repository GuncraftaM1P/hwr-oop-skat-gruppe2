package hwr.oop.skat.gruppe2.application;

import hwr.oop.skat.gruppe2.domain.Spielfeld;
import hwr.oop.skat.gruppe2.domain.SpielendeSpieler;

import java.util.List;

public class SpielVerwaltung {

  public SpielVerwaltung(List<SpielendeSpieler> spielers) {
    Spielfeld stapel = new Spielfeld();
    stapel.kartenVerteilen(spielers);

    starteSpielrunde();
  }

  private void starteSpielrunde() {}
}
