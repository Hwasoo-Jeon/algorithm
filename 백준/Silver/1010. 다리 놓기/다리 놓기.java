import java.util.*;
import java.io.*;

public class Main {

	private static long[][] dp = new long[30][30];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());
		
		// r(left)이 0이거나  n ==r 이면 1 return.
		for (int i = 0; i < 30; i++) {
			dp[i][i] = 1;
			dp[i][0] = 1;
		}
		
		for(int i=0; i<tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			for(int j = 1; j<=left; j++) {
				for(int k=1; k<=right; k++) {
					dp[k][j] = dp[k-1][j-1] + dp[k-1][j];  
				}
			}
			bw.write(dp[right][left]+"\n");
		}

		bw.flush();
	}
	
	
	private static long dpFunc(int n, int r) {
		
		if(dp[n][r] > 0) {
			return dp[n][r];
		}
		
		if(n==r || r==0) {
			return dp[n][r] = 1;
		}
		
		return dpFunc(n-1, r-1) + dpFunc(n-1, r);
	}
	
}

/*
조합 nCr
=> 재귀 진행시(파스칼공식) : (n+1 C r+1) = (n C r) + (n C r+1) 
=> r(left)이 0이거나  n ==r 이면 1 return.
*/