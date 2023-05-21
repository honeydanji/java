package Study;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class study3_Queue_3190_강주희 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Deque<int[]> snake = new LinkedList<>();
		snake.add(new int[] { 1, 1 });
		int count = 0;

		int n = Integer.parseInt(br.readLine());
		int[][] board = new int[n + 1][n + 1];
		int k = Integer.parseInt(br.readLine());

		// 사과 위치
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			// 사과의 위치는 2
			board[r][c] = 2;
		}

		// 이동
		int l = Integer.parseInt(br.readLine());
		int[] direct = new int[l];
		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			while (count < x) {
				int[] preH = snake.removeFirst();
				int a = preH[0];
				int b = preH[1];
				// 처음에는 우측으로 이동
				if (i == 0) b += 1;
				// 처음이 아닐 땐 이전 입력의 이동 방향을 고려해야함
				if (i != 0) {
					switch (direct[i - 1]) {
					case 1: // 상
						a -= 1;
						break;
					case 2: // 하
						a += 1;
						break;
					case 3: // 좌
						b -= 1;
						break;
					case 4: // 우
						b += 1;
						break;
					}
				}
				// 벽에 부딪히는 경우
				if (a > n || b > n || a == 0 || b == 0) {
					sb.append(count + 1);
					System.out.print(sb);
					return;
				}
				// 자신의 몸과 부딪히는 경우
				if (board[a][b] == 1) {
					sb.append(count + 1);
					System.out.print(sb);
					return;
				}
				// 사과를 먹은 경우 -> 몸 길이가 늘어남
				if (board[a][b] == 2) {
					snake.addFirst(preH);
				}
				// 사과를 먹지 않고 이동하는 경우
				if (board[a][b] == 0) {
					// 몸 길이가 2 이상인 경우
					if (snake.size() > 0) {
						// 꼬리가 이동
						int[] preT = snake.removeLast();
						board[preT[0]][preT[1]] = 0;
						snake.addFirst(preH);
					}
					// 몸 길이가 1인 경우
					else board[preH[0]][preH[1]] = 0;
				}
				board[a][b] = 1;
				snake.addFirst(new int[] { a, b });
				count++;
			}

			// 방향 회전
			char c = st.nextToken().charAt(0);
			// 1: 상 2: 하 3: 좌 4: 우
			if (i == 0) {
				if (c == 'D') direct[i] = 2;
				else direct[i] = 1;
			} else {
				// 짝수일 경우 -> 1 또는 2
				if (i % 2 == 0) {
					// 바로 전이 좌
					if (direct[i - 1] == 3) {
						if (c == 'D') direct[i] = 1;
						else direct[i] = 2;
					}
					// 바로 전이 우
					else {
						if (c == 'D') direct[i] = 2;
						else direct[i] = 1;
					}
				}
				// 홀수인 경우 -> 3 또는 4
				else {
					// 바로 전이 상
					if (direct[i - 1] == 1) {
						if (c == 'D') direct[i] = 4;
						else direct[i] = 3;
					}
					// 바로 전이 하
					else {
						if (c == 'D') direct[i] = 3;
						else direct[i] = 4;
					}
				}
			}
		}
		// 입력으로 들어온 시간을 넘어서도 이동이 가능한 경우
		while (true) {
			int[] preH = snake.removeFirst();
			int a = preH[0];
			int b = preH[1];
			switch (direct[direct.length - 1]) {
			case 1: // 상
				a -= 1;
				break;
			case 2: // 하
				a += 1;
				break;
			case 3: // 좌
				b -= 1;
				break;
			case 4: // 우
				b += 1;
				break;
			}
			if (a > n || b > n || a == 0 || b == 0) {
				sb.append(count + 1);
				break;
			}
			if (board[a][b] == 1) {
				sb.append(count + 1);
				break;
			}
			if (board[a][b] == 2) {
				snake.addFirst(preH);
			}
			if (board[a][b] == 0) {
				if (snake.size() > 0) {
					int[] preT = snake.removeLast();
					board[preT[0]][preT[1]] = 0;
					snake.addFirst(preH);
				} else board[preH[0]][preH[1]] = 0;
			}
			board[a][b] = 1;
			snake.addFirst(new int[] { a, b });
			count++;
		}
		System.out.print(sb);
	}
}
