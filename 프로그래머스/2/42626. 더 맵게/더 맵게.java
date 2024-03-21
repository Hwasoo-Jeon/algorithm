import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = -1;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i =0; i<scoville.length; i++) {
            pq.offer(scoville[i]);
        }
        
        if (pq.peek() >= K) {
            return 0;
        } else {
            int cnt = 0;
            while(pq.size() >= 2) {
                int num1 = pq.poll();
                int num2 = pq.poll();
                int newK = num1+num2*2;
                pq.offer(newK);
                cnt++;
                if(pq.peek()>=K) {
                    return cnt;
                }
            }
            return answer;
        }
    }
}