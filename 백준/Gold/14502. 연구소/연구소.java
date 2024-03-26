import java.io.*;
import java.util.*;

public class Main {
	
	static int result = Integer.MIN_VALUE;
	static int row;
	static int col;
	static int[][] arr;
	static ArrayList<Integer[]> vList = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		arr = new int[row][col];
		int[][] copyArr = new int[row][col];
		
		for(int i=0; i<row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<col; j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i][j] = num;
				if(num == 2) {
					vList.add(new Integer[] {i,j});
				}
			}
		}

		//벽세우기 8*8  벽탐색 : 8*8
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(arr[i][j] == 0) {
					for(int k = 0; k < arr.length; k++) {
						copyArr[k] = arr[k].clone();
					}
					copyArr[i][j] = 1;
					wall(1,i,j, copyArr);
					copyArr[i][j] = 0;
				}
			}
		}
		System.out.println(result);
	}
	
	private static void wall(int cnt, int curRow, int curCol, int[][] copyArr) {
		
		//바이러스 퍼뜨리기
		if(cnt >= 3) {
			int[] moveR = {-1,1,0,0};
			int[] moveC = {0,0,-1,1};
			boolean[][] virus = new boolean[row][col];
			Queue<Integer[]> q = new LinkedList<>();
			for(int i =0; i<vList.size(); i++) {
				q.offer(vList.get(i));
			}
			int[][] virusArr = new int[row][col];
			for(int i=0; i<row; i++) {
				for(int j=0; j<col; j++) {
					virusArr[i][j] = copyArr[i][j];
				}
			}
			
			while(!q.isEmpty()) {
				Integer[] cur = q.poll();
				int curR = cur[0];
				int curC = cur[1];
				for(int i =0; i<4; i++) {
					int newR = curR + moveR[i];
					int newC = curC + moveC[i];
					if(newR >=0 && newR<row && newC>=0 && newC <col) {
						if(virusArr[newR][newC]==0 && !virus[newR][newC]) {
							virusArr[newR][newC]=2;
							virus[newR][newC] = true;
							q.offer(new Integer[] {newR, newC});
						}
					}
				}
			}
			
			//계산
			int curResult = 0;
			for(int i=0; i<row; i++) {
				for(int j=0; j<col; j++) {
					if(virusArr[i][j] == 0) {
						curResult++;
					}
				}
			}	
			result = Math.max(result, curResult);
			
			return;
		}
			
		//벽세우기
		for(int i = curRow; i < row; i++) {
		    // 현재 행에 대해서는 curCol+1부터 시작, 그 외에는 0부터 시작
		    int startCol = (i == curRow) ? curCol + 1 : 0;
		    for(int j = startCol; j < col; j++) {
		        if(arr[i][j] == 0) {
		        	copyArr[i][j] = 1;
		            wall(cnt+1, i, j, copyArr);
		            copyArr[i][j] = 0;

		        }
		    }
		}
	}
}
