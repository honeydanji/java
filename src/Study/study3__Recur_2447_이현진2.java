package Study;

import java.util.Scanner;

public class study3__Recur_2447_이현진2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] stars = starsrecur(n);
		int partlen = stars.length / 2;
		for (String s : stars) {
			System.out.println(s);
		}
		for (int i = 0; i < partlen; i++) {
			System.out.println(stars[i]);
		}
		sc.close();
	}

	public static String[] starsrecur(int n) {
		if (n == 3) {
			return new String[] { "***", "* *" };
		}
		String[] star = starsrecur(n / 3);
		int partlen = star.length / 2;
		String[] bigstar = new String[partlen * 6];
		for (int i = 0; i < partlen; i++) {// 전 단계의 위아래 부분
			String updown = star[i];
			bigstar[i] = updown.repeat(3);
			bigstar[partlen * 2 + i] = updown.repeat(3);
			bigstar[partlen * 3 + i] = updown + " ".repeat(partlen * 3) + updown;
			bigstar[partlen * 5 + i] = updown + " ".repeat(partlen * 3) + updown;
		}
		for (int i = partlen; i < partlen * 2; i++) {// 전 단계의 중간 부분
			String middle = star[i];
			bigstar[i] = middle.repeat(3);
			bigstar[partlen * 3 + i] = middle + " ".repeat(partlen * 3) + middle;
		}
		return bigstar;
	}
}
