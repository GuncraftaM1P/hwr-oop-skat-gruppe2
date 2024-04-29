package hwr.oop;

import java.util.UUID;

public class Spieler {
    private UUID uuid;
    private String name; //Muss unic sein zur identification
    private int gewonneneRunden;
    private int gespieleteRunden;

    public Spieler(String name) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.gewonneneRunden = 0;
        this.gespieleteRunden = 0;
    }

    public Spieler(UUID uuid, String name,int gewonneneRunden, int gespieleteRunden) {
        this.uuid = uuid;
        this.name = name;
        this.gewonneneRunden = gewonneneRunden;
        this.gespieleteRunden = gespieleteRunden;
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
