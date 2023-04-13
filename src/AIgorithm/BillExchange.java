package AIgorithm;

import java.util.Scanner;

public class BillExchange {

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.println("값을 입력해주세요 : ");
			int a = sc.nextInt();
			
			int[] arr = {50000, 10000, 5000, 1000};
			int[][] brr = new int[4][2];
			
			for(int i=0; i < arr.length; i++) {
				brr[i][0] = (a % arr[i]);
				brr[i][1] = (a / arr[i]);
				a = brr[i][0];
				System.out.println(arr[i] + "권 : " + brr[i][1] + "장");
			}
		}
}

// 152365
