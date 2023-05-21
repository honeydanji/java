//https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/?ref=lbp
//N Queen problem / backtracking

package chap5_Recursive_Algorithm;

import java.awt.Point;
import java.util.Stack;

//class Stack3 {
//	private List<Point> data; // 스택용 배열
//	private int capacity; // 스택의 크기
//	private int top; // 스택 포인터
//
//	public Stack3(int maxlen) {
//		top = 0;
//		capacity = maxlen;
//		try {
//			data = new ArrayList<Point>();
//		} catch (OutOfMemoryError e) {
//			capacity = 0;
//		}
//	}
//
//	public int push(Point x) throws OverflowGenericStackException {
//		if (top >= capacity) {
//			throw new OverflowGenericStackException();
//		}
//		data.add(x);
//		return top++;
//	}
//
//	public Point pop() throws EmptyGenericStackException {
//		if (top <= 0) {
//			throw new EmptyGenericStackException();
//		}
//		// Point p = data.get(top--);
//		Point p = data.remove(top - 1);
//		top--;
//		return p;
//	}
//
//	public Point peek() throws EmptyGenericStackException {
//		if (top <= 0) {
//			throw new EmptyGenericStackException();
//		}
//		return data.get(top - 1);
//	}
//
//	public void clear() {
//		top = 0;
//	}
//
//	public int indexOf(Point x) {
//		for (int i = top - 1; i >= 0; i--) {
//			if (data.get(i).equals(x)) {
//				return i;
//			}
//		}
//		return -1;
//	}
//
//	public int size() {
//		return top;
//	}
//
//	public boolean isEmpty() {
//		return top <= 0;
//	}
//
//	public boolean isFull() {
//		return top >= capacity;
//	}
//
//	public void dump() {
//		if (isEmpty())
////      if(ptr <= 0)
//			System.out.println("stack이 비었습니다.");
//		else {
//			for (int i = 0; i < top; i++) {
//				System.out.print(data.get(i).getX() + " " + data.get(i).getY());
//				System.out.println();
//			}
//		}
//	}
//
//	public int getCapacity() {
//		return capacity;
//	}
//
//}
//
//class OverflowGenericStackException extends RuntimeException {
//	public OverflowGenericStackException() {
//	}
//}
//
//class EmptyGenericStackException extends RuntimeException {
//	public EmptyGenericStackException() {
//	}
//}
//
//class Point {
//	private int x;
//	private int y;
//
//	public Point(int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
//
//	public int getX() {
//		return x;
//	}
//
//	public void setX(int x) {
//		this.x = x;
//	}
//
//	public int getY() {
//		return y;
//	}
//
//	public void setY(int y) {
//		this.y = y;
//	}
//
//	@Override
//	public boolean equals(Object p) {
//		Point px = (Point) p;
//		if (this.x == px.x && this.y == px.y)
//			return true;
//		else
//			return false;
//	}
//}

public class Backtracking_Queen_Stack_Point {
	static final int numberQueens = 4;

	public static void SolveQueen(int[][] d) {
		int count = 0, mode = 0;
		int ix = 0, iy = 0;
		Stack<Point> st = new Stack<>();
		Point p = new Point(ix, iy);
		d[ix][iy] = 1;
		count++;//경우의 수
		st.push(p);
//		while (count < 8) {
		while (ix < d.length) {
			ix++;
			int cy = 0;
			while (ix < d.length) {
				while (cy < d[0].length) {
					while(cy < d[0].length) {
						if (checkMove(d, ix, cy) == true && checkDiagSW(d, ix, cy) == true && checkDiagSE(d, ix, cy) == true) {
							d[ix][cy] = 1;
							p = new Point(ix, cy);
							st.push(p);
							count++;
							break;
						}
						cy++;
					}
					break;
				}
				System.out.println(st.peek());
				
				if (cy != d[0].length) {
					break;
				} else {
					p = st.peek();
					//count--;
					break;
				}
			}
		}
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
	}
}
