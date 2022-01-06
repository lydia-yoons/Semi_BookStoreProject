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
	private Scanner sc2 = new Scanner(System.in); // �ؽ�Ʈ ���� ������
	private int choice;
	private boolean flag = true; // ���α׷� ���� ���� Ȯ��
	private BookManager bm = new BookManager();
	private String loginId;// �α��ξ��̵� ��ɷ� ��� ���̵� �α��� ����
	private String loginPw;
	
	
	public BookUI() {

		while (flag) {
			if (loginId == null) {// �α����� �������� ���
				firstMenu();// ù �α��� ȭ��
				choice = sc1.nextInt();// ����� ����

				switch (choice) {
				case 1: // ������ �α���
					System.out.print("���̵�: ");
					String adminid = sc2.nextLine();
					System.out.print("��й�ȣ: ");
					String adminpw = sc2.nextLine();
					if (bm.loginAdmin(adminid, adminpw)) {
						System.out.println("[ �����ڷ� �����߽��ϴ�. ]");
						loginId = "admin";
					} else {
						System.out.println("���̵�� ��й�ȣ�� ���� �ʽ��ϴ�.");
					}
					break;

				case 2:// ȸ�� �α���
					Users loginUsers = bm.loginUsers(checkUsers());
					if (loginUsers == null) {
						System.out.println("���������ʴ� �����Դϴ�.");
					} else {
						loginId = loginUsers.getUserid();
						System.out.println("[ " + loginId + "�� ������ ȯ���մϴ�! ]");
					}
					break;

				case 3:// ȸ�� ����
					Users u = makeUsers();
					if (bm.insertUsers(u)) {
						loginId = u.getUserid();// �α��� ������
						System.out.println("��ϼ���");
					} else {
						System.out.println("��Ͻ���. ���̵� �ٽ��Է��ϼ���.");
					}
					break;
				}

			} else if (loginId == "admin") { // ������ �α����� �� ���
				AdminMenu();
				choice = sc1.nextInt();

				switch (choice) {
				case 1: // å ���
					bm.insertBook(makeBook());
					System.out.println("å ��� �Ϸ�");
					break;
				case 2: // å ����
					updateBook();
					
					break;

				case 3: // å ����
					deleteBook();
					break;

				case 4: // å ���(��ȸ)
					bookShowList();
					break;
					
				case 5: // ȸ�� ���
					int count = 0;
					System.out.println("*****************[ȸ�����]*****************");
					for (Users u : bm.selectAllUsers()) {
						System.out.println(
								"���̵� : " + u.getUserid() + ", �̸� : " + u.getUsername() + ", ��ȭ��ȣ:" + u.getUserphone());
						count++;
					}
					System.out.println("{�� " + count + "���� ȸ���� �ֽ��ϴ�.}");
					break;
					
				case 9:// ����
					flag = false;
					break;
					
				}

			} else {// ȸ�� �α����� �� ���
				UserMenu();
				choice = sc1.nextInt();

				switch (choice) {
				case 1:// å ��ȸ
					bookShow();
					break;
				case 2:// å���� �ϱ�

					System.out.print("������ å �Ϸù�ȣ�� �Է����ּ��� : ");
					String bookseq = sc2.nextLine();
					
					
					minusBookCount(bookseq);

					
					break;
				case 3:// ���� ��� ����
					buyList();
					break;

				case 9:// ����
					flag = false;
					break;
				}
			}
		}
	}

	// ù ���� ȭ��
	public void firstMenu() {
		System.out.println("=============");
		System.out.println("1.������ �α���");
		System.out.println("2.ȸ�� �α���");
		System.out.println("3.ȸ������");
		System.out.println("=============");
	}

	public void UserMenu() {// ȸ�� �Խù� �޴���������
		System.out.println("=============");
		System.out.println("1.å ��ȸ");
		System.out.println("2.å ����");
		System.out.println("3.���Ÿ��");
		System.out.println("9.����");
		System.out.println("=============");
	}

	public void AdminMenu() {// ������ �Խù� �޴�
		System.out.println("=============");
		System.out.println("1.å ���");
		System.out.println("2.å ����");
		System.out.println("3.å ����");
		System.out.println("4.å ���");
		System.out.println("5.ȸ�� ���");
		System.out.println("9.����");
		System.out.println("=============");
	}

	public void bookShowMenu() { // å �˻��޴�
		System.out.println("======<å ��ȸ>======");
		System.out.println("1.��ü��ȸ");
		System.out.println("2.å ���� ��ȸ");
		System.out.println("3.���ں� ��ȸ");
		System.out.println("4.���ǻ纰 ��ȸ");
		System.out.println("9.�ڷΰ���");
		System.out.println("==================");
	}

	public Users makeUsers() {// ȸ������ �޼���
		System.out.print("���̵�: ");
		String userid = sc2.nextLine();
		System.out.print("��й�ȣ: ");
		String userpw = sc2.nextLine();
		System.out.print("�̸�: ");
		String username = sc2.nextLine();
		System.out.print("��ȭ��ȣ(000-0000-0000): ");
		String userphone = sc2.nextLine();

		return new Users(userid, userpw, username, userphone);
	}

	public Users checkUsers() {// �α��� �޼���
		System.out.print("���̵�: ");
		String userid = sc2.nextLine();
		System.out.print("��й�ȣ: ");
		String userpw = sc2.nextLine();

		return new Users(userid, userpw, null, null);
	}

	public void bookShow() { // å ����Ʈ ����
		bookShowMenu();
		choice = sc1.nextInt();

		switch (choice) {
		case 1: // ��ü���
			bookShowList();
			break;
		case 2: // ����
			showTitle();
			break;
		case 3: // ���ں�
			showAuthor();
			break;
		case 4:// ���ǻ纰
			showHouse();
			break;

		case 9: // �ڷΰ���
			return;
		}
	}

	public void bookShowList() {
		System.out.println("**********************************[ å ���  ]**********************************");
		System.out.println("-----------------------------------------------------------------------------");
		for (Book b : bm.selectAllBook()) {
			System.out.println(" " + b.getBookseq() + "�� => ����: " + b.getBookname() + " / ����:" + b.getBookauthor()
					+ " / ���ǻ�:" + b.getBookhouse() + " / ����:" + b.getBookprice() + "�� / ����:" + b.getBookcount() + "��");
		}
	}

	public Book makeBook() {// ������ å ���
		System.out.print("å ���� :");
		String bookname = sc2.nextLine();
		System.out.print("���� :");
		String bookauthor = sc2.nextLine();
		System.out.print("���ǻ� :");
		String bookhouse = sc2.nextLine();
		System.out.print("���� :");
		String bookprice = sc2.nextLine();
		System.out.print("���� :");
		int bookcount = sc1.nextInt();

		return new Book(null, bookname, bookauthor, bookhouse, bookprice, bookcount);
	}

	public void deleteBook() {// ������ å ����
		System.out.print("å �Ϸù�ȣ�� �Է����ּ���: ");
		int bookseq = sc1.nextInt();

		int result = bm.deleteBook(bookseq);

		if (result == 1) {
			System.out.println("å ��������!");
		} else {
			System.out.println("���� �Ϸù�ȣ �Դϴ�.");
		}
	}

	public Buy bookBuy(String bookseq) {// å�� ��(Buy) �޼���
		
		String b = bookseq;
		return new Buy(null, loginId, b);
		
	}

	public void minusBookCount(String bookseq) { // å ���Ž� ī��Ʈ

		Book b = new Book(); // å �⺻ ������
		b.setBookseq(bookseq);

		for (Book b2 : bm.selectAllBook()) {
			if (b2.getBookseq().equals(bookseq)) {
				if (b2.getBookcount() <= 0) { //å���� 0���Ϸ� ���̱� �Ұ�(���źҰ�)
					System.out.println("å ��� �����ϴ�.");
					return;
				}
			}
		}
		
		bm.insertBuy(bookBuy(bookseq));
		int result = bm.minusBookCount(b);
		
		if (result != 1) {
			System.out.println("å ���� ����. �ٽ� �Է��ϼ���");
		} else {
			System.out.println("å���� �Ϸ�");
		}
	}

	public void buyList() {// ���Ÿ��

		ArrayList<HashMap> buyList = new ArrayList<HashMap>();

		buyList = bm.searchBuyList(loginId); // ���Ÿ���Ʈ
		System.out.println(
				"**********************************[" + loginId + "���� ���� ��� ]**********************************");
		for (HashMap b : buyList) {
			System.out.println(b);
		}
		if (buyList == null) {
			System.out.println("���� ����� �����ϴ�.");
		}
	}
	
	public void updateBookMenu() {
		System.out.println("=====<å ����>=====");
		System.out.println("1.�⺻ ���� ����");
		System.out.println("2.���� ����");
		System.out.println("9.�ڷΰ���");
		System.out.println("================");
	}
	public void updateBook() { // ������ å ����
		updateBookMenu();
		choice = sc1.nextInt();
		
		switch (choice) {
		case 1:
			updateBookis();
			break;
			
		case 2:
			System.out.print("������ å�� �Ϸù�ȣ :");
			String bookseq2 = sc2.nextLine();
			
			System.out.print("������ ����:");
			int bookcount = sc2.nextInt();
			
			int result2 = bm.updateBookCount(new Book(bookseq2, null, null, null, null, bookcount));
			
			break;

		case 9:
			
			return;
		}
		
	}
	
	public void updateBookis() {
		System.out.print("������ å�� �Ϸù�ȣ :");
			String bookseq = sc2.nextLine();
	
			System.out.print("������ å �̸�:");
			String bookname = sc2.nextLine();
			System.out.print("������ ����:");
			String bookauthor = sc2.nextLine();
			System.out.print("������ ���ǻ�:");
			String bookhouse = sc2.nextLine();
			System.out.print("������ ����:");
			String bookprice = sc2.nextLine();
		
			int result= bm.updateBook(new Book(bookseq, bookname, bookauthor, bookhouse, bookprice, 0));
			
			if(result==1) {
	    		System.out.println("���������� ������ �Ǿ����ϴ�.");
	    	}else {
	    		System.out.println("��������. �Ϸù�ȣ�� Ȯ���ϼ���");
	    	}
	}

	public void showTitle() {// ���� ���
		ArrayList<Book> title = new ArrayList<Book>();
		System.out.print("å ������ �Է����ּ���(Ű���� ����) :");
		String b = sc2.nextLine();

		title = bm.selectTitle(b);
		int count = 0;
		System.out.println("**********************************[���� '" + b + "'�� ã�ҽ��ϴ�]**********************************");
		for (Book b1 : title) {
			System.out.println(" " + b1.getBookseq() + "�� => ����:" + b1.getBookname() + " / ����:" + b1.getBookauthor()
			+ " / ���ǻ�:" + b1.getBookhouse() + " / ����:" + b1.getBookprice() + "�� / ����:" + b1.getBookcount() + "��");
			count++;
		}
		
		System.out.println("{ �˻� ��� �� "+count+"�� �Դϴ�. }");
	}

	public void showAuthor() {// ���ں� ���
		ArrayList<Book> author = new ArrayList<Book>();
		System.out.print("���ڸ� �Է����ּ���(Ű���� ����) :");
		String b = sc2.nextLine();

		author = bm.selectAuthor(b);
		int count = 0;
		System.out.println("**********************************[����  '" + b + "'�� ã�ҽ��ϴ�]**********************************");
		for (Book b1 : author) {
			System.out.println(" " + b1.getBookseq() + "��=> ����:" + b1.getBookauthor()+ " / ����:" + b1.getBookname() 
			+ " / ���ǻ�:" + b1.getBookhouse() + " / ����:" + b1.getBookprice() + "�� / ����:" + b1.getBookcount() + "��");
			count++;
		}
		System.out.println("{ �˻� ��� �� "+count+"�� �Դϴ�. }");
	}
	
	public void showHouse() {// ���ǻ纰 ���
		ArrayList<Book> house = new ArrayList<Book>();
		System.out.print("���ǻ縦 �Է����ּ���(Ű���� ����) :");
		String b = sc2.nextLine();

		house = bm.selectHouse(b);
		int count = 0;
		System.out.println("**********************************[���ǻ�  '" + b + "'�� ã�ҽ��ϴ�]**********************************");
		for (Book b1 : house) {
			System.out.println(" " + b1.getBookseq()+ "��=> ���ǻ�:" + b1.getBookhouse() + " / ����:" + b1.getBookname() 
			+ " / ����:" + b1.getBookauthor()+ " / ����:" + b1.getBookprice() + "�� / ����:" + b1.getBookcount() + "��");
			count++;
		}
		System.out.println("{ �˻� ��� �� "+count+"�� �Դϴ�. }");
	}
}
