import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int i = 0; i < tc; i++) {
			String[] strArr = br.readLine().split(" ");
			String input = strArr[0];
			String output = strArr[1];
			List<String> list1 = new ArrayList<>();
			List<String> list2 = new ArrayList<>();
			
			for(int j=0; j<input.length(); j++) {
				list1.add(Character.toString(input.charAt(j)));
			}
			
			for(int j=0; j<output.length(); j++) {
				list2.add(Character.toString(output.charAt(j)));	
			}
			Collections.sort(list1);
            Collections.sort(list2);
			if(list1.equals(list2)) {
				System.out.println("Possible");
			} else {
				System.out.println("Impossible");
			}
		}
	}
}
