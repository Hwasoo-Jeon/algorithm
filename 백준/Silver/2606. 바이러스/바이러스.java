import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int total = Integer.parseInt(br.readLine());
		int edge_count = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		
		for(int i=0; i<= total; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<edge_count; i++) {
			st = new StringTokenizer(br.readLine());
			int ver1 = Integer.parseInt(st.nextToken());
			int ver2 = Integer.parseInt(st.nextToken());
			graph.get(ver1).add(ver2);
			graph.get(ver2).add(ver1);
		}
		
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[total+1];
		queue.offer(1);
		visited[1] = true;
		int result = 0;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for(int next : graph.get(cur)) {
				if(!visited[next]) {
					queue.offer(next);
					visited[next] = true;
					result++;
				}
			}
		}
		bw.write(result+"");
		bw.flush();
	}

}
