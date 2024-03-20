import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int pre = Integer.parseInt(st.nextToken());
		int result = 0;
		ArrayList<Queue<Integer[]>> people = new ArrayList<>();
		
		for (int i = 0; i<m; i++) {
			Queue<Integer[]> queue = new LinkedList<>();
			people.add(queue);
		}
		
		//입력 정보 list
		for(int i =0; i<n; i++) {
			int idx = i%m; //라인
			st = new StringTokenizer(br.readLine());
			if(i== pre) {
				people.get(idx).offer(new Integer[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), idx, -1}); //데카 표식
			} else {
				people.get(idx).offer(new Integer[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), idx, 0});
			}
			//System.out.println(Arrays.toString(people.get(idx).poll()));
		}
		
		//우선순위큐 사용
		PriorityQueue<Integer[]> pq = new PriorityQueue<Integer[]>((o1, o2) -> {
		    if (o1[0].equals(o2[0])) {
		    	if(o1[1].equals(o2[1])) {
			    	return o1[2] - o2[2];
			    } 
			    return o2[1] - o1[1]; 
		    } 
		    return o2[0] - o1[0];
		});
		
		//첫 번째 라인 진행
		for(int i =0; i<m; i++) {
			if(!people.get(i).isEmpty()) {
				pq.offer(people.get(i).poll());
			} else {
				break;
			}
		}
		
		while(!pq.isEmpty()) {
			Integer[] cur = pq.poll();
			int emptyLine = cur[2];
			if(cur[3] == -1) {
				break;
			}
			
			if(!people.get(emptyLine).isEmpty()) {
				pq.offer(people.get(emptyLine).poll());
			}
			
			result++;
		}

		System.out.println(result);

	}
	//참고사항 : pq의 사용 시점, 특정 라인이 사라진 것의 체킹을 위한 인덱스 추가
	//틀린사항 : pq의 조건문에서 == 을 사용하여 참조값을 비교했기때문 => equals로 변경
}
