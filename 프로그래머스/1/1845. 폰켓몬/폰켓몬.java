import java.util.*;

class Solution {
    static int max = Integer.MIN_VALUE;
    static int pick = 0;
    static int[] numArr;
    
    public int solution(int[] nums) {
        int cnt = nums.length;
        pick = cnt/2;
        HashSet<Integer> numsSet = new HashSet<>();
        for(int i : nums) {
            numsSet.add(i);
        }
        return pick<=numsSet.size() ? pick : numsSet.size();
    }
    
    private static void makeNum(int idx, int pickCnt, boolean[] visited) {
        if(pickCnt == pick) {
            HashSet<Integer> numSet = new HashSet<>();
            for(int i=0; i<visited.length; i++) {
                if(visited[i]) numSet.add(numArr[i]);
            }
            max = Math.max(numSet.size(), max);
            return; 
        }
        
        for(int i=idx; i<numArr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                makeNum(idx+1, pickCnt+1, visited);
                visited[i] = false;
            }
        }
    }
}