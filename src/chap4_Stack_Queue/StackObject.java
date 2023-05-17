//package chap4_Stack_Queue;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//import java.util.Scanner;
//
//import chap4_Stack_Queue.IntStack.EmptyIntStackException;
//import chap4_Stack_Queue.IntStack.OverflowIntStackException;
//
//class ObjectStack {
//	private List<Point> stk; // 스택용 배열
//	private int capacity; // 스택의 크기
//	private int ptr; // 스택 포인터
//
//	// 실행 시 예외: 스택이 비어 있음
//	public class EmptyIntStackException extends RuntimeException {
//		public EmptyIntStackException() {
//		}
//	}
//
//	// 실행 시 예외: 스택이 가득 참
//	public class OverflowIntStackException extends RuntimeException {
//		public OverflowIntStackException() {
//		}
//	}
//
//	public ObjectStack(int maxlen) {
//		ptr = 0;
//		capacity = maxlen;
//		try {
//			stk = new ArrayList<Point>();
//		} catch (OutOfMemoryError e) {
//			capacity = 0;
//		}
//	}
//
//	// 스택에 x를 푸시
//	public int push(Point x) throws OverflowIntStackException {
//		if (ptr >= capacity)
//			throw new OverflowIntStackException();
//		{
//			++ptr;
//			stk.add(x);
//			return 1;
//		}
//	}
//
//	// 스택에서 데이터를 팝(꼭대기에 있는 데이터를 꺼냄)
//	public Point pop() throws EmptyIntStackException {
//		if (ptr <= 0)
//			throw new EmptyIntStackException();
//		{
//			Point p = stk.get(ptr - 1);
//			ptr--;
//			return p;
//		}
//	}
//
//	// 스택에서 데이터를 피크(꼭대기에 있는 데이터를 들여다봄)
//	public Point peek() throws EmptyIntStackException {
//		if (ptr <= 0)
//			throw new EmptyIntStackException();
//		return stk.get(ptr-1);
////		return stk.indexOf(stk);
//	}
//
//	// 스택을 비움
//	public void clear() {
//		ptr = 0;
//	}
//
//
//
//	// 스택의 용량을 반환
//	public int getCapacity() {
//		return capacity;
//	}
//
//	// 스택에 쌓여 있는 데이터 개수를 반환
//	public int size() {
//		return ptr;
//	}
//
//	// 스택이 비어 있는가?
//	public boolean isEmpty() {
//		return ptr <= 0;
//	}
//
//	// 스택이 가득 찼는가?
//	public boolean isFull() {
//		return ptr >= capacity;
//	}
//
//	// 스택 안의 모든 데이터를 바닥 >> 꼭대기 순서로 출력
//	public void dump() {
//		if (ptr <= 0)
//			System.out.println("스택이 비어 있습니다.");
//		else {
//			for (int i = 0; i < ptr; i++)
//				System.out.println(stk.get(i).getIx() + " " + stk.get(i).getIy());
//			System.out.println();
//		}
//	}
//	
//	// 스택에서 x를 찾아 인덱스(없으면 -1)를 반환
//		public int indexOf(int x) {
//			for (int i = ptr - 1; i >= 0; i--)
//				if (stk.get(i).equals(x))
//					return i-1;
//			return -1;
//		}
//}
//
//
//
//class Point {
//	private int ix;
//	private int iy;
//
//	// Point 생성자
//	public Point(int rndx, int rndy) {
//		this.ix = rndx;
//		this.iy = rndy;
//	}
//
//	public int getIx() {
//		return ix;
//	}
//	
//	public int getIy() {
//		return iy;
//	}
//	@Override
//	public boolean equals(Object p) {
//		Point px = (Point) p;
//		if (this.ix == px.ix && this.iy == px.iy)
//			return true;
//		else
//			return false;
//	}
//}
//
//public class StackObject {
//	public static void main(String[] args) {
//		Scanner stdIn = new Scanner(System.in);
//		ObjectStack s = new ObjectStack(8); // 최대 8 개를 push할 수 있는 stack
//		Random random = new Random();
//		int rndx = 0, rndy = 0;
//		Point p = null;
//
//		while (true) {
//			//System.out.println(); // 메뉴 구분을 위한 빈 행 추가
//			System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
//			System.out.println();
//			System.out.print("(1)push　(2)pop　(3)peek　(4)dump　(0)종료: ");
//
//			int menu = stdIn.nextInt();
//			if (menu == 0)
//				break;
//
//			switch (menu) {
//			case 1: // 푸시
//				System.out.print("데이터: ");
//				rndx = random.nextInt() % 20;
//				rndy = random.nextInt() % 20;
//				p = new Point(rndx, rndy);
//				
//				try {
//					s.push(p);
//					System.out.println("push한 데이터는" + p.getIx()  + ", "+ p.getIy() + "입니다.");
//				} catch (ObjectStack.OverflowIntStackException e) {
//					System.out.println("stack이 가득찼있습니다.");
//				}
//				break;
//
//			case 2: // 팝
//				try {
//					p = s.pop();
//					System.out.println("pop한 데이터는 " + p.getIx()  + ", "+ p.getIy()  + "입니다.");
//				} catch (ObjectStack.EmptyIntStackException e) {
//					System.out.println("stack이 비어있습니다.");
//				}
//				break;
//
//			case 3: // 피크
//				try {
//					p = s.peek();
//					System.out.println("peek한 데이터는 " + p.getIx()  + ", "+ p.getIy()  + "입니다.");
//				} catch (ObjectStack.EmptyIntStackException e) {
//					System.out.println("stack이 비어있습니다.");
//				}
//				break;
//
//			case 4: // 덤프
//				s.dump();
//				break;
//			}
//		}
//	}
//}
