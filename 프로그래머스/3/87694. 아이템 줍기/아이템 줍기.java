import java.util.*;

class Solution {
    static int[][] map = new int[101][101];
    static int compareCnt = Integer.MAX_VALUE;
    static boolean visited[][] = new boolean[101][101];
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        for(int i=0; i< rectangle.length; i++) 
        {
            int lx = 2*rectangle[i][0];
            int ly = 2*rectangle[i][1];
            int rx = 2*rectangle[i][2];
            int ry = 2*rectangle[i][3];
            for(int y=ly; y<=ry; y++)
            {
                for(int x=lx; x<=rx; x++)
                {
                	if(map[y][x] == 1 ) continue; 
                    map[y][x] = 1;
                    
                    if(x==lx || x==rx || y==ly || y ==ry)
                    {
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
        visited[y][x] = true;
        Queue<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[]{y,x,cnt});
        
    
        while(!queue.isEmpty())
        {	
        	Integer[] cur = queue.poll();
        	int curY = cur[0];
        	int curX = cur[1];
        	int curCnt = cur[2];
        	
        	if(curY == itemY && curX == itemX)
        	{
        		compareCnt = Math.min(compareCnt, curCnt);
        		return;
        	}
        	
        	for(int i = 0; i<4; i++)
            {
                int newX = curX+moveX[i];
                int newY = curY+moveY[i];

                if(newX >= 0 && newY>=0 && newX<=100 && newY<=100 && map[newY][newX] == 2 && !visited[newY][newX])
                {	
                	visited[newY][newX] = true;
                	queue.offer(new Integer[]{newY,newX, curCnt + 1});
                }
            }	
	    }
    }
}
