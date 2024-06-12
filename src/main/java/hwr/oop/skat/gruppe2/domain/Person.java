package hwr.oop.skat.gruppe2.domain;

import java.util.UUID;

public class Person {
  private final UUID uuid;
  private final String name;
  private final int gewonneneRunden;
  private final int gespielteRunden;

  public Person(String name) {
    this.uuid = UUID.randomUUID();
    this.name = name;
    this.gewonneneRunden = 0;
    this.gespielteRunden = 0;
  }

  public Person(UUID uuid, String name, int gewonneneRunden, int gespielteRunden) {
    this.uuid = uuid;
    this.name = name;
    this.gewonneneRunden = gewonneneRunden;
    this.gespielteRunden = gespielteRunden;
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
    return gespielteRunden;
  }

  public int getVerloreneRunden() {
    return this.gespielteRunden - this.gewonneneRunden;
  }
}
