package AIgorithm;

public class MinMaxProblem {
	public static void main(String[] args) {
		int score[] = new int[] {10, 55, 23, 2, 79, 101, 16, 82, 30, 45};
		for(int i = 0; i < score.length; i++) {
			if(score[i] == 2) {
				System.out.println("최솟값 :" + score[i]);
			}
		}
	}
}
