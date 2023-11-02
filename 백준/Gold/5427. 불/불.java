import java.util.*;
import java.io.*;

class Coord {
	int y;
	int x;
	int idx;
	
	Coord(int y, int x, int idx) {
		this.y = y;
		this.x = x;
		this.idx = idx;
	}
	
	Coord(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int i = 0; i < tc; i++) {
			st= new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			char[][] map = new char[h][w];
			boolean[][] visited = new boolean[h][w];
			boolean flag = false;
			int[] move_y = {-1,1,0,0};
			int[] move_x = {0,0,-1,1};
			
			Queue<Coord> q = new LinkedList<>();
			Queue<Coord> fire = new LinkedList<>();
			for(int y=0; y <h ; y++) { //1000*1000 *100
				String s = br.readLine();
				for(int x=0; x <w; x++) {
					map[y][x] = s.charAt(x);
					if(map[y][x] == '*') {
						fire.offer(new Coord(y,x));
					} else if(map[y][x] == '@') {
						q.offer(new Coord(y,x,0));
						visited[y][x] = true;
					}
				}
			}
			Loop:
			while (!q.isEmpty()) {			
				int size = fire.size();
				for(int j=0; j< size; j++) {
					Coord curF = fire.poll();
					for(int dir=0; dir < 4 ; dir++) {
						int nextF_y = curF.y + move_y[dir];
						int nextF_x = curF.x + move_x[dir];
						if(nextF_y >=0 && nextF_y<h && nextF_x>=0 && nextF_x<w) {
							if(map[nextF_y][nextF_x] =='.') {
								fire.offer(new Coord(nextF_y, nextF_x));
								map[nextF_y][nextF_x] = '*';
							}
						}
					}
				}
				
				int qSize = q.size();
				for(int k=0; k<qSize; k++) {
					Coord cur = q.poll();
					if(cur.y == h-1 || cur.x == w-1 || cur.y==0 || cur.x==0) {
						sb.append((cur.idx+1)+"\n");
						flag = true;
						break Loop;
					}
					for(int dir=0; dir < 4 ; dir++) {
						int next_y = cur.y + move_y[dir];
						int next_x = cur.x + move_x[dir];
						if(next_y >=0 && next_y<h && next_x>=0 && next_x<w) {
							if(map[next_y][next_x] == '.' && !visited[next_y][next_x]) {
								q.offer(new Coord(next_y, next_x, cur.idx +1));
								visited[next_y][next_x] = true;
							}
						}
					}
				}
					
				
			}
			
			if(!flag) {
				sb.append("IMPOSSIBLE\n");
			}
			
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
