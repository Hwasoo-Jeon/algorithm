import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> runningPQ = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                
                return o1[1] - o2[1];
            }
        });
        PriorityQueue<int[]> waitingPQ = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        
        for(int[] i : jobs) {
            waitingPQ.offer(i);
        }
        
        int cnt = jobs.length;
        int processing = 0;
        int startTime = 0;
        
        while(!waitingPQ.isEmpty() || !runningPQ.isEmpty()) {
            
            while(!waitingPQ.isEmpty() && startTime >= waitingPQ.peek()[0]) {
                runningPQ.offer(waitingPQ.poll());    
            }
            
            if(runningPQ.isEmpty()) {
                startTime = waitingPQ.peek()[0];    
            } else {
                int[] cur = runningPQ.poll();
                processing += cur[1] + startTime - cur[0];
                startTime += cur[1]; 
            }
        }
        
        return processing/cnt;
    }
}