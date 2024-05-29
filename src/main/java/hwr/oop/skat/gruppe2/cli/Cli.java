package hwr.oop.skat.gruppe2.cli;

import hwr.oop.skat.gruppe2.persistence.LadenUndSpeichern;
import hwr.oop.skat.gruppe2.domain.Spieler;

import java.io.PrintStream;

public class Cli {
  private final PrintStream systemOut;

  public Cli(PrintStream systemOut, String[] args) {
    this.systemOut = systemOut;
    argumentAuswerten(args);
  }

  private void argumentAuswerten(String[] args) {
    if (args.length >= 2 && args[0].equals("ErstelleNeuenSpieler")) {
      neuerSpieler(args);
    }
  }

  private void neuerSpieler(String[] args) {
    Spieler spieler = new Spieler(args[1]);
    LadenUndSpeichern ladenUndSpeichern = new LadenUndSpeichern();
    ladenUndSpeichern.spielerNeuErstellen(spieler);
    systemOut.println(
        "Der neue Spieler "
            + spieler.getName()
            + " wurde gespeichert. Und hat die UUID:"
            + spieler.getUuid());
  }
}
