package TIP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BufferedReader_BufferedWrite {
	public static void main(String[] args) throws IOException {
		// 사용법
		
		//BufferedReader선언
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
		//String 문자열 받기
		String s = bf.readLine(); 
		//Int
		int i = Integer.parseInt(bf.readLine()); 
		// readLine()은 꼭 예외처리가 필수다.
		// 1. throws IOException  
		// 2. try/catch 
		
		
		// 데이터 가공
		// 1번째 방법) StringTokenizer를 이용한다.
		StringTokenizer st = new StringTokenizer(bf.readLine()); //StringTokenizer인자값에 입력 문자열 넣음
		int a = Integer.parseInt(st.nextToken()); //첫번째 호출을 to int
		int b = Integer.parseInt(st.nextToken()); //두번째 호출을 to int

		// 두번째 방법) string을 한번에 받아서 split을 이용해 배열로 변환
		String ss = bf.readLine();
		String array[] = s.split(" "); //공백마다 데이터 끊어서 배열에 넣음
		
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//선언
		//String sss = bw.readLine();//출력할 문자열

		//bw.write(sss);//출력
		bw.newLine(); //줄바꿈 -> 이게 잘 안된다. 개행을 할때에는 bw.write(s + "\n"); 처럼 사용한다.
		bw.flush();//남아있는 데이터를 모두 출력시킴
		bw.close();//스트림을 닫음
		
	}
}
