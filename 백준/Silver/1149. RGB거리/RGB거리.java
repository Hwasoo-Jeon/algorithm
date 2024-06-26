import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n][3];
		int[][] arr = new int[n][3];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		
		//1:0, 2:1, 3:2, 4: 3, ...  1000: 999
		dp[0][0] = arr[0][0];
		dp[0][1] = arr[0][1];
		dp[0][2] = arr[0][2];
		for(int i=1; i<n; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0]; //현재 위치가 r
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1]; //현재 위치가 g
			dp[i][2] = Math.min(dp[i-1][1], dp[i-1][0]) + arr[i][2]; //현재 위치가 b
		}
		
		System.out.println(Math.min(Math.min(dp[n-1][0],dp[n-1][1]),dp[n-1][2]));
	}
}