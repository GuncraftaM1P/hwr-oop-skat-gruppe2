package hwr.oop.skat.gruppe2.cli;

import hwr.oop.skat.gruppe2.application.SpielVerwaltung;
import hwr.oop.skat.gruppe2.domain.Farbe;
import hwr.oop.skat.gruppe2.domain.Karte;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

  public String handle(List<String> arguments) {
    SpielVerwaltung sv;
    final List<String> mutable = new ArrayList<>(arguments);
    if (mutable.size() == 4 && mutable.getFirst().equals("neuesSpiel")) {
      sv = new SpielVerwaltung(List.of(mutable.get(1), mutable.get(2), mutable.get(3)));
      return sv.getUUID().toString();
    } else if (mutable.size() == 2 && mutable.getFirst().equals("neuePerson")) {
      sv = new SpielVerwaltung();
      sv.erstelleSpieler(mutable.get(1));
    } else if (mutable.size() == 6 && mutable.getFirst().equals("skatAblegen")) {
      sv = new SpielVerwaltung(mutable.get(1));
      if (sv.waehleSkat(mutable.get(2), List.of(new Karte(mutable.get(3)), new Karte(mutable.get(4))), Farbe.getFarbeByWert(Integer.parseInt(mutable.get(5))))) {
        return "erfolgreich";
      }
    }
    return null;
  }
}