package Study;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class study5_Queue_1966 {
	public static Scanner sc = new Scanner(System.in);
	public static Queue<Integer> Q0, Q1, Q2 = new LinkedList<>();

	public static void main(String args[]) {
		// 테스트 케이스 수 입력 == 배열의 수
		int n = sc.nextInt();
		int[][] Test = new int[n][2];
		int[] Test0 = null;
		int[] Test1 = null;
		int[] Test2 = null;

		for (int i = 0; i < Test.length; i++) {
			for (int j = 0; j < Test[0].length; j++) {
				Test[i][j] = sc.nextInt();
			}
			switch (i) {
			case 0:
				Test0 = new int[Test[i][0]];
				break;
			case 1:
				Test1 = new int[Test[i][0]];
				break;
			case 2:
				Test2 = new int[Test[i][0]];
				break;
			}
			for (int k = 0; k < Test[i][0]; k++) {
				switch (i) {
				case 0:
					Test0[k] = sc.nextInt(); // 우선순위
					break;
				case 1:
					Test1[k] = sc.nextInt(); // 우선순위
					break;
				case 2:
					Test2[k] = sc.nextInt(); // 우선순위
					break;
				}
			}
		}

		for (int c = 0; c < Test1.length; c++) {
			for (int v = 1; v < Test1.length; v++) {
				if (Test1[c] < Test1[v]) {
					int temp = Test1[v];
					Test1[v] = Test1[c];
					Test1[c] = temp;
				}
			}
		}

//		for (int c = 0; c < Test1.length/2; c++) {
//			if (Test1[c] < Test1[c+1]) {
//				int temp = Test1[Test1.length - 1 - c];
//				Test1[Test1.length - 1 - c] = Test1[c];
//				Test1[c] = temp;
//			}else
//				continue;
//		}

//		for(int a : Test0) {
//			System.out.print(a);
//		}
//		System.out.println();
		for (int a : Test1) {
			System.out.print(a);
		}
//		System.out.println();
//		for(int a : Test2) {
//			System.out.print(a);
//		}

//		for (int i = 0; i < n; i++) {
//			int[] TestCase = new int[sc.nextInt()];
//			searchIndex = sc.nextInt();
//			for (int j = 0; j < TestCase.length; j++) {
//				TestCase[j] = sc.nextInt();
//				Q.add(TestCase[j]);
//			}
//			while (true) {
//				if (Q.poll() == TestCase[searchIndex]) {
//					System.out.println(count);
//					break;
//				}else {
//					Q.peek();
//					count++;
//				}
//			}
//		}

	}
}

// Document : 테스트케이스의 수
// N : 문서의 개수 (1 ~ 100)
// M : 몇번째로 인쇄되었는지 궁금한 문서가 Queue에서 몇 번째에 놓여있는지를 나타내는 정수
// Importance : 중요도 (1 ~ 9)
