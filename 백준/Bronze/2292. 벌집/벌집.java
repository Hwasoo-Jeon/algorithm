import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		int comNum = 1;
		int cnt = 1;
		while(num>comNum) {
			comNum+= 6*cnt;
			cnt++;
		}
		
		bw.write(cnt+"");
		bw.flush();
	}
}