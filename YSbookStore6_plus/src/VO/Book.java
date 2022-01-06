package VO;

public class Book {
	private String bookseq; //책 일련번호
	private String bookname; //책이름
	private String bookauthor; //저자
	private String bookhouse; // 출판사
	private String bookprice; //책가격
	private int bookcount; //책 수량
	
	public Book(String bookseq, String bookname, String bookauthor, String bookhouse, String bookprice, int bookcount) {
		super();
		this.bookseq = bookseq;
		this.bookname = bookname;
		this.bookauthor = bookauthor;
		this.bookhouse = bookhouse;
		this.bookprice = bookprice;
		this.bookcount = bookcount;
	}

	public Book() {
		super();
	}

	public String getBookseq() {
		return bookseq;
	}

	public void setBookseq(String bookseq) {
		this.bookseq = bookseq;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getBookauthor() {
		return bookauthor;
	}

	public void setBookauthor(String bookauthor) {
		this.bookauthor = bookauthor;
	}

	public String getBookhouse() {
		return bookhouse;
	}

	public void setBookhouse(String bookhouse) {
		this.bookhouse = bookhouse;
	}

	public String getBookprice() {
		return bookprice;
	}

	public void setBookprice(String bookprice) {
		this.bookprice = bookprice;
	}

	public int getBookcount() {
		return bookcount;
	}

	public void setBookcount(int bookcount) {
		this.bookcount = bookcount;
	}

	@Override
	public String toString() {
		return "책 일련번호=" + bookseq + ", 책이름=" + bookname + ", 책저자=" + bookauthor + ", 출판사="
				+ bookhouse + ", 책 가격=" + bookprice + ", 책 수량=" + bookcount;
	}
	
	


}
