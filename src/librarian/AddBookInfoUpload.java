package librarian;

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

public class AddBookInfoUpload {
	
	private String isbnNo;
	private String bookName;
	private String authorName;
	private String publisherName;
	private int quantity;
	
	public AddBookInfoUpload(String isbnNo, String bookName, String authorName, String publisherName, int quantity) {
		super();
		this.isbnNo = isbnNo;
		this.bookName = bookName;
		this.authorName = authorName;
		this.publisherName = publisherName;
		this.quantity = quantity;
	}

	public String getIsbnNo() {
		return isbnNo;
	}

	public void setIsbnNo(String isbnNo) {
		this.isbnNo = isbnNo;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

	public boolean uploadInfoToDatabase() throws SQLException, IOException {
		DatabaseConnectivity dbconnect = new DatabaseConnectivity();
		Connection connection = dbconnect.getConnection();
		PreparedStatement pstUploadInfo = connection.prepareStatement("insert into books(isbn , name , author , publisher , quantity) values(? , ? , ? , ? , ? )");
		pstUploadInfo.setString(1, getIsbnNo());
		pstUploadInfo.setString(2, getBookName());
		pstUploadInfo.setString(3, getAuthorName());
		pstUploadInfo.setString(4, getPublisherName());
		pstUploadInfo.setInt(5, getQuantity());
		return (pstUploadInfo.executeUpdate() > 0 ? true:false);
	}

	

}
