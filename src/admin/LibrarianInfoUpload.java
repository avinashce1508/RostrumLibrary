package admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.DatabaseConnectivity;

public class LibrarianInfoUpload {
	private String name;
	private String password;
	private String email;
	private String address;
	private String city;
	private long contactNo;
	private byte[] image;
	public LibrarianInfoUpload(String name, String password, String email, String address, String city, long contactNo,
			byte[] image) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.address = address;
		this.city = city;
		this.contactNo = contactNo;
		this.image = image;
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
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	public boolean uploadInfoToDatabase() throws SQLException, IOException {
		DatabaseConnectivity dbconnect = new DatabaseConnectivity();
		Connection connection = dbconnect.getConnection();
		PreparedStatement pstUploadInfo = connection.prepareStatement("insert into librarian(name , password , email , address , city , contact , image) values(? , ? , ? , ? , ? , ? ,? )");
		pstUploadInfo.setString(1, getName());
		pstUploadInfo.setString(2, getPassword());
		pstUploadInfo.setString(3, getEmail());
		pstUploadInfo.setString(4, getAddress());
		pstUploadInfo.setString(5, getCity());
		pstUploadInfo.setLong(6, getContactNo());
		FileInputStream fis;
		File imgfile = new File("Image.txt");
		Path path=Paths.get(imgfile.getAbsolutePath());
		Files.write(path,getImage());
		System.out.println(getImage());
		fis=new FileInputStream(imgfile);
		pstUploadInfo.setBinaryStream(7, fis);
		
		return (pstUploadInfo.executeUpdate() > 0 ? true:false);
	}
}
