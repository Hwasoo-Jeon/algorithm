import java.util.*;

class Solution {
    
    static int answer = 0;
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        //  0,0은 1
        visited = new boolean[n];
        
        for(int node =0; node < n; node++)
        {   
            if (!visited[node]) 
            {
                dfs(n,node, computers);
                answer++;
            }      
        }
        

        return answer;
    }
    
    private static void dfs(int n, int node, int[][] computers) {
        visited[node] = true;
        
        for(int col =0; col < n; col++)
        {
            if(computers[node][col]==1 && !visited[col]) 
            {        
                dfs(n, col, computers);
            }
        }
        
    }
}