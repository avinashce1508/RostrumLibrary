package librarian;

import java.sql.Connection;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import database.DatabaseConnectivity;

public class BookListAdapter {
	public ArrayList<BooksTable> getDataFromDatabase() throws SQLException {
		DatabaseConnectivity dbconnect = new DatabaseConnectivity();
		Connection connection = dbconnect.getConnection();
		Statement stbook = connection.createStatement();
		ResultSet rsbookinfo = stbook.executeQuery("select * from books");
		ArrayList<BooksTable> booksList = new ArrayList<BooksTable>();
		while(rsbookinfo.next()) {
			
			BooksTable bookTable = new BooksTable(rsbookinfo.getInt("id"), rsbookinfo.getString("isbn"), rsbookinfo.getString("name"), rsbookinfo.getString("author"), rsbookinfo.getString("publisher"), rsbookinfo.getInt("quantity") , rsbookinfo.getInt("issued") , toDate(rsbookinfo.getTimestamp("added_date")));
			booksList.add(bookTable);
		}
		return (booksList);
	}
	
	public Date toDate(java.sql.Timestamp timestamp) {
	    long milliseconds = timestamp.getTime() + (timestamp.getNanos() / 1000000);
	    return new java.util.Date(milliseconds);
	}
}
