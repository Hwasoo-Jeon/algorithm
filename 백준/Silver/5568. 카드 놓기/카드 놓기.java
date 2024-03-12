import java.util.*;
import java.io.*;

public class Main {
	static int n = 0;
	static int k = 0;
	static Set<String> ans = new HashSet<>();
	static ArrayList<Integer> num_arr = new ArrayList<Integer>(); 
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		visited = new boolean[n];
		
		// 입력 배열
		for (int i=0; i<n; i++) {
			num_arr.add(Integer.parseInt(br.readLine()));
		}
		
		//순열
		dfs(0, new String());
		bw.write(ans.size()+"");
		bw.flush();
	}
	
	private static void dfs(int depth, String str) {
		
		if(depth == k) {
			ans.add(str);
			return;
		}
		
		for (int i=0; i<n; i++ ) {
			if(visited[i] == false) {
				visited[i] = true;
				dfs(depth +1, str+num_arr.get(i).toString());
				visited[i] = false;
			}
		}
	}
}
