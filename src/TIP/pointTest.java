package TIP;

//import java.awt.Point;

// 클래스 POINT
// : 정수 정밀도로 지정되는 (x, y) 좌표 공간에서의 위치를 나타낼 때 쓰는 class

// Point() : 좌표 공간의 원점 (0, 0)에 점을 생성하고 초기화한다.
// Point(int x, int y) : 좌표 공간의 지정된 위치 (x, y)에 점을 생성하고 초기화한다.
// Point(Point p) : 점을 생성하고, 지저된 Point와 같은 위치에 초기화한다.
// equals(Object obj) : 2개의 점이 동일한지 판정합니다.
// getLocation() : 해당 점의 위치를 리턴합니다.
// getX(), getY() : 점의 x,y 좌표를 리턴합니다.
// move(int x, int y) : 점을 (x,y)로 이동합니다.
// setLocation(double x, double y) : 지정된 좌표로 점의 위치를 설정합니다.

public class pointTest {
	public static void main(String[] args) {
		// Point 타입으로 참조변수를 만들고 생성자를 호출한다.
		Point p = new Point();
		
		// 내장함수가 아닌 아래에 직접 만든 Point함수에 인자값을 넣어준다.
		p.Point(1, 2);
		
		// getLocation함수를 이용해 String으로 출력한다.
		System.out.println(p.getLocation());
	}
}

class Point {
	int x;
	int y;

	public void Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public String getLocation() {
		return "(" + this.x + ", " + this.y + ")";
	}
}
