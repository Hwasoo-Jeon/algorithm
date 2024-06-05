import java.util.*;

class Solution {
    private static int[] parent;
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
        
        Arrays.sort(costs, (a,b) -> a[2] - b[2]);
        int result = 0;
        for (int i = 0; i < costs.length; i++) {
            int a = costs[i][0];
            int b = costs[i][1];
            int val = costs[i][2];
            if (find(a) != find(b)) {
                union(a, b);
                result += val;
            }
        }
        return result;
    }

    
    private static int find(int a) {
        if(parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }
    
    // private static void union(int a, int b) {
    //     if(find(a) != find(b)) parent[b] = parent[a];
    // }
    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) 
            parent[rootB] = rootA;
    }
}

/*
시행착오
- 모든 node에서 한번씩 dfs 시작 => 그러면 모든 node를 시작으로 dfs 실행해봐야함.
- 이게 가장 작은 값인지 체크 -> sort해서 먼저 연결시키기
- 

문제풀이 참고
- 최적 경로 획득 (크루스칼 알고리즘)
- 최소 val만 연결 (정렬)
루트 입력, find, union 함수 사용

*/