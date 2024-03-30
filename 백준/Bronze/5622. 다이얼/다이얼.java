import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int tc= s.length();
		int result = 0;
		
		for(int i=0; i<tc; i++) {
			String str = s.substring(i,i+1);
			int num = 0;
			if(str.matches("[A-R]")) {
				num = (s.charAt(i)-'A')/3+2;
			} else if(str.matches("[S-Y]")) {
				num = (s.charAt(i)-'A'-1)/3+2;
			} else if(str.matches("[Z]")) {
				num = 9;
			}
			result+= num+1;
		}
		System.out.println(result);
	}
	
}
