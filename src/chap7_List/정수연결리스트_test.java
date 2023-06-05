package chap7_List;
//단순한 linked list에서 insert, delete하는 알고리즘을 코딩: 1단계

import java.util.Random;
import java.util.Scanner;

class Node1 {
	int data;
	Node1 link;

	public Node1(int element) {
		data = element;
		link = null;
	}
}

class LinkedList1 {
	Node1 first;

	public LinkedList1() {
		first = null;
	}

	public int Delete(int element) { // delete the element
		Node1 currentNode = first;
		Node1 previousNode = currentNode;
		
		while(previousNode.link != null) {
			if(currentNode.data == element) {
				previousNode.link = currentNode.link;
				currentNode = null;
				currentNode = previousNode.link;
			}else {
				previousNode = currentNode;
				currentNode = previousNode.link;
			}
		}
		return element;
	}
	
	public void Show() { // 전체 리스트를 순서대로 출력한다.
		 Node1 currentNode = first;
		    while (currentNode != null) {
		        System.out.print(currentNode.data + " ");
		        currentNode = currentNode.link;
		    }
		    System.out.println();
	}

	public void Add(int element) // 임의 값을 삽입할 때 리스트가 오름차순으로 정렬이 되도록 한다
	{
		Node1 newNode = new Node1(element);
		
		// 첫번쨰 노드 값이 비어 있으면 data와 link를 설정해준다.
		if (first == null) {
			first = newNode; // data = 4 , link = null
			// 그 다음 노드 값을 추가해줄 때
			// 첫번째 노드 값보다 작을 경우에 새로운 노드를 기존 노드 앞에 배치하고 링크를 기존 노드에 데이타로 설정해준다.
		} else if (element < first.data) { // element = 2
			newNode.link = first;
			first = newNode; // data = 2 , link = null
		} else {
			Node1 currentNode = first;
			while (currentNode.link != null && element > currentNode.link.data) {
				currentNode = currentNode.link;
			}
			newNode.link = currentNode.link;
			currentNode.link = newNode;
		}
	}

	public boolean Search(int data) { 
		boolean ox = false;
		Node1 currentNode = first;
		while(currentNode.link != null) {
			if(currentNode.data == data) {
				ox = true;
				break;
			}
			currentNode = currentNode.link; 
		}
		return ox;
		
	}
}

public class 정수연결리스트_test {
	enum Menu {
		Add("삽입"), Delete("삭제"), Show("인쇄"), Search("검색"), Exit("종료");

		private final String message; // 표시할 문자열

		static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) { // 생성자(constructor)
			message = string;
		}

		String getMessage() { // 표시할 문자열을 반환
			return message;
		}
	}

	// --- 메뉴 선택 ---//
	static Menu SelectMenu() {
		Scanner sc = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values()) {
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
				if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.Exit.ordinal())
					System.out.println();
			}
			System.out.print(" : ");
			key = sc.nextInt();
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());
		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Menu menu; // 메뉴
		Random rand = new Random();
		System.out.println("Linked List");
		LinkedList1 l2 = new LinkedList1();
		Scanner sc = new Scanner(System.in);
		int data = 0;
		System.out.println("inserted");
		//l2.Show();
		do {
			switch (menu = SelectMenu()) {
			case Add: // 머리노드 삽입
				data = rand.nextInt(20);
				// double d = Math.random();
				// data = (int) (d * 50);
				l2.Add(data);
				break;
			case Delete: // 머리 노드 삭제
				data = sc.nextInt();
				int num = l2.Delete(data);
				System.out.println("삭제된 데이터는 " + num);
				break;
			case Show: 
				l2.Show();
				break;
			case Search: // 회원 번호 검색
				int n = sc.nextInt();
				boolean result = l2.Search(n);
				if (result == false)
					System.out.println("검색 값 = " + n + "데이터가 없습니다.");
				else
					System.out.println("검색 값 = " + n + "데이터가 존재합니다.");
				break;
			case Exit: 
				break;
			}
		} while (menu != Menu.Exit);
	}
}
