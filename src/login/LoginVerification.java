package login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.DatabaseConnectivity;

public class LoginVerification {
	
	private String username;
	private String password;
	public LoginVerification(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean verifyUser() throws SQLException{
		
		DatabaseConnectivity dbconnect = new DatabaseConnectivity();
		Connection connection = dbconnect.getConnection();
		PreparedStatement pstmt = connection.prepareStatement("select * from login where username = ? and password = ?");
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		return pstmt.execute();
	}

}
