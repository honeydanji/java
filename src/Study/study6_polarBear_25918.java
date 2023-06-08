package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class study6_polarBear_25918 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(bf.readLine()); 
		
		
		// 괄호갯수 입력받기 
		int n = Integer.parseInt(bf.readLine());
		List<String> bear = new ArrayList<>(n);
		
		
		// bear 리스트에 괄호 입력하기 
		for(int i = 0; i < n; i++) {
			bear.add(i, bf.readLine());
		}
		
		int i = 0;
		int count = 1;
		
		// 리스트에 해당 괄호가 존재하면 해당 위치에 있는 인덱스 요소를 비워준다.
		// 반복문이 한번 돌 때마다 count를 증가시켜준다.
		// 비워지지 않으면 -1을 출력한다.
		while(i < bear.size() - 1) {
//		while(true) {
			if(bear.get(i).equals("(") && bear.get(i+1).equals(")")) {
				bear.remove(i);	//리스트안에 요소가 없어지면 크기가 줄어든다.
				bear.remove(i+1);
			}else if(bear.get(i).equals(")") && bear.get(i+1).equals("(")) {
				bear.remove(i);
				bear.remove(i+1);
			}
			// bear 리스트가 루프중에 비어졌으면 count 출력
			if(bear.isEmpty()) {
				System.out.println(count);
				break;
			}
			i+=2;
			// bear리스트가 루프를 추가로 돌 때마다 count++
			if(i ==  bear.size() - 1) {
				i = 0;
				count++;
			} 	
		}
	}
}

// 루프를 도는 중에 리스트 값이 제거되면 리스트 크기가 줄어들어 리스트 크기를 초과한다는 오류가 나온다.
// 가장 좋은 방법은 리스트를 제거 할 때 리스트 크기가 유지 되게 하거나 다른 방법을 찾아야 한다. 
