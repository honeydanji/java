package baekJoonTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class loopTest_3_6 {

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out) );
		 
		 StringTokenizer st; 
		 int N = Integer.parseInt(br.readLine()); 
		 
		 for(int i=0; i<N; i++) {
			 st = new StringTokenizer(br.readLine());
			 
			 int a = Integer.parseInt(st.nextToken());
			 int b = Integer.parseInt(st.nextToken());
			 int sum = a + b;
			 
			 bw.write(sum + "\n");
		 }
       bw.flush();  
		bw.close();
	}

}

// BufferedReader : Scanner와 유사
// 입력값은 String으로 고정. 다른 타입으로 입력을 받기 위해서는 무조건 형변환을 해줘야한다.
// BufferedWriter : System.out.println();과 유사