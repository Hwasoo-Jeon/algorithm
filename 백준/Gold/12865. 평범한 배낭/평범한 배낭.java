import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num = Integer.parseInt(st.nextToken());
		int val = Integer.parseInt(st.nextToken());
		int[] w = new int[num+1]; //입력 값의 index 대한 물건 무게 배열
		int[] v = new int[num+1]; //입력 값의 index 대한 물건 가치 배열
		int[][] dp = new int[num+1][val+1]; //i번째 물건을 배낭에 담을 때, 0~최대 수용 무게에 대항 하는 최대 가치
		
		for(int i=1; i<=num; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
		
		//dp
		for(int i=1; i<=num; i++) {
			for(int j=1; j<=val; j++) {
				if(j<w[i]) { //현재 담으려는 무게가(w[i]) 현재까지 고려한 무게보다 크다면
					dp[i][j] = dp[i-1][j]; //지금 물건을 담기 직전의 최대 가치 합을 저장
				} else {
					//지금 물건을 담기 직전의 최대가치 
					//vs
					//지금 담으려는 물건의 가치 + (현재 무게 - 지금 무게)분할하여 담을 수 있는 무게의 가치
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]] + v[i]); 
				}
			}
		}
		
		bw.write(Integer.toString(dp[num][val]));
		bw.flush();
	}

}