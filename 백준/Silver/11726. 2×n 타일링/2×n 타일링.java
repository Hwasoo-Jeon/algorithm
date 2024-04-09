import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		int[] dp = new int[size+1];
		if(size < 3) {
			if (size == 1) System.out.println(1);
			else System.out.println(2);
		} else {
			dp[1] = 1;
			dp[2] = 2;
			for(int i=3; i<=size; i++) {
				dp[i] = (dp[i-2] + dp[i-1])%10007;
			}
			System.out.println(dp[size]);
		}
	}
}