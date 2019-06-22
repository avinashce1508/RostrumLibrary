package login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.DatabaseConnectivity;

public class UpdatePassword {
	
	private String username;
	private String password;
	public UpdatePassword(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public boolean updatePassword() throws SQLException {
		DatabaseConnectivity dbconnect = new DatabaseConnectivity();
		Connection connection = dbconnect.getConnection();
		PreparedStatement pstmt = connection.prepareStatement("update login set password = ? where username = ?");
		pstmt.setString(1, password);
		pstmt.setString(2, username);
		int val = pstmt.executeUpdate();
		System.out.println(val);
		return (val>0 ? true:false);
		
	}

}
