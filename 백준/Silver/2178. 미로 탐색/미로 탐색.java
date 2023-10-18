import java.util.*;
import java.io.*;

class Coord {
	int y;
	int x;
	int idx;
	
	public Coord(int y, int x, int idx) {
		this.y = y;
		this.x = x;
		this.idx = idx;
	}
}

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb= new StringBuilder();
		String[] input= br.readLine().split(" ");
		int row = Integer.parseInt(input[0]);
		int col = Integer.parseInt(input[1]);
		int[][] arr = new int[row][col];
		for(int y =0; y<row; y++) {
			String line = br.readLine();
			for(int x=0; x<col; x++) { //100*100
				arr[y][x]= line.charAt(x)-'0';
			}
			
		}
		
		boolean[][] visited = new boolean[row][col];
		Queue<Coord> queue = new LinkedList<>();
		Coord coord = new Coord(0,0,1);
		queue.offer(coord);
		visited[coord.y][coord.x] = true;
		
		while(!queue.isEmpty()) {
			Coord cur = queue.poll();
			int curIdx = cur.idx;
			
			if(cur.y==row-1&&cur.x==col-1) {
				sb.append(cur.idx);
				break;
			}
			
			//우
			if(cur.x+1<col && arr[cur.y][cur.x+1]==1) {
				if(!visited[cur.y][cur.x+1]) {
					queue.offer(new Coord(cur.y,cur.x+1,curIdx+1));
					visited[cur.y][cur.x+1]=true;
				}
			}
			//하
			if(cur.y+1<row && arr[cur.y + 1][cur.x]==1) {
				if(!visited[cur.y + 1][cur.x]) {
					queue.offer(new Coord(cur.y+1, cur.x,curIdx+1));
					visited[cur.y + 1][cur.x]=true;
				}
			}
			//상
			if(cur.y-1>=0 && arr[cur.y-1][cur.x]==1) {
				if(!visited[cur.y-1][cur.x]) {
					queue.offer(new Coord(cur.y-1, cur.x,curIdx+1));
					visited[cur.y-1][cur.x]=true;
				}
			}
			//좌
			if(cur.x-1>=0 && arr[cur.y][cur.x-1]==1) {
				if(!visited[cur.y][cur.x-1]) {
					queue.offer(new Coord(cur.y, cur.x-1,curIdx+1));
					visited[cur.y][cur.x-1]=true;
				}
			}
		}
		bw.write(sb.toString());
		bw.flush();
		
	}
		
}
