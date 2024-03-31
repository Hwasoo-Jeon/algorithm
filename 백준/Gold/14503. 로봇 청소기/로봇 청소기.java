import java.util.*;
import java.io.*;

public class Main {
	
	private static int[][] arr;
	private static int row;
	private static int col;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] start = new int[3];
		start[0] = Integer.parseInt(st.nextToken()); 
		start[1] = Integer.parseInt(st.nextToken()); 
		start[2] = Integer.parseInt(st.nextToken());
		arr = new int[row][col];
		int answer = 0;
		
		for(int i=0; i<row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<col; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(start);
		Loop:
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			//현재칸 청소
			if(arr[cur[0]][cur[1]] == 0) {
				arr[cur[0]][cur[1]] = 3;
				answer++;
			}

			//4방위 탐색
			int[] moveRow = {-1,1,0,0};
			int[] moveCol = {0,0,-1,1};
			for(int i=0; i<4; i++) {
				int newRow = cur[0] + moveRow[i];
				int newCol = cur[1] + moveCol[i];
				//0있으면 continue;
				if(newRow>=0 && newRow<row && newCol>=0 && newCol<col) {
					if(arr[newRow][newCol] == 0) {
						int[] searchResult = cleaning(cur[0], cur[1], cur[2]);
						q.offer(searchResult);
						continue Loop;
					}
				}
			}
			
			//바라보는 방향 유지한채 후진
			if(cur[2] == 0) {
				cur[0] += 1;
			} else if(cur[2] == 1) {
				cur[1] -= 1;
			} else if(cur[2] == 2) {
				cur[0] -= 1;
			} else {
				cur[1] += 1;
			}
			
			if(cur[0] >=0 && cur[0] <row && cur[1]>=0 && cur[1] < col && arr[cur[0]][cur[1]] != 1) {
				q.offer(new int[] {cur[0], cur[1], cur[2]});
				continue Loop;
			} else {
				break Loop;
			}
		}
		
		System.out.println(answer+"");
	}
	
	private static int[] cleaning(int r, int c, int dir) {
		
		for(int i=0; i<4; i++) {
			//반시계 90도 회전
			if(dir >0) {
				dir -= 1;
			} else {
				dir = 3;
			}
			//보는 방향 탐색 후, 전진 좌표 return
			if(dir == 0) {
				if(r-1>=0 && r-1<row && c>=0 && c<col && arr[r-1][c] == 0) {
					return new int[] {r-1,c,dir};
				}
			} else if(dir == 1) {
				if(r>=0 && r<row && c+1>=0 && c+1<col && arr[r][c+1] == 0) {
					return new int[] {r,c+1,dir};
				}
				
			} else if(dir == 2) {
				if(r+1>=0 && r+1<row && c>=0 && c<col && arr[r+1][c] == 0) {
					return new int[] {r+1,c,dir};
				}
			} else {
				if(r>=0 && r<row && c-1>=0 && c-1<col && arr[r][c-1] == 0) {
					return new int[] {r,c-1,dir};
				}
			}
		}
		
		return null;
	}
}
