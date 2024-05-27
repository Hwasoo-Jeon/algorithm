import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : scoville) {
            pq.offer(i);
        }
        
        if(pq.peek() >= K) {
            return answer;
        }
        
        while(pq.size() > 1) {
            int n1 = pq.poll();
            int n2 = pq.poll();
            int result = n1 + n2*2;
            answer++;
            pq.offer(result);
            if(pq.peek() >= K) {
                return answer;
            }
            
        }
        return -1;
    }
}