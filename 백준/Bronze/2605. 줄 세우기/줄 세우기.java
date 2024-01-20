import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i<tc; i++) {
			int num = Integer.parseInt(st.nextToken());
			list.add(num, i+1);
		}
		
		for(int j = list.size() -1 ; j >= 0; j--) {
			if (j == 0) {
				System.out.print(list.get(j));
			} else {
				System.out.print(list.get(j) + " ");
			}
			
		}
		
	}
}