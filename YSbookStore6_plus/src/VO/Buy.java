package VO;

public class Buy {
	private String buyseq; //���� �Ϸù�ȣ(��������ȣ)
	private String userid; // ȸ�����̵�
	private String bookseq; //å �Ϸù�ȣ(������ȣ)
	
	
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
		return "���Ź�ȣ=" + buyseq + ", ���̵�=" + userid + ", å �Ϸù�ȣ=" + bookseq;
	}
	
	
	

}
