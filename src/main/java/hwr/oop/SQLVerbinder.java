package hwr.oop;

import java.sql.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SQLVerbinder {

  public static void main(String[] args) {
    getSingletonSchnitstelle();
  }

  private static SQLVerbinder singleton;

  private static final String url = "jdbc:sqlite:sqlite/Skat.db";
  private Connection schnittstelle = null;

  public static SQLVerbinder getSingletonSchnitstelle() {
    if (singleton == null) {
      singleton = new SQLVerbinder();
    }
    return singleton;
  }



  private SQLVerbinder() {
    try {
      // db parameters
      String url = "jdbc:sqlite:sqlite/Skat.db";
      // create a connection to the database
      new File("./sqlite/").mkdirs();

      schnittstelle = DriverManager.getConnection(url);
    }
    catch (SQLException e) {
      e.printStackTrace();
    }

    // Eine Liste für alle Befehle die am anfang vor dem Benutzen der Datenbank gemacht werden soll
    List<String> startBefehle = new ArrayList<>();

    startBefehle.add(
        "CREATE TABLE IF NOT EXISTS spieler (\n"
            + "UUIDSpieler text PRIMARY KEY,\n"
            + "name text NOT NULL,\n"
            + "gewonneneSpiele integer,\n"
            + "verlohrendeSpiele integer\n"
            + ");");

    startBefehle.add("CREATE TABLE IF NOT EXISTS spiel (\n"
            + "UUIDSpiel text PRIMARY KEY,\n"//Spiel ID
            + "UUIDRunde text,\n"
            + "UUIDspielenderSpielerEinzelspieler text, \n" //einzelspieler
            + "UUIDAktuellerSpielenderSpieler text, \n" //der Spieler der darann ist
            + "UUIDStich text, \n"
            + "OffenerSkart text \n" // wenn Null skat wurde vergeben und sonnst mit zwei katent belegt die vergegeben werden müssen
            + ");");

    startBefehle.add("CREATE TABLE IF NOT EXISTS SpielHatSpieler (\n"
            + "UUIDSpiel text PRIMARY KEY,\n"//Spiel ID
            + "UUIDspielenderSpieler text, \n" //Spieler 1
            + "SpielerNummer interger, \n" //die nummer von spieler im game
            + "Hantkaten text, \n"
            + "GewonneneKaten text \n"
            + ");");

    startBefehle.add(
            "CREATE TABLE IF NOT EXISTS runden (\n"
            + "UUIDRunde  text PRIMARY KEY,\n"
            + "GespielteKarten text\n"
                    + ");");

    sendMehreSQLBefehle(startBefehle);


    try{
      ResultSet resultSet =executeSQL("SELECT COUNT(*) as Anzahl FROM spieler WHERE spieler.UUIDSpieler like 'Test1'");
      resultSet.next();
    if (resultSet.getInt("Anzahl") < 0) {
        sendSQLBefehle("INSERT INTO spieler(UUIDSpieler,name,gewonneneSpiele,verlohrendeSpiele)\n"
                + "VALUES('Test1','TestSpieler',0,0);");}
    }catch (SQLException e){
      e.printStackTrace();
    }


    try {
      ResultSet resultSet =executeSQL("SELECT name FROM spieler");
      resultSet.next();
      System.out.println(resultSet.toString());
      if(resultSet.getMetaData().getColumnCount()!=1){
        System.out.println("ErRRRRROROROOROOR");
      }else {
        System.out.println(resultSet.getString("name"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }


  }

  public void NeuenSpielerInDatenbank(String Name, UUID UUIDSpieler){
    sendSQLBefehle("INSERT INTO spieler(UUIDSpieler,name,gewonneneSpiele,verlohrendeSpiele)\n"
            + "VALUES('"+UUIDSpieler+"','"+Name+"',0,0);");
  }

  public Spieler getSpielerVonDatenbank(UUID UUIDSpieler){

    ResultSet resultSet =  executeSQL("SELECT * FROM spieler WHERE UUIDSpieler = '"+UUIDSpieler+"'");
    try{
      return new Spieler(
              UUID.fromString( resultSet.getString("UUIDSpieler")),
          resultSet.getString("name"),
          resultSet.getInt("gewonneneRunden"),
          resultSet.getInt("gespieleteRunden"));
    }catch (SQLException e){
      e.printStackTrace();
    }
    return null;
  }

  public int getIntegerVonDB(String sql){
    try {
         ResultSet resultSet = schnittstelle.prepareStatement(sql).executeQuery() ;
      while (resultSet.next()){
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
    try{
      schnittstelle = DriverManager.getConnection(url);
      schnittstelle.prepareStatement(sql).execute();
      //TODO löschen ! nach arbeiten
      System.out.println(sql);
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private void sendMehreSQLBefehle(List<String> sqlList) {
    try{
      schnittstelle = DriverManager.getConnection(url);
      for(String s : sqlList) {
        schnittstelle.prepareStatement(s).execute();
        //TODO löschen ! nach arbeiten
        System.out.println(s);
      }
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
