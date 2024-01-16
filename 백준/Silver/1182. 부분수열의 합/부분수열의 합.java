import java.util.*;
import java.io.*;

public class Main {
	
	static int num;
	static int target;
	static int[] arr;
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		num = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());
		arr = new int[num];
	
		st = new StringTokenizer(br.readLine());
		for(int i =0; i<num; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0,0);
		bw.write(target==0?Integer.toString(result-1) : Integer.toString(result));
		bw.flush();
	}
	
	private static void dfs(int depth, int cur) {
		
		if(depth == num) {
			if (cur == target) {
				result++;
			}
			
			return;
		}
		
        dfs(depth+1, cur+arr[depth]);
        dfs(depth+1, cur);
			
	}
	
}
