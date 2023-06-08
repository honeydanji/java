package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class study6_polarBear_25918 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		// 괄호의 개수를 입력 받기
        int n = Integer.parseInt(bf.readLine());

        // 괄호 문자열을 입력 받기
        String input = bf.readLine();

        List<String> bear = new ArrayList<>();

        // 입력된 괄호 문자열을 괄호 단위로 분리하여 리스트에 저장
        for (int i = 0; i < input.length(); i++) {
            String bracket = input.substring(i, i + 1);
            bear.add(bracket);
        }
        
		int count = 1;
		int i = 0;
		// 리스트에 해당 괄호가 존재하면 해당 위치에 있는 인덱스 요소를 비워준다.
		// 반복문이 한번 돌 때마다 count를 증가시켜준다.
		// 비워지지 않으면 -1을 출력한다.
		while (true) {
			// 괄호의 갯수가 홀수면 절대 비워질 수 없다.
			if(bear.size() % 2 == 1) {
				System.out.println(-1);
				break;
			}
			if (bear.get(i).equals("(") && bear.get(i + 1).equals(")")) {
				bear.remove(i); // 리스트 요소가 지워지면 인덱스가 당겨진다.
				bear.remove(i);
			} else if (bear.get(i).equals(")") && bear.get(i + 1).equals("(")) {
				bear.remove(i);
				bear.remove(i);
			} else {
				i++;
			}
			
			// bear 리스트가 루프중에 비어졌으면 count 출력
			if (bear.isEmpty()) {
				System.out.println(count);
				break;
			}
			// bear리스트가 루프를 추가로 돌 때마다 count++
			if (i == bear.size() - 1) {
				i = 0;
				count++;
			}
		}
	}
}

/* 북극곰 문제를 풀면서 알게된 것
*1. List는 배열과는 다르게 요소의 갯수에 따라 크기가 늘어났다 줄어들었다 하는 장점이있다. 하지만 반대로 생각해보면
*	요소가 사라질 때 마다 기존 요소의 인덱스 위치가 달라지기 때문에 그 점에 유의해야한다.
*2. String클래스에 substring(startIndex, EndIndex) 메소드가 존재한다.
*	지정한 문자열의 인덱스 번호를 기준으로 자를 수 있다. split이랑 비슷해 보이지만 다르다.
*3. ArrayList : 속도가 빠르고 메모리 사용이 적다.
*	>>> 목록이 자주 수정되지 않을 때 잘 수행된다.
*	LinkedList : 속도가 느리고 메모리 사용이 매우 크다. 데이터 추가 및 제거가 간편하다. 
*	>>> 목록을 자주 수정할 때 유리하다.
*/
