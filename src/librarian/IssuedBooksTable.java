package librarian;

import java.util.Date;

public class IssuedBooksTable {
	private int id;
	private String isbn;
	private String issuerId;
	private String issuerName;
	private long issuerContactNo;
	private Date issueDate;
	
	public IssuedBooksTable(int id, String isbn, String issuerId, String issuerName, long issuerContactNo,
			Date issueDate) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.issuerId = issuerId;
		this.issuerName = issuerName;
		this.issuerContactNo = issuerContactNo;
		this.issueDate = issueDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getIssuerId() {
		return issuerId;
	}

	public void setIssuerId(String issuerId) {
		this.issuerId = issuerId;
	}

	public String getIssuerName() {
		return issuerName;
	}

	public void setIssuerName(String issuerName) {
		this.issuerName = issuerName;
	}

	public long getIssuerContactNo() {
		return issuerContactNo;
	}

	public void setIssuerContactNo(long issuerContactNo) {
		this.issuerContactNo = issuerContactNo;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	
	
	

}
