package hwr.oop.skat.gruppe2.persistence;

import hwr.oop.skat.gruppe2.domain.Person;
import hwr.oop.skat.gruppe2.domain.Spielfeld;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SqlVerbinder {
  // db parameter
  private static final Path URL = Paths.get("jdbc:sqlite:sqlite/Skat.db");
  private Connection schnittstelle = null;

  public SqlVerbinder() {
    this.initialisiereDatenbank();
  }

  public void initialisiereDatenbank() {
    try {
      // create a connection to the database
      new File("./sqlite/").mkdirs();

      schnittstelle = DriverManager.getConnection(URL.toString());
    } catch (SQLException e) {
      e.printStackTrace();
    }

    // Eine Liste für alle Befehle die am anfang vor dem Benutzen der Datenbank gemacht werden soll
    List<String> startBefehle =
        List.of(
            """
                CREATE TABLE IF NOT EXISTS spieler (
                UUIDSpieler text PRIMARY KEY,
                name text NOT NULL,
                gewonneneSpiele integer,
                verloreneSpiele integer
                );""",
            """
                CREATE TABLE IF NOT EXISTS spiel (
                UUIDSpiel text PRIMARY KEY,
                UUIDRunde text,
                UUIDSpielenderSpielerEinzelspieler text,
                UUIDAktuellerSpielenderSpieler text,
                UUIDStich text,
                OffenerSkat text
                );""",
            """
                CREATE TABLE IF NOT EXISTS SpielHatSpieler (
                UUIDSpiel text PRIMARY KEY,
                UUIDSpielenderSpieler text,
                SpielerNummer integer,
                Handkarten text,
                GewonneneKarten text
                );""",
            """
                CREATE TABLE IF NOT EXISTS runden ("
                "UUIDRunde  text PRIMARY KEY,"
                "GespielteKarten text"
                ");""");

    sendMehreSQLBefehle(startBefehle);
  }

  public void neuePersonInDatenbank(String name, UUID personUUID) {
    sendSQLBefehle(
        "INSERT INTO spieler(UUIDSpieler,name,gewonneneSpiele,verloreneSpiele)\n"
            + "VALUES('"
            + personUUID
            + "','"
            + name
            + "',0,0);");
  }

  public Person getPersonByUUIDPerson(String personUUID) {
    try {
      ResultSet resultSet = executeSQL("SELECT * FROM spieler WHERE UUIDSpieler = '" + personUUID + "'");
      return new Person(
          UUID.fromString(resultSet.getString("UUIDSpieler")),
          resultSet.getString("name"),
          resultSet.getInt("gewonneneSpiele"),
          resultSet.getInt("verloreneSpiele"));
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public int getIntegerVonDB(String sql) {
    try {
      ResultSet resultSet = schnittstelle.prepareStatement(sql).executeQuery();
      while (resultSet.next()) {
        return resultSet.getInt(1);
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
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private void sendMehreSQLBefehle(List<String> sqlList) {
    try {
      schnittstelle = DriverManager.getConnection(URL.toString());
      for (String s : sqlList) {
        schnittstelle.prepareStatement(s).execute();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public Spielfeld ladeSpielfeld(UUID spiel) {
    try {
      ResultSet resultSet = this.executeSQL("SELECT * FROM  WHERE  =" + spiel.toString() + "");
      return new Spielfeld(); //todo fill with data
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
