import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		int a = 3;
		int result = 9;
		for(int i=2; i<=num; i++) {
			a = a+ a-1;
			result = (int)Math.pow(a, 2);
		}
		
		bw.write(result+"");
		bw.flush();
	}
}
