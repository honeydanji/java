package baekJoonTest;

import java.util.Scanner;

public class loopTest_3_4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
			
		int sum = 0;
		// X : 총 금액, N : 물건의 종류 수, a : 물건 가격, b : 물건 개수
		int X = sc.nextInt();
		int N = sc.nextInt();
		
		for(int i = 1; i <= N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			sum += (a*b);
		}
		if(X == sum) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
	
		}
	}

}
