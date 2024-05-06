package hwr.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class LadenUndSpeichern {

    public static void main(String[] args){
        LadenUndSpeichern ladenUndSpeichern = new LadenUndSpeichern();
        KartenListe kartes = ladenUndSpeichern.kartenListeVonString("2-7,3-12,1-8");
    System.out.println(ladenUndSpeichern.kartenListeZuString(kartes));
    }

    //
    //Karten list transformation
    //
    //Format von den String muss sein Eine Karte ist Zahl gefolgt von "-" gefolgt von ein bis zwei Zahlen
    //die Karten sind durch "," von einander getränd
    //z.B. "2-7,3-12,1-8" -> Herz sieben, Pik Zehn, Karo Acht
    public KartenListe kartenListeVonString(String kartenListenString) {
        return new KartenListe(Arrays.stream(kartenListenString.split(",")).map(karteString -> stringZuKarte(karteString)).toList());
    }
    private Karte stringZuKarte(String stringZuKarte) {
        String[] temp =  stringZuKarte.split("-");
        return new Karte(Farbe.getFarbeByWert(Integer.parseInt(temp[0])),Wert.getWertByStaerke(Integer.parseInt(temp[1])));
    }

    public String kartenListeZuString(KartenListe kartenListe){
        return kartenListe.getKartenListe().stream()
                .map(karte -> kartezuString(karte))
                .reduce((a,b) -> a+","+b)
                .orElse("");
    }
    private String kartezuString(Karte karte) {
        return karte.getFarbe().getWert()+"-"+karte.getWert().getStaerke();
    }

    //Neuer Spieler in DatenBank Speichern
    public UUID spielerNeuErstellen(Spieler spieler){
        SQLVerbinder.getSingletonSchnitstelle().NeuenSpielerInDatenbank(spieler.getName(), spieler.getUuid());
        return spieler.getUuid();
    }

    public Spieler getSpielerVonUUID(UUID uuid){
        return SQLVerbinder.getSingletonSchnitstelle().getSpielerByUUIDSpieler(uuid.toString());
    }
}
