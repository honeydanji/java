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

public class study5_Rotto_6603 {
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
		// int n = Integer.parseInt(st.nextToken());
		int n = sc.nextInt();
		int[] s = new int[n];

		// list를 저장하는 2차원 배열
		Integer[][] ss = new Integer[calculateCombination(n, 6).intValue()][6];

		// 집합(배열) s에 요소를 입력.
		for (int i = 0; i < s.length; i++) {
			s[i] = sc.nextInt();
		}

		
	
		for (int i = 0; i < calculateCombination(n, 6).intValue(); i++) {
			int[] arr = new int[6]; // 집합s로 만든 크기 6의 집합(배열) 선언

			for (int j = 0; j < 6; j++) {
				arr[j] = ((int) Math.floor(Math.random() * s.length + 1));
			}

			// 집합s로부터 만들어진 배열 오름차순으로 정렬
			Arrays.sort(arr);

			// 집합 s로부터 만들어진 배열의 중복요소 제거
			int[] result = removeDuplicates(arr);
			// result배열을 List타입으로 변환시켜 list에 저장
			// 왜? List는 배열처럼 크기 제한이 없기 때문에 사용이 편리하다.
			// <?> : 제네럴은 반환 타입을 적어준다.
			List<Integer> list = new ArrayList<>(Arrays.asList(Arrays.stream(result).boxed().toArray(Integer[]::new)));

			
			while (true) {
				// 제거된 부분에 새로운 요소를 넣어줘야한다.
				if (list.size() != 6) {
					for (int d = list.size(); d < 6; d++) {
						// 새로운 값을 집어 넣기 위해 집합s를 랜덤수를 이용해 넣어준다.
						list.add(d - 1, ((int) Math.floor(Math.random() * s.length + 1)));
						// 새로 넣어준 요소가 중복이 안되는 지 한번더 확인하고 중복이 있으면 과정을 반복한다.
						List<Integer> newList = list.stream().distinct().collect(Collectors.toList()); // 중복제거
						list = newList; // 중복제거된 리스트
						Collections.sort(list); // 중복 제거된 리스트 정렬
					}
				} else if (list.size() == 6) {
					ss[i] = list.toArray(new Integer[0]);
					break;
				}
			}
		}
		
		// 정수가 아닌 리스트가 요소로 이루어진 2차원 배열의 중복리스트 제거 하기.
		List<List<Integer>> uniqueLists = removeDuplicates(ss);
		
		// 중복을 제거한 2차원 배열의 크기가 6이 안나오면 나올때 까지 반복한다. 재귀?
		if (uniqueLists.size() != calculateCombination(n, 6).intValue())
			for (List<Integer> sss : uniqueLists) {
				System.out.println(sss);
			}

		
		// sss가 7개가 될 때까지 재귀를 돌리자
	}
}
