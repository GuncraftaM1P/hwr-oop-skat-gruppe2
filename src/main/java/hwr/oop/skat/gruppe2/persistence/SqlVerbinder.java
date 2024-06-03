package hwr.oop.skat.gruppe2.persistence;

import hwr.oop.skat.gruppe2.domain.Person;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class SqlVerbinder {
  public static void main(String[] args) {
    getSingletonSchnittstelle();
  }

  private static SqlVerbinder singleton;
  // db parameter
  private static final Path URL = Paths.get("jdbc:sqlite:sqlite/Skat.db");
  private Connection schnittstelle = null;

  public static SqlVerbinder getSingletonSchnittstelle() {
    if (singleton == null) {
      singleton = new SqlVerbinder();
    }
    return singleton;
  }

  private SqlVerbinder() {
    try {
      // create a connection to the database
      new File("./sqlite/").mkdirs();

      schnittstelle = DriverManager.getConnection(URL.toString());
    } catch (SQLException e) {
      e.printStackTrace();
    }

    // Eine Liste für alle Befehle die am anfang vor dem Benutzen der Datenbank gemacht werden soll
    List<String> startBefehle = new ArrayList<>();

    startBefehle.add(
        """
                    CREATE TABLE IF NOT EXISTS spieler (
                    UUIDSpieler text PRIMARY KEY,
                    name text NOT NULL,
                    gewonneneSpiele integer,
                    verlohrendeSpiele integer
                    );""");

    // Spiel ID
    // einzelspieler
    // der Spieler der darann ist
    // wenn Null skat wurde vergeben und sonnst mit zwei katent belegt die vergegeben werden müssen
    startBefehle.add(
        """
              CREATE TABLE IF NOT EXISTS spiel (
              UUIDSpiel text PRIMARY KEY,
              UUIDRunde text,
              UUIDspielenderSpielerEinzelspieler text,
              UUIDAktuellerSpielenderSpieler text,
              UUIDStich text,
              OffenerSkart text
              );""");

    // Spiel ID
    // Spieler 1
    // die nummer von spieler im game
    startBefehle.add(
        """
              CREATE TABLE IF NOT EXISTS SpielHatSpieler (
              UUIDSpiel text PRIMARY KEY,
              UUIDspielenderSpieler text,
              SpielerNummer interger,
              Hantkaten text,
              GewonneneKaten text
              );""");

    startBefehle.add(
        """
              CREATE TABLE IF NOT EXISTS runden ("
              "UUIDRunde  text PRIMARY KEY,"
              "GespielteKarten text"
              ");""");

    sendMehreSQLBefehle(startBefehle);

    // TODO entefernen nach dem Testen ist Test daten
    try {
      ResultSet resultSet =
          executeSQL(
              "SELECT COUNT(*) as Anzahl FROM spieler WHERE spieler.UUIDSpieler like 'Test1'");
      resultSet.next();
      if (resultSet.getInt("Anzahl") < 0) {
        sendSQLBefehle(
            "INSERT INTO spieler(UUIDSpieler,name,gewonneneSpiele,verlohrendeSpiele)\n"
                + "VALUES('Test1','TestSpieler',0,0);");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    try {
      ResultSet resultSet = executeSQL("SELECT name FROM spieler");
      resultSet.next();
      System.out.println(resultSet.toString());
      if (resultSet.getMetaData().getColumnCount() != 1) {
        System.out.println("ErRRRRROROROOROOR");
      } else {
        System.out.println(resultSet.getString("name"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void NeuePersonInDatenbank(String Name, UUID UUIDPerson) {
    sendSQLBefehle(
        "INSERT INTO spieler(UUIDSpieler,name,gewonneneSpiele,verlohrendeSpiele)\n"
            + "VALUES('"
            + UUIDPerson
            + "','"
            + Name
            + "',0,0);");
  }

  public Person getPersonByUUIDPerson(String UUIDPerson) {
    ResultSet resultSet =
        executeSQL("SELECT * FROM spieler WHERE UUIDSpieler = '" + UUIDPerson + "'");
    try {
      return new Person(
          UUID.fromString(resultSet.getString("UUIDSpieler")),
          resultSet.getString("name"),
          resultSet.getInt("gewonneneSpiele"),
          resultSet.getInt("verlohrendeSpiele"));
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public int getIntegerVonDB(String sql) {
    try {
      ResultSet resultSet = schnittstelle.prepareStatement(sql).executeQuery();
      while (resultSet.next()) {
        int id = resultSet.getInt(1);
        return id;
      }
    } catch (Exception e) {
      e.printStackTrace();
      return -1;
    }
    return -1;
  }

  private ResultSet executeSQL(String sql) {
    try {
      return schnittstelle.prepareStatement(sql).executeQuery();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  private void sendSQLBefehle(String sql) {
    try {
      schnittstelle = DriverManager.getConnection(URL.toString());
      schnittstelle.prepareStatement(sql).execute();
      // TODO löschen ! nach arbeiten
      System.out.println(sql);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private void sendMehreSQLBefehle(List<String> sqlList) {
    try {
      schnittstelle = DriverManager.getConnection(URL.toString());
      for (String s : sqlList) {
        schnittstelle.prepareStatement(s).execute();
        // TODO löschen ! nach arbeiten
        System.out.println(s);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
