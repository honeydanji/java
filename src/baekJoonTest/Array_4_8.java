package baekJoonTest;

import java.util.Scanner;

public class Array_4_8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[10];
		int j = 0;
		int d = 1;
		
		for (int i = 0; i < arr.length; i++) {
			int A = sc.nextInt();
			arr[i] = A;
			if(arr[i] % 42 == arr[i+1] % 42) {
				d -= 1;
			}else {
				d += 1;
			}
		}

		for(int k = 0; k < 43; k++) {
			if(arr[j] % 42 == k) {
				if(arr[j] % 42 == arr[j+1] % 42) {
					d -= 1;
				}
				j++;
				System.out.println(d);
			}
		}
		
	}

}
// 데이터 10개를 배열로 입력 받는다.
// 배열의 데이터를 전부 42로 나눈 나머지를 구한다.
// 서로 다른 값이 뭐가 있는 지 뽑아낸다.
// 뽑아 낸 값이 몇개 인지 구한다.
// 어떻게 구할건가? 
// 