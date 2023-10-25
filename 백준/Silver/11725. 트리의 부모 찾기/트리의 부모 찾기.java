import java.util.*;
import java.io.*;

public class Main {
	
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph;
	static TreeMap<Integer,Integer> result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int total = Integer.parseInt(br.readLine());
		graph = new ArrayList<>();
		for(int i=0; i<=total; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<total-1; i++) {
			st = new StringTokenizer(br.readLine());
			int ver1 = Integer.parseInt(st.nextToken());
			int ver2 = Integer.parseInt(st.nextToken());
			graph.get(ver1).add(ver2);
			graph.get(ver2).add(ver1);
		}
		
        /*
		//treeMap에 <k,v> => <자식노드 , 부모노드>로 저장
		for (int i = 0; i <= total; i++) {
			Collections.sort(graph.get(i));
		}*/
		result = new TreeMap<>();
		visited = new boolean[total+1];
		dfs(1);
		
		//결과 출력
		for(int key: result.keySet()) {
			bw.write(result.get(key)+"\n");
		}
		bw.flush();
	}

	private static void dfs(int i) {
		if(visited[i]) {
			return;
		}
		visited[i] = true;
		
		for(int next : graph.get(i)) {
			if(!visited[next]) {
				result.put(next, i);
				dfs(next);
			}
		}
		
	}
}
