import java.util.*;
import java.io.*;

public class Main {
	private static int L;
	private static ArrayList<String> vList = new ArrayList<String>();
	private static ArrayList<String> cList = new ArrayList<String>();
	private static ArrayList<String> apList = new ArrayList<String>();
	private static ArrayList<String> result = new ArrayList<String>();;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<C; i++) {
			String alphabet = st.nextToken();
			apList.add(alphabet);
			if(check(alphabet)) vList.add(alphabet);
			else cList.add(alphabet);
		}
		Collections.sort(apList);
		Collections.sort(vList);
		Collections.sort(cList);
		// 모든 경우의 수 조합, 체크
		boolean[] visited = new boolean[C];
		combi("", visited, 0);
	
		Collections.sort(result);
		for(String s : result) {
			bw.write(s+"\n");
		}
		bw.flush();
	}
	private static boolean check(String alphabet) {
		switch (alphabet) {
		case "a":
			return true;
		case "e" :
			return true;
		case "i" :
			return true;
		case "o" :
			return true;
		case "u" :
			return true;
		default :
			return false;	
		}
	}
	private static boolean resultCheck(String code) {
		int consonantNum = 0;
		boolean flag = false;
		int n = code.length();
		for(int i=0; i<n; i++) {
			String s = code.substring(i, i+1);
			if(vList.contains(s)) {
				flag = true;
			} else if(cList.contains(s)) {
				consonantNum++;
			}
		}
		if(flag && consonantNum>=2) return true; 
		return false;
	}
	
	private static void combi(String str, boolean[] visited, int depth) {
		if(str.length() == L) {
			if(resultCheck(str)) result.add(str);
			return;
		}
		for(int i=depth; i<apList.size(); i++) {
			if(!visited[i]) {
				if(depth!=0 && str.charAt(depth-1) > apList.get(i).charAt(0)) {
					continue;
				}
				visited[i] = true;
				combi(str+apList.get(i), visited, depth+1);
				visited[i] = false;
			}
		}
	}
}
