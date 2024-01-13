import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	private static int num;
	private static int maxN = Integer.MIN_VALUE;
	private static int minN = Integer.MAX_VALUE;
	private static int[] numArr;
	private static int[] operArr = new int[4];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		num = Integer.parseInt(br.readLine());
		
		numArr = new int[num]; 
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i=0; i<num; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i=0; i<4; i++) {
			operArr[i] = Integer.parseInt(st2.nextToken());
		}
		dfs(1,numArr[0]);
		bw.write(maxN+"\n"+minN);
		bw.flush();
		
	}
	
	static void dfs(int depth, int result) {
		
		if(depth == num) {
			maxN = Math.max(maxN, result);
			minN = Math.min(minN, result);
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(operArr[i] > 0) {
				
				operArr[i]--;
				
				if(i == 0) {
					dfs(depth+1, result+numArr[depth]);
				} else if(i == 1) {
					dfs(depth+1, result-numArr[depth]);
				} else if(i == 2) {
					dfs(depth+1, result*numArr[depth]);
				} else if(i == 3) {
					dfs(depth+1, result/numArr[depth]);
				}
				
				operArr[i]++;
				
			}
		}
		
	}
}
