package DAO;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import VO.Book;
import VO.Buy;
import VO.Users;

public class BookDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	public boolean insertUsers(Users u) { // 회원 등록
		boolean result = true;

		SqlSession session = factory.openSession();
		Mapper mapper = session.getMapper(Mapper.class);

		try {
			mapper.insertUsers(u);
			session.commit(); // insert니까 커밋해주기
		} catch (Exception e) {
			e.printStackTrace();
			// session.rollback();
			return false;
		}finally {
			session.close();
		}
		return result;
	}

	public Users loginUsers(Users u) { // 로그인
		Users result = null;

		SqlSession session = factory.openSession();
		Mapper mapper = session.getMapper(Mapper.class);

		try {
			result = mapper.loginUsers(u);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.close();
		}
		return result;
	}

	public ArrayList<Book> selectAllBook() { // 책 리스트보기
		ArrayList<Book> bList = new ArrayList<>();

		SqlSession session = factory.openSession();
		Mapper mapper = session.getMapper(Mapper.class);

		try {
			bList = mapper.selectAllBook();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.close();
		}

		return bList;
	}

	public void insertBook(Book b) { // 관리자가 책 등록하기
		SqlSession session = factory.openSession();
		Mapper mapper = session.getMapper(Mapper.class);

		try {
			mapper.insertBook(b);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}

	}

	public ArrayList<Users> selectAllUsers() { // 회원 리스트보기
		ArrayList<Users> uList = new ArrayList<>();

		SqlSession session = factory.openSession();
		Mapper mapper = session.getMapper(Mapper.class);

		try {
			uList = mapper.selectAllUsers();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.close();
		}

		return uList;
	}

	public int deleteBook(int bookseq) { // 관리자 책삭제

		SqlSession session = factory.openSession();
		Mapper mapper = session.getMapper(Mapper.class);
		
		
		int result = mapper.deleteBook(bookseq);

		session.commit();
		session.close();

		return result;
	}

	public void insertBuy(Buy b) { // 회원이 책 구매하기

		SqlSession session = factory.openSession();
		Mapper mapper = session.getMapper(Mapper.class);

		try {

			mapper.insertBuy(b);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}

	}

	public int minusBookCount(Book b) {// 책 수량 마이너스

		SqlSession session = factory.openSession();
		Mapper mapper = session.getMapper(Mapper.class);

		int result = mapper.minusBookCount(b);

		session.commit();
		session.close();

		return result;

	}

	public ArrayList<HashMap> searchBuyList(String userid) {// 책 구매 목록
		ArrayList<HashMap> buyList = new ArrayList<HashMap>();

		SqlSession session = factory.openSession();
		Mapper mapper = session.getMapper(Mapper.class);

		buyList = mapper.searchBuyList(userid);
		session.close();

		return buyList;
	}

	public int updateBook(Book b) {// 관리자 책 수정
		SqlSession session = factory.openSession();
		Mapper mapper = session.getMapper(Mapper.class);
		int result = 0;

		try {
			result = mapper.updateBook(b);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}

		return result;

	}
	
	public int updateBookCount(Book b) {// 책수량 수정
		SqlSession session = factory.openSession();
		Mapper mapper = session.getMapper(Mapper.class);
		int result = 0;

		try {
			result = mapper.updateBookCount(b);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}

		return result;

	}
	
	
	public ArrayList<Book> selectTitle(String b) { // 책 제목별 리스트보기
		ArrayList<Book> bList = new ArrayList<>();

		SqlSession session = factory.openSession();
		Mapper mapper = session.getMapper(Mapper.class);

		try {
			bList = mapper.selectTitle(b);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.close();
		}

		return bList;
	}
	
	public ArrayList<Book> selectAuthor(String b) { // 저자별 리스트보기
		ArrayList<Book> bList = new ArrayList<>();

		SqlSession session = factory.openSession();
		Mapper mapper = session.getMapper(Mapper.class);

		try {
			bList = mapper.selectAuthor(b);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.close();
		}

		return bList;
	}
	public ArrayList<Book> selectHouse(String b) { // 출판사별 리스트보기
		ArrayList<Book> bList = new ArrayList<>();

		SqlSession session = factory.openSession();
		Mapper mapper = session.getMapper(Mapper.class);

		try {
			bList = mapper.selectHouse(b);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.close();
		}

		return bList;
	}

}
