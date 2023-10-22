import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] arr = new int[100][100];
		
		for (int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			for(int r=0; r<10; r++) {
				for(int c=0; c<10; c++) {
					arr[y+r][x+c]=1;
				}
			}
		}
		
		int result = 0;
		
		for(int r=0; r<100; r++) {
			for(int c=0; c<100; c++) {
				if(arr[r][c] ==1) {
					result+= arr[r][c];
				}
			}
		}
		

		bw.write(result+"");
		bw.flush();
	}
}
