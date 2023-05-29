package Study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class study4_bipartiteSearch_3020_하성진 {
	public static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));// 선언

	public static void main(String args[]) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken()); // 6
		int H = Integer.parseInt(st.nextToken()); // 7
		int[] Obstacle = new int[N]; // 각 행에 배치해야 하는 장애물을 저장하는 배열


		if (N % 2 == 0) {
			// 개똥벌레가 지나가는 동굴
			byte[][] Cave = new byte[H][N];

			// 열 갯수만큼 장애물 입력
			for (int i = 0; i < N; i++) {
				Obstacle[i] = Integer.parseInt(bf.readLine());
			}


			// 장애물 배치(boolean배열 이용)
			// 1 = 장애물이 있는 공간
			for (int i = 0; i < Cave[0].length; i++) {
				if (i % 2 == 0) { // 열이 짝수
					for (int j = (Cave.length - 1); j >= (Cave.length - Obstacle[i]); j--) {
						//Cave[j][i] = true;
						Cave[j][i] = 1;
					}
				} else { // 열이 홀수
					for (int j = 0; j < Obstacle[i]; j++) {
						//Cave[j][i] = true;
						Cave[j][i] = 1;
					}
				}
			}

			int minCount = Integer.MAX_VALUE;
			int minRowCount = 0;
			
			for (int i = 0; i < Cave.length; i++) {
			    int count = 0;
			    for (int j = 0; j < Cave[0].length; j++) {
			        if (Cave[i][j] == 1) {
			            count++;
			        }
			    }

			    if (count < minCount) {
			        minCount = count;
			        minRowCount = 1;
			    } else if (count == minCount) {
			        minRowCount++;
			    }
			}
			
			System.out.println(minCount + " " + minRowCount);
		}

	}
}
