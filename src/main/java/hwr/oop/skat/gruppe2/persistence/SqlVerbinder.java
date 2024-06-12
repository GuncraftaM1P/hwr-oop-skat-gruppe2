package hwr.oop.skat.gruppe2.persistence;

import hwr.oop.skat.gruppe2.domain.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class SqlVerbinder {
  // db parameter
  private static final Path URL = Paths.get("jdbc꞉sqlite꞉sqlite/Skat.db");
  private Connection schnittstelle = null;

  private static final String GEWONNENE_SPIELE = "gewonneneSpiele"; //damit SonarLint Ruhe gibt
  private static final String VERLORENE_SPIELE = "verloreneSpiele"; //damit SonarLint Ruhe gibt
  private static final String UUIDSPIELER = "UUIDSpieler"; //damit SonarLint Ruhe gibt

  public SqlVerbinder() {
    this.initialisiereDatenbank();
  }

  public void initialisiereDatenbank() {
    try {
      // create a connection to the database
      new File("./sqlite/").mkdirs();

      schnittstelle = DriverManager.getConnection(this.URL.toString());
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
                UUIDEinzelspieler text,
                UUIDAktuellerSpieler text,
                Stich text,
                OffenerSkat text,
                Trumpf text
                );""",
            """
                CREATE TABLE IF NOT EXISTS SpielHatSpieler (
                UUIDSpielHatSpieler text PRIMARY KEY,
                UUIDSpiel text,
                UUIDSpieler text,
                SpielerNummer integer,
                Handkarten text,
                GewonneneKarten text
                );""");

    sendMehreSQLBefehle(startBefehle);
  }

  public boolean speicherPerson(Person person) {
    return this.sendSQLBefehle(
        "INSERT INTO spieler(UUIDSpieler, name, gewonneneSpiele, verloreneSpiele) "
            + "VALUES('" + person.getUuid() + "','" + person.getName() + "'," + person.getGewonneneRunden() + "," + person.getVerloreneRunden() + ");");
  }

  public Person getPersonByUUIDPerson(String personUUID) {
    try {
      ResultSet resultSet = executeSQL("SELECT * FROM spieler WHERE UUIDSpieler = '" + personUUID + "'");
      return new Person(
          UUID.fromString(resultSet.getString(UUIDSPIELER)),
          resultSet.getString("name"),
          resultSet.getInt(GEWONNENE_SPIELE),
          resultSet.getInt(VERLORENE_SPIELE) + resultSet.getInt(GEWONNENE_SPIELE));
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public int getIntegerVonDB(String sql) {
    try {
      try (ResultSet resultSet = schnittstelle.prepareStatement(sql).executeQuery()) {
        while (resultSet.next()) {
          return resultSet.getInt(1);
        }
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

  private boolean sendSQLBefehle(String sql) {
    try {
      schnittstelle = DriverManager.getConnection(this.URL.toString());
      schnittstelle.prepareStatement(sql).execute();
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  private void sendMehreSQLBefehle(List<String> sqlList) {
    try {
      schnittstelle = DriverManager.getConnection(this.URL.toString());
      for (String s : sqlList) {
        schnittstelle.prepareStatement(s).execute();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public Spielfeld ladeSpielfeld(UUID spiel) {
    try {
      ResultSet resultSet = this.executeSQL("SELECT OffenerSkat, Trumpf FROM spiel s " +
          "WHERE UUIDSpiel =" + spiel.toString());
      return new Spielfeld(this.kartenListeVonString(resultSet.getString("OffenerSkat")), Farbe.getFarbeByWert(Integer.parseInt(resultSet.getString("Trumpf"))));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public List<Karte> kartenListeVonString(String kartenListenString) {
    return Arrays.stream(kartenListenString.split(",")).map(Karte::new).toList();
  }

  public String kartenListeZuString(List<Karte> kartenListe) {
    return kartenListe.stream().map(this::kartezuString).reduce((a, b) -> a + "," + b).orElse("");
  }

  private String kartezuString(Karte karte) {
    return karte.getFarbe().getWert() + "-" + karte.getWert().getStaerke();
  }

  public List<Spieler> ladeSpieler(UUID spiel) {
    List<Spieler> spielerListe = new ArrayList<>();
    try {
      ResultSet rs = this.executeSQL("SELECT shs.UUIDSpieler, shs.SpielerNummer, shs.Handkarten, shs.GewonneneKarten, s.name, s.gewonneneSpiele, s.verloreneSpiele " +
          "FROM spielHatSpieler shs, spieler s WHERE shs.UUIDSpiel =" + spiel.toString() + " AND shs.UUIDSpieler = s.UUIDSpieler " +
          "ORDER BY SpielerNummer ASC");
      while (rs != null && rs.next()) {
        Person person = new Person(UUID.fromString(rs.getString(UUIDSPIELER)), rs.getString("name"), Integer.parseInt(rs.getString(GEWONNENE_SPIELE)), Integer.parseInt(rs.getString(VERLORENE_SPIELE)));
        spielerListe.add(new Spieler(person, this.kartenListeVonString(rs.getString("Handkarten")), this.kartenListeVonString(rs.getString("GewonneneKarten"))));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return spielerListe;
  }

  public Stich ladeStich(UUID spiel) {
    try {
      ResultSet rs = this.executeSQL("SELECT shs.UUIDSpieler, shs.SpielerNummer, shs.Handkarten, shs.GewonneneKarten, s.name, s.gewonneneSpiele, s.verloreneSpiele, sp.Stich " +
          "FROM spielHatSpieler shs, spieler s, spiel sp WHERE shs.UUIDSpiel =" + spiel.toString() + " AND sp.UUIDSpiel = " + spiel + " AND shs.UUIDSpieler = s.UUIDAktuellerSpieler");
      while (rs != null && rs.next()) {
        Person person = new Person(UUID.fromString(rs.getString(UUIDSPIELER)), rs.getString("name"), Integer.parseInt(rs.getString(GEWONNENE_SPIELE)), Integer.parseInt(rs.getString(VERLORENE_SPIELE)));
        Spieler spieler = new Spieler(person, this.kartenListeVonString(rs.getString("Handkarten")), this.kartenListeVonString(rs.getString("GewonneneKarten")));
        return new Stich(spieler, this.kartenListeVonString(rs.getString("Stich")));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public boolean speicherSpiel(List<Spieler> spieler, Stich stich, Spielfeld stapel, UUID spiel) {
    int i = 0;
    for (Spieler s : spieler) {
      this.sendSQLBefehle(
          "UPDATE spieler " +
              "SET gewonneneSpiele = " + s.getPerson().getGewonneneRunden() + ", verloreneSpiele = " + s.getPerson().getVerloreneRunden() + " " +
              "WHERE UUIDSpieler = " + s.getUUID().toString() + "; "
      );
      this.sendSQLBefehle(
          "UPDATE SpielHatSpieler " +
              "SET SpielerNummer = " + i + ", Handkarten = " + this.kartenListeZuString(s.getHandKarten()) + ", " +
              "GewonneneKarten = " + this.kartenListeZuString(s.getGewonneneKarten()) + " " +
              "WHERE UUIDSpiel = " + spiel.toString() + " AND UUIDSpieler = " + s.getUUID().toString() + ";"
      );
      i++;
    }
    this.sendSQLBefehle(
        "UPDATE spiel " +
            "SET UUIDEinzelspieler = " + spieler.getFirst().getUUID().toString() + ", UUIDAktuellerSpieler = " + stich.getSpielerAnDerReihe().getUUID().toString() + ", " +
            "Stich = " + this.kartenListeZuString(stich.getGelegteKarten()) + ", OffenerSkat = " + this.kartenListeZuString(stapel.getDeck()) + ", Trumpf = " + stapel.getTrumpf().toString() + " " +
            "WHERE UUIDSpieler = " + spiel.toString() + ";"
    );

    return true;
  }
}