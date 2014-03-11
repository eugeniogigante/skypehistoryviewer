package skypehistoryviewer.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import skypehistoryviewer.storage.SQLiteJDBC;

public class TestSQLiteJDBC {

	

	@Test
	public void testGetConnection() {
		Connection c=new SQLiteJDBC().getConnection("C://Users//eugenio.gigante//AppData//Roaming//Skype//eugenio_gigante//main.db");
		assertFalse(c==null);
		fail("Not yet implemented");
	}

}
