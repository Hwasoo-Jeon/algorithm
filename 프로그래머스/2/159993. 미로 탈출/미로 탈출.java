import java.util.*;

class Solution {
    private static int[] start = new int[3];
    private static int[] tar = new int[2];
    private static int[] lev = new int[2];
    private static int y;
    private static int x;
    private static int answer = -1;
    public int solution(String[] maps) {
           
        y = maps.length;
        x = maps[0].length();
        
        for(int i=0; i<y; i++) {
            for(int j=0; j<x; j++) {
                if(maps[i].substring(j,j+1).equals("S")) {
                    start[0] = i;
                    start[1] = j;
                }
                if(maps[i].substring(j,j+1).equals("E")) {
                    tar[0] = i;
                    tar[1] = j;
                }
                if(maps[i].substring(j,j+1).equals("L")) {
                    lev[0] = i;
                    lev[1] = j;
                }
            }        
        }
        bfs(maps);       
        return answer;
    }
    
    public static void bfs(String[] maps) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[y][x];
        q.offer(start);
        visited[start[0]][start[1]] = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[0] == lev[0] && cur[1] == lev[1]) {
                exit(cur, maps);
                return;
            }
            int[] moveY = {-1,1,0,0};
            int[] moveX = {0,0,-1,1};
            for(int i=0; i<4; i++) {
                int newY = cur[0]+moveY[i];
                int newX = cur[1]+moveX[i];
                if(newY>=0 && newY<y && newX>=0 && newX<x) {
                    if(!visited[newY][newX] && !maps[newY].substring(newX,newX+1).equals("X")) {
                        q.offer(new int[] {newY,newX,cur[2]+1});
                        visited[newY][newX] = true;
                    }
                }
            }
        }
    }
    
    public static void exit(int[] loc, String[] maps) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[y][x];
        q.offer(loc);
        visited[loc[0]][loc[1]] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[0] == tar[0] && cur[1] == tar[1]) {
                answer = cur[2];
                return;
            }
            int[] moveY = {-1,1,0,0};
            int[] moveX = {0,0,-1,1};
            for(int i=0; i<4; i++) {
                int newY = cur[0]+moveY[i];
                int newX = cur[1]+moveX[i];
                if(newY>=0 && newY<y && newX>=0 && newX<x) {
                    if(!visited[newY][newX] && !maps[newY].substring(newX,newX+1).equals("X")) {
                        q.offer(new int[] {newY,newX,cur[2]+1});
                        visited[newY][newX] = true;
                    }
                }
            }
        }        
    }
}