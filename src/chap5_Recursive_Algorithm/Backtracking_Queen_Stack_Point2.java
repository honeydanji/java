//https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/?ref=lbp
//N Queen problem / backtracking

package chap5_Recursive_Algorithm;

import java.awt.Point;
import java.util.Stack;

public class Backtracking_Queen_Stack_Point2 {
	static final int numberQueens = 4;

	public static void SolveQueen(int[][] d) {
		int count = 0;
		int ix = 0;
		int iy = 0; 
		
		Stack<Point> st = new Stack<>();
		Point p = new Point(ix, iy);
		
		d[ix][iy] = 1;
		count++;
		System.out.println(st.push(p));
		
		
		while(count < numberQueens) {
			ix++;
			int cy = 0;
			while(cy < d.length) {
				// ix = 4 오류발생 방지를 위해 ix-- 설정해주자.
				if(ix == d.length) ix--;
				if (checkMove(d, ix, cy) == true && checkDiagSW(d, ix, cy) == true && checkDiagSE(d, ix, cy) == true) {
					d[ix][cy] = 1;
					p = new Point(ix, cy);
					st.push(p);
					count++;
					System.out.println(st.peek());
					break;
				}
				cy++;
				// ix가 배열의 길이가 되야한다.
				// count = 8 되지 않으면 pop을 이용해 전부 제거한다.
				while(ix == d.length - 1 && cy == d.length) {
					if(ix == d.length - 1 && count != d.length) {
						p = st.pop();
						System.out.println("POP : " + p);
						d[p.x][p.y] = 0;
						System.out.println(p.x + " : " + p.y);
						count--;
					}
					// 스택이 비어있으면 처음과 같이 되돌려준다.
					// 서로 공격하지 않는 위치에 있는 퀸에 해당하는 모든 경우의 수를 출력해야한다.
					// 그 중에서 퀸이 8개가 되는 경우만 콘솔에 출력한다.
					// 
					if(st.empty()) {
						d[0][0] = 1;
						p = new Point(0, 0);
						st.push(p);
						System.out.println(st.peek());
						count++;
						System.out.println("conunt : " + count);
						ix = 0;
						break;
					}
				}
			}
		}
		System.out.println("count : " + count);
	}
			
	public static boolean checkRow(int[][] d, int crow) {
		// 배열 d에서 crow에 queen을 놓을 수 있느냐?
		for (int j = 0; j < numberQueens; j++)
			if (d[crow][j] == 1)
				return false; // false면 놓을 수 없다.
		return true; // 놓을 수 있다.
	}

	public static boolean checkCol(int[][] d, int ccol) {
		// 배열 d에 ccol 열에 배치할 수 있느냐? 있다면 true로 리턴
		for (int j = 0; j < numberQueens; j++)
			if (d[j][ccol] == 1)
				return false; // 놓을 수 없다.
		return true; // 놓을 수 있다.
	}

	public static boolean checkDiagSW(int[][] d, int x, int y) { // x++, y-- or x--, y++ where 0<= x,y <= 7
		// 배열 d에 d[cs][cy]의 sw 대각선에 배치 가능하냐?
		int cx = x, cy = y;
		while (cx >= 0 && cx < numberQueens && cy >= 0 && cy < numberQueens) {
			if (d[cx][cy] == 1)
				return false;
			cx++;
			cy--;
		}

		cx = x;
		cy = y;
		while (cx >= 0 && cx < numberQueens && cy >= 0 && cy < numberQueens) {
			if (d[cx][cy] == 1)
				return false;
			cx--;
			cy++;
		}
		return true;
	}

	public static boolean checkDiagSE(int[][] d, int x, int y) {// x++, y++ or x--, y--
		int cx = x, cy = y;
		while (cx >= 0 && cx < numberQueens && cy >= 0 && cy < numberQueens) {
			if (d[cx][cy] == 1)
				return false;
			cx++;
			cy++;
		}

		cx = x;
		cy = y;
		while (cx >= 0 && cx < numberQueens && cy >= 0 && cy < numberQueens) {
			if (d[cx][cy] == 1)
				return false;
			cx--;
			cy--;
		}
		return true;
	}

	public static boolean checkMove(int[][] d, int x, int y) {// (x,y)로 이동 가능한지를 check
		if (checkRow(d, x) && checkCol(d, y))
			return true;
		else
			return false;
	}

	public static int NextMove(int[][] d, int row) {// 다음 row에 대하여 이동할 col을 조사
		for (int i = 0; i < numberQueens; i++) {
			if (checkMove(d, row, i) == true) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int row = numberQueens, col = numberQueens;
		int[][] data = new int[numberQueens][numberQueens];
		for (int i = 0; i < numberQueens; i++)
			for (int j = 0; j < data[0].length; j++)
				data[i][j] = 0;

		SolveQueen(data);
		for (int i = 0; i < numberQueens; i++) {
			for (int j = 0; j < data[0].length; j++) {
				System.out.print(" " + data[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
