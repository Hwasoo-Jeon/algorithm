import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[][] arr = new String[n][n];
		String[][] arr2 = new String[n][n];
		//100*100
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<n; j++) {
				String cur = s.substring(j, j+1);
				arr[i][j] = cur;
				if(cur.equals("R")) {
					arr2[i][j] = "G";
				} else {
					arr2[i][j] = cur;
				}
			}
		}
		
		boolean[][] visited = new boolean[n][n];
		boolean[][] visited2 = new boolean[n][n];
		int answer = 0;
		int answer2 = 0;
		
		
		int[] moveR = {-1,1,0,0};
		int[] moveC = {0,0,-1,1};
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				//bfs
				if(!visited[i][j]) {
					Queue<int[]> q = new LinkedList<>();
					visited[i][j] = true;
					q.offer(new int[] {i,j});
					while(!q.isEmpty()) {
						int[] cur = q.poll();
						for(int d=0; d<4; d++) {
							int newR = cur[0]+moveR[d];
							int newC = cur[1]+moveC[d];
							if(newR>=0 && newR<n && newC>=0 && newC<n) {
								if(!visited[newR][newC] && arr[cur[0]][cur[1]].equals(arr[newR][newC])) {
									q.offer(new int[] {newR, newC});
									visited[newR][newC] = true;
								}
							}
						}
			
					}
					answer++;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				//bfs
				if(!visited2[i][j]) {
					Queue<int[]> q = new LinkedList<>();
					visited2[i][j] = true;
					q.offer(new int[] {i,j});
					while(!q.isEmpty()) {
						int[] cur = q.poll();
						for(int d=0; d<4; d++) {
							int newR = cur[0]+moveR[d];
							int newC = cur[1]+moveC[d];
							if(newR>=0 && newR<n && newC>=0 && newC<n) {
								if(!visited2[newR][newC] && arr2[cur[0]][cur[1]].equals(arr2[newR][newC])) {
									q.offer(new int[] {newR, newC});
									visited2[newR][newC] = true;
								}
							}
						}
			
					}
					answer2++;
				}
			}
		}
		
		System.out.println(answer+" "+answer2);
	}
}