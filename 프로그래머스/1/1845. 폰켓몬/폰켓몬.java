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
}