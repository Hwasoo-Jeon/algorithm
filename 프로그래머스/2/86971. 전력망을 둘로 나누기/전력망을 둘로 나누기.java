import java.util.*;

class Solution {
    
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        int answer = n;
        //입력 배열에서 한개씩 끊어보기
        //이를 그래프로 연결 후 탐색
        //answer 초기화
        
        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 무방향 그래프 생성
        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        // 각 전선을 끊어보며 두 그룹의 노드 개수 차이의 최소값 찾기
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];

            // 전선을 끊음
            // b라는 숫자 자체를 지우기 위해, Integer 타입으로 int를 변환
            graph.get(a).remove(Integer.valueOf(b)); 
            graph.get(b).remove(Integer.valueOf(a));

            visited = new boolean[n + 1];
            // 한 쪽 그룹의 노드 개수 세기
            int count = dfs(a);

            // 두 그룹의 노드 개수 차이
            answer = Math.min(answer, Math.abs((n - count) - count));

            // 전선을 다시 연결
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        return answer;
    }
    
     private int dfs(int node) {
        visited[node] = true;
        int count = 1;

        for (int next : graph.get(node)) {
            if (!visited[next]) {
                count += dfs(next);
            }
        }
         
        return count;
    }
}