import java.io.*;
import java.util.*;

public class Main {
	private static int answer = Integer.MAX_VALUE;
	private static int target = 0;
	private static boolean[] broken;	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		target = Integer.parseInt(br.readLine());
		int num = Integer.parseInt(br.readLine());
		broken = new boolean[10];
		if(num!=0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<num; i++) {
				int n = Integer.parseInt(st.nextToken());
				broken[n] = true;
			}
		}
		
		dfs(0,"");
		System.out.println(Math.min(answer, Math.abs(target-100)));
	}
	
	
	private static void dfs(int depth, String curNum) {
		
		if(depth !=0 && depth >= (target+"").length()-1 && depth <= (target+"").length()+1) {
			if(curNum.matches("[0]+")) {
				curNum = "0";
			}
			answer = Math.min(answer, Math.abs(Integer.parseInt(curNum)-target)+curNum.length());
			
			if(depth < (target+"").length()+1) {
				for(int i=0; i < 10; i++) {
					if(!broken[i]) {
						dfs(depth+1, curNum+i);
					}
				}
			}
		} else {
			for(int i=0; i < 10; i++) {
				if(!broken[i]) {
					dfs(depth+1, curNum+i);
				}
			}
		}
	}
}
//참고사항: N은 최대 500,000 각자리 모두 0~9까지 재귀 돌려도 10^6, 정규표현식: matches("[0]+")