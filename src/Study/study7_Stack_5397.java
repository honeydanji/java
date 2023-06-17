package Study;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class study7_Stack_5397 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트 case 입력하세요.
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			List<String> list = new LinkedList<>();
			List<String> text = new ArrayList<>();
			String s = sc.next();
			String[] ss = s.split("");
			
			for (int k = 0; k < ss.length; k++) {
				list.add(ss[k]);
			}
			
			System.out.println(list.size());// 확인
			
			int j = 0;
			int x = 0; //재배열 인덱스
//			String temp; // temporary : 임시의
			// 문자열 정렬
			while(j != list.size()) {
				switch (list.get(j)) {
				case "<":
					if ("<".equals(list.get(0))) { // 제일 처음이면 어떤 값이 오든 의미가 없다. // j == 0일 때라고 가정하자.
						list.remove(j);
						break;
					}else{
						list.remove(j);
						x--;
						break;
					}
				case ">":
					if (">".equals(list.get(0))) {
						list.remove(j);
						break;
					}else {
						list.remove(j);
						if(text.get(x+1) != null) x++;
//						if(text.get(x+1) != null) x++; // 오류 수정 // 디버깅
						break;
					}
				case "-":
					if ("-".equals(list.get(0))) {
						list.remove(j);
						break;
					}else {
						list.remove(j);
						text.remove(x);
						break;
					}
				default:
					text.add(x, list.get(j));
					j++;
					x++;
				}
			}
			
			// 정렬된 문자열 출력
			System.out.println(text);
		}

	}

}

/*
 * 문제풀이 생각
 * 
 * 문자열을 입력 받고 하나씩 분리 해서 List에 넣는다. loop를 작성하고 안에 switch-case문을 넣는다. < : 나오면 두가지
 * 경우로 분리한다. 앞에 요소가 존재할 경우 : <를 지우고 다음에 입력받을 데이터의 위치를 정해준다. 앞에 요소가 존재하지 않을 경우 :
 * < 를 지우고 별다른 동작을 하지 않고 넘어간다.
 * 
 * > : 나오면 두 가지 경우로 분리한다. 앞에 요소가 존재할 경우 : >를 지우고 다음에 입력받을 데이터를 앞에 요소가 없을 경우 : >를
 * 지우고 넘어간다.
 * 
 * - : -를 지우고 앞에있는 인덱스를 제거한다.
 */

// char 배열 저장
//String str = br.readLine(); (문장 입력받아오고)
//char[] N = new char[str.length()]; (문장 길이만큼 배열 만들어주고)      
//N = str.toCharArray(); (문장을 한글자씩 배열 N에 넣어주기)