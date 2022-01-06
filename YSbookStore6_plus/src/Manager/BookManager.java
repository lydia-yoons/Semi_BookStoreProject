package Manager;

import java.util.ArrayList;
import java.util.HashMap;

import DAO.BookDAO;
import VO.Book;
import VO.Buy;
import VO.Users;

public class BookManager {

	private ArrayList<Book> bList = new ArrayList<>();
	private ArrayList<Users> uList = new ArrayList<>();
	private BookDAO dao = new BookDAO();
	private static final String ADMIN_ID = "admin"; // �����ھ��̵�
	private static final String ADMIN_PW = "admin"; // �����ں��

	public boolean insertUsers(Users u) {// ȸ�� ���� �޼���
		boolean result = false;
		result = dao.insertUsers(u);

		return result;
	}

	public Users loginUsers(Users u) {// ȸ���α��� �޼���
		Users result = null;

		result = dao.loginUsers(u);

		return result;
	}

	public boolean loginAdmin(String id, String pw) { // ������ �α��� �޼���
		if (id.equals(ADMIN_ID) && pw.equals(ADMIN_PW)) {
			return true;
		}
		return false;
	}

	public ArrayList<Book> selectAllBook() { // å ��ü ����Ʈ ����

		bList = dao.selectAllBook();

		return bList;
	}

	public void insertBook(Book b) { // å ����ϱ�
		dao.insertBook(b);
	}

	public ArrayList<Users> selectAllUsers() { // ȸ�� ��ü ����Ʈ ����

		uList = dao.selectAllUsers();

		return uList;
	}

	public int deleteBook(int bookseq) {// å ����
		int result = 0;

		result = dao.deleteBook(bookseq);

		return result;
	}

	public void insertBuy(Buy b) { // å��� buy���̺� insert
		dao.insertBuy(b);
	}

	public int minusBookCount(Book b) {// å ���� ����(����)
		int result = 0;

		result = dao.minusBookCount(b);

		return result;
	}

	public ArrayList<HashMap> searchBuyList(String userid) {
		ArrayList<HashMap> buyList = new ArrayList<HashMap>();

		buyList = dao.searchBuyList(userid);

		return buyList;

	}

	public int updateBook(Book b) {// ������ å ����
		int result = 0;

		result = dao.updateBook(b);

		return result;
	}
	
	public int updateBookCount(Book b) {// ������ å ���� ����
		int result = 0;

		result = dao.updateBookCount(b);

		return result;
	}
	
	public ArrayList<Book> selectTitle(String b) { // å ���� ����Ʈ ����
		bList = dao.selectTitle(b);
		return bList;
	}
	public ArrayList<Book> selectAuthor(String b) { // ���ں� ����Ʈ ����
		bList = dao.selectAuthor(b);
		return bList;
	}
	public ArrayList<Book> selectHouse(String b) { // ���ǻ纰 ����Ʈ ����
		bList = dao.selectHouse(b);
		return bList;
	}



}
