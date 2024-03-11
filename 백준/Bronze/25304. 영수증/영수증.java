import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		int tc = Integer.parseInt(br.readLine());
		int sum = 0;
		
		for(int i=0; i<tc; i++) {
			String[] arr = br.readLine().split(" ");
			sum += Integer.parseInt(arr[0])*Integer.parseInt(arr[1]);
		}
		if(sum== total) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}	
}
