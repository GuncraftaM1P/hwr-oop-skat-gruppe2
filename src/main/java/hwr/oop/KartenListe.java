package hwr.oop;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class KartenListe {
    private List<Karte> karten = new ArrayList<>();

    public KartenListe() {}
    public KartenListe(List<Karte> Karte) {
        this.karten = Karte;

    }
    //TODO ist atomic klassen  erlaubt ?
    public boolean istKarteEnthalten(Karte vergleichkarte) {
        AtomicBoolean istKarteEnthalten = new AtomicBoolean(false);
        karten.forEach(karte -> {if(karte.getFarbe()==vergleichkarte.getFarbe()&&karte.getWert()==vergleichkarte.getWert()){
            istKarteEnthalten.set(true);}});
        return istKarteEnthalten.get();
    }

    public boolean istFarbeEnthalten(Farbe farbe) {
        AtomicBoolean istKarteEnthalten = new AtomicBoolean(false);
        karten.forEach(karte -> {if(karte.getFarbe()==farbe){
            istKarteEnthalten.set(true);}});
        return istKarteEnthalten.get();
    }

    public List<Karte> getKartenListe() {
        return karten;
    }

    public boolean istEmpte(){
        return karten.isEmpty();
    }

    public void addKarte(Karte karte) {
        karten.add(karte);
    }

    public boolean removeKarte(Karte karte) {
        return karten.remove(karte);
    }

}
