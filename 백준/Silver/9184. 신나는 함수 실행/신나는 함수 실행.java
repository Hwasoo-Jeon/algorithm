import java.io.*;

public class Main {
	private static int[][][] dp = new int[21][21][21];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while(true) {
			String input = br.readLine();
			if(input.equals("-1 -1 -1")) break;
			String[] arr = input.split(" ");
			int a = Integer.parseInt(arr[0]);
			int b = Integer.parseInt(arr[1]);
			int c = Integer.parseInt(arr[2]);
			int result = w(a,b,c);
			bw.write("w("+a+", "+b+", "+c+") = "+result+"\n");
		}
		bw.flush();
	}
	
	private static int w(int a, int b, int c) {
		if(a>= 0 && b>=0 && c>=0 && a <= 20 && b<=20 && c<= 20 && dp[a][b][c] != 0) {
			return dp[a][b][c];
		}
		
		if (a <= 0 || b <= 0 || c <= 0) return dp[0][0][0] = 1;
		else if (a > 20 || b > 20 || c > 20) return w(20, 20, 20);
		else if (a < b && b < c) return dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
		else return dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
	}

}
