package chap11_HashAlgorithm;

import java.util.Comparator;
import java.util.Scanner;

//체인법에 의한 해시

class SimpleObject5_p {
	static final int NO = 1;
	static final int NAME = 2;
	String no; // 회원번호
	String name; // 이름
	
	public SimpleObject5_p(String sno, String sname) {
		this.no = sno;
		this.name = sname;
	}
	
	public SimpleObject5_p() {
		this.no = null;
		this.name = null;
	}
	
	public String toString() {
		return "(" + no + ")" + name;
	}
	
	// 회원번호로 순서를 매기는 comparator
	public static final Comparator<SimpleObject5> NO_ORDER = new NoOrderComparator();
	
	private static class NoOrderComparator implements Comparator<SimpleObject5>{
		public int compare(SimpleObject5_p d1, SimpleObject5_p d2) {
			return d1.no.compareTo(d2.no);
		}
	}
	
	// 이름으로 순서를 매기는 comparator
	public static final Comparator<SimpleObject5> NAME_ORDER = new NameOrderComparator();
	
	private static class NameOrderComparator implements Comparator<SimpleObject5_p>{
		public int compare(SimpleObject5_p d1, SimpleObject5_p d2) {
			return d1.name.compareTo(d2.name);
		}
	}
	
	void scanData(String guide, int sw) {
		Scanner stdIn = new Scanner(System.in);
		System.out.println(guide + "할 데이터를 입력하세요: ");
		if ((sw & NO) == NO) {
			System.out.println("번호: ");
			no = stdIn.next();
		}
		if ((sw & NAME) == NAME) {
			System.out.println("이름: ");
			name = stdIn.next();
		}
	}
}

class ChainHash5_p{
	
	class Node2{
		private SimpleObject5_p data;
		private Node2 next;
		
		public Node2(SimpleObject5_p s) {
			this.data = s;
			this.next = null;
		}
		
		Node2(SimpleObject5_p s, Node2 p){
			this.data = s;
			this.next = p;
		}
		
		Node2() {
			this.data = null;
			this.next = null;
		}
		
		public int hashCode() {
			int hash = this.data.hashCode();
			hash = 31 * hash;
			hash = hash * hash;
			return hash;
		}
		
		private int size;
		private Node2[] table;
		
		
	}
}

public class 객체체인해시2_Practice1{
	// enum : 열거형 객체
	enum Menu{
		Add("삽입"), Delete("삭제"), Search("검색"), Show("출력"), Exit("종료");
		
		private final String message;
		
		static Menu MenuAt(int idx) {
			for(Menu m : Menu.values())
				if(m.ordinal() == idx)
					return m;
			return null;
		}
		
		Menu(String string){
			message = string;
		}
		
		String getMessasge() {
			return message;
		}
	}
	
	static Menu SelectMenu_p() {
		Scanner sc = new Scanner(System.in);
		int key;
		do {
			for(Menu m : Menu.values()){
				System.out.printf("(%d) %s ", m.ordinal(), m.getMessasge());
				if((m.ordinal() % 3) == 2 && m.ordinal() != Menu.Exit.ordinal())
					System.out.println();
			}
			System.out.println(" : ");
			key = sc.nextInt();
		} while(key < Menu.Add.ordinal() || key > Menu.Exit.ordinal()); 
		return Menu.MenuAt(key);
	}
	
	
	
	public static void main(String[] args) {
		Menu menu; // Menu 클래스는 이전 GUI 프레임워크인 Java의 AWT(Abstract Window Toolkit)의 일부
		Scanner stdIn = new Scanner(System.in);
		ChainHash5_p hash = new ChainHash5_p(15);
		SimpleObject5_p data;
		int select = 0, result = 0;
		do {
			switch (menu = SelectMenu_p()) {
			case Add:
				data = new SimpleObject5_p();
				data.scanData("삽입", SimpleObject5_p.NO | SimpleObject5_p.NAME);
				result = hash.add(data, SimpleObject5_p.NO_ORDER);
				if (result == 1)
					System.out.println(" 중복 데이터가 존재한다.");
				else
					System.out.println(" 입력 처리됌");
				break;
			case Delete:
				data = new SimpleObject5_p();
				data.scanData("삭제", SimpleObject5_p.NO);
				result = hash.delete(data, SimpleObject5_p.NO_ORDER);
				if(result == 1)
					System.out.println("삭제 처리");
				else
					System.out.println("삭제 데이터가 없음");
				break;
			case Search:
				data = new SimpleObject5_p();
				data.scanData("검색", SimpleObject5_p.NO);
				result = hash.search(data, SimpleObject5_p.NO_ORDER);
				if (result == 1)
					System.out.println("검색 데이터가 존재한다.");
				else
					System.out.println("검색 데이터가 없음");
				break;
			case Show:
				hash.dump();
				break;
			}
		}while (menu != Menu.Exit);
	}

	
}
