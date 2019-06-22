package librarian;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import database.DatabaseConnectivity;

public class IssueBookInfoUpload {
	private String isbn;
	private String issuerName;
	private String issuerId;
	private long issuerContactNo;
	public IssueBookInfoUpload(String isbn, String issuerName, String issuerId, long issuerContactNo) {
		super();
		this.isbn = isbn;
		this.issuerName = issuerName;
		this.issuerId = issuerId;
		this.issuerContactNo = issuerContactNo;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getIssuerName() {
		return issuerName;
	}
	public void setIssuerName(String issuerName) {
		this.issuerName = issuerName;
	}
	public String getIssuerId() {
		return issuerId;
	}
	public void setIssuerId(String issuerId) {
		this.issuerId = issuerId;
	}
	public long getIssuerContactNo() {
		return issuerContactNo;
	}
	public void setIssuerContactNo(long issuerContactNo) {
		this.issuerContactNo = issuerContactNo;
	}
	
	
public boolean checkBook(String isbn){
	boolean status=false;
	try{
		DatabaseConnectivity dbconnect = new DatabaseConnectivity();
		Connection connection = dbconnect.getConnection();
		PreparedStatement ps=connection.prepareStatement("select * from books where isbn=?");
		ps.setString(1,isbn);
	    ResultSet rs=ps.executeQuery();
		status=rs.next();
		connection.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}

public boolean uploadInfoToDatabase(){
	int status = 0;
	try{
		DatabaseConnectivity dbconnect = new DatabaseConnectivity();
		Connection connection = dbconnect.getConnection();
		status=updatebook(getIsbn());//updating quantity and issue
		
		if(status>0){
		PreparedStatement ps=connection.prepareStatement("insert into issuebooks(isbn,issuerId,issuerName,issuerContactNo) values(?,?,?,?)");
		ps.setString(1,getIsbn());
		ps.setString(2,getIssuerId());
		ps.setString(3,getIssuerName());
		ps.setLong(4,getIssuerContactNo());
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
		
		if(quantity > 0){
		PreparedStatement ps2=connection.prepareStatement("update books set quantity=?,issued=? where isbn=?");
		ps2.setInt(1,quantity-1);
		ps2.setInt(2,issued+1);
		ps2.setString(3,isbn);
		
		status=ps2.executeUpdate();
		}
		connection.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
	
}
