package VO;

public class Book {
	private String bookseq; //å �Ϸù�ȣ
	private String bookname; //å�̸�
	private String bookauthor; //����
	private String bookhouse; // ���ǻ�
	private String bookprice; //å����
	private int bookcount; //å ����
	
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
		return "å �Ϸù�ȣ=" + bookseq + ", å�̸�=" + bookname + ", å����=" + bookauthor + ", ���ǻ�="
				+ bookhouse + ", å ����=" + bookprice + ", å ����=" + bookcount;
	}
	
	


}
