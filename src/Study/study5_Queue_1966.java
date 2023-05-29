package Study;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class study5_Queue_1966 {
	public static Scanner sc = new Scanner(System.in);
	public static Queue<int[]> Q0, Q1, Q2 = new LinkedList<>();

	
	 public static void sort(Integer[] array) {
		 int n = array.length;
	        boolean swapped;

	        for (int i = 0; i < n - 1; i++) {
	            swapped = false;
	            for (int j = 0; j < n - i - 1; j++) {
	                if (array[j] > array[j + 1]) {
	                    // Swap array[j] and array[j + 1]
	                    int temp = array[j];
	                    array[j] = array[j + 1];
	                    array[j + 1] = temp;
	                    swapped = true;
	                }
	            }
	            if (!swapped) {
	                break;
	            }
	        }
	    }
	
	public static void main(String args[]) {
		// 테스트 케이스 수 입력 == 배열의 수
		int n = sc.nextInt();
		int[][] Test = new int[n][2];
		Integer[] Test0 = null;
		Integer[] Test1 = null;
		Integer[] Test2 = null;

		for (int i = 0; i < Test.length; i++) {
			for (int j = 0; j < Test[0].length; j++) {
				Test[i][j] = sc.nextInt();
			}
			switch (i) {
			case 0:
				Test0 = new Integer[Test[i][0]];
				break;
			case 1:
				Test1 = new Integer[Test[i][0]];
				break;
			case 2:
				Test2 = new Integer[Test[i][0]];
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
		
		for(int a : Test0) {
			System.out.print(a);
		}
		System.out.println();
		for (int a : Test1) {
			System.out.print(a);
		}
		System.out.println();
		for(int a : Test2) {
			System.out.print(a);
		}
		
		sort(Test0);
		sort(Test1);
		sort(Test2);
		
		System.out.println();
		for(int a : Test0) {
			System.out.print(a);
		}
		System.out.println();
		for (int a : Test1) {
			System.out.print(a);
		}
		System.out.println();
		for(int a : Test2) {
			System.out.print(a);
		}

	}
}





// Document : 테스트케이스의 수
// N : 문서의 개수 (1 ~ 100)
// M : 몇번째로 인쇄되었는지 궁금한 문서가 Queue에서 몇 번째에 놓여있는지를 나타내는 정수
// Importance : 중요도 (1 ~ 9)
