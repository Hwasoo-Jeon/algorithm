import java.util.*;
import java.io.*;

public class Main {
	
	static int curAnswer = 0;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		
		//층수 set
		Set<Integer> level = new HashSet<>();
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				int cur = Integer.parseInt(st.nextToken());
				map[i][j] = cur;
				level.add(cur);
			}
		}
		
		int answer = 1;
		for(int depth : level) {
			curAnswer = 0;
			visited = new boolean[n][n];
			for(int r=0; r <n; r++) {
				for(int c=0; c<n; c++) {
					if(map[r][c] > depth && !visited[r][c]) {
						bfs(map, r, c, n, depth);
						
					}
				}
			}
			if(curAnswer > 0) answer = Math.max(answer, curAnswer);
		}
		
		System.out.println(answer+"");
	}
	
	private static void bfs(int[][] map, int r, int c, int n, int depth) {
		visited[r][c] = true;
		int[] moveY = {-1,1,0,0};
		int[] moveX = {0,0,-1,1};
		Queue<Integer[]> q = new LinkedList<>();
		q.offer(new Integer[] {r,c});
		while(!q.isEmpty()) {
			Integer[] cur = q.poll();
			for(int i = 0; i<4; i++) {
				int curY = cur[0]+moveY[i];
				int curX = cur[1]+moveX[i];
				if(curY>=0 && curY <n && curX>=0 && curX<n) {
					if(!visited[curY][curX] && map[curY][curX] > depth) {
						visited[curY][curX] = true;
						q.offer(new Integer[] {curY,curX});
					}
				}
			}
		}
		curAnswer ++;
	}
}
