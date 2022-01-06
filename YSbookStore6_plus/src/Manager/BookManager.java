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
	private static final String ADMIN_ID = "admin"; // 관리자아이디
	private static final String ADMIN_PW = "admin"; // 관리자비번

	public boolean insertUsers(Users u) {// 회원 가입 메서드
		boolean result = false;
		result = dao.insertUsers(u);

		return result;
	}

	public Users loginUsers(Users u) {// 회원로그인 메서드
		Users result = null;

		result = dao.loginUsers(u);

		return result;
	}

	public boolean loginAdmin(String id, String pw) { // 관리자 로그인 메서드
		if (id.equals(ADMIN_ID) && pw.equals(ADMIN_PW)) {
			return true;
		}
		return false;
	}

	public ArrayList<Book> selectAllBook() { // 책 전체 리스트 보기

		bList = dao.selectAllBook();

		return bList;
	}

	public void insertBook(Book b) { // 책 등록하기
		dao.insertBook(b);
	}

	public ArrayList<Users> selectAllUsers() { // 회원 전체 리스트 보기

		uList = dao.selectAllUsers();

		return uList;
	}

	public int deleteBook(int bookseq) {// 책 삭제
		int result = 0;

		result = dao.deleteBook(bookseq);

		return result;
	}

	public void insertBuy(Buy b) { // 책사기 buy테이블 insert
		dao.insertBuy(b);
	}

	public int minusBookCount(Book b) {// 책 수량 빼기(수정)
		int result = 0;

		result = dao.minusBookCount(b);

		return result;
	}

	public ArrayList<HashMap> searchBuyList(String userid) {
		ArrayList<HashMap> buyList = new ArrayList<HashMap>();

		buyList = dao.searchBuyList(userid);

		return buyList;

	}

	public int updateBook(Book b) {// 관리자 책 수정
		int result = 0;

		result = dao.updateBook(b);

		return result;
	}
	
	public int updateBookCount(Book b) {// 관리자 책 수량 수정
		int result = 0;

		result = dao.updateBookCount(b);

		return result;
	}
	
	public ArrayList<Book> selectTitle(String b) { // 책 제목별 리스트 보기
		bList = dao.selectTitle(b);
		return bList;
	}
	public ArrayList<Book> selectAuthor(String b) { // 저자별 리스트 보기
		bList = dao.selectAuthor(b);
		return bList;
	}
	public ArrayList<Book> selectHouse(String b) { // 출판사별 리스트 보기
		bList = dao.selectHouse(b);
		return bList;
	}



}
