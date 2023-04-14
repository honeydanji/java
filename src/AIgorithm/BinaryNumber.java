package AIgorithm;

import java.util.Scanner;

public class BinaryNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("수를 입력해주세요 : ");
		int a = sc.nextInt();
		System.out.print("이진수변환(반대) : ");
		int[] arr = new int[1000];
		
//		for(int i = 1; ; i++) {
//			if(a % 2 == 1) {	//홀수
//				arr[i] = (a % 2);
//			}else if(a % 2 == 0) { //짝수
//				arr[i] = 0;
//			}else if(a <= 1) {
//				arr[i] = a;
//				break;
//			}
//			a = a / 2;
//			System.out.println(arr[i]);
			
			

			for(int i = 0; ; i++) {
				if(a <= 1) {	//홀수
					arr[i] = 1;
					System.out.println(arr[i]);
					break;
				}else if(a % 2 == 0) { //짝수
					arr[i] = 0;
					//arr[i+1] = 0;
				}else if(a % 2 == 1) {
					arr[i] = 1; // (a % 2)
				}
				a = a / 2;
				System.out.print(arr[i]);
		}
			
	}
}
// 이진수 변환은 잘된다.
// 정수 0은 출력이 안된다.
// 배열이 반대로 출력된다.
