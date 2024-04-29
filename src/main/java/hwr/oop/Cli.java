package hwr.oop;

import java.io.PrintStream;

public class Cli {
    private final PrintStream Systemout;
    public Cli(PrintStream SystemOut,String[] args) {
        this.Systemout = SystemOut;
        ArgumentAuswerten(args);
    }

    private void ArgumentAuswerten(String[] args) {
        if(args.length>=2&& args[0].equals("ErstelleNeuenSpieler")){
            SQLVerbinder sqlVerbinder = SQLVerbinder.getSingletonSchnitstelle();
            Spieler spieler = new Spieler(args[1]);
            // TODO ersetzen von Sout
            System.out.println("Der neue Spieler"+spieler.getName()+" wurde gespeichert. Und hat die UUID:"+spieler.getUuid());
        }
    }
}
