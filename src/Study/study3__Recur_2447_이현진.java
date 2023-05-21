package Study;

import java.util.Scanner;

public class study3__Recur_2447_이현진 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (String s: starsrecur(n)) {
            System.out.println(s);
        }
        sc.close();
    }
    
    public static String[] starsrecur(int n) {
        if (n == 3) {
            return new String[] {"***", "* *", "***"};
        }
        String[] star = starsrecur(n / 3);
        int starlen = star.length;
        String[] bigstar = new String[starlen * 3];
        for (int i = 0; i < starlen; i++) {
            bigstar[i] = star[i].repeat(3);
            bigstar[starlen + i] = star[i] + " ".repeat(starlen) + star[i];
            bigstar[starlen * 2 + i] = star[i].repeat(3);
        }
        return bigstar;
    }
}
