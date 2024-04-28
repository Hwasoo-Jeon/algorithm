import java.util.*;

class Solution {
   
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    
    public int solution(int n, int[][] edge) {

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] info : edge) {
            graph.get(info[0]).add(info[1]);
            graph.get(info[1]).add(info[0]);
        }
        
        //각 노드로 진입
        return bfs(n);
    }
    
    private int bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        int[] distance = new int[n+1];
        Arrays.fill(distance, -1);
        distance[1] = 0;
        int d = 0;
        q.offer(1);
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int next : graph.get(cur)) {
                if(distance[next] == -1) {
                    distance[next] = distance[cur] +1;
                    q.offer(next);
                    d = Math.max(d, distance[next]);
                }
            }
        }
        int answer = 0;
        for(int i : distance) {
            if(i == d) {
                answer++;
            }
        }
        return answer;
    }
}