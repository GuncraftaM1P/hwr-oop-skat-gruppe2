package hwr.oop.skat.gruppe2.application;

import hwr.oop.skat.gruppe2.cli.Cli;
import hwr.oop.skat.gruppe2.domain.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonenVerwaltung {

  public static void main(String[] args) {
    // TODO noch erstellen@SuppressWarnings()
    new Cli(System.out, args);
  }

  List<Person> person; // TODO Laden Liste

  public PersonenVerwaltung() {
    person = new ArrayList<>(); // TODO Laden Liste
  }
}



