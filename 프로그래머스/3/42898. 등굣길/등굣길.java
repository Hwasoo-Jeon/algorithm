class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n+1][m+1];
        //dp이자 map
        for(int[] arr : puddles) {
            int x = arr[0];
            int y = arr[1];
            dp[y][x] = -1;
        }
        
        // 가장자리(우향, 하향) 초기화
        boolean doNotEnter = false;
        for(int y=1; y<=n; y++) {
            if(dp[y][1] != 0) doNotEnter = true;
            if(doNotEnter) dp[y][1] = -1;    
            else dp[y][1] = 1; 
        }    
        
        doNotEnter = false;
        for(int x=2; x<=m; x++) {
            if(dp[1][x] != 0) doNotEnter = true;
            if(doNotEnter) dp[1][x] = -1; 
            else dp[1][x] = 1;   
        }
        
        // 탐색
        for(int y=1; y<=n; y++) {
            for(int x=1; x<=m; x++) {
                if(dp[y][x] == -1) continue;
                if(y == 1 || x == 1) continue;
                int left = dp[y][x-1] != -1 ? dp[y][x-1] : 0;
                int up = dp[y-1][x] != -1 ? dp[y-1][x] : 0;
                
                dp[y][x] = (left + up) % 1000000007;
                //System.out.println(y+" : "+x+" >>> "+dp[y][x]);
            }
        }
        
        return dp[n][m];
    }
}