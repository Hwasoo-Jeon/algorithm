import java.util.*;
class Solution {
    public int solution(String arr[]) {
        int n = arr.length/2+1;
        int[][] max_dp = new int[n][n];
        int[][] min_dp = new int[n][n];
        int[] numArr = new int[n];
        char[] oper = new char[n-1];
        
        // arr 분해
        for(int i=0; i<n; i++) {
            numArr[i] = Integer.parseInt(arr[2*i]);
            if(i < n -1) {
                oper[i] = arr[2*i + 1].charAt(0);       
            }
        }
        
        // dp 초기화
        for(int i=0; i<n; i++) { 
            for(int j=0; j<n; j++) {
                max_dp[i][j] = Integer.MIN_VALUE;
                min_dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        // dp배열 초기값 세팅
        for(int i=0; i<n; i++) { 
            max_dp[i][i] = numArr[i];
            min_dp[i][i] = numArr[i];    
        }
        
        // i자리부터 j 자리의 연산 진행
        // step 변수 : i와 j 사이의 간격
        for(int step = 1; step < n; step++) {
            for(int i = 0; i < n - step; i++) {
                int j = i + step;
                
                // i부터 j까지 연산 진행
                // ex) step : 1, i : 0, j: 1
                // 0부터 1까지 더하고, 1부터 1까지
                for(int operIdx = i; operIdx <j; operIdx++) {
                    if(oper[operIdx] == '+') {
                        max_dp[i][j] = Math.max(max_dp[i][operIdx] + max_dp[operIdx+1][j], max_dp[i][j]);
                        min_dp[i][j] = Math.min(min_dp[i][operIdx] + min_dp[operIdx+1][j], min_dp[i][j]);
                    } else {
                        max_dp[i][j] = Math.max(max_dp[i][operIdx] - min_dp[operIdx+1][j], max_dp[i][j]);
                        min_dp[i][j] = Math.min(min_dp[i][operIdx] - max_dp[operIdx+1][j], min_dp[i][j]);
                    }
                }
            }
        }
        return max_dp[0][n-1];
    }
}

/*

step1 = 10 - ( 5 + 7 + 9 - 20 - 30 + 10)
step2 = (10 - 5) + (7 + 9 - 20 - 30 + 10)
step3 = (10 - 5 + 7) + (9 - 20 - 30 + 10)
step4 = (10 - 5 + 7 + 9) - (20 - 30 + 10)
step5 = (10 - 5 + 7 + 9 - 20) - (30 + 10)
step6 = (10 - 5 + 7 + 9 - 20 - 30) + 10

각단계에서 연산자에 따라 사용되는 max_dp, min_dp

*/
