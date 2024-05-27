package hwr.oop.skat.gruppe2.domain;

import hwr.oop.skat.gruppe2.application.SpielVerwaltung;

public class SpielendeSpieler {
  Spieler spieler;
  KartenListe handKarten;
  KartenListe gewonneneKarten;

  public SpielendeSpieler(Spieler spieler) {
    this.spieler = spieler;
    this.handKarten = new KartenListe();
    this.gewonneneKarten = new KartenListe();
  }

  public SpielendeSpieler(Spieler spieler, KartenListe handKarten) {
    this.spieler = spieler;
    this.handKarten = handKarten;
    this.gewonneneKarten = new KartenListe();
  }

  public boolean karteSetzen(Karte karte, Runde runde) {
    if (!handKarten.istKarteEnthalten(karte)){
      return false;
    }
    if(runde.getBedinnFarbe()==karte.getFarbe()||!handKarten.istFarbeEnthalten(karte.getFarbe())){
      runde.addGelegteKarte(karte,this);
      return true;
    }else{
      return false;
    }
  }

  public void karteAufDieHand(Karte karte) {
    this.handKarten.addKarte(karte);
  }

  public void karteGewonnen(Karte karte) {
    this.gewonneneKarten.addKarte(karte);
  }

  // Getter
  public KartenListe getHandKarten() {
    return this.handKarten;
  }

  public KartenListe getGewonneneKarten() {
    return this.gewonneneKarten;
  }
}
