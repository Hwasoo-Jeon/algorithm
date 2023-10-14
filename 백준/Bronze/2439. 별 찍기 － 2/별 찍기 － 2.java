import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		String st = "*";
		for(int i =tc; i>0; i--) {
			for(int j =i-1; j>=1; j--) {
				System.out.print(" ");
			}
			for(int k=1; k<=tc-i+1; k++) {
				System.out.print(st);
			}
			System.out.println();
		}
	}	
}
