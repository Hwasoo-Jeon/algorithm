import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int target = Integer.parseInt(st.nextToken());
		int destination = Integer.parseInt(st.nextToken());
		Queue<LinkedList<Integer>> q = new LinkedList<>();
		LinkedList<Integer> input = new LinkedList<>();
		boolean[] visited = new boolean[100001];
		
		input.add(target);
		input.add(0);
		
		q.offer(input);
		visited[target] = true;
		
		while(!q.isEmpty()) {
			LinkedList<Integer> cur = q.poll();
			int cur_loc = cur.pollFirst();
			int cur_count = cur.pollFirst();
			if(cur_loc == destination) {
				bw.write(cur_count + "");
				break;
			}
			
			//이동로직
			int new_mloc = cur_loc - 1;
			int new_ploc = cur_loc + 1;
			int new_2loc = cur_loc*2;
			int new_count = cur_count+1;
			
			if(new_2loc<= 100000 && !visited[new_2loc]) {
				input.add(new_2loc);
				input.add(new_count);
				q.offer(input);
				visited[new_2loc] = true;
			}
			if(new_ploc<= 100000 && !visited[new_ploc]) {
				input = new LinkedList<Integer>();
				input.add(new_ploc);
				input.add(new_count);
				q.offer(input);
				visited[new_ploc] = true;
			}
			if(new_mloc>=0 && !visited[new_mloc]) {
				input = new LinkedList<Integer>();
				input.add(new_mloc);
				input.add(new_count);
				q.offer(input);
				visited[new_mloc] = true;
			}
		}
		bw.flush();
	}	
}
