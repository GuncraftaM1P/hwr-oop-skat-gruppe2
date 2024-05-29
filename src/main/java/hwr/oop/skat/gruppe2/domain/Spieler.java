package hwr.oop.skat.gruppe2.domain;

import java.util.UUID;

public class Spieler {
  private final UUID uuid;
  private final String name; // Muss unique sein zur identification
  private final int gewonneneRunden;
  private final int verloreneSpiele;

  public Spieler(String name) {
    this.uuid = UUID.randomUUID();
    this.name = name;
    this.gewonneneRunden = 0;
    this.verloreneSpiele = 0;
  }

  public Spieler(UUID uuid, String name, int gewonneneRunden, int verloreneSpiele) {
    this.uuid = uuid;
    this.name = name;
    this.gewonneneRunden = gewonneneRunden;
    this.verloreneSpiele = verloreneSpiele;
  }

  public UUID getUuid() {
    return uuid;
  }

  public String getName() {
    return name;
  }

  public int getGewonneneRunden() {
    return gewonneneRunden;
  }

  public int getGespielteRunden() {
    return gewonneneRunden + verloreneSpiele;
  }
}
