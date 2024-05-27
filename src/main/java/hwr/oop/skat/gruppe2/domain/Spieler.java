package hwr.oop.skat.gruppe2.domain;

import java.util.UUID;

public class Spieler {
    private UUID uuid;
    private String name; //Muss unic sein zur identification
    private int gewonneneRunden;
    private int verlohrendeSpiele;

    public Spieler(String name) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.gewonneneRunden = 0;
        this.verlohrendeSpiele = 0;
    }

    public Spieler(UUID uuid, String name,int gewonneneRunden, int verlohrendeSpiele) {
        this.uuid = uuid;
        this.name = name;
        this.gewonneneRunden = gewonneneRunden;
        this.verlohrendeSpiele = verlohrendeSpiele;
    }

    public UUID getUuid() {return uuid;}

    public String getName() {
        return name;
    }

    public int getGewonneneRunden() {
        return gewonneneRunden;
    }

    public int getGespielteRunden() {
        return gewonneneRunden;
    }
}
