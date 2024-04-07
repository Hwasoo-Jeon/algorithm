import java.util.*;

class Solution {
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>(); //건널트럭(입력 큐)
        Queue<Integer> isCrossing = new LinkedList<>(); //건너는 트럭
        Queue<Integer> isCrossingTime = new LinkedList<>(); //건너는 트럭의 시간
        
        for(int i=0; i<truck_weights.length; i++) {
            q.offer(truck_weights[i]);
        }
        
        int answer = 0;
        int bridgeWeight = 0;
        int isCrossingCnt = 0;
        int totalCnt = 0;
        while(totalCnt != truck_weights.length) {
            answer++;
            if(!isCrossingTime.isEmpty() 
               && isCrossingTime.peek() == bridge_length) {
                isCrossingTime.poll();
                bridgeWeight -= isCrossing.poll();
                isCrossingCnt --;
                totalCnt++;
            }
            
            if(!q.isEmpty()) {
                int next = q.peek();
                if(bridgeWeight + next <= weight && isCrossingCnt < bridge_length) {
                    bridgeWeight += next;
                    isCrossingCnt++;
                    isCrossing.offer(q.poll());
                    isCrossingTime.offer(0);
                }
            }
            
            for(int i=0; i<isCrossingTime.size(); i++) {
                isCrossingTime.add(isCrossingTime.poll()+1);
            }
        }

        return answer;
    }
}
/*
모든 트럭 다리 건너는 시간 최소 몇초?
정해진 순.
bridge_length대
weight 이하까지의 무게


*/