import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String num1 = st.nextToken(); //이건 무조건 string
		int num2 = Integer.parseInt(st.nextToken());
		bw.write(Integer.parseInt(num1, num2)+""); // int는 변환
		bw.flush();
	}
}
