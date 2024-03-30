import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int result = 0;
		for(int i=0; i<tc; i++) {
			result += Integer.parseInt(s.charAt(i)+"");
		}
		System.out.println(result);
	}
	
}
