import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int f = Integer.parseInt(st.nextToken()); // 건물 높이
		int s = Integer.parseInt(st.nextToken()); // 현 위치
		int g = Integer.parseInt(st.nextToken()); // 스타링크
		int u = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		Queue<LinkedList<Integer>> q = new LinkedList<>();
		LinkedList<Integer> input = new LinkedList<>();
		boolean[] visited = new boolean[f + 1];
		boolean flag = false;
		visited[0] = true;
		input.add(s);
		input.add(0);
		q.offer(input);
		visited[s] = true;
		while (!q.isEmpty()) {
			LinkedList<Integer> cur = q.poll();
			int cur_lvl = cur.pollFirst();
			int cur_count = cur.pollFirst();

			if (cur_lvl == g) {
				bw.write(cur_count + "");
				flag = true;
				break;
			}

			int next_up = cur_lvl + u;
			int next_down = cur_lvl - d;

			if (next_up <= f && !visited[next_up]) {
				input.add(next_up);
				input.add(cur_count+1);
				q.offer(input);
				visited[next_up] = true;
			}
			if (next_down >= 1 && !visited[next_down]) {
				input.add(next_down);
				input.add(cur_count+1);
				q.offer(input);
				visited[next_down] = true;
			}
		}

		if (!flag) {
			bw.write("use the stairs");
		}
		bw.flush();

	}
}
