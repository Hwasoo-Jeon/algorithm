import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = Integer.parseInt(st.nextToken()); //10,000
		int edge = Integer.parseInt(st.nextToken()); //100,000
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		
		for(int i=0; i<=max; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for(int i=0; i<edge; i++) { //100,000
			st = new StringTokenizer(br.readLine());
			int ver1 = Integer.parseInt(st.nextToken());
			int ver2 = Integer.parseInt(st.nextToken());
			graph.get(ver2).add(ver1);
		}
		
		//결과저장
		TreeMap<Integer, LinkedList<Integer>> result = new TreeMap<>();
		//bfs
		for(int i=1; i<=max; i++) { //10,000
			if(graph.get(i)!=null) {
				Queue<Integer> queue = new LinkedList<>();
				boolean[] visited = new boolean[max+1];
				queue.offer(i);
				visited[i]=true;
				int count =0;
				while(!queue.isEmpty()) { 
					int cur = queue.poll();
					count++;
					for(int node : graph.get(cur)) { //100,000
						if(!visited[node]) {
							queue.offer(node);
							visited[node]=true;
						}
					}					
				}
				if(result.get(count)==null) {
					result.put(count, new LinkedList<>());
				}
				result.get(count).add(i);
				
			}
		}
		
		//결과 출력
		int maxCount = result.lastKey();
		if(result.get(maxCount) != null) {
			Collections.sort(result.get(maxCount));
			for(int val : result.get(maxCount)) {
				bw.write(val+" ");
			}
		} else {
			bw.write(maxCount+"");
		}
		bw.flush();
	}
}
