package baekJoonTest;

import java.util.Scanner;

public class Array_4_3 {
	  public static void main(String args[]){
	        Scanner sc = new Scanner(System.in);

	    int N = sc.nextInt();
	    int[] A = new int[N];

	    for (int i = 0; i < A.length; i++) {
	        A[i] = sc.nextInt();
	    }

	    int min = A[0];
	    int max = A[0];

	    for (int i = 1; i < A.length; i++) {
	        if (A[i] > max) {
	            max = A[i];
	        }
	        if (A[i] < min) {
	            min = A[i];
	        }
	    }

	    System.out.println(min + " " + max);
	    }

}
