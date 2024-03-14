import java.io.*;

public class Main {
	
	static int[][] dp;
	static int[] point;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int level = Integer.parseInt(br.readLine());
		int[] point = new int[level+1];
		int[][] dp = new int[level+1][2];
		
		for(int i = 1; i <=level; i++)
		{	
			point[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1][0] = point[1];
		// dp[1][1] = 0; => 첫계단 연속은 불가
			
		if(level >= 2)
		{
            dp[2][0] = point[2];
            dp[2][1] = point[1] + point[2];
        }
		
		for(int i = 3; i <= level; i++)
		{
            dp[i][0] = Math.max(dp[i-2][0], dp[i-2][1]) + point[i]; // 연속 안 밟은 경우
            dp[i][1] = dp[i-1][0] + point[i]; // 연속으로 밟은 경우
        }
        
        int result = Math.max(dp[level][0], dp[level][1]);
		bw.write(result+"");
		bw.flush();
	}
}