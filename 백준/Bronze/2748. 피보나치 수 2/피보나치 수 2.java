import java.io.*;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		long prev = 0;
		long prev2 = 1;
		long result = 0;
		
		if (num == 0) {
			System.out.println(prev);
			return;
		} else if(num==1) {
			System.out.println(prev2);
			return;
		}
		for(int i =2; i <= num; i++) {
			result = prev + prev2;
			prev = prev2;
			prev2 = result;
		}
		bw.write(Long.toString(result));
		bw.flush();
	}
}
