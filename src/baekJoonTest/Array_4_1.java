package baekJoonTest;

import java.util.Scanner;

public class Array_4_1 {
	 public static void main(String args[]) {
	        Scanner sc = new Scanner(System.in);
			
			int N = sc.nextInt();
			int sum = 0;
			int[] arr = new int[N];
			
			for(int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			
			int v = sc.nextInt();
			for(int ar : arr) {
				if(ar == v) {
					sum += 1;
				}
			}
			System.out.println(sum);
	    }

}
