import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		Map<String, Integer> map = new LinkedHashMap<>();
		
		for(int i=0; i<n;i++) {
			String str = br.readLine();
			int in = map.getOrDefault(str, 0);
			map.put(str, in+1);
		}
		
		List<String> list = new LinkedList<>();
		
		int check = Integer.MIN_VALUE;
		for(String key: map.keySet()) {
			int cur = map.get(key);
			if(cur > check) {
				check = cur;
				list.clear();
				list.add(key);
			} else if (check == cur) {
				list.add(key);
			}
		}
		Collections.sort(list);
		bw.write(list.get(0));
		bw.flush();
		
	}	
}
