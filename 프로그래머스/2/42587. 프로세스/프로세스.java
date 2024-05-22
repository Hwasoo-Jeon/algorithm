import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int cnt = priorities.length;
        Queue<Integer> lQ = new LinkedList<>();
        Queue<Integer> rQ = new LinkedList<>();

        int[] arr = new int[cnt];
        for(int i=0; i<cnt; i++) {
            lQ.offer(i);            
        }
        int answer = 1;
        
        Loop:
        while(!lQ.isEmpty()) {
            int cur = lQ.poll();
            for(int i : lQ) {
                if(priorities[i] > priorities[cur]) {
                    lQ.offer(cur);
                    continue Loop;
                } 
            }
            if(cur == location) {
                return answer;
            }
            answer++;
        }
        
        return cnt;
        // for(int i : arr) {
        //     System.out.println(i);
        // }
        // return arr[location];
    }
}

/*
int maxIdx = q.poll();
            int innerSize = q.size();  
            for(int i = 0; i < innerSize; i++) {
                int nextIdx = q.poll();
                if(priorities[maxIdx] < priorities[nextIdx]) {
                    q.offer(maxIdx);
                    maxIdx = i;
                    q.poll();
                } else {
                  q.offer(nextIdx);  
                }
            }
            arr[maxIdx] = answer;
            answer++;

*/