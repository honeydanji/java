package baekJoonTest;

import java.util.Scanner;

public class Array_4_2 {
	 public static void main(String args[]){
	        Scanner sc = new Scanner(System.in);
			
			int N = sc.nextInt();
			int[] A = new int[N];
			int X = sc.nextInt();
			
			for(int i = 0; i < A.length; i++) {
				A[i] = sc.nextInt();
			}
			for(int a : A) {
				if(a < X) {
					System.out.print(a + " ");
				}
			}
	    }
}
