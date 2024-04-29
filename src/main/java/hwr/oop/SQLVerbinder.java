package hwr.oop;

import java.sql.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SQLVerbinder {

  public static void main(String[] args) {
    getSingletonSchnitstelle();
  }

  private static SQLVerbinder singleton;

  private static final String URL = "jdbc:sqlite:sqlite/Skat.db";
  private Connection schnittstelle = null;

  public static Connection getSingletonSchnitstelle() {
    if (singleton == null) {
      singleton = new SQLVerbinder();
    }
    return singleton.schnittstelle;
  }

  private SQLVerbinder() {
    try {
      // db parameters

      // create a connection to the database
      new File("./sqlite/").mkdirs();

      schnittstelle = DriverManager.getConnection(URL);
    }
    catch (SQLException e) {
      e.printStackTrace();
    }

    // Eine Liste für alle Befehle die am anfang vor dem Benutzen der Datenbank gemacht werden soll
    List<String> startBefehle = new ArrayList<>();

    startBefehle.add(
        "CREATE TABLE IF NOT EXISTS spieler (\n"
            + "UUID text PRIMARY KEY,\n"
            + "name text NOT NULL,\n"
            + "gewonneneSpiele integer\n"
            + "verloreneSpiele integer\n"
            + ");");
    startBefehle.add(
        "CREATE TABLE IF NOT EXISTS spielendeSpieler (\n"
            + "UUID text PRIMARY KEY,\n"
            + "name text NOT NULL,\n"
            + "istEinzelspieler integer\n" // 1 =true; 0 = false; 2= es wurde noch nicht entschieden
            + " integer\n"
            + ");");
    startBefehle.add(
            "CREATE TABLE IF NOT EXISTS runden (\n"
            + "UUID spieler text PRIMARY KEY,\n"
            + "name text NOT NULL,\n"
            + "istEinzelspieler integer\n"
    );

    sendeMehreSQLBefehle(startBefehle);
  }

  private String sendeSQLAnfrage(String sql) {
    try{
      Statement statement = schnittstelle.createStatement();
      ResultSet resultSet = statement.executeQuery(sql);

      //Beispiel zum Lesen der return Werte
      int id = resultSet.getInt("id");
      return ""+id;
    }
    catch (SQLException e) {
      e.printStackTrace();
      return "";
    }
  }

  public void spielLoeschen(String spielID) {
    try {
      schnittstelle = DriverManager.getConnection(URL);
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
    List<String> loeschenBefehle = new ArrayList<>();
    loeschenBefehle.add("DELETE FROM spielHatSpieler sh WHERE sh.spielID = "+spielID+";");
    loeschenBefehle.add("DELETE FROM spiel s WHERE s.UUID = "+spielID+";");

    sendeMehreSQLBefehle(loeschenBefehle);
  }

  private void sendeMehreSQLBefehle(List<String> sqlList) {
    try{
      schnittstelle = DriverManager.getConnection(URL);
      for(String s : sqlList) {
        schnittstelle.prepareStatement(s).execute();
      }
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
