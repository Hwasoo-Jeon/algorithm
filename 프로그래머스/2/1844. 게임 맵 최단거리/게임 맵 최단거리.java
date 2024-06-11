import java.util.*;

class Coord {
    int y;
    int x;
    int move;
    
    Coord(int y, int x, int move) {
        this.y = y;
        this.x = x;
        this.move = move;
    }
}

class Solution {
    
    private static int answer = Integer.MAX_VALUE;
    private static int ySize;
    private static int xSize;

    public int solution(int[][] maps) {
        ySize = maps.length;
        xSize = maps[0].length;
        Queue<Coord> q = new LinkedList<>();
        q.offer(new Coord(0,0, 1));
        boolean[][] visited = new boolean[ySize][xSize];
        visited[0][0] = true;
        while(!q.isEmpty()) {
            Coord cur = q.poll();
            
            if(cur.y == ySize-1 && cur.x == xSize-1) {
                answer = Math.min(answer, cur.move);
                break;
            }

            int[] moveY = {-1, 1, 0, 0};
            int[] moveX = {0, 0, -1, 1};
            for(int m = 0; m<4; m++) {
                int newY = cur.y+ moveY[m];
                int newX = cur.x+ moveX[m];
                if(newY >=0 && newX>=0 && newY<ySize && newX<xSize) {
                    if(maps[newY][newX] == 1 && !visited[newY][newX]) {
                        visited[newY][newX] = true;
                        q.offer(new Coord(newY, newX, cur.move+1));    
                    }
                }
            }
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
}

/*
private static void dfs(int y, int x, int move, int[][] maps, boolean[][] visited) {
    if(y == ySize-1 && x == xSize-1) {
        answer = Math.min(answer, move);
        return;
    }

    int[] moveY = {-1, 1, 0, 0};
    int[] moveX = {0, 0, -1, 1};
    for(int m = 0; m<4; m++) {
        int newY = y+ moveY[m];
        int newX = x+ moveX[m];
        if(newY >=0 && newX>=0 && newY<ySize && newX<xSize) {
            if(maps[newY][newX] == 1 && !visited[newY][newX]) {
                visited[newY][newX] = true;
                bfs(newY, newX, move+1, maps, visited);
                visited[newY][newX] = false;    
            }
        }
    }
}
*/