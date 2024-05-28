import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        for(String s : operations) {
            String[] cmd = s.split(" ");
            int i = Integer.parseInt(cmd[1]);
            switch(cmd[0]) {
                case "I" :
                    minPQ.offer(i);
                    maxPQ.offer(i);
                    break;
                case "D" :
                    if(!minPQ.isEmpty()) {
                        if(i == -1) {
                            int n = minPQ.poll();
                            maxPQ.remove(n);
                        } else {
                            int n = maxPQ.poll(); 
                            minPQ.remove(n);
                        }    
                    }
                    break;
            }
        }
        
        if(minPQ.isEmpty()) {
            return new int[] {0,0};
        } else {
            return new int[] {maxPQ.peek(), minPQ.peek()};
        }
    }
}