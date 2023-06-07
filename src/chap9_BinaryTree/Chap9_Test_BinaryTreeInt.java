package chap9_BinaryTree;

/*
 * 23.6.7 3회차 실습 코드
 */
import java.util.Random;
import java.util.Scanner;

//정수를 저정하는 이진트리 만들기 실습
class TreeNode {
	TreeNode LeftChild;
	int data;
	TreeNode RightChild;

	public TreeNode() {
		LeftChild = RightChild = null;
	}
}

class Tree {
	TreeNode root;

	Tree() {
		root = null;
	}

	TreeNode inorderSucc(TreeNode current) {
		TreeNode temp = current.RightChild;
		if (current.RightChild != null)
			while (temp.LeftChild != null)
				temp = temp.LeftChild;
		return temp;
	}

	boolean isLeafNode(TreeNode current) {
		if (current.LeftChild == null && current.RightChild == null)
			return true;
		else
			return false;
	}

	void inorder() {
		inorder(root);
	}

	void preorder() {
		preorder(root);
	}

	void postorder() {
		postorder(root);
	}

	void inorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			inorder(CurrentNode.LeftChild);
			System.out.print(" " + CurrentNode.data);
			inorder(CurrentNode.RightChild);
		}
	}

	void preorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			System.out.print(CurrentNode.data + " ");
			preorder(CurrentNode.LeftChild);
			preorder(CurrentNode.RightChild);
		}
	}

	void postorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			postorder(CurrentNode.LeftChild);
			postorder(CurrentNode.RightChild);
			System.out.print(CurrentNode.data + " ");
		}
	}

	boolean insert(int x) {// binary search tree를 만드는 입력 => A + B * C을 tree로 만드는 방법: 입력 해결하는 알고리즘 작성 방법을 //
							// 설계하여 구현
		// root값이 없는 경우 = 비교값이 없다. 새로운 노드를 만들어줘야한다.
		if (root == null) {
			root = new TreeNode();
			root.data = x;
			return true;
		}
		return insertNode(root, x);
	}

	boolean insertNode(TreeNode currentNode, int x) {
		boolean ox = true;
		if (x < currentNode.data) {
			if (currentNode.LeftChild == null) {
				currentNode.LeftChild = new TreeNode();
				currentNode.LeftChild.data = x;
				ox = true;
			} else {
				insertNode(currentNode.LeftChild, x);
			}
		} else if (x > currentNode.data) {
			if (currentNode.RightChild == null) {
				currentNode.RightChild = new TreeNode();
				currentNode.RightChild.data = x;
				ox = true;
			} else {
				insertNode(currentNode.RightChild, x);
			}
		} else {
			ox = false;
		}

		return ox;
	}

	boolean delete(int num) {
		TreeNode parent = null;
		TreeNode current = root;

		while (current != null) {
			// 삭제하고자 하는 값이 나올 때까지 현재노드를 바꿔가면서 검사한다.
			if (num < current.data) {
				parent = current;
				current = current.LeftChild;
			} else if (num > current.data) {
				parent = current;
				current = current.RightChild;
				// 삭제할 데이터 값을 찾은 경우에 3가지 케이스로 나눠서 삭제한다.
			} else {
				// num == current.data(즉 삭제하고자 하는 값을 포함한 노드를 찾은 경우)
				
				// Case 1: 삭제할 노드가 단말 노드인 경우(자식노드 x)
				if (isLeafNode(parent)) {
					if (parent == null) {
						root = null; // 루투 노드 삭제
					} else if (parent.LeftChild == current) {
						parent.LeftChild = null;
					} else {
						parent.RightChild = null;
					}
				}
				// Case 2: 삭제할 노드가 하나의 자식을 가지는 경우
				else if (current.LeftChild == null) {
					if (parent == null) { // parent == current
						root = current.RightChild;
					} else if (parent.LeftChild == current) {
						parent.LeftChild = current.RightChild;
					} else {
						parent.RightChild = current.RightChild;
					}
				}else if (current.RightChild == null) {
					if (parent == null) {
						root = current.LeftChild;
					} else if (parent.LeftChild == current) {
						parent.LeftChild = current.LeftChild;
					} else {
						parent.RightChild = current.LeftChild;
					}
				}
				
				// Case 3: 삭제할 노드가 두개의 자식을 가지는 경우
				else {
					if()
				}
			}
		}
	}

	boolean search(int num) {

	}
}

public class Chap9_Test_BinaryTreeInt {
	enum Menu {
		Add("삽입"), Delete("삭제"), Search("검색"), InorderPrint("순차출력"), Exit("종료");

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
		Scanner stdIn = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values())
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
			System.out.print(" : ");
			key = stdIn.nextInt();
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());

		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner stdIn = new Scanner(System.in);
		Tree t = new Tree();
		Menu menu; // 메뉴
		int count = 0;
		int num;
		boolean result;
		do {
			switch (menu = SelectMenu()) {
			case Add: // 노드 삽입
				System.out.println("The number of items = ");
				count = stdIn.nextInt();
				int[] input = new int[10];
				for (int ix = 0; ix < count; ix++) {
					input[ix] = rand.nextInt(20);
				}
				for (int i = 0; i < count; i++) {
					if (t.insert(input[i]) == false)
						System.out.println("Insert Duplicated data");
				}
				break;

			case Delete: // 노드 삭제
				System.out.println("삭제할 데이터:: ");
				num = stdIn.nextInt();
				if (t.delete(num) == true)
					System.out.println("삭제 데이터 = " + num + " 성공");
				else
					System.out.println("삭제 실패");
				;
				break;

			case Search: // 노드 검색
				System.out.println("검색할 데이터:: ");

				num = stdIn.nextInt();
				result = t.search(num);
				if (result == true)
					System.out.println(" 데이터 = " + num + "존재합니다.");
				else
					System.out.println("해당 데이터가 없습니다.");
				break;

			case InorderPrint: // 전체 노드를 키값의 오름차순으로 표시
				t.inorder();
				System.out.println();
				break;
			}
		} while (menu != Menu.Exit);
	}
}
