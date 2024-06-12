package hwr.oop.skat.gruppe2.cli;
/*
import hwr.oop.skat.gruppe2.application.SpielVerwaltung;
import hwr.oop.skat.gruppe2.domain.Farbe;
import hwr.oop.skat.gruppe2.domain.Karte;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public final class Cli {
  private final PrintStream out;
  private String feedback;

  public Cli(OutputStream outputStream, String... arguments) {
    this.out = new PrintStream(outputStream);

    this.feedback = handle(Arrays.asList(arguments));
    if (this.feedback == null)
      this.feedback = "Ein Fehler ist aufgetreten oder der eingegebene Befehl war fehlerhaft";
    out.println(this.feedback);
  }

  //so in etwa könnte der CLI Ansatz sein, um die Funktionen richtig zu nutzen
  public String handle(List<String> arguments) {
    SpielVerwaltung sv = null;
    String ret = null;
    final List<String> mutable = new ArrayList<>(arguments);
    if (mutable.size() == 4 && mutable.getFirst().equals("neuesSpiel")) {
      sv = new SpielVerwaltung(List.of(mutable.get(1), mutable.get(2), mutable.get(3)));
      ret = sv.getUUID().toString();
    } else if (mutable.size() == 2 && mutable.getFirst().equals("neuePerson")) {
      sv = new SpielVerwaltung();
      sv.erstelleSpieler(mutable.get(1));
    } else if (mutable.size() == 6 && mutable.getFirst().equals("skatAblegen")) {
      sv = new SpielVerwaltung(UUID.fromString(mutable.get(1)));
      if (sv.waehleSkat(mutable.get(2), List.of(new Karte(mutable.get(3)), new Karte(mutable.get(4))), Farbe.getFarbeByWert(Integer.parseInt(mutable.get(5))))) {
        ret = "erfolgreich";
      }
    } else if (mutable.size() == 4 && mutable.getFirst().equals("karteLegen")) {
      sv = new SpielVerwaltung(UUID.fromString(mutable.get(1)));
      sv.karteLegen(UUID.fromString(mutable.get(2)), new Karte(mutable.get(4)));
    }

    if(ret != null && sv != null)
      sv.spielZwischenspeichern();
    return ret;
  }
}*/