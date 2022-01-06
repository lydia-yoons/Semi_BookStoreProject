package DAO;

import java.util.ArrayList;
import java.util.HashMap;

import VO.Book;
import VO.Buy;
import VO.Users;

public interface Mapper {

	public Users loginUsers(Users u); // 회원로그인

	public ArrayList<Book> selectAllBook(); // 북리스트 뽑기

	public int insertUsers(Users u); // 회원가입
	
	public void insertBook(Book b); //관리자 책 등록하기
	
	public void insertBuy(Buy b); //책 구매 하기
	
	public ArrayList<Users> selectAllUsers(); //회원목록 출력하기
	
	public int deleteBook(int bookseq); //삭제하기

	public int minusBookCount(Book b);//책 수량 빼기
	
	public ArrayList<HashMap> searchBuyList(String userid); //구매 목록
	
	public int updateBook(Book b); //관리자 책 수정
	public int updateBookCount(Book b); //관리자 책 수량수정
	
	public ArrayList<Book> selectTitle(String b); // 제목별 뽑기
	public ArrayList<Book> selectAuthor(String b); // 저자별 뽑기
	public ArrayList<Book> selectHouse(String b); // 출판사별 뽑기
	
	
}
