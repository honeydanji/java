package AIgorithm;

import java.util.Scanner;

public class Minus {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		
		System.out.println("첫번째 수를 입력해주세요 : ");
		int score = sc.nextInt();
		int a = score;
		
		System.out.println("두번째 수를 입력해주세요 : ");
		int b; 
		b = sc.nextInt();
		
		System.out.println("a-b" + "="+ (a-b));
		
	}

}
