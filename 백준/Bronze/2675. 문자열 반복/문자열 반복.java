import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int i=0; i<tc;i++) {
			st = new StringTokenizer(br.readLine());
			int re = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			for(int j =0; j<str.length(); j++) {
				String s = str.charAt(j)+"";
				sb.append(s.repeat(re)+"");
			}
			sb.append("\n");
		}
		bw.write(sb+"");
		bw.flush();
		
	}
}
