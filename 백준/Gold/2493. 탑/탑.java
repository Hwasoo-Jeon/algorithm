import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine()); // 500,000
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] building = new int[N+1];
		int[] result = new int[N+1];
		Stack<int[]> stack = new Stack<>();
		for(int i=1; i<=N;i++) {
			building[i] = Integer.parseInt(st.nextToken());
		}
		stack.add(new int[] {building[1], 1}); // 1번째를 stack에 저장
		
		for(int i=2; i<=N;i++) { //2번째 부터 stack과 비교.
			while(!stack.isEmpty()) { //num이 building[i]보다 작으면, stack에서 pop. building[i]값이 현재 가장 크므로, stack이 비어도 상관없음.
				int[] cur = stack.pop();
				if(cur[0] > building[i]) {
					result[i] = cur[1];
					stack.add(cur); //lifo 이용
					break;
				}
			}
			stack.add(new int[] {building[i], i});
		}
		
		for(int i=1; i<= N; i++) {
			bw.write(result[i]+" ");
		}
		bw.flush();
	}
	
//	
//	private static void recur(int start, int idx) {
//		System.out.println(start+"  "+idx);
//		if(start <= 0) {
//			result[idx] = 0;
//			return;
//		}
//		
//		if(building[idx] <= building[start-1]) {
//			result[idx] = start-1;
//			return;
//		} else {
//			recur(start-1, idx);
//		}
//	}
}

//참고사항 : 재귀써서 이전꺼 탐색하면 무조건 O(N^2)
//stack 사용
