package Study;

import java.util.*;

public class twoWeek_baekJoonTest_2470 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> sc2 = new ArrayList<>();

		int N = sc.nextInt(); // 용액의 수
		int[] arr = new int[N];
		int ij = 0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i != j && i < j) {
					ij = arr[i] + arr[j];
					if (ij < 0) {
						ij = -(ij);
						sc2.add(ij);
					} else {
						sc2.add(ij);
					}
				}
			}
		}

		Collections.sort(sc2);

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (sc2.get(0) == -(arr[i] + arr[j]) && i < j) {
					System.out.println(arr[i] + " " + arr[j]);
					break;
				}
			}
		}

	}
}

//if(i == 3 && j == 4) {
//Collections.sort(sc2);
//if(sc2.get(0) == ij) {
//	System.out.println(arr[i] + " " + arr[j]);
//}
//}
//System.out.print(arr[i] +" ," + arr[j]);
//System.out.println(": "+ ij + " ");

//for (int i = 0; i < arr.length; i++) {
//	if(i == arr.length-1) {
//		break;
//	}
//	ij = arr[i] + arr[i + 1];
//	if (ij < 0) {
//		ij = -(ij);
//		sc2.add(ij);
//	} else {
//		sc2.add(ij);
//	}
//
//}
