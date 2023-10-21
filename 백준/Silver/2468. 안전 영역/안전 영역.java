import java.util.*;
import java.io.*;

class Coord {
	int y;
	int x;
	
	public Coord(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st; 
		int size = Integer.parseInt(br.readLine());
		int[][] info = new int[size][size];
		int[][] map = new int[size][size];
		LinkedHashSet<Integer> height = new LinkedHashSet<>();
		
		int[] move_y = {-1,1,0,0};
		int[] move_x = {0,0,-1,1};
		
		for(int i=0; i< size; i++) {//100*100
			st = new StringTokenizer(br.readLine());
			for(int j=0; j< size; j++) {
				int num = Integer.parseInt(st.nextToken());
				info[i][j] = num;
				height.add(num);
			}
		}
		
		height.add(0);
		int result = 0;
		
		for(int num : height) { //100
			int count = 0;
			Queue<Coord> queue = new LinkedList<>();
			boolean[][] visited = new boolean[size][size];
	
			//이동 가능 영역 표기
			for(int i=0; i<size; i++) { //100*100
				for(int j=0; j<size; j++) {
					if(info[i][j] <= num) {
						map[i][j] = 0;
					}else {
						map[i][j] = 1;
					}
				}
			}
			
			//while
			for(int i=0; i<size; i++) { //100*100
				for(int j=0; j<size; j++) {
					if(map[i][j]==1 && !visited[i][j]) {
						queue.offer(new Coord(i,j));
						visited[i][j] = true;
						
						while(!queue.isEmpty()) {
							Coord cur = queue.poll();
							for(int dir = 0; dir<4; dir++) {
								int newY = cur.y + move_y[dir];
								int newX = cur.x + move_x[dir];
								
								if(newY>=0&& newY<size&& newX>=0 && newX<size) {
									if(map[newY][newX]==1 &&!visited[newY][newX]) {
										queue.offer(new Coord(newY,newX));
										visited[newY][newX] = true;
									}
								}
							}
						}
						count++;
					}
				}
			}	
			//result 수정
			if(count >result) {
				result = count;
			}
		}
		bw.write(result+"");
		bw.flush();
	}
}
