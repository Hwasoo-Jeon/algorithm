import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dp = new int[size+1];
		int[] num = new int[size+1];
		for(int i=1; i<=size; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = 1;
		for(int i=1; i<=size; i++) {
			dp[i] = 1;
			for(int j=1; j<=i; j++) {
				if(num[i] < num[j] && dp[i] < dp[j] +1) {
					dp[i] = dp[j] + 1;
				}
			}
			result = Math.max(result, dp[i]);
		}
		System.out.println(result);
	}

	//참고사항 : 가장긴 감소순열 정의, dp[i]의 값이 뜻하는 건? 해당 index까지의 가장긴 감소순열의 길이
	//추가참고함
}
