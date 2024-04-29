import java.util.*;
import java.io.*;

public class Main {
	private static int[][] dp = new int[41][5]; //값 0 1
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		for(int[] inner: dp) {
			Arrays.fill(inner, -1);
		}
		dp[0] = new int[] {0,1,0};
		dp[1] = new int[] {1,0,1};
		fibo(40);
		
		for(int i=0; i<n; i++) {
			int tar = Integer.parseInt(br.readLine());
			bw.write(dp[tar][1]+" "+dp[tar][2]+"\n");
		}
		
		bw.flush();
	}
	
	private static int[] fibo(int idx) {
		
		if(dp[idx][0] != -1) {
			return dp[idx];
		}
		
		for(int i=2; i<=idx; i++) {
			dp[i][0] = dp[i-1][0] + dp[i-2][0];
			String num = String.valueOf(dp[i][0]);
//			int zeroCnt = 0;
//			int oneCnt = 0;
//			for(int k=0; k<num.length(); k++) {
//				
//				String cur = num.substring(k, k+1);
//				if (cur.equals("0")) {
//					zeroCnt++;
//				} else if (cur.equals("1")) {
//					oneCnt++;
//				}
//				
//			}
			dp[i][1] = dp[i-1][1] + dp[i-2][1];
			dp[i][2] = dp[i-1][2] + dp[i-2][2];

			
		}
		return dp[idx];
	}
}