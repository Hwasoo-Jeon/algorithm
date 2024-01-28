import java.util.*;

class Solution {
    static int[] arr;
    static int realTarget = 0;
    static int result = 0;
    public int solution(int[] numbers, int target) {
        
        arr = Arrays.copyOf(numbers, numbers.length);
        realTarget = target;
        bfs(0,0);
        return result;
    }
    
    private static void bfs(int idx, int cur) {
        if(idx == arr.length) {
            if(cur == realTarget) {
                result++;
            }
            return;
        } else {
            bfs(idx+1, cur+arr[idx]);
            bfs(idx+1, cur+arr[idx]*-1); 
        }
    }
}