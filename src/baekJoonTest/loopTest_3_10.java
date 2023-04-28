package baekJoonTest;

import java.util.Scanner;

public class loopTest_3_10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if((a + b) == 0) {
				break;
			}
			System.out.println(a + b);
		}
	}

}
