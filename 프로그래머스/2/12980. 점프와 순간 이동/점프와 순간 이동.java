import java.util.*;

public class Solution {
    
    public int solution(int n) {
        if (n == 1) return 1;

        int battery = 1;
        while (n > 1) {            
            if (n % 2 != 0) {
                n--;
                battery++;
                continue;
            }
            n = n / 2;
        }
        return battery;
    }
//     private static int[] dp;
    
//     public int solution(int n) {
//         dp = new int[n+1];
        
//         for(int i=1; i<=n; i++) {
//             dp[i] = i;
//             dp[i] = Math.min(dp[i], search(i));
//         }
        
//         return dp[n];
//     }
    
//     private static int search(int idx) {
        
//         if(dp[idx] > 0 && dp[idx] <idx) {
//             return dp[idx];
//         }
        
//         if(idx-1 >= 0 && idx/2> 0 && idx%2 == 0 && dp[idx-1] > 0 ) {
//             return Math.min(dp[idx-1]+1, dp[idx/2]);   
//         } else {
//             return dp[idx-1]+1;
//         }  
//     }
}