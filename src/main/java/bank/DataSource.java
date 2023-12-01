package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
  public static Connection connect(){
    String db_file ="jbdc:sqlite:resources/bank.db";
    Connection connection = null;
    try{
      DriverManager.getConnection(db_file);
      System.out.println("Connected to the DB");

    } catch(SQLException ex ){
      ex.printStackTrace();
    }
    return connection;

  }
  public static void main(String[] args) {
    connect();
  }

}
