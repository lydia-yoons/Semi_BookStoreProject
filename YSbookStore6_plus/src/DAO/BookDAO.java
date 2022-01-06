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

	public boolean insertUsers(Users u) { // ȸ�� ���
		boolean result = true;

		SqlSession session = factory.openSession();
		Mapper mapper = session.getMapper(Mapper.class);

		try {
			mapper.insertUsers(u);
			session.commit(); // insert�ϱ� Ŀ�����ֱ�
		} catch (Exception e) {
			e.printStackTrace();
			// session.rollback();
			return false;
		}finally {
			session.close();
		}
		return result;
	}

	public Users loginUsers(Users u) { // �α���
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

	public ArrayList<Book> selectAllBook() { // å ����Ʈ����
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

	public void insertBook(Book b) { // �����ڰ� å ����ϱ�
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

	public ArrayList<Users> selectAllUsers() { // ȸ�� ����Ʈ����
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

	public int deleteBook(int bookseq) { // ������ å����

		SqlSession session = factory.openSession();
		Mapper mapper = session.getMapper(Mapper.class);
		
		
		int result = mapper.deleteBook(bookseq);

		session.commit();
		session.close();

		return result;
	}

	public void insertBuy(Buy b) { // ȸ���� å �����ϱ�

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

	public int minusBookCount(Book b) {// å ���� ���̳ʽ�

		SqlSession session = factory.openSession();
		Mapper mapper = session.getMapper(Mapper.class);

		int result = mapper.minusBookCount(b);

		session.commit();
		session.close();

		return result;

	}

	public ArrayList<HashMap> searchBuyList(String userid) {// å ���� ���
		ArrayList<HashMap> buyList = new ArrayList<HashMap>();

		SqlSession session = factory.openSession();
		Mapper mapper = session.getMapper(Mapper.class);

		buyList = mapper.searchBuyList(userid);
		session.close();

		return buyList;
	}

	public int updateBook(Book b) {// ������ å ����
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
	
	public int updateBookCount(Book b) {// å���� ����
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
	
	
	public ArrayList<Book> selectTitle(String b) { // å ���� ����Ʈ����
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
	
	public ArrayList<Book> selectAuthor(String b) { // ���ں� ����Ʈ����
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
	public ArrayList<Book> selectHouse(String b) { // ���ǻ纰 ����Ʈ����
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
