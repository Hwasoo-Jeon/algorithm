import java.util.*;
import java.io.*;

public class Main {
	
	private static int row;
	private static int col;
	private static Character[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		arr = new Character[row][col];
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		
		for(int i=0; i<row; i++) {
			String s = br.readLine();
			for(int j=0; j<col; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(arr[i][j] == 'L') {
					boolean[][] visited = new boolean[row][col];
					visited[i][j] = true;
					int curMove = bfs(i,j, visited);
					resultList.add(curMove);
				}
			}
		}
		Collections.sort(resultList, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		
		System.out.println(resultList.get(0));
		
	}
	
	private static int bfs(int r, int c, boolean[][] visited) {
		Queue<Integer[]> q = new LinkedList<>();
		q.offer(new Integer[] {r,c,0});
		int result = 0;
		while(!q.isEmpty()) {
			Integer[] cur = q.poll();
			int curRow = cur[0];
			int curCol = cur[1];
			int curMove = cur[2];
			int[] moveRow = {-1,1,0,0};
			int[] moveCol = {0,0,-1,1};
			result = Math.max(result, curMove);
			for(int i=0; i<4; i++) {
				int newRow = curRow+moveRow[i];
				int newCol = curCol+moveCol[i];
				if(newRow>=0 && newRow<row && newCol>=0 && newCol<col) {
					if(arr[newRow][newCol] == 'L' &&!visited[newRow][newCol]) {
						visited[newRow][newCol] = true;
						q.offer(new Integer[] {newRow, newCol, curMove+1});
					}
				}
			}
		}
		return result;
	}
}
