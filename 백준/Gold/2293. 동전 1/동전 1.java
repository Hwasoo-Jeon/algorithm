import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int kind = Integer.parseInt(st.nextToken()); //100
		int val = Integer.parseInt(st.nextToken()); //10000
		long[] dp = new long[val+1];
		int[] coin = new int[kind];
		for(int i=0; i< kind; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		//DP
		dp[0] = 1;
		for(int i=0; i<kind; i++) {
			for(int j=coin[i]; j<=val; j++) {
				dp[j] += dp[j - coin[i]];
			}
		}
		bw.write(dp[val]+"");
		bw.flush();
	}
}
