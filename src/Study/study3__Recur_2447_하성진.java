package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class study3__Recur_2447_하성진 {
	 public static char star(int x, int y, int n) {
	        if ((x / n) % 3 == 1 && (y / n) % 3 == 1) {
	            return ' ';
	        } else {
	            if (n / 3 == 0) {
	                return '*';
	            } else {
	                return star(x, y, n / 3);
	            }
	        }
	    }

	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int n = Integer.parseInt(br.readLine());

	        for (int x = 0; x < n; x++) { // 행
	            for (int y = 0; y < n; y++) { // 열
	                char p = star(x, y, n);
	                System.out.print(p);
	            }
	            System.out.println();
	        }
	    }
}
