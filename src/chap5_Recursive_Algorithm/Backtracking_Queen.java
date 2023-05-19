//package Chap5_Recursive;
//https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/?ref=lbp
//N Queen problem / backtracking
//
//public class Chap5_Test_QueenEight_revised {
//
//}
package chap5_Recursive_Algorithm;

public class Backtracking_Queen {
	//final : 변하지 않는 상수
	static final int numberQueens = 4;
	
	public static void SolveQueen(int[][] d) {
		for (int ix = 0; ix < d.length; ix++) {
			for (int iy = 0; iy < d.length; iy++) {
				if (checkMove(d, ix, iy) == true && checkDiagSW(d, ix, iy) == true && checkDiagSE(d, ix, iy) == true) {
					d[ix][iy] = 1;
				}
			}
		}
	}

	public static boolean checkRow(int[][] d, int crow) {
		//배열 d에서 crow에 queen을 놓을 수 있느냐?
		for(int j = 0; j < numberQueens; j++)
			if (d[crow][j] == 1) return false; // false면 놓을 수 없다.
		return true;	// 놓을 수 있다.
	}

	public static boolean checkCol(int[][] d, int ccol) {
		//배열 d에 ccol 열에 배치할 수 있느냐? 있다면 true로 리턴
		for(int j = 0; j < numberQueens; j++)
			if(d[j][ccol] == 1) return false; // 놓을 수 없다.
		return true;	// 놓을 수 있다.
	}

	public static boolean checkDiagSW(int[][] d, int x, int y) { // x++, y-- or x--, y++ where 0<= x,y <= 7
		//배열 d에 d[cs][cy]의 sw 대각선에 배치 가능하냐?
		int cx = x, cy = y;
		while(cx >= 0 && cx < numberQueens && cy >=0 && cy < numberQueens) {
			if(d[cx][cy] == 1) return false;
			cx++; cy--;
		}
		
		cx = x; cy = y;
		while(cx >= 0 && cx < numberQueens && cy >=0 && cy < numberQueens) {	
			if(d[cx][cy] == 1) return false;
			cx--; cy++;
		}
		return true;
	}

	public static boolean checkDiagSE(int[][] d, int x, int y) {// x++, y++ or x--, y--
		int cx = x, cy = y;
		while(cx >= 0 && cx < numberQueens && cy >=0 && cy < numberQueens) {
			if(d[cx][cy] == 1) return false;
			cx++; cy++;
			}
		
		cx = x; cy = y;
		while(cx >= 0 && cx < numberQueens && cy >=0 && cy < numberQueens) {
			if(d[cx][cy] == 1) return false;
			cx--; cy--;
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
			if(checkMove(d, row, i) == true) {
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
	}
}
