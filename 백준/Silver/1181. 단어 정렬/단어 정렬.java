import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		List<String> list = new ArrayList<>();
	
		for (int i = 0; i<tc; i++) {
			String str = br.readLine();
			list.add(str);
		}
		
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				
				if(o1.length()==o2.length()) {
					return o1.compareTo(o2);
				} else {
					return Integer.compare(o1.length(), o2.length());
				}
			}
		});
		
		Set<String> set = new LinkedHashSet<>();
		for (int j = 0 ; j < tc; j++) {
			set.add(list.get(j));
		}
		
		for(String s : set) {
			System.out.println(s);
		}
	}
}