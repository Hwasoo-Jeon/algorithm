import java.util.*;

class Solution {
    
    private static int answer = 0;
    private static int lastNum;
    
    public int solution(int k, int[][] dungeons) {
        lastNum = dungeons.length;
        Arrays.sort(dungeons, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        calculate(k,0,dungeons, new boolean[lastNum]); 
        return answer;
    }
    
    private static void calculate(int curEnergy, int cnt, int[][] dungeons, boolean[] visited) {
        
        
        for(int i = 0; i < lastNum; i++) {
            // System.out.println(i +" "+ cnt+" " +answer);
            int[] cur = dungeons[i];
            if(!visited[i]) {
                if(cur[0] <= curEnergy && curEnergy - cur[1] >= 0) {
                    visited[i] = true;
                    // System.out.println(i +" "+ cnt+" " +answer);
                    calculate(curEnergy-cur[1], cnt+1, dungeons, visited);
                    visited[i] = false;
                }
            }
        }
        
        answer = Math.max(cnt, answer);
    }
}