package DAO;

import java.util.ArrayList;
import java.util.HashMap;

import VO.Book;
import VO.Buy;
import VO.Users;

public interface Mapper {

	public Users loginUsers(Users u); // ȸ���α���

	public ArrayList<Book> selectAllBook(); // �ϸ���Ʈ �̱�

	public int insertUsers(Users u); // ȸ������
	
	public void insertBook(Book b); //������ å ����ϱ�
	
	public void insertBuy(Buy b); //å ���� �ϱ�
	
	public ArrayList<Users> selectAllUsers(); //ȸ����� ����ϱ�
	
	public int deleteBook(int bookseq); //�����ϱ�

	public int minusBookCount(Book b);//å ���� ����
	
	public ArrayList<HashMap> searchBuyList(String userid); //���� ���
	
	public int updateBook(Book b); //������ å ����
	public int updateBookCount(Book b); //������ å ��������
	
	public ArrayList<Book> selectTitle(String b); // ���� �̱�
	public ArrayList<Book> selectAuthor(String b); // ���ں� �̱�
	public ArrayList<Book> selectHouse(String b); // ���ǻ纰 �̱�
	
	
}
