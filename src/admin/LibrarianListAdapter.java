package admin;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.DatabaseConnectivity;


public class LibrarianListAdapter {

	public ArrayList<LibrarianTable> getDataFromDatabase() throws SQLException {
		DatabaseConnectivity dbconnect = new DatabaseConnectivity();
		Connection connection = dbconnect.getConnection();
		Statement stlibrarian = connection.createStatement();
		ResultSet rslib_info = stlibrarian.executeQuery("select * from librarian");
		ArrayList<LibrarianTable> libList = new ArrayList<LibrarianTable>();
		while(rslib_info.next()) {
			LibrarianTable libTable = new LibrarianTable(rslib_info.getInt("id"), rslib_info.getString("name"), rslib_info.getString("password"), rslib_info.getString("email"), rslib_info.getString("address"), rslib_info.getString("city") , rslib_info.getLong("contact"));
			libList.add(libTable);
		}

		return (libList);
	}
}
