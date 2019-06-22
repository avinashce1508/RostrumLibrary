package librarian;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.DatabaseConnectivity;

public class ReturnBookInfoUpload {

	private String isbn;
	private String issuedId;
	public ReturnBookInfoUpload(String isbn, String issuedId) {
		super();
		this.isbn = isbn;
		this.issuedId = issuedId;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getIssuedId() {
		return issuedId;
	}
	public void setIssuedId(String issuedId) {
		this.issuedId = issuedId;
	}

	public boolean uploadInfoToDatabase(){
		int status=0;
		try{
			DatabaseConnectivity dbconnect = new DatabaseConnectivity();
			Connection connection = dbconnect.getConnection();
			status=updatebook(getIsbn());//updating quantity and issue

			if(status>0){
				PreparedStatement ps=connection.prepareStatement("delete from issuebooks where isbn=? and issuerid=?");
				ps.setString(1,getIsbn());
				ps.setString(2,getIssuedId());
				status=ps.executeUpdate();

			}
			connection.close();
		}catch(Exception e){System.out.println(e);}
		return (status>0 ? true:false);
	}
	public int updatebook(String isbn){
		int status=0;
		int quantity=0,issued=0;
		try{
			DatabaseConnectivity dbconnect = new DatabaseConnectivity();
			Connection connection = dbconnect.getConnection();		
			PreparedStatement ps=connection.prepareStatement("select quantity,issued from books where isbn=?");
			ps.setString(1,isbn);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				quantity=rs.getInt("quantity");
				issued=rs.getInt("issued");
			}

			if(issued>0){
				PreparedStatement ps2=connection.prepareStatement("update books set quantity=?,issued=? where isbn=?");
				ps2.setInt(1,quantity+1);
				ps2.setInt(2,issued-1);
				ps2.setString(3,isbn);
				status=ps2.executeUpdate();

			}
			connection.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

}
