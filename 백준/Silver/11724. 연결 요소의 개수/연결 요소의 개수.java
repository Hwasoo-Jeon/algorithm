import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); 
		int ver = Integer.parseInt(st.nextToken()); 
		int edge = Integer.parseInt(st.nextToken()); 
		int count = 0;
		//graph 생성
		for(int i=0; i<= ver; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		Queue<Integer> queue = new LinkedList<>();
		boolean visited[] = new boolean[ver+1];
		for(int i=0; i< edge; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			graph.get(num1).add(num2);
			graph.get(num2).add(num1);
		}
		
		for(int x=1; x<=ver; x++) {
			if(!visited[x]) {
				queue.offer(x);
				visited[x] = true;
				while(!queue.isEmpty()) {
					int cur = queue.poll();
					for(int num2:graph.get(cur)) {
						if(!visited[num2]) {
							queue.offer(num2);
							visited[num2] = true;
						}
					}
				}
				count++;
			}
		}
		bw.write(count+"");
		bw.flush();
	}
}
