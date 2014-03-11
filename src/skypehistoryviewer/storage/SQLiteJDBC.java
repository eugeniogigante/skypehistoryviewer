package skypehistoryviewer.storage;
import java.sql.*;
public class SQLiteJDBC {
	private String path;
	
	public void setPath(String path){
		this.path=path;
	}
	
	public Connection getConnection(){
	    Connection c = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:"+path);
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Opened database successfully");
	    return c;
	}
}
