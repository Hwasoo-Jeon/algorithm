import java.util.*;
import java.io.*;

public class Main {
	
	private static int n;
	private static int m;
	private static int[] arr;
	private static boolean[] visit;
	private static BufferedWriter bw;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[m];
		visit = new boolean[n];
		
		dfs(0);
		bw.flush();
		bw.close();
	}
	
	private static void dfs(int depth) throws IOException {
		if(depth == m) {
			for(int num : arr) {
				bw.write(num+" ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[depth] = i+1;
				dfs(depth+1);
				visit[i] = false;
			}
		}
	}
}
