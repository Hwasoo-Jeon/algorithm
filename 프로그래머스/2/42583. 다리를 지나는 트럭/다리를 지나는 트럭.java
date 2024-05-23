import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        int answer = 0;
        int bridgeWeight = 0;
        Queue<int[]> bridgeQ = new LinkedList<>();
        Queue<int[]> waitQ = new LinkedList<>();
        
        for(int i : truck_weights) {
            waitQ.offer(new int[] {i, bridge_length});
        }
        
        while(!waitQ.isEmpty() || !bridgeQ.isEmpty()) {
            
            //다리 위 트럭 이동
            int cnt = bridgeQ.size();
            for(int i=0; i< cnt; i++) {
                int[] truck = bridgeQ.poll();
                truck[1]--;
                if(truck[1] > 0) {
                    bridgeQ.offer(truck);
                } else {
                    bridgeWeight -= truck[0];
                }
            }
            
            
            //대기 중 트럭을 다리에 진입
            if(!waitQ.isEmpty()) {
                int[] waitingTruck = waitQ.peek();
                if (bridgeWeight + waitingTruck[0] <= weight) {
                    bridgeWeight += waitingTruck[0];
                    bridgeQ.offer(waitQ.poll());
                }
            }
            
            //시간 증가
            answer++;
        }
        return answer;
    }
}