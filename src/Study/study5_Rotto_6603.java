package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class study5_Rotto_6603 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static Scanner sc = new Scanner(System.in);
	// static Random rd = new Random();

	public static void main(String args[]) throws IOException {
		// StringTokenizer st = new StringTokenizer(bf.readLine());

		// 집합 크기 설정
		// int n = Integer.parseInt(st.nextToken());
		int n = sc.nextInt();
		int[] s = new int[n];

		for (int i = 0; i < s.length; i++) {
			s[i] = sc.nextInt();
		}

		for (int i = 0; i < 6; i++) {
			int[] arr = new int[6];
			for (int j = 0; j < 6; j++) {
				arr[j] = ((int) Math.floor(Math.random() * s.length + 1));
			}
			LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>( Arrays.asList(arr) );
			Arrays.sort(arr);
			for (int a : arr) {
				System.out.print(a + " ");
			}
			System.out.println();
		}

		// 집합 생성
//		List<Integer> list = new ArrayList<>();
//		int[] s = new int[list.size()];
//		
//		for (int i = 0; i < n; i++) {
//			list.add(sc.nextInt());
//			s[i] = list.get(i);
//		}
//		
//		List<Integer>[][] arr = new ArrayList[0][6];
//		
//		Arrays.sort(s);
//		
//		for(int j : s) {
//			System.out.println(s); 
//		}
		
		
		//참고
		//https://seeminglyjs.tistory.com/247

	}
}

// 로또 1 ~ 49
// k개의 수를 골라 집합 s를 만든다.
// 집합 s는 오름차순 sort함수를 사용하자.
// 만들어진 집합 s에서 6개만 뽑아서 집합을 만든다.
// 그렇게 만들어진 집합의 모든 경우의 수를 출력해라.
