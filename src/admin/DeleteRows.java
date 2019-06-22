package admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.DatabaseConnectivity;

public class DeleteRows {
	private int id;

	public DeleteRows(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public boolean deleteRowFromDatabase() throws SQLException {
		DatabaseConnectivity dbconnect = new DatabaseConnectivity();
		Connection connection = dbconnect.getConnection();
		PreparedStatement pstDeleteRow = connection.prepareStatement("delete from librarian where id = ?");
		pstDeleteRow.setInt(1, id);
		
		return pstDeleteRow.executeUpdate()>0?true:false;
	}
}
