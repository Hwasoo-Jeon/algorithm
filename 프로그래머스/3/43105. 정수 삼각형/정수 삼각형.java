import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int size = triangle.length;
        int[][] dp = new int[size][size];
        for(int i=0; i<size; i++) {
            for(int j=0; j<=i; j++) {
                dp[i][j] = triangle[i][j];
                if(i == 0) continue;
                
                if(j == 0 || j == i) {
                    if(j == 0) dp[i][j] = Math.max(dp[i][j], dp[i-1][j] + triangle[i][j]);  
                    else dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + triangle[i][j]);  
                         
                } else {
                    int leftNode = j-1;
                    int rightNode = j;
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][leftNode] + triangle[i][j]);
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][rightNode] + triangle[i][j]);
                }
            }
        }
        
        int answer = 0;
        for(int i=0; i<size; i++) {
            answer = Math.max(answer, dp[size-1][i]);
        }
        return answer;
    }
}