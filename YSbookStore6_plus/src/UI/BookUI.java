package UI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import Manager.BookManager;
import VO.Book;
import VO.Buy;
import VO.Users;

public class BookUI {

	private Scanner sc1 = new Scanner(System.in);
	private Scanner sc2 = new Scanner(System.in); // 넥스트 라인 빼오기
	private int choice;
	private boolean flag = true; // 프로그램 동작 여부 확인
	private BookManager bm = new BookManager();
	private String loginId;// 로그인아이디 요걸로 계속 아이디 로그인 적용
	private String loginPw;
	
	
	public BookUI() {

		while (flag) {
			if (loginId == null) {// 로그인을 하지않은 경우
				firstMenu();// 첫 로그인 화면
				choice = sc1.nextInt();// 사용자 선택

				switch (choice) {
				case 1: // 관리자 로그인
					System.out.print("아이디: ");
					String adminid = sc2.nextLine();
					System.out.print("비밀번호: ");
					String adminpw = sc2.nextLine();
					if (bm.loginAdmin(adminid, adminpw)) {
						System.out.println("[ 관리자로 접속했습니다. ]");
						loginId = "admin";
					} else {
						System.out.println("아이디와 비밀번호가 맞지 않습니다.");
					}
					break;

				case 2:// 회원 로그인
					Users loginUsers = bm.loginUsers(checkUsers());
					if (loginUsers == null) {
						System.out.println("존재하지않는 계정입니다.");
					} else {
						loginId = loginUsers.getUserid();
						System.out.println("[ " + loginId + "님 접속을 환영합니다! ]");
					}
					break;

				case 3:// 회원 가입
					Users u = makeUsers();
					if (bm.insertUsers(u)) {
						loginId = u.getUserid();// 로그인 시켜줌
						System.out.println("등록성공");
					} else {
						System.out.println("등록실패. 아이디를 다시입력하세요.");
					}
					break;
				}

			} else if (loginId == "admin") { // 관리자 로그인을 한 경우
				AdminMenu();
				choice = sc1.nextInt();

				switch (choice) {
				case 1: // 책 등록
					bm.insertBook(makeBook());
					System.out.println("책 등록 완료");
					break;
				case 2: // 책 수정
					updateBook();
					
					break;

				case 3: // 책 삭제
					deleteBook();
					break;

				case 4: // 책 목록(조회)
					bookShowList();
					break;
					
				case 5: // 회원 목록
					int count = 0;
					System.out.println("*****************[회원목록]*****************");
					for (Users u : bm.selectAllUsers()) {
						System.out.println(
								"아이디 : " + u.getUserid() + ", 이름 : " + u.getUsername() + ", 전화번호:" + u.getUserphone());
						count++;
					}
					System.out.println("{총 " + count + "명의 회원이 있습니다.}");
					break;
					
				case 9:// 종료
					flag = false;
					break;
					
				}

			} else {// 회원 로그인을 한 경우
				UserMenu();
				choice = sc1.nextInt();

				switch (choice) {
				case 1:// 책 조회
					bookShow();
					break;
				case 2:// 책구매 하기

					System.out.print("구매할 책 일련번호를 입력해주세요 : ");
					String bookseq = sc2.nextLine();
					
					
					minusBookCount(bookseq);

					
					break;
				case 3:// 구매 목록 보기
					buyList();
					break;

				case 9:// 종료
					flag = false;
					break;
				}
			}
		}
	}

	// 첫 메인 화면
	public void firstMenu() {
		System.out.println("=============");
		System.out.println("1.관리자 로그인");
		System.out.println("2.회원 로그인");
		System.out.println("3.회원가입");
		System.out.println("=============");
	}

	public void UserMenu() {// 회원 게시물 메뉴ㅇㅇㅇㅇ
		System.out.println("=============");
		System.out.println("1.책 조회");
		System.out.println("2.책 구매");
		System.out.println("3.구매목록");
		System.out.println("9.종료");
		System.out.println("=============");
	}

	public void AdminMenu() {// 관리자 게시물 메뉴
		System.out.println("=============");
		System.out.println("1.책 등록");
		System.out.println("2.책 수정");
		System.out.println("3.책 삭제");
		System.out.println("4.책 목록");
		System.out.println("5.회원 목록");
		System.out.println("9.종료");
		System.out.println("=============");
	}

	public void bookShowMenu() { // 책 검색메뉴
		System.out.println("======<책 조회>======");
		System.out.println("1.전체조회");
		System.out.println("2.책 제목별 조회");
		System.out.println("3.저자별 조회");
		System.out.println("4.출판사별 조회");
		System.out.println("9.뒤로가기");
		System.out.println("==================");
	}

	public Users makeUsers() {// 회원가입 메서드
		System.out.print("아이디: ");
		String userid = sc2.nextLine();
		System.out.print("비밀번호: ");
		String userpw = sc2.nextLine();
		System.out.print("이름: ");
		String username = sc2.nextLine();
		System.out.print("전화번호(000-0000-0000): ");
		String userphone = sc2.nextLine();

		return new Users(userid, userpw, username, userphone);
	}

	public Users checkUsers() {// 로그인 메서드
		System.out.print("아이디: ");
		String userid = sc2.nextLine();
		System.out.print("비밀번호: ");
		String userpw = sc2.nextLine();

		return new Users(userid, userpw, null, null);
	}

	public void bookShow() { // 책 리스트 보기
		bookShowMenu();
		choice = sc1.nextInt();

		switch (choice) {
		case 1: // 전체출력
			bookShowList();
			break;
		case 2: // 제목별
			showTitle();
			break;
		case 3: // 저자별
			showAuthor();
			break;
		case 4:// 출판사별
			showHouse();
			break;

		case 9: // 뒤로가기
			return;
		}
	}

	public void bookShowList() {
		System.out.println("**********************************[ 책 목록  ]**********************************");
		System.out.println("-----------------------------------------------------------------------------");
		for (Book b : bm.selectAllBook()) {
			System.out.println(" " + b.getBookseq() + "번 => 제목: " + b.getBookname() + " / 저자:" + b.getBookauthor()
					+ " / 출판사:" + b.getBookhouse() + " / 가격:" + b.getBookprice() + "원 / 수량:" + b.getBookcount() + "권");
		}
	}

	public Book makeBook() {// 관리자 책 등록
		System.out.print("책 제목 :");
		String bookname = sc2.nextLine();
		System.out.print("저자 :");
		String bookauthor = sc2.nextLine();
		System.out.print("출판사 :");
		String bookhouse = sc2.nextLine();
		System.out.print("가격 :");
		String bookprice = sc2.nextLine();
		System.out.print("수량 :");
		int bookcount = sc1.nextInt();

		return new Book(null, bookname, bookauthor, bookhouse, bookprice, bookcount);
	}

	public void deleteBook() {// 관리자 책 삭제
		System.out.print("책 일련번호를 입력해주세요: ");
		int bookseq = sc1.nextInt();

		int result = bm.deleteBook(bookseq);

		if (result == 1) {
			System.out.println("책 삭제성공!");
		} else {
			System.out.println("없는 일련번호 입니다.");
		}
	}

	public Buy bookBuy(String bookseq) {// 책구 매(Buy) 메서드
		
		String b = bookseq;
		return new Buy(null, loginId, b);
		
	}

	public void minusBookCount(String bookseq) { // 책 구매시 카운트

		Book b = new Book(); // 책 기본 생성자
		b.setBookseq(bookseq);

		for (Book b2 : bm.selectAllBook()) {
			if (b2.getBookseq().equals(bookseq)) {
				if (b2.getBookcount() <= 0) { //책수량 0이하로 줄이기 불가(구매불가)
					System.out.println("책 재고가 없습니다.");
					return;
				}
			}
		}
		
		bm.insertBuy(bookBuy(bookseq));
		int result = bm.minusBookCount(b);
		
		if (result != 1) {
			System.out.println("책 구매 실패. 다시 입력하세요");
		} else {
			System.out.println("책구매 완료");
		}
	}

	public void buyList() {// 구매목록

		ArrayList<HashMap> buyList = new ArrayList<HashMap>();

		buyList = bm.searchBuyList(loginId); // 구매리스트
		System.out.println(
				"**********************************[" + loginId + "님의 구매 목록 ]**********************************");
		for (HashMap b : buyList) {
			System.out.println(b);
		}
		if (buyList == null) {
			System.out.println("구매 기록이 없습니다.");
		}
	}
	
	public void updateBookMenu() {
		System.out.println("=====<책 수정>=====");
		System.out.println("1.기본 정보 수정");
		System.out.println("2.수량 수정");
		System.out.println("9.뒤로가기");
		System.out.println("================");
	}
	public void updateBook() { // 관리자 책 수정
		updateBookMenu();
		choice = sc1.nextInt();
		
		switch (choice) {
		case 1:
			updateBookis();
			break;
			
		case 2:
			System.out.print("수정할 책의 일련번호 :");
			String bookseq2 = sc2.nextLine();
			
			System.out.print("수정할 수량:");
			int bookcount = sc2.nextInt();
			
			int result2 = bm.updateBookCount(new Book(bookseq2, null, null, null, null, bookcount));
			
			break;

		case 9:
			
			return;
		}
		
	}
	
	public void updateBookis() {
		System.out.print("수정할 책의 일련번호 :");
			String bookseq = sc2.nextLine();
	
			System.out.print("수정할 책 이름:");
			String bookname = sc2.nextLine();
			System.out.print("수정할 저자:");
			String bookauthor = sc2.nextLine();
			System.out.print("수정할 출판사:");
			String bookhouse = sc2.nextLine();
			System.out.print("수정할 가격:");
			String bookprice = sc2.nextLine();
		
			int result= bm.updateBook(new Book(bookseq, bookname, bookauthor, bookhouse, bookprice, 0));
			
			if(result==1) {
	    		System.out.println("성공적으로 수정이 되었습니다.");
	    	}else {
	    		System.out.println("수정실패. 일련번호를 확인하세요");
	    	}
	}

	public void showTitle() {// 제목별 목록
		ArrayList<Book> title = new ArrayList<Book>();
		System.out.print("책 제목을 입력해주세요(키워드 가능) :");
		String b = sc2.nextLine();

		title = bm.selectTitle(b);
		int count = 0;
		System.out.println("**********************************[제목 '" + b + "'로 찾았습니다]**********************************");
		for (Book b1 : title) {
			System.out.println(" " + b1.getBookseq() + "번 => 제목:" + b1.getBookname() + " / 저자:" + b1.getBookauthor()
			+ " / 출판사:" + b1.getBookhouse() + " / 가격:" + b1.getBookprice() + "원 / 수량:" + b1.getBookcount() + "권");
			count++;
		}
		
		System.out.println("{ 검색 결과 총 "+count+"건 입니다. }");
	}

	public void showAuthor() {// 저자별 목록
		ArrayList<Book> author = new ArrayList<Book>();
		System.out.print("저자를 입력해주세요(키워드 가능) :");
		String b = sc2.nextLine();

		author = bm.selectAuthor(b);
		int count = 0;
		System.out.println("**********************************[저자  '" + b + "'로 찾았습니다]**********************************");
		for (Book b1 : author) {
			System.out.println(" " + b1.getBookseq() + "번=> 저자:" + b1.getBookauthor()+ " / 제목:" + b1.getBookname() 
			+ " / 출판사:" + b1.getBookhouse() + " / 가격:" + b1.getBookprice() + "원 / 수량:" + b1.getBookcount() + "권");
			count++;
		}
		System.out.println("{ 검색 결과 총 "+count+"건 입니다. }");
	}
	
	public void showHouse() {// 출판사별 목록
		ArrayList<Book> house = new ArrayList<Book>();
		System.out.print("출판사를 입력해주세요(키워드 가능) :");
		String b = sc2.nextLine();

		house = bm.selectHouse(b);
		int count = 0;
		System.out.println("**********************************[출판사  '" + b + "'로 찾았습니다]**********************************");
		for (Book b1 : house) {
			System.out.println(" " + b1.getBookseq()+ "번=> 출판사:" + b1.getBookhouse() + " / 제목:" + b1.getBookname() 
			+ " / 저자:" + b1.getBookauthor()+ " / 가격:" + b1.getBookprice() + "원 / 수량:" + b1.getBookcount() + "권");
			count++;
		}
		System.out.println("{ 검색 결과 총 "+count+"건 입니다. }");
	}
}
