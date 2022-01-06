package VO;

public class Buy {
	private String buyseq; //구매 일련번호(영수증번호)
	private String userid; // 회원아이디
	private String bookseq; //책 일련번호(고유번호)
	
	
	public Buy(String buyseq, String userid, String bookseq) {
		super();
		this.buyseq = buyseq;
		this.userid = userid;
		this.bookseq = bookseq;
		
	}

	public Buy() {
		super();
	}

	public String getBuyseq() {
		return buyseq;
	}

	public void setBuyseq(String buyseq) {
		this.buyseq = buyseq;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getBookseq() {
		return bookseq;
	}

	public void setBookseq(String bookseq) {
		this.bookseq = bookseq;
	}

	@Override
	public String toString() {
		return "구매번호=" + buyseq + ", 아이디=" + userid + ", 책 일련번호=" + bookseq;
	}
	
	
	

}
