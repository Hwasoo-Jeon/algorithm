import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		int[] coin = new int[n];
		int[] dp = new int[target+1];
		for(int i=0; i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			if(num > target) {
				continue;
			}
			coin[i] = num;
			dp[num] = 1;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=coin[i]; j<=target; j++) {
				if(dp[j-coin[i]] == 0 ) {
					continue;
				}
				if(dp[j] == 0) {
					dp[j] = dp[j-coin[i]] + 1;
				} else {
					dp[j] = Math.min(dp[j-coin[i]] + 1, dp[j]);
				}
			}
		}
		
		System.out.println(dp[target]==0? -1 : dp[target]);
	}	
}
