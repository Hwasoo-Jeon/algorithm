import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[][] dp = new long[11][11];
		
		// r(left)이 0이거나  n ==r 이면 1 return.
		for (int i = 0; i < 11; i++) {
			dp[i][i] = 1;
			dp[i][0] = 1;
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		for(int i=2; i<=n; i++) {
			for(int j=1; j<=r; j++) {
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j]; 
			}
		}
		System.out.println(dp[n][r]);
	}	
}