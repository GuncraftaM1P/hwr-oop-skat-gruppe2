package hwr.oop.skat.gruppe2.cli;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Cli {
  private final PrintStream out;
  private String feedback;
  //Path

  public Cli(OutputStream outputStream, String... arguments) {
    this.out = new PrintStream(outputStream);
    handle(Arrays.asList(arguments));
    this.feedback = "Ein Fehler ist aufgetreten oder der eingegebene Befehl war fehlerhaft";
  }

  public void handle(List<String> arguments) {//?
    final List<String> mutable = new ArrayList<>(arguments);
    //takes the arguments and compresses them into usable commands
    //print feedback
  }

  /*
  if(args.length>=2&& args[0].equals("ErstelleNeuenSpieler")){
      neuerSpieler(args);
  }
  */
  //methode die Commands auf validität überprüft, bei falscher Eingabe einen Fehler zurrückgibt, bei leer den help command
  //methode, die den help command printed
  //methode, die den current game state wiedergibt (Handkarten, aktueller Stich, Trumpf), (Mitspieler, Einzelspieler, Reihenfolge)
  //Methode, die Testet ob der eingegebene Command valide ist
}
