package baekJoonTest;

import java.util.Scanner;

public class Array_4_5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] A = new int[N];
		for(int d = 1; d <= M; d++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int k = sc.nextInt();

			for (; i <= j; i++) {
				A[i-1] = k;
			}
		}
		
		for (int a : A) {
			System.out.print(a + " ");
		}
	}
}
