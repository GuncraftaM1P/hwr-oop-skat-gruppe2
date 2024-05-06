package hwr.oop;


import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class KartenListe {
    private List<Karte> Karte;
    public KartenListe() {}
    public KartenListe(List<Karte> Karte) {
        this.Karte = Karte;
    }
    //TODO ist atomic klassen  erlaubt ?
    public boolean istKarteEnthalten(Karte vergleichkarte) {
        AtomicBoolean istKarteEnthalten = new AtomicBoolean(false);
        Karte.forEach(karte -> {if(karte.getFarbe()==vergleichkarte.getFarbe()&&karte.getWert()==vergleichkarte.getWert()){
            istKarteEnthalten.set(true);}});
        return istKarteEnthalten.get();
    }

    public boolean istFarbeEnthalten(Farbe farbe) {
        AtomicBoolean istKarteEnthalten = new AtomicBoolean(false);
        Karte.forEach(karte -> {if(karte.getFarbe()==farbe){
            istKarteEnthalten.set(true);}});
        return istKarteEnthalten.get();
    }

    public List<Karte> getKartenListe() {
        return Karte;
    }

    public List<Karte> kartenListeVonString(String kartenListenString) {

        return Karte;
    }

}
