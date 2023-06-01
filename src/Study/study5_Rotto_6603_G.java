package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class study5_Rotto_6603_G {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static Scanner sc = new Scanner(System.in);

	// 리스트로 이루어진 2차원 배열의 중복 리스트 제거하는 메소드
	public static List<List<Integer>> removeDuplicates(Integer[][] ss) {
		Set<List<Integer>> set = new HashSet<>();
		for (Integer[] array : ss) {
			if (array != null) {
				List<Integer> list = new ArrayList<>(List.of(array));
				set.add(list);
			}
		}
		return new ArrayList<>(set);
	}

	// 배열요소 중복제거 해쉬함수
	public static int[] removeDuplicates(int[] arr) {

		HashSet<Integer> set = new HashSet<>();

		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}

		int[] result = new int[set.size()];
		int index = 0;

		for (int num : set) {
			result[index++] = num;
		}

		return result;
	}

	// n개 중에서 r개를 뽑아서 만들수 있는 집합의 경우의 수를 구하는 메서드
	public static BigInteger calculateCombination(int n, int r) {
		if (n < r) {
			throw new IllegalArgumentException("n이 r보다 작으면 안된다.");
		}

		BigInteger numerator = factorial(n);
		BigInteger denominator = factorial(r).multiply(factorial(n - r));
		return numerator.divide(denominator);
	}

	private static BigInteger factorial(int num) {
		BigInteger fact = BigInteger.ONE;
		for (int i = 1; i <= num; i++) {
			fact = fact.multiply(BigInteger.valueOf(i));
		}
		return fact;
	}

	public static void main(String args[]) throws IOException {
		
		// 집합 크기 설정
		while (true) {
			int n = sc.nextInt();
			System.out.println();
			if (n == 0) {
				break;
			}
			
			int[] s = new int[n];
			
			// list를 저장하는 2차원 배열
			Integer[][] ss = new Integer[calculateCombination(n, 6).intValue()][6];

			// 집합(배열) s에 요소를 입력.
			for (int i = 0; i < s.length; i++) {
				s[i] = sc.nextInt();
			}

			int count = 0; // 출력된 경우의 수 카운트

			while (count < calculateCombination(n, 6).intValue()) {
				List<Integer> list = new ArrayList<>();

				while (list.size() < 6) {
					int randomNumber = ((int) Math.floor(Math.random() * s.length));
					int randomElement = s[randomNumber];
					if (!list.contains(randomElement)) {
						list.add(randomElement);
					}
				}

				Collections.sort(list);

				// 중복이 없는 경우에만 저장하고 카운트 증가
				if (!containsList(ss, list)) {
					ss[count] = list.toArray(new Integer[0]);
					count++;
				}
			}

			// 배열 리스트 정렬
			Arrays.sort(ss, (a, b) -> {
	            for (int i = 0; i < a.length; i++) {
	                if (a[i] != b[i]) {
	                    return Integer.compare(a[i], b[i]);
	                }
	            }
	            return 0;
	        });
			
			// 중복을 제거한 2차원 배열 출력
			for (Integer[] list : ss) {
				//System.out.println();
				Arrays.toString(list);
				for(int d : list) {
					System.out.print(d + " ");
				}
				System.out.println();
			}
		}
	}

	// 2차원 배열에 중복 리스트가 있는지 확인하는 메서드
	private static boolean containsList(Integer[][] array, List<Integer> list) {
		for (Integer[] arr : array) {
			if (Arrays.equals(arr, list.toArray(new Integer[0]))) {
				return true;
			}
		}
		return false;
	}
}