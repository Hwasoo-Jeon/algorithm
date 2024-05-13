import java.util.*;
import java.io.*;

public class Main {
	private static int L, C;
	private static char[] apArr, pwd;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		apArr = new char[C];
		pwd = new char[L];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<C; i++) {
			apArr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(apArr);
		combi(0, 0);
	}

	private static boolean resultCheck() {
		int consonantNum = 0;
		int vowelNum = 0;
		for(char c : pwd) {
			if(c == 'a' || c =='e' || c== 'i' || c=='o' || c=='u') vowelNum++;
			else consonantNum++;
		}
		if(consonantNum >=2 && vowelNum >=1 ) return true;
		else return false;
	}
	
	private static void combi (int start, int depth) throws IOException {
		if(depth == L) {
			if(resultCheck()) {
				System.out.println(pwd);
			}
			return;
		}
		for(int i=start; i<C; i++) {
			pwd[depth] = apArr[i];
			combi(i+1, depth+1);
		}
	}
}
