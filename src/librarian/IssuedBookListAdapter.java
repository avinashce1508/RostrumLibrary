package librarian;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import admin.LibrarianTable;
import database.DatabaseConnectivity;

public class IssuedBookListAdapter {
	public ArrayList<IssuedBooksTable> getDataFromDatabase() throws SQLException {
		DatabaseConnectivity dbconnect = new DatabaseConnectivity();
		Connection connection = dbconnect.getConnection();
		Statement stbook = connection.createStatement();
		ResultSet rsissuedbookinfo = stbook.executeQuery("select * from issuebooks");
		ArrayList<IssuedBooksTable> issuedbooksList = new ArrayList<IssuedBooksTable>();
		while(rsissuedbookinfo.next()) {
			IssuedBooksTable issuedbookTable = new IssuedBooksTable(rsissuedbookinfo.getInt("id"), rsissuedbookinfo.getString("isbn"), rsissuedbookinfo.getString("issuerid"), rsissuedbookinfo.getString("issuername"),  rsissuedbookinfo.getLong("issuerContactNo") , toDate(rsissuedbookinfo.getTimestamp("issueddate")));
			issuedbooksList.add(issuedbookTable);
		}
		return (issuedbooksList);
	}
	
	public Date toDate(java.sql.Timestamp timestamp) {
	    long milliseconds = timestamp.getTime() + (timestamp.getNanos() / 1000000);
	    return new java.util.Date(milliseconds);
	}
}
