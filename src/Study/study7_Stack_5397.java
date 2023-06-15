package Study;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class study7_Stack_5397 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 테스트 case 입력
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			List<String> list = new ArrayList<>();
			String s = sc.nextLine();
			String[] ss = s.split("");
			for (int k = 0; k < ss.length; k++) {
				list.add(ss[k]);
			}
			int j = 0;
			String temp;
			// 문자열 정렬
			while(true) {
				switch (list.get(j)) {
				case "<":
					if ("<" == list.get(0)) { // 제일 처음이면 어떤 값이 오든 의미가 없다.
						list.remove(j);
						break;
					}else{
						list.remove(j);
						temp = list.get(j-1);
						break;
					}
				case ">":
					if (">" == list.get(0)) {
						list.remove(j);
						break;
					}else {
						
						break;
					}
				case "-":
					if (">" == list.get(0)) {
						list.remove(j);
						break;
					}else {
						
						break;
					}
				default:
					j++;
				}
			}
			
			// 정렬된 문자열 출력
			System.out.println(list);
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