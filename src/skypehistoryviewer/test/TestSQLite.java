package skypehistoryviewer.test;
import java.sql.*;

public class TestSQLite
{
  public static void main( String args[] )
  {
    Connection c = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:C://Users//eugenio.gigante//AppData//Roaming//Skype//eugenio_gigante//main.db");
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Opened database successfully");
  }
}