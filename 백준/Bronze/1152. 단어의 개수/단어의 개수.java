import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = 0;
		while(st.hasMoreTokens()) {
			st.nextToken();
			count++;
		}
		bw.write(count+"");
		bw.flush();
		
	}
}
