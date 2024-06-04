class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n+1][m+1]; //dp이자 map
        
        //물웅덩이 표기 
        for(int[] arr : puddles) {
            dp[arr[1]][arr[0]] = -1;
        }
        
        //집표시
        dp[1][1] = 1;
        
        // 탐색
        for(int y=1; y<=n; y++) {
            for(int x=1; x<=m; x++) {
                if(dp[y][x] == -1) {
                    dp[y][x] = 0;
                    continue;
                }
                //하향 움직임
                if(y > 1) dp[y][x] += dp[y-1][x] % 1000000007;    
                //우향 움직임
                if(x > 1) dp[y][x] += dp[y][x-1] % 1000000007;
                dp[y][x] %= 1000000007;
            }
        }
        
        return dp[n][m];
    }
}