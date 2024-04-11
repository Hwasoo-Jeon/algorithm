import java.io.*;
import java.util.*;

public class Main {
	private static int[] arr;
	private static ArrayList<Integer> resultList = new ArrayList<Integer>();
	private static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		visited = new boolean[n+1];
		
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=1; i<=n; i++) {
			visited[i] = true;
			search(i, i);
			visited[i] = false;
		}
		
		Collections.sort(resultList);
		
		bw.write(resultList.size()+"\n");
		for(int i=0; i<resultList.size(); i++) {
			bw.write(resultList.get(i)+"\n");
		}
		bw.flush();
		
	}
	
	public static void search(int start, int circleNum) {
		
		if(!visited[arr[start]]) {
			visited[arr[start]] = true;
			search(arr[start], circleNum);
			visited[arr[start]] = false;
		}
		
		if(arr[start] == circleNum) resultList.add(circleNum); 
	}

}
/*
답지 확인 : 1-> 3 -> 1, 2->1->3 (순환x),3->1->3 , 5->5 // backtracking 사용하여 모든 배열 돌기.
백트래킹 두번 사용. 그래서 순환탐색에 사용된 배열, 그리고 첫시작시 start했던 index모두 false로 전환

인덱스의 절댓값으로 판별 : 불가
1 2 3
2 3 1
==
조합 : 불가
1개 n
2개 NC2
5개
100C5
==
lis 아님
*/