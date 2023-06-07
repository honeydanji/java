package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class study6_Parrot_14713 {
	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		List<String[]> parrot = new ArrayList<>();
		int n = Integer.parseInt(bf.readLine());

		for (int i = 0; i < n; i++) {
			String s = bf.readLine();
			parrot.add(i, s.split(" "));
		}
		/*
		 * List의 index 유무 parrot.add(s.split(" "))는 새로운 배열을 리스트의 맨 끝에 추가. parrot.add(i,
		 * s.split(" "))는 새로운 배열을 특정 인덱스에 삽입하고 기존의 요소들을 뒤로 이동.
		 */

		// 앵무새가 말한 문장을 스택으로 저장하기 위해 변수 선언
		Stack<String> sss = new Stack<>();
		// 입력받은 앵무새 말을 공백을 기준으로 나눈다. 문장 > 단어
		String[] ssss = bf.readLine().split(" ");

		// 문장을 단어로 해서 스택에 저장
		for (int i = 0; i < ssss.length; i++) {
			sss.push(ssss[i]);
		}

		int count = 0;
		// 각각의 앵무새들이 말한 단어를 스택에 쌓여 있는 단어와 비교한다.
		// 모든 단어를 검사해서 스택이 비어지면 탈출한다.
		// 스택이 비어지지 않으면 탈출을 하지 못한다. 해결법은?
		while (true) {
			count++;
			for (String[] pp : parrot) {
				for (String ppp : pp) {
					if (sss.peek().equals(ppp)) {
						sss.pop();
						if (sss.empty()) {
							break;
						}
					}
				}
				if (sss.empty()) {
					break;
				}
			}

			if (sss.empty()) {
				System.out.println("Possible");
				break;
			}else if(count > ssss.length) {
				System.out.println("Impossible");
				break;
			}
		}
	}
}
// 예를들어 2번 요소가 1번 요소보다 먼저 뽑히면 반복문을 탈출하고 Impossible을 출력한다. 
/*
 * 최종문장을 각 배열의 요소를 비교할 때 순서를 지켜야 한다. 
 * 비교하는 단어 중간에 다른 단어과 와도 상관은 없다.
 * 하지만 각각의 문장의 순서는 정확해야한다.
 * 그럼 어떻게 순서를 체크할 수 있을까?
 * 일단 pop()가 실행될 때 마다 
 * */
