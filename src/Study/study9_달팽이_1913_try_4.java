package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 좌표 출력
class PPPoint{
	int x;
	int y;

	public void point(int x, int y) {
		this.x = x+1;
		this.y = y+1;
	}
}

public class study9_달팽이_1913_try_4 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		PPPoint p = new PPPoint();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		// 배열크기
		int N = Integer.parseInt(bf.readLine()); // N = 홀수
		if(N < 3 || N > 999) bf.close();
		
		// 찾고 싶은 수
		int num = Integer.parseInt(bf.readLine());
		
		// 달팽이배열
		int[][] NN = new int[N][N];
		
		// 배열의 요소가 되는 값 
		int k = (int) Math.pow(N, 2);

		int i = 0;
		int j = 0;
		
		// k가 기준
		while(k != 0) {
			while(i < N) { 
				if(k == Math.pow(N,2)) NN[i][j] = k--; // i=0, j=0 인 경우만 해당한다.
				else {
					i++;
					if(i == N || NN[i][j] != 0) { // 다음 칸에 값이 있는 지 없는 지 판단. 값이 존재하면 꺽는다. 
						i--;
						break;
					}
					NN[i][j] = k--;
				}
			}
			while(j < N) {
				j++;
				if(j == N || NN[i][j] != 0) {
					j--;
					break;
				}
				NN[i][j] = k--;
			}
			while(i != 0) {
				i--;
				if(i < 0 || NN[i][j] != 0) {
					i++;
					break;
				}				
				NN[i][j] = k--;
				}
			while(j != 0) {
				j--;
				if(j < 0 || NN[i][j] != 0) {
					j++;
					break;
				}
				NN[i][j] = k--;	
			}
		}
		
		for(int ii = 0; ii < NN.length; ii++) {
			for(int jj = 0; jj < NN.length; jj++) {
				System.out.print(NN[ii][jj] + " ");
				if(NN[ii][jj] == num) {
					p.point(ii, jj);
				}
			}
			System.out.println();
		}		
		System.out.println(p.x + " " + p.y);
	}
}

