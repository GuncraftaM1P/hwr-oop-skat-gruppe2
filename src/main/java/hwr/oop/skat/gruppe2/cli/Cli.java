package hwr.oop.skat.gruppe2.cli;

import hwr.oop.skat.gruppe2.application.SpielVerwaltung;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Cli {
  private final PrintStream out;
  private String feedback;

  // Path

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
      // neuePerson(name)
      // return uuid der Person
    }
    return null;
  }
  // methode die Commands auf validität überprüft, bei falscher Eingabe einen Fehler zurrückgibt,
  // bei leer den help command
  // methode, die den help command printed
  // methode, die den current game state wiedergibt (Handkarten, aktueller Stich, Trumpf),
  // (Mitspieler, Einzelspieler, Reihenfolge)
  // Methode, die Testet ob der eingegebene Command valide ist
}
