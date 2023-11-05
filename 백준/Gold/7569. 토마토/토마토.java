import java.io.*;
import java.util.*;

class Coord {
	int y;
	int x;
	int h;
	int idx;

	Coord(int h, int y, int x, int idx) {
		this.y = y;
		this.x = x;
		this.h = h;
		this.idx = idx;
	}
}

public class Main {

	// 입력 >> 1: 익음, 0:안익음, -1:없음
	// 출력 >> 모두 익어있는 상태로 입력됨 :1, 모두 익지 못함:-1
	// M N H 입력, M:col(x) N:row(y) H:height
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int[][][] tom = new int[h][n][m];
		int[] move_h = { -1, 1, 0, 0, 0, 0 };
		int[] move_y = { 0, 0, -1, 1, 0, 0 };
		int[] move_x = { 0, 0, 0, 0, -1, 1 };

		// 토마토 지도 100*100*100
		boolean allFlag = true;
		boolean first = true;

		Queue<Coord> q = new LinkedList<Coord>();
		boolean[][][] visited = new boolean[h][n][m];
		// 토마토 지도 그리기, 익은 토마토 q에 삽입, 모두 익은 상태인지 검증
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < m; k++) {
					int num = Integer.parseInt(st.nextToken());
					tom[i][j][k] = num;

					if (num == 1) {
						q.offer(new Coord(i, j, k, 0));
						visited[i][j][k] = true;
					} else if (num != 1) {
						allFlag = false;
					}
				}
			}
		}

		// 모두 익음
		if (allFlag) {
			bw.write("0");
			bw.flush();
			return;
		}

		// bfs
		int maxCount = Integer.MIN_VALUE;
		while (!q.isEmpty()) {
			Coord now_polled = q.poll();
			int cur_h = now_polled.h;
			int cur_y = now_polled.y;
			int cur_x = now_polled.x;
			int cur_idx = now_polled.idx;

			for (int dir = 0; dir < 6; dir++) {
				int new_h = cur_h + move_h[dir];
				int new_y = cur_y + move_y[dir];
				int new_x = cur_x + move_x[dir];
				int new_idx = cur_idx +1;
				if (new_h >= 0 && new_h < h && new_y >= 0 && new_y < n && new_x >= 0 && new_x < m) {
					if(!visited[new_h][new_y][new_x] && tom[new_h][new_y][new_x] == 0) {
						q.offer(new Coord(new_h, new_y, new_x, new_idx));
						visited[new_h][new_y][new_x] = true;
					}
				}
			}
			
			if(maxCount < cur_idx) { maxCount = cur_idx;}
		}

		// 모두 익었는지 검증
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (tom[i][j][k] == 0 && !visited[i][j][k]) {
						bw.write("-1");
						bw.flush();
						return;
					}
				}
			}
		}

		// 정상 결과 출력
		bw.write(maxCount + "");
		bw.flush();

	}

}
