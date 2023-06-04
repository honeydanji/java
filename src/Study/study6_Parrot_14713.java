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
		int count = 0;
		
		for(int i = 0; i < n; i++) {
			String s = bf.readLine();
			parrot.add(i, s.split(" "));
		}
		/* List의 index 유무
		 *  parrot.add(s.split(" "))는 새로운 배열을 리스트의 맨 끝에 추가.
		 *  parrot.add(i, s.split(" "))는 새로운 배열을 특정 인덱스에 삽입하고 기존의 요소들을 뒤로 이동.
		 * */ 
		
		// 앵무새 말
		Stack<String> sss = new Stack<>();
		String[] ssss = bf.readLine().split(" "); 		
		
		for(int i = 0; i < ssss.length; i++) {
			sss.push(ssss[i]);
		}
		while(true) {
			for(String[] pp : parrot) {
				for(String ppp : pp) {
					if(sss.peek().equals(ppp)) {
						sss.pop();
						if(sss.empty()) {
							break;
						}
					}
				}
				if(sss.empty()) {
					break;
				}
			}
			if(sss.empty()) {
				System.out.println("Possible");
				System.out.println(count);
				break;
			}	
		}
//		문장을 char배열에 저장한 후에 최종문장의 char배열을 하나하나 전부 비교하는 방식
//		Scanner sc = new Scanner(System.in);
//		List<char[]> parrot = new ArrayList<>();
//
//		for (int i = 0; i < sc.nextInt(); i++) { // sc.nextInt() = 앵무새 마리수
//			String par = sc.next();
//			parrot.add(i, par.toCharArray());
//		}
//
//		System.out.println(parrot.get(0));

	}
}

// 앵무새 마리수 
// 1번 앵무새 : 영어 문장
// 2번 앵무새 : 영어 문장
// 3번 앵무새 : 영어 문장
// 모든 앵무새가 말한 영어 문장에 속해 있는 단어들의 조합.
// 특징 : 문당이 순서의 상관없이 단어들로 이루어져 있다.
// 그럼 어떻게 푸는 것이 좋을까?
// 일단은 각각의 앵무새들이 말하는 영어문장을 char or String 어떤 것으로 받을지 정하자.
// 입력된 영어 문장이 배열, 리스트, 스택, 큐 등등 여러가지 방식으로 저장해보자
// 각각의 문장들속에 있는 공백도 요소중에 하나로 판단한다.
// 공백을 신겨써야 하므로 String보다는 char가 좋을 듯하다.

// 앵무새 3마리가 말하는 문장을 공백을 포함해서 전부 char타입의 배열로 저장한다.
// 마지막에 완성된 문장을 입력한다.
// 완성된 문장을 스택타입으로 리스트에 저장한다.
// 하나씩 꺼내서 3개의 문장과 비교후에 중복된 값이 존재하면 하나씩 제거한다.
// 모든 루프를 돌았을 때 스택이 비어 있으면 possible을 출력한다.
