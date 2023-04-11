package AIgorithm;

public class Plus {

	public static void main(String[] args) {
		int sum1 = 0;
		int sum2 = 0;
		for(int i = 0; i <= 1000; i++) {
			if((i % 2) == 0) {
				sum1 += i; 
			}else if((i % 2) != 0) {
				sum2 += i;
			}
		}
		System.out.println("짝수합:" + sum1);
		System.out.println("홀수합:" + sum2);
		System.out.println("총 합:" + (sum1 + sum2));
	}

}
