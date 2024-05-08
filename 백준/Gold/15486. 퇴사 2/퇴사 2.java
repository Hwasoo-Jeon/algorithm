import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n+1][2];
		int[] dp = new int[n+2];//최대 금액 저장
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			arr[i][0] = n1; //시간
			arr[i][1] = n2; //임금
		}

		//dp[][0] : 최대금액, dp[][1] 전작업시간
		for(int i=1; i<=n; i++) {
			
			// i일의 상담 시간이 n+1일에 종료된다면 ok
			if(i + arr[i][0] <= n+1) {
				dp[i + arr[i][0]] = Math.max(dp[i + arr[i][0]],  dp[i] + arr[i][1]); //i일의 상담이 끝나는 날짜의 기존 금액과 비교해서 갱신 
			}
			// i일에 일을 선택 여부에 따른, i+1일의 최고금액 갱신, n+1일엔 max값 저장 
			dp[i+1] = Math.max(dp[i], dp[i+1]);
		}
		System.out.println(dp[n+1]);
	}
}