package hwr.oop.skat.gruppe2.cli;

import java.util.Arrays;

public final class Main {
  public static void main(String[] args) {
    //Todo suppress warning
    final Cli cli = new Cli(System.out, args);
    cli.handle(Arrays.asList(args));
  }
}
