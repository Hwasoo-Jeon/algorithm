import java.util.*;
import java.io.*;

//0번 node는 없기에 list 생성범위를 +1, visited 배열 범위를 +1
public class Main {

	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int startNum = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>(); // 선언법 체크

		// 인접리스트 생성
		for (int i = 0; i <= n; i++) { // <= 는 인덱스 오류 방지
			graph.add(new ArrayList<>());
		}
		String[] arr;
		for (int i = 0; i < m; i++) {
			arr = br.readLine().split(" ");
			int num1 = Integer.parseInt(arr[0]);
			int num2 = Integer.parseInt(arr[1]);
			graph.get(num1).add(num2);
			graph.get(num2).add(num1);
		}
        
        for (int i = 0; i <= n; i++) { // <= 작은 
			Collections.sort(graph.get(i));
		}

		// dfs
		visited = new boolean[n + 1];
		dfs(startNum);
		sb.append("\n");
		// bfs
		Arrays.fill(visited, false); // 단지 값만 초기화
		bfs(startNum);

		bw.write(sb.toString());
		bw.flush();
	}

	static void dfs(int nodeIndex) {
		if (visited[nodeIndex]) {
			return;
		}

		visited[nodeIndex] = true;
		sb.append(nodeIndex).append(" ");
		for (int next : graph.get(nodeIndex)) {
			// 재귀
			if (!visited[next]) {
				dfs(next);
			}
		}
	}

	static void bfs(int nodeIndex) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(nodeIndex);
		visited[nodeIndex] = true; // while 안에서 하면 어떻게 됨? 상관없다 while안에서 false인 경우 true로 바꿔주면 됨. 동작 원리는 동일

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			sb.append(cur).append(" ");

			for (int next : graph.get(cur)) {
				if (!visited[next]) {
					queue.offer(next);
					visited[next] = true;
					// bfs(next); 재귀호출 하면 dfs 처럼 next와 연결된 노드를 탐색하므로 깊이 탐색과 같이 됨.
				}
			}
		}
	}

}