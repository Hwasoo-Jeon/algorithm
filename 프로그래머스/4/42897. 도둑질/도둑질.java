import java.util.*;

class Solution {
    public int solution(int[] money) {
        int size = money.length;
        int[] f_dp = new int[size]; // 처음 선택 dp배열
        int[] l_dp = new int[size]; // 마지막 선택 dp 배열
        
        // 처음 선택 dp배열 대입
        for(int i=0; i<size-1; i++) {
            f_dp[i+1] = money[i];
        }
        
        // 마지막 선택 dp 배열 대입
        for(int i=1; i<size; i++) {
            l_dp[i] = money[i];
        }
        
        for(int target=2; target<size; target++) {
            f_dp[target] = Math.max(f_dp[target-2]+f_dp[target], f_dp[target-1]);
            l_dp[target] = Math.max(l_dp[target-2]+l_dp[target], l_dp[target-1]);
        }
        return Math.max(l_dp[size-1], f_dp[size-1]);
    }
}