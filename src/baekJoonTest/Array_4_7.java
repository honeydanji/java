package baekJoonTest;

import java.util.Scanner;

public class Array_4_7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 
				11, 12, 13, 14, 15, 16, 17 ,18 ,19, 
				20 ,21 ,22, 23, 24, 25, 26, 27,28 ,29, 30};
		int[] B = new int[28];
		
		for (int i = 0; i < B.length; i++) {
			B[i] = sc.nextInt();
		}
		
		for(int i = 0; i < A.length; i++) {
			if(B[i] == A[j]) {
				
			}
		}
		
		

		for (int j = 0; j < A.length; j++) {
			for (int d = 1; d <= 30;) {
				d++;
				if (A[j] == d) {
					System.out.println("과제제출하지 않은 번호 : " + d);
					break;
				}

			}
		}
	}
}
// 번호는 1 ~ 30번 까지 존재한다
// 그중 2개의 번호만 빠진다.
// 일단 배열의 크기를 30으로 맞춘다.
// 배열안에 중복되지 않는 수르 28개 집어넣는다.
// 아니면 배열에 미리 1 ~ 30 데이터를 집어 넣는다.
// 들어간 배열에 있는 값을 하나씩 비교 받는다.
// 비교를 해서 배열에 값이 존재하면 false로 반환 받는다.
// false로 반환이 되면 해당 값을 출력한다.