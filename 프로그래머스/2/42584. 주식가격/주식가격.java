import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Queue<Integer> que = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        int[] answer = new int[prices.length];
        
        for(int i : prices) {
            que.offer(i);
        }
        
        // (100000*9999)/2
        int num = 0;
        while(!que.isEmpty()) {
            int target = que.poll();
            int time = 0;
            for(int i: que) {
                answer[num]++;
                if(target > i) {
                    break;
                }
            }
            num ++;
        }
    
        return answer;
    }
}