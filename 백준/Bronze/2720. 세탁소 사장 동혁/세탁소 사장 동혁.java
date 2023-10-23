import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());
		int quarter = 25;
		int dime = 10;
		int nickel = 5;
		for(int i =0; i<tc; i++) {
			int num = Integer.parseInt(br.readLine());
			int result1 = num/quarter;
			int re1 = num%quarter;
			int result2 = re1/dime;
			int re2 = re1%dime;
			int result3 = re2/nickel;
			int re3 = re2%nickel;
			int result4 = re3;
			bw.write(result1+" "+result2+" "+result3+" "+result4+"\n");
		}
		bw.flush();
		
	}
}
