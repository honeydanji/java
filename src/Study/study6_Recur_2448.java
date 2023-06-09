package Study;

import java.util.Scanner;

public class study6_Recur_2448 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		char[][] star = new char[n][n*2-1];
		
		for(int i = 0; i < star.length; i++) {
			for(int j = 0; j < star[0].length; j++) {
				if(i == 0 && j == star[i].length - star.length) {
					star[i][j] = '*';
				}
			}
			System.out.println();
		}
	}
}



// 3 * 2**k
// 행 : 3 * 2**k, 열 : (3 * 2**(k+1)) - 1
// s[3 * 2**k][(3 * 2**(k+1)) - 1]
// 입력 : 행 : 12 열 : 12 * 2 -1
// 입력 : 행 : 6 열 : 6 * 2 -1
// 입력 : 행 : n 열 : n * 2 - 1

// 조건이 2개
// 1번 조건이면 공백을 찍고
// 2번 조건이면 *을 찍는다.
// 아주 단순하게 생각해보자
