import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		long[][] dp = new long[row+1][col+1]; //입력(x,y) => 변환(y,x)
		int[][] van = new int[Integer.parseInt(br.readLine())][4]; //입력(x,y) => 변환(y,x)
		ArrayList<int[]> vanList = new ArrayList<>();
		for(int i=0; i<van.length; i++) {
			st = new StringTokenizer(br.readLine());
			int lx = Integer.parseInt(st.nextToken());
			int ly = Integer.parseInt(st.nextToken());
			int rx = Integer.parseInt(st.nextToken());
			int ry = Integer.parseInt(st.nextToken());
			if(rx<lx || ry<ly) {
				van[i][0] =ry;
				van[i][1] =rx;
				van[i][2] =ly;
				van[i][3] =lx;
				vanList.add(new int[] {ry,rx,ly,lx});
			} else {
				van[i][0] =ly;
				van[i][1] =lx;
				van[i][2] =ry;
				van[i][3] =rx;
				vanList.add(new int[] {ly,lx,ry,rx});
			}
		}
		
		Collections.sort(vanList, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]!= o2[0]) {
					return o1[0]- o2[0];
				} else if(o1[1]!= o2[1]) {
					return o1[1] - o2[1];
				} else if(o1[2]!= o2[2]) {
					return o1[2] - o2[2];
				} else if(o1[3] != o2[3]) {
					return o1[3] - o2[3];
				}
				return 0;
			}
		});
		 
		dp[0][0] = 1;
//		for(int i=0; i<=row; i++) {
//			for(int j=0; j<=col; j++) {
//				int[] mRow = {1,0};
//				int[] mCol = {0,1};
//				for(int m=0; m<2; m++) {
//					int newRow = i+mRow[m];
//					int newCol = j+mCol[m];
//					if(newRow>=0&& newRow<=row && newCol>=0 && newCol<=col) {
//						if(vanList.size()>0) {
//							int[] check = vanList.get(0);
//							int ly = check[0];
//							int lx = check[1];
//							int ry = check[2];
//							int rx = check[3];
//							if(ly==i && lx==j && ry==newRow && rx==newCol) {
//								vanList.remove(0);
//								continue;
//							}
//						}
//						dp[newRow][newCol] += dp[i][j];
//					}
//				}
//			}
//		}
		for(int i=0; i<=row; i++) {
			for(int j=0; j<=col; j++) {
				int[] mRow = {1,0};
				int[] mCol = {0,1};
				loop:
				for(int m=0; m<2; m++) {
					int newRow = i+mRow[m];
					int newCol = j+mCol[m];
					if(newRow>=0&& newRow<=row && newCol>=0 && newCol<=col) {
						for(int v=0; v<vanList.size(); v++) {
							int[] check = vanList.get(v);
							int ly = check[0];
							int lx = check[1];
							int ry = check[2];
							int rx = check[3];
							if(ly==i && lx==j && ry==newRow && rx==newCol) {
								vanList.remove(v);
								continue loop;
							}
						}
						dp[newRow][newCol] += dp[i][j];
					}
				}
			}
		}
		
		System.out.println(dp[row][col]);
	}
}

/*
탐색 방법
: dp[1][1] = dp[0][1] + dp[1][0]
newX = curX + 1;
newY = curY + 0;

newX = curX + 0;
newY = curY + 1;
for() van과 겹치면 진입불가

//		for(int i=0; i< vanList.size(); i++) {
//			int[] start = vanList.get(i);
//			int sy = start[0];
//			int sx = start[1];
//			if(sy == 0 & sx==0) {
//				System.out.println(0);
//				return;
//			}
//		}
			
//			for(int i=0; i<row; i++) {
//				for(int j=0;j<dp[i].length;j++) {
//				System.out.print(dp[i][j]+",");
//				}
//				System.out.println();
//			}

*/