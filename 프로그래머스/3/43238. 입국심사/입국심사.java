import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = Long.MAX_VALUE;
        long left = 0;
        long right = (long)n*times[0];
        int size = times.length;
        while(left < right) {
            long mid = (left+right)/2;
            long temp = 0;
            for(int i=0; i<size; i++) {
                temp += mid/times[i];    
            }
            
            if(n <= temp) {
                right = mid;
                // System.out.println(mid +"::::"+n);
            } else {
                left = mid+1;
            }
        }
        return right;
    }
}