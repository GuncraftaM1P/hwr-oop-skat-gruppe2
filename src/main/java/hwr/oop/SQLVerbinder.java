package hwr.oop;

import java.sql.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SQLVerbinder {

  public static void main(String[] args) {
    getSingletonSchnitstelle();
  }

  private static SQLVerbinder singleton;

  private String url = "jdbc:sqlite:sqlite/Skat.db";
  private Connection schnitstelle = null;

  public static Connection getSingletonSchnitstelle() {
    if (singleton == null) {
      singleton = new SQLVerbinder();
    }
    return singleton.schnitstelle;
  }



  private SQLVerbinder() {
    try {
      // db parameters
      String url = "jdbc:sqlite:sqlite/Skat.db";
      // create a connection to the database
      new File("./sqlite/").mkdirs();

      schnitstelle = DriverManager.getConnection(url);
    }
    catch (SQLException e) {
      e.printStackTrace();
    }



      System.out.println("Test");
    // Eine Liste für alle Befehle die am anfang vor dem benutzen der Datenban gemacht werden soll
    List<String> startBefehle = new ArrayList<>();

    startBefehle.add(
        "CREATE TABLE IF NOT EXISTS spieler (\n"
            + "UUID text PRIMARY KEY,\n"
            + "name text NOT NULL,\n"
            + "gewonneneSpiele integer\n"
            + "verlohrendeSpiele integer\n"
            + ");");
    startBefehle.add(
        "CREATE TABLE IF NOT EXISTS spielendeSpieler (\n"
            + "UUID spieler PRIMARY KEY,\n" // ist der gleiche wie in spieler
            + "name text NOT NULL,\n"
            + "istEinzelspieler integer\n" // 1 =true; 0 = false; 2= es wurde nochnicht entschieden
            + " integer\n"
            + ");");
    startBefehle.add(
            "CREATE TABLE IF NOT EXISTS runden (\n"
            + "UUID spieler text PRIMARY KEY,\n"
            + "name text NOT NULL,\n"
            + "istEinzelspieler integer\n"
            
    );

    sendMehreSQLBefehle(startBefehle);


  }

  private void sendSQLBefehle(String sql) {
    try{
      schnitstelle = DriverManager.getConnection(url);
      schnitstelle.prepareStatement(sql).execute();
      //TODO löschen ! nach arbeiten
      System.out.println(sql);
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private void sendMehreSQLBefehle(List<String> sqlList) {
    try{
      schnitstelle = DriverManager.getConnection(url);
      for(String s : sqlList) {
        schnitstelle.prepareStatement(s).execute();
        //TODO löschen ! nach arbeiten
        System.out.println(s);
      }
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
