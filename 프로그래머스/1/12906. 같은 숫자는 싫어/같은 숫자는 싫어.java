import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Deque<Integer> deque = new LinkedList<>();
        for(int i=0; i<arr.length; i++) {
            int cur = arr[i];
            if(deque.isEmpty()) {
                deque.offerLast(cur);
                continue;
            }
            if(deque.peekLast() != cur) {
                deque.offerLast(cur);
            }
        }
        int cnt = deque.size();
        int[] answer = new int[cnt];
        for(int i=0; i< cnt; i++) {
            answer[i] = deque.poll();
        }
        return answer;
    }
}