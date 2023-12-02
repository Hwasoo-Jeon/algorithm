import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int tc = Integer.parseInt(br.readLine());
		
		//예외 조건 동전이 1개인경우.
		for(int i=0; i < tc; i++) { //10
			int kind = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] coin = new int[kind]; //동전 넣어있는 배열
			for(int j=0; j<kind; j++) { //20(*10)
				coin[j] = Integer.parseInt(st.nextToken());
			}
			int val = Integer.parseInt(br.readLine());
			long[] dp = new long[val+1]; //최대 10000
			
			//바텀업
			dp[0] = 1;
			for(int j=0; j<kind; j++) { //20
				for(int k=coin[j]; k<=val; k++) {
					dp[k] += dp[k-coin[j]]; //현재 동전을 사용해 결과를 만드는 가짓수를 이전 것을 통해 가져오기 위해.
				}
			}
			bw.write(dp[val]+"\n");
		}
		bw.flush();
	}
}
