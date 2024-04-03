import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //100,000
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<n; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		
		int answer = 0;
        if(pq.size()==1) {
			System.out.println(0);
			return;
		}
		while(!pq.isEmpty()) {
			if(pq.size() == 2) {
				answer += pq.poll()+pq.poll();
				break;
			}
			int num1 = pq.poll();
			int num2 = pq.poll();
			int num3 = num1+num2;
			answer += num3;
			pq.offer(num3);
		}
		
		System.out.println(answer);
	}
}
