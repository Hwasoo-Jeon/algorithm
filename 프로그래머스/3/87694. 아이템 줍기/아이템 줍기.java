import java.util.*;

class Solution {
    static int[][] map = new int[101][101];
    static int compareCnt = Integer.MAX_VALUE;
    // static boolean visited[][] = new boolean[101][101];
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        for(int i=0; i< rectangle.length; i++) {
            int lx = 2*rectangle[i][0];
            int ly = 2*rectangle[i][1];
            int rx = 2*rectangle[i][2];
            int ry = 2*rectangle[i][3];
            for(int y=ly; y<=ry; y++) {
                for(int x= lx; x<=rx; x++) {
                    if(map[y][x] == 1) {
                        continue;
                    }
                    map[y][x] = 1;
                    
                    if(y == ry || y==ly || x==lx || x== rx) {
                        map[y][x] = 2;
                    }
                }    
            }
        }
        
        bfs(2*characterX, 2*characterY, 0, 2*itemX, 2*itemY);
        
        return compareCnt/2;
    }
    
    private static void bfs(int x, int y, int cnt, int itemX, int itemY) {
        
        int[] moveY = {-1, 1, 0, 0};
        int[] moveX = {0, 0, -1, 1};
        boolean visited[][] = new boolean[101][101];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y,x,cnt});
        visited[y][x] =true;
        while(!queue.isEmpty()) {	
            int[] cur = queue.poll();
            
            if(cur[0] == itemY && cur[1] == itemX) {
                compareCnt = Math.min(compareCnt, cur[2]);
                continue;
            }
            
            for(int i=0; i<4; i++) {
                int newY = cur[0] + moveY[i];   
                int newX = cur[1] + moveX[i];
                if(newY>=0 && newY <101&& newX>=0 &&newX<101) {
                    if(map[newY][newX] == 2 && !visited[newY][newX]) {
                        visited[newY][newX] =true;
                        queue.offer(new int[] {newY, newX, cur[2]+1});
                    }
                }
            }
	    }
    }
}
