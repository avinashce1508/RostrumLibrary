package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectivity {
	
  private Connection connection;

public Connection getConnection() {
    try {
   	 // establish the connection with database
   	Class.forName(DatabaseCredentials.CLASSPATH);
		connection  = DriverManager.getConnection(DatabaseCredentials.URL, DatabaseCredentials.USERNAME, DatabaseCredentials.PASSWORD);
	 
    }catch(ClassNotFoundException cnfe) {
	    	
   	 System.out.println("class not found " + cnfe.getMessage());
	 
    }catch(SQLException sqle) {
	    	sqle.printStackTrace();
    }
    return connection;
  }
}