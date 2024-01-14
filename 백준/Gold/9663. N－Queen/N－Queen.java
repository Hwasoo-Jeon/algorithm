import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static int result;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		arr = new int[n];

		dfs(0);
		bw.write(result+"");
		bw.flush();
	}

	private static void dfs(int depth) {
		if (depth == n) {
			result++;
			return;
		}

		for (int i = 0; i < n; i++) {
			arr[depth] = i;
			if(possibility(depth)) {
				dfs(depth+1);
			}
		}

	}
	
	private static boolean possibility(int col) {
		for(int i =0; i<col; i++) {
			if(arr[col] == arr[i]) {
				return false;
			}
			if(Math.abs(arr[col] - arr[i]) == Math.abs(col - i)) {
				return false;
			}
		}
		return true;
	}
}
