package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.DatabaseConnectivity;

public class EditInfo {
	private int id;
	private String name;
	private String password;
	private String email;
	private String address;
	private String city;
	private long contactNo;
	public EditInfo(int id, String name, String password, String email, String address, String city,
			long contactNo) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.address = address;
		this.city = city;
		this.contactNo = contactNo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getContactNo() {
		return contactNo;
	}
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	
	public boolean updateDataInDatabase() throws SQLException{
		DatabaseConnectivity dbconnect = new DatabaseConnectivity();
		Connection connection = dbconnect.getConnection();
		PreparedStatement pstUpdateInfo = connection.prepareStatement("update librarian set name = ? , password = ? , email = ? , address = ? , city = ? , contact = ?  where id = ?");
		pstUpdateInfo.setString(1, getName());
		pstUpdateInfo.setString(2, getPassword());
		pstUpdateInfo.setString(3, getEmail());
		pstUpdateInfo.setString(4, getAddress());
		pstUpdateInfo.setString(5, getCity());
		pstUpdateInfo.setLong(6, getContactNo());
		pstUpdateInfo.setInt(7, getId());
		
		return (pstUpdateInfo.executeUpdate()>0 ? true : false);
	}


}
