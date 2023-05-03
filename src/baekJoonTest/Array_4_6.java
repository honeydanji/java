package baekJoonTest;

import java.util.Scanner;

public class Array_4_6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] A = new int[N];

		for (int d = 0; d < A.length; d++) {
			A[d] = d + 1;
		}

		for (int k = 0; k < M; k++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int temp = A[i - 1];
			A[i - 1] = A[j - 1];
			A[j - 1] = temp;
		}
		for (int a : A) {
			System.out.print(a + " ");
		}

	}

}
