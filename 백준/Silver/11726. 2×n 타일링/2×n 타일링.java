import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int size = Integer.parseInt(br.readLine());

		if (size == 1 || size == 2) {
			bw.write(Integer.toString(size));
		} else {
			int[] dp = new int[size + 1];
			dp[1] = 1;
			dp[2] = 2;
			for (int i = 3; i <= size; i++) {
				dp[i] = (dp[i - 1] + dp[i - 2])%10007;
			}
			bw.write((dp[size])+"");
		}
		bw.flush();

	}
}