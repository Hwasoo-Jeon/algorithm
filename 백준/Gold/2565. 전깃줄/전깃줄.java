import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] wire = new int[tc][2];
		int[] dp = new int[tc];
		for(int i=0; i<tc; i++) {
			st = new StringTokenizer(br.readLine());
			wire[i][0] = Integer.parseInt(st.nextToken());
			wire[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(wire, new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				
				return o1[0] - o2[0];
			}
		});
		
		//LIS+DP
		int max = Integer.MIN_VALUE;
		for(int i=0; i<tc; i++) {
			dp[i] = 1;
			for(int j=0; j<i; j++) {
				if(wire[i][1] > wire[j][1] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(tc - max);
	}
}

/*
 * 
 * 답안체크함 : LIS 방식으로 dp배열의 각 index에 해당 위치까지 존재할 수 있는 최다 전깃줄 갯수 계산, Comparator 사용
 * 전체 전깃줄-최다 전깃줄 갯수 >> 가장 적게 철거할 갯수
 * == LIS인 이유?
 *1 8
 *2 2
 *3 9
 *4 1
 *6 4
 *7 6 
 *9 7 
 *10 10
 *==
 *8 2 9 1 4 6 7 10 에서 특정 index에서 가질 수 있는 최다 전깃줄은 "증가순열 + 최장"
 *
 *idx
 *1   => 8
 *2   => 2
 *3   => 8 9
 *4   => 1
 *5   => 2 4
 *6   => 2 4 6 
 *7   => 2 4 6 7 
 *8   => 2 4 6 7 10 => 간섭받지 않은 a->b 연결된 최다 갯수
 *
 *마지막 dp 배열만이 최다 갯수를 지칭하진 않음.
 */