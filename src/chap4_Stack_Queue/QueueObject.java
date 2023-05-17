package chap4_Stack_Queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import chap4_Stack_Queue.Queue.OverflowQueueException;

//int형 고정 길이 큐
class objectQueue {
    private List<Point> que;  
	private int capacity; // 큐의 크기
	private int front; // 맨 처음 요소 커서
	private int rear; // 맨 끝 요소 커서
	private int num; // 현재 데이터 개수
	
	public objectQueue(int maxlen) {
		num = rear = front = 0;
		this.capacity = maxlen;
		try {
			que = new ArrayList<Point>();
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}
	
	// 실행 시 예외: 스택이 비어 있음
	public class EmptyQueueException extends RuntimeException {
		public EmptyQueueException() {
		}
	}

	// 실행 시 예외: 스택이 가득 참
	public class OverflowQueueException extends RuntimeException {
		public OverflowQueueException() {
		}
	}
	
	public int size() {
		return num;
	}
	
	public int getCapacity() {
		return this.capacity;
	}
	
	public void enque(Point p) {
		if(num >= capacity) {
			throw new OverflowQueueException();
		}
		que.add(p);
		rear++;
		num++;
	}
	
	public Point deque() {
		num--;
		Point p = que.remove(front); 
		return p;
	}
	
	public Point peek() {
		Point p = que.get(front); 
		return p; 
	}
	
	public void dump() {
		while(true) {
			System.out.println(que.get(front++));
			num--;
			if(num == 0) {
				break;
			}
		}
	}
}

class Point{
	private int rndx1;
	private int rndy1;
	
	public Point(int rndx, int rndy) {
		this.rndx1 = rndx;
		this.rndy1 = rndy;
	}
	
	public int getRndx1() {
		return this.rndx1;
	}
	
	public int getRndy1() {
		return this.rndy1;
	}
	
	public String toString() {
		return this.rndx1 + " " + this.rndy1;
	}
	
}

//int형 고정 길이 큐의 사용 예
public class QueueObject {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);	
		objectQueue s = new objectQueue(64); // 최대 64개를 인큐할 수 있는 큐
		Random random = new Random();
		
		int rndx = 0, rndy = 0;
		Point p = null;
		
		while (true) {
			System.out.println(" "); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
			System.out.print("(1)인큐　(2)디큐　(3)피크　(4)덤프　(0)종료: ");

			int menu = stdIn.nextInt();
			if (menu == 0)
				break;	

			int x;
			switch (menu) {
			case 1: // 인큐
				System.out.print("데이터: ");
				rndx = random.nextInt() % 20;
				rndy = random.nextInt() % 20;
				p = new Point(rndx,rndy);
				
				try {
					s.enque(p);
					System.out.println(p.toString());
				} catch(objectQueue.OverflowQueueException e) {
					System.out.println("stack이 가득찼있습니다.");
				}
				break;

			case 2: // 디큐
				try {
					p = s.deque();
					System.out.println("디큐한 데이터는 " + p.toString() + "입니다.");
				} catch (objectQueue.EmptyQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 3: // 피크
				try {
					p = s.peek();
					System.out.println("피크한 데이터는 " + p.toString() + "입니다.");
				} catch (objectQueue.EmptyQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 4: // 덤프
				s.dump();
				break;
			}
		}
	}
}
