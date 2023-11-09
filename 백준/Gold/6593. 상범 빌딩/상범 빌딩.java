import java.util.*;
import java.io.*;

class Coord5 {
	int y;
	int x;
	int h;
	int idx;

	Coord5(int h, int y, int x, int idx) {
		this.y = y;
		this.x = x;
		this.h = h;
		this.idx = idx;
	}

	Coord5(int h, int y, int x) {
		this.y = y;
		this.x = x;
		this.h = h;
	}
}

public class Main {

	// L:층 height, R:행 y, C:열 x / S:현위치, .:빈칸, #:벽
	// Escaped in x minute(s).
	// Trapped!
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int l = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] move_h = { -1, 1, 0, 0, 0, 0 };
		int[] move_y = { 0, 0, -1, 1, 0, 0 };
		int[] move_x = { 0, 0, 0, 0, -1, 1 };
		
		boolean flag = false;
		
		while(l !=0 && r != 0 && c != 0) {
			char[][][] building = new char[l][r][c];
			boolean[][][] visited = new boolean[l][r][c];
			Queue<Coord5> q = new LinkedList<>();
			
			Coord5 destination = null;
			

			for (int i = 0; i < l; i++) {
				for (int j = 0; j < r; j++) {
					String str = br.readLine();
					for (int k = 0; k < c; k++) {
						char s = str.charAt(k);
						building[i][j][k] = s;
						if (s == 'S') {
							q.offer(new Coord5(i, j, k, 0));
							visited[i][j][k] = true;
						}
						
						else if (s == 'E') {
							destination = new Coord5(i, j, k);
						}
					}
				}
				br.readLine();
			}

			flag = false;
			while (!q.isEmpty()) {
				Coord5 now_polled = q.poll();
				int cur_h = now_polled.h;
				int cur_y = now_polled.y;
				int cur_x = now_polled.x;
				int cur_idx = now_polled.idx;

				
				if (cur_h == destination.h && cur_y == destination.y && cur_x == destination.x) {
					sb.append("Escaped in ").append(cur_idx).append(" minute(s).\n");
					flag = true;
					break;
				}
				
				for (int dir = 0; dir < 6; dir++) {
					int new_h = cur_h + move_h[dir];
					int new_y = cur_y + move_y[dir];
					int new_x = cur_x + move_x[dir];
					int new_idx = cur_idx + 1;
					if (new_h >= 0 && new_h < l && new_y >= 0 && new_y < r && new_x >= 0 && new_x < c) {
						if (!visited[new_h][new_y][new_x]
								&& (building[new_h][new_y][new_x] == '.' || building[new_h][new_y][new_x] == 'E')) {
							q.offer(new Coord5(new_h, new_y, new_x, new_idx));
							visited[new_h][new_y][new_x] = true;
						}
					}
				}
			}
			if(!flag) {
				sb.append("Trapped!\n");
			}
			st = new StringTokenizer(br.readLine());
			l = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
}
