package librarian;

import java.util.Date;

public class BooksTable {
	private int id;
	private String isbn;
	private String bookName;
	private String authorName;
	private String publisher;
	private int quantity;
	private int issued;
	private Date addedDate;
	public BooksTable(int id, String isbn, String bookName, String authorName, String publisher, int quantity,
			int issued, Date addedDate) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.bookName = bookName;
		this.authorName = authorName;
		this.publisher = publisher;
		this.quantity = quantity;
		this.issued = issued;
		this.addedDate = addedDate;
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
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getIssued() {
		return issued;
	}
	public void setIssued(int issued) {
		this.issued = issued;
	}
	public Date getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
	
	
	
}
