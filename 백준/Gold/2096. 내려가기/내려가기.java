import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int tc = Integer.parseInt(br.readLine());
		int[][] arr = new int[tc][3];

		int[][] max = new int[2][3];
		int[][] min = new int[2][3];
		for (int i = 0; i < tc; i++) { // 100000
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < 3; i++) {
			max[0][i] = arr[0][i];
			min[0][i] = arr[0][i];
		}

		for (int i = 1; i < tc; i++) {
			max[1][0] = Math.max(max[0][0], max[0][1]) + arr[i][0];
			max[1][1] = Math.max(max[0][0], Math.max(max[0][1], max[0][2])) + arr[i][1];
			max[1][2] = Math.max(max[0][1], max[0][2]) + arr[i][2];

			min[1][0] = Math.min(min[0][0], min[0][1]) + arr[i][0];
			min[1][1] = Math.min(min[0][0], Math.min(min[0][1], min[0][2])) + arr[i][1];
			min[1][2] = Math.min(min[0][1], min[0][2]) + arr[i][2];

			for (int j = 0; j < 3; j++) {
				max[0][j] = max[1][j];
				min[0][j] = min[1][j];
			}
		}

		int resultMax = Math.max(Math.max(max[0][0], max[0][1]), max[0][2]);
		int resultMin = Math.min(Math.min(min[0][0], min[0][1]), min[0][2]);

		bw.write(resultMax + " " + resultMin);
		bw.flush();
	}

}
