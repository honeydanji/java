package chap5_Recursive_Algorithm;

import java.util.Scanner;

public class Recur {
	static void recur(int n) {
		if (n > 0) {
			System.out.println("recur(" + n +  "- 1)");
			recur(n - 1);
			System.out.println(n);
			System.out.println("recur(" + n +  "- 2)");
			recur(n - 2);
		}

	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
	}
}
