import java.util.*;

class Solution {
    
    private static class Coord {
        int y;
        int x;
        int idx;

        public Coord(int y, int x, int idx) {
            this.y = y;
            this.x = x;
            this.idx = idx;
        }
    }
    
    public int solution(int[][] maps) {
        
        int answer = Integer.MAX_VALUE;
        boolean[][] visit = new boolean[maps.length][maps[0].length];
        
        int dest_y = maps.length;
        int dest_x = maps[0].length;
        
        int[] move_y = {-1,1,0,0};
        int[] move_x = {0,0,-1,1};
        
        Queue<Coord> queue = new LinkedList<>();
        queue.offer(new Coord(0,0,1));
        
        while(!queue.isEmpty()) {
            Coord coord = queue.poll();
            int cur_idx = coord.idx;
            int cur_y = coord.y;
            int cur_x = coord.x;
            
            if(cur_y == dest_y-1 && cur_x==dest_x-1) {
                answer = Math.min(answer, cur_idx);
                break;
            }
        
            for(int i=0; i<4; i++) {
                int next_y = move_y[i] + cur_y;
                int next_x = move_x[i] + cur_x;
                if(next_y>=0 && next_y<dest_y && next_x>=0 && next_x<dest_x) {
                    if(!visit[next_y][next_x] && maps[next_y][next_x] != 0) {
                        queue.offer(new Coord(next_y, next_x, cur_idx+1));
                        visit[next_y][next_x] = true;
                    }
                }
            }
        }
        
        return answer>dest_y*dest_x? -1:answer;
    }
}