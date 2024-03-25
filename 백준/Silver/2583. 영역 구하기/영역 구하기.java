import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] arr = new int[M][N];
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int lx = Integer.parseInt(st.nextToken());
			int by = Integer.parseInt(st.nextToken());
			int rx = Integer.parseInt(st.nextToken())-1;
			int ty = Integer.parseInt(st.nextToken())-1;
			arr[ty][lx] = 2; //좌상
			arr[by][lx] = 2; //좌하
			arr[ty][rx] = 2; //우상			
			arr[by][rx] = 2; //우하
			for(int row = by; row<=ty; row++) {
				for(int col = lx; col<=rx; col++) {
					if(arr[row][col]!=2) arr[row][col] = 2;
				}
			}
		}
		
		int answer = 0;
		LinkedList<Integer> widthList = new LinkedList<Integer>();
		Queue<Integer[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[M][N];
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j] == 0 && !visited[i][j]) {
					q.offer(new Integer[] {i, j});
					int width = 0;
					while(!q.isEmpty()) {
						Integer[] cur = q.poll();
						int curR = cur[0];
						int curC = cur[1];
						
						if(visited[curR][curC]) {
							continue;
						} else {
							visited[curR][curC] = true;
							width++;
							int[] moveY = {-1,1,0,0};
							int[] moveX = {0,0,-1,1};
							for(int c =0; c<4;c++) {
								int newR = curR + moveY[c];
								int newC = curC + moveX[c];
								if(newR>=0 && newR<M && newC>=0 && newC<N ) {
									if(arr[newR][newC] == 0 &&!visited[newR][newC]) {
										q.offer(new Integer[] {newR, newC});
									}
								}
							}
						}	
					}
					widthList.add(width);
					answer++;
				}
			}
		}
		Collections.sort(widthList);
		bw.write(answer + "\n");
		for(int i =0; i<widthList.size(); i++) {
			bw.write(widthList.get(i) +" ");
		}
		bw.flush();
	}
}
